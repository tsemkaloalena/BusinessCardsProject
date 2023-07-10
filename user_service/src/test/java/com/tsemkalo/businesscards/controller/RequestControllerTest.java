package com.tsemkalo.businesscards.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.AbstractTest;
import com.tsemkalo.businesscards.ChangePasswordRequest;
import com.tsemkalo.businesscards.ChangePasswordResponse;
import com.tsemkalo.businesscards.EditInfoRequest;
import com.tsemkalo.businesscards.ForgotPasswordRequest;
import com.tsemkalo.businesscards.ProtoRoleType;
import com.tsemkalo.businesscards.RoleProto;
import com.tsemkalo.businesscards.SafeUserProto;
import com.tsemkalo.businesscards.SafeUserProtoList;
import com.tsemkalo.businesscards.Token;
import com.tsemkalo.businesscards.UserIdProtoList;
import com.tsemkalo.businesscards.UserProto;
import com.tsemkalo.businesscards.UsernameProto;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.RoleDTO;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.LinkExpiredException;
import com.tsemkalo.businesscards.exceptions.UserExistsException;
import com.tsemkalo.businesscards.service.impl.UserServiceImpl;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.EXPIRATION_TIME;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.SECRET_ACTIVATE_ACCOUNT;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.SECRET_FORGOT_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class RequestControllerTest extends AbstractTest {
    @Spy
    private UserServiceImpl userService;

    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    public void setupServices() {
        try {
            Field userDaoField = UserServiceImpl.class.getDeclaredField("userDao");
            userDaoField.setAccessible(true);
            userDaoField.set(userService, getUserDao());
            userDaoField.setAccessible(false);

            Field nonActivatedUserDaoField = UserServiceImpl.class.getDeclaredField("nonActivatedUserDao");
            nonActivatedUserDaoField.setAccessible(true);
            nonActivatedUserDaoField.set(userService, getNonActivatedUserDao());
            nonActivatedUserDaoField.setAccessible(false);

            Field passwordEncoderField = UserServiceImpl.class.getDeclaredField("bCryptPasswordEncoder");
            passwordEncoderField.setAccessible(true);
            passwordEncoderField.set(userService, getBCryptPasswordEncoder());
            passwordEncoderField.setAccessible(false);

            Field userMapperField = UserServiceImpl.class.getDeclaredField("userMapper");
            userMapperField.setAccessible(true);
            userMapperField.set(userService, getUserMapper());
            userMapperField.setAccessible(false);

            Field nonActivatedUserMapperField = UserServiceImpl.class.getDeclaredField("nonActivatedUserMapper");
            nonActivatedUserMapperField.setAccessible(true);
            nonActivatedUserMapperField.set(userService, getNonActivatedUserMapper());
            nonActivatedUserMapperField.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUserByUsername_whenUsernameExists_thenUserReturned() throws Exception {
        String username = "edik";
        UsernameProto request = UsernameProto.newBuilder()
                .setUsername(username)
                .build();

        StreamRecorder<UserProto> responseObserver = StreamRecorder.create();
        requestController.getUserByUsername(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<UserProto> results = responseObserver.getValues();
        assertEquals(1, results.size());
        UserProto userProto = results.get(0);
        assertEquals(username, userProto.getUsername());
    }

    @Test
    public void getUserByUsername_whenUsernameDoesNotExist_thenUsernameNotFoundExceptionThrown() {
        String username = "mysterious";
        UsernameProto request = UsernameProto.newBuilder()
                .setUsername(username)
                .build();

        StreamRecorder<UserProto> responseObserver = StreamRecorder.create();

        assertThrows(UsernameNotFoundException.class, () -> requestController.getUserByUsername(request, responseObserver));
    }

    @Test
    public void getNonActivatedUserByUsername_whenUsernameExists_thenUserReturned() throws Exception {
        String username = "sashenka";
        UsernameProto request = UsernameProto.newBuilder()
                .setUsername(username)
                .build();

        StreamRecorder<SafeUserProto> responseObserver = StreamRecorder.create();
        requestController.getNonActivatedUserByUsername(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<SafeUserProto> results = responseObserver.getValues();
        assertEquals(1, results.size());
        SafeUserProto userProto = results.get(0);
        assertEquals(username, userProto.getUsername());
    }

    @Test
    public void getNonActivatedUserByUsername_whenUsernameDoesNotExist_thenUsernameNotFoundExceptionThrown() {
        String username = "mysterious";
        UsernameProto request = UsernameProto.newBuilder()
                .setUsername(username)
                .build();

        StreamRecorder<SafeUserProto> responseObserver = StreamRecorder.create();

        assertThrows(UsernameNotFoundException.class, () -> requestController.getNonActivatedUserByUsername(request, responseObserver));
    }

    @Test
    public void saveUser_whenAllDataIsCorrect_thenSuccess() throws Exception {
        int originalNonActivatedUsersAmount = getNonActivatedUserTable().size();
        int originalUsersAmount = getUserTable().size();
        String username = "antoha";
        String password = "in_the_hood";
        String name = "Anatoliy";
        String surname = "English";
        String email = "tsemkaloalena@gmail.com";
        UserProto request = prepareUserProto(username, password, name, surname, email, getRoleTable().get(3L)).build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.saveUser(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertEquals(originalNonActivatedUsersAmount + 1, getNonActivatedUserTable().size());
        assertEquals(originalUsersAmount, getUserTable().size());
        assertNull(getUserDao().findByUsername(username));
        assertNotNull(getNonActivatedUserDao().findByUsername(username));
        assertNotEquals(password, getNonActivatedUserDao().findByUsername(username).getPassword());
        assertTrue(getBCryptPasswordEncoder().matches(password, getNonActivatedUserDao().findByUsername(username).getPassword()));
    }

    @Test
    public void saveUser_whenUsernameExists_thenUserExistsExceptionThrown() {
        String username = "marik";
        String password = "otherPassword";
        String name = "otherName";
        String surname = "otherSurname";
        String email = "tsemkaloalena@gmail.com";
        UserProto request = prepareUserProto(username, password, name, surname, email, getRoleTable().get(3L)).build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(UserExistsException.class, () -> requestController.saveUser(request, responseObserver));
    }

    @Test
    public void changePassword_whenAllDataIsCorrect_thenSuccess() throws Exception {
        String currentUsername = "marik";
        String oldPassword = "who";
        String newPassword = "theWho";
        ChangePasswordRequest request = ChangePasswordRequest.newBuilder()
                .setNewPassword(newPassword)
                .setOldPassword(oldPassword)
                .setCurrentUsername(currentUsername)
                .build();

        StreamRecorder<ChangePasswordResponse> responseObserver = StreamRecorder.create();
        requestController.changePassword(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<ChangePasswordResponse> results = responseObserver.getValues();
        assertEquals(1, results.size());
        ChangePasswordResponse response = results.get(0);

        assertNotEquals(newPassword, response.getNewPassword());
        assertTrue(getBCryptPasswordEncoder().matches(newPassword, response.getNewPassword()));
        assertTrue(getBCryptPasswordEncoder().matches(newPassword, getUserDao().findByUsername(currentUsername).getPassword()));
        assertFalse(getBCryptPasswordEncoder().matches(oldPassword, response.getNewPassword()));
    }

    @Test
    public void changePassword_whenOldPasswordIsNotCorrectAndBelongsToOtherUser_thenIncorrectDataExceptionThrown() {
        String currentUsername = "marik";
        String oldPassword = "male";
        String newPassword = "newPswd";
        ChangePasswordRequest request = ChangePasswordRequest.newBuilder()
                .setNewPassword(newPassword)
                .setOldPassword(oldPassword)
                .setCurrentUsername(currentUsername)
                .build();

        StreamRecorder<ChangePasswordResponse> responseObserver = StreamRecorder.create();

        assertThrows(IncorrectDataException.class, () -> requestController.changePassword(request, responseObserver));
    }

    @Test
    public void changePassword_whenOldPasswordIsNotCorrect_thenIncorrectDataExceptionThrown() {
        String currentUsername = "marik";
        String oldPassword = "somePswd";
        String newPassword = "newPswd";
        ChangePasswordRequest request = ChangePasswordRequest.newBuilder()
                .setNewPassword(newPassword)
                .setOldPassword(oldPassword)
                .setCurrentUsername(currentUsername)
                .build();

        StreamRecorder<ChangePasswordResponse> responseObserver = StreamRecorder.create();

        assertThrows(IncorrectDataException.class, () -> requestController.changePassword(request, responseObserver));
    }

    @Test
    public void activateAccount_whenTokenIsValid_thenAddToDB() throws Exception {
        String username = "sashenka";
        String activateAccountToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_ACTIVATE_ACCOUNT.getBytes()));
        Token request = Token.newBuilder()
                .setToken(activateAccountToken)
                .build();

        StreamRecorder<UsernameProto> responseObserver = StreamRecorder.create();
        requestController.activateAccount(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<UsernameProto> results = responseObserver.getValues();
        assertEquals(1, results.size());
        UsernameProto response = results.get(0);

        assertEquals(username, response.getUsername());
        assertNull(getNonActivatedUserDao().findByUsername(username));
        assertNotNull(getUserDao().findByUsername(username));
    }

    @Test
    public void activateAccount_whenTokenIsInvalid_thenLinkExpiredExceptionThrown() {
        String username = "sashenka";
        String activateAccountToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() - EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_ACTIVATE_ACCOUNT.getBytes()));
        Token request = Token.newBuilder()
                .setToken(activateAccountToken)
                .build();

        StreamRecorder<UsernameProto> responseObserver = StreamRecorder.create();
        assertThrows(LinkExpiredException.class, () -> requestController.activateAccount(request, responseObserver));
        assertNotNull(getNonActivatedUserDao().findByUsername(username));
        assertNull(getUserDao().findByUsername(username));
    }

    // TODO deleteUserIfNotActivated

    @Test
    public void deleteNonActivatedAccount_ifNotActivated_thenDelete() {
        String username = "sashenka";
        UsernameProto request = UsernameProto.newBuilder()
                .setUsername(username)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteNonActivatedAccount(request, responseObserver);

        assertNull(responseObserver.getError());
        assertNull(getNonActivatedUserDao().findByUsername(username));
    }

    @Test
    public void deleteNonActivatedAccount_ifDoesNotExist_thenDoNothing() {
        String username = "newUser";
        UsernameProto request = UsernameProto.newBuilder()
                .setUsername(username)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteNonActivatedAccount(request, responseObserver);

        assertNull(responseObserver.getError());
        assertNull(getNonActivatedUserDao().findByUsername(username));
    }

    @Test
    public void deleteNonActivatedAccount_ifActivated_thenDoNothing() {
        String username = "derevo";
        UsernameProto request = UsernameProto.newBuilder()
                .setUsername(username)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteNonActivatedAccount(request, responseObserver);

        assertNull(responseObserver.getError());
        assertNull(getNonActivatedUserDao().findByUsername(username));
    }

    @Test
    public void resetPassword_whenTokenIsValid_thenChangePassword() throws Exception {
        String username = "lisa";
        String newPassword = "newPswd";
        String resetPasswordToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_FORGOT_PASSWORD.getBytes()));
        ForgotPasswordRequest request = ForgotPasswordRequest.newBuilder()
                .setResetPasswordToken(resetPasswordToken)
                .setNewPassword(newPassword)
                .build();

        StreamRecorder<ChangePasswordResponse> responseObserver = StreamRecorder.create();
        requestController.resetPassword(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<ChangePasswordResponse> results = responseObserver.getValues();
        assertEquals(1, results.size());
        ChangePasswordResponse response = results.get(0);

        assertNotEquals(newPassword, response.getNewPassword());
        assertTrue(getBCryptPasswordEncoder().matches(newPassword, response.getNewPassword()));
        assertTrue(getBCryptPasswordEncoder().matches(newPassword, getUserDao().findByUsername(username).getPassword()));
    }

    @Test
    public void resetPassword_whenTokenIsInvalid_thenLinkExpiredExceptionThrown() {
        String username = "lisa";
        String newPassword = "newPswd";
        String resetPasswordToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() - EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_FORGOT_PASSWORD.getBytes()));
        ForgotPasswordRequest request = ForgotPasswordRequest.newBuilder()
                .setResetPasswordToken(resetPasswordToken)
                .setNewPassword(newPassword)
                .build();

        StreamRecorder<ChangePasswordResponse> responseObserver = StreamRecorder.create();
        assertThrows(LinkExpiredException.class, () -> requestController.resetPassword(request, responseObserver));

        assertFalse(getBCryptPasswordEncoder().matches(newPassword, getUserDao().findByUsername(username).getPassword()));
    }

    @Test
    public void editInfo_whenSurnameIsChanged_thenAccessDeniedExceptionThrown() {
        String currentUsername = "marik";
        Long userId = 12L;
        SafeUserProto editedUser = prepareSafeUserProto("derevo", "Drevo", "Obrabotka", "tsemkaloalena@gmail.com", getRoleTable().get(3L))
                .setId(userId)
                .build();
        EditInfoRequest request = EditInfoRequest.newBuilder()
                .setEditedInfo(editedUser)
                .setCurrentUsername(currentUsername)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editInfo(request, responseObserver));
    }

    @Test
    public void editInfo_whenRoleIsChanged_thenAccessDeniedExceptionThrown() {
        String currentUsername = "derevo";
        Long userId = 12L;
        SafeUserProto editedUser = prepareSafeUserProto("derevo", "Drevo", "Obrabotka", "tsemkaloalena@gmail.com", getRoleTable().get(1L))
                .setId(userId)
                .build();
        EditInfoRequest request = EditInfoRequest.newBuilder()
                .setEditedInfo(editedUser)
                .setCurrentUsername(currentUsername)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editInfo(request, responseObserver));
    }

    @Test
    public void editInfo_whenNewNameIsSet_thenNameChanged() throws Exception {
        String currentUsername = "derevo";
        String oldName = "Derevo";
        String newName = "Bush";
        Long userId = 12L;
        SafeUserProto editedUser = prepareSafeUserProto(currentUsername, newName, "Obrabotka", "tsemkaloalena@gmail.com", getRoleTable().get(3L))
                .setId(userId)
                .build();
        EditInfoRequest request = EditInfoRequest.newBuilder()
                .setEditedInfo(editedUser)
                .setCurrentUsername(currentUsername)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editInfo(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertEquals(newName, getUserTable().get(userId).getName());
        assertNotNull(getUserTable().get(userId).getSurname());
        assertNotEquals(oldName, getUserTable().get(userId).getName());
    }

    @Test
    public void getUsersByTheirId_whenListIsEmpty() throws Exception {
        List<Long> userIds = new ArrayList<>(List.of(new Long[]{7L, 8L, 9L}));
        UserIdProtoList request = UserIdProtoList.newBuilder()
                .addAllUserIds(userIds)
                .build();

        StreamRecorder<SafeUserProtoList> responseObserver = StreamRecorder.create();
        requestController.getUsersByTheirId(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<SafeUserProtoList> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<SafeUserProto> response = results.get(0).getUsersList();

        for (int i = 0; i < response.size(); i++) {
            assertEquals(getUserTable().get(userIds.get(i)).getUsername(), response.get(i).getUsername());
        }
    }

    private UserProto.Builder prepareUserProto(String username, String password, String name, String surname, String email, Role role) {
        RoleProto roleProto = RoleProto.newBuilder()
                .setId(role.getId())
                .setName(ProtoRoleType.valueOf(role.getName().name()))
                .build();
        return UserProto.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setRole(roleProto);
    }

    private SafeUserProto.Builder prepareSafeUserProto(String username, String name, String surname, String email, Role role) {
        RoleProto roleProto = RoleProto.newBuilder()
                .setId(role.getId())
                .setName(ProtoRoleType.valueOf(role.getName().name()))
                .build();
        return SafeUserProto.newBuilder()
                .setUsername(username)
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setRole(roleProto);
    }
}

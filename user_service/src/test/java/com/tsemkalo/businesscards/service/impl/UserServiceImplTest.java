package com.tsemkalo.businesscards.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.AbstractServiceTest;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.Role;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.RoleDTO;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.LinkExpiredException;
import com.tsemkalo.businesscards.exceptions.UserExistsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.EXPIRATION_TIME;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.SECRET_ACTIVATE_ACCOUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest extends AbstractServiceTest {
    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void loadUserByUsername_whenUsernameExists_thenUserReturned() {
        String username = "edik";

        assertEquals(username, userService.loadUserByUsername(username).getUsername());
    }

    @Test
    public void loadUserByUsername_whenUsernameDoesNotExist_thenUsernameNotFoundExceptionThrown() {
        String username = "mysterious";

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(username));
    }

    @Test
    public void saveUser_whenAllDataIsCorrect_thenSuccess() {
        String username = "antoha";
        String password = "in_the_hood";
        String name = "Anatoliy";
        String surname = "English";
        String email = "tsemkaloalena@gmail.com";
        Role role = getRoleTable().get(3L);
        NonActivatedUser nonActivatedUser = new NonActivatedUser();
        nonActivatedUser.setUsername(username);
        nonActivatedUser.setPassword(password);
        nonActivatedUser.setName(name);
        nonActivatedUser.setSurname(surname);
        nonActivatedUser.setEmail(email);
        nonActivatedUser.setRole(role);

        userService.saveUser(nonActivatedUser);

        assertNotEquals(nonActivatedUser.getPassword(), password);
        assertTrue(getBCryptPasswordEncoder().matches(password, nonActivatedUser.getPassword()));
        assertNotNull(nonActivatedUser.getId());
        assertNull(getUserDao().findByUsername(username));
        assertEquals(getNonActivatedUserTable().get(nonActivatedUser.getId()), nonActivatedUser);
    }

    @Test
    public void saveUser_whenUsernameExists_thenUserExistsExceptionThrown() {
        String username = "marik";
        String password = "otherPassword";
        String name = "otherName";
        String surname = "otherSurname";
        String email = "tsemkaloalena@gmail.com";
        Role role = getRoleTable().get(3L);
        NonActivatedUser nonActivatedUser = new NonActivatedUser();
        nonActivatedUser.setUsername(username);
        nonActivatedUser.setPassword(password);
        nonActivatedUser.setName(name);
        nonActivatedUser.setSurname(surname);
        nonActivatedUser.setEmail(email);
        nonActivatedUser.setRole(role);

        assertThrows(UserExistsException.class, () -> userService.saveUser(nonActivatedUser));
    }

    @Test
    public void activateAccount_whenTokenIsValid() {
        String username = "sashenka";
        String activateAccountToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_ACTIVATE_ACCOUNT.getBytes()));
        userService.activateAccount(activateAccountToken);
        assertNull(getNonActivatedUserDao().findByUsername(username));
        assertNotNull(getUserDao().findByUsername(username));
    }

    @Test
    public void activateAccount_whenTokenIsInvalid() {
        String username = "sashenka";
        String activateAccountToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() - EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_ACTIVATE_ACCOUNT.getBytes()));
        assertThrows(LinkExpiredException.class, () -> userService.activateAccount(activateAccountToken));
        assertNotNull(getNonActivatedUserDao().findByUsername(username));
        assertNull(getUserDao().findByUsername(username));
    }

    @Test
    public void changePassword_whenAllDataIsCorrect_thenSuccess() {
        String currentUsername = "marik";
        String oldPassword = "who";
        String newPassword = "theWho";
        User user = getUserTable().get(10L);

        userService.changePassword(oldPassword, newPassword, currentUsername);

        assertNotEquals(newPassword, user.getPassword());
        assertTrue(getBCryptPasswordEncoder().matches(newPassword, user.getPassword()));
        assertFalse(getBCryptPasswordEncoder().matches(oldPassword, user.getPassword()));
    }

    @Test
    public void changePassword_whenOldPasswordIsNotCorrectAndBelongsToOtherUser_thenIncorrectDataExceptionThrown() {
        String currentUsername = "marik";
        String oldPassword = "male";
        String newPassword = "newPswd";

        assertThrows(IncorrectDataException.class, () -> userService.changePassword(oldPassword, newPassword, currentUsername));
    }

    @Test
    public void changePassword_whenOldPasswordIsNotCorrect_thenIncorrectDataExceptionThrown() {
        String currentUsername = "marik";
        String oldPassword = "somePswd";
        String newPassword = "newPswd";

        assertThrows(IncorrectDataException.class, () -> userService.changePassword(oldPassword, newPassword, currentUsername));
    }

    @Test
    public void deleteUserIfNotActivated_ifNotActivated() {
        String username = "sashenka";

        userService.deleteUserIfNotActivated(username);

        assertNull(getNonActivatedUserDao().findByUsername(username));
    }

    @Test
    public void deleteUserIfNotActivated_ifDoesntExist() {
        String username = "newUser";

        userService.deleteUserIfNotActivated(username);

        assertNull(getNonActivatedUserDao().findByUsername(username));
    }

    @Test
    public void deleteUserIfNotActivated_ifActivated() {
        String username = "derevo";

        userService.deleteUserIfNotActivated(username);

        assertNull(getNonActivatedUserDao().findByUsername(username));
    }

    @Test
    public void editInfo_whenSurnameIsChanged_thenAccessDeniedExceptionThrown() {
        String currentUsername = "marik";
        Role role = getRoleTable().get(3L);
        RoleDTO roleDTO = new RoleDTO(role.getId(), role.getName());
        SafeUserDTO editedUser = new SafeUserDTO(12L, "derevo", "Drevo", "Obrabotka", roleDTO, "tsemkaloalena@gmail.com");

        assertThrows(AccessDeniedException.class, () -> userService.editInfo(currentUsername, editedUser));
    }

    @Test
    public void editInfo_whenNewNameIsSet_thenNameChanged() {
        String currentUsername = "derevo";
        String oldName = "Derevo";
        String newName = "Bush";
        Long id = 12L;
        Role role = getRoleTable().get(3L);
        RoleDTO roleDTO = new RoleDTO(role.getId(), role.getName());
        SafeUserDTO editedUser = new SafeUserDTO(id, currentUsername, newName, "Obrabotka", roleDTO, "tsemkaloalena@gmail.com");

        userService.editInfo(currentUsername, editedUser);

        assertEquals(newName, getUserTable().get(id).getName());
        assertNotNull(getUserTable().get(id).getSurname());
        assertNotEquals(oldName, getUserTable().get(id).getName());
    }

    @Test
    public void getUsersByTheirId_whenListIsEmpty() {
        List<Long> userIds = new ArrayList<>(List.of(new Long[]{7L, 8L, 9L}));

        List<User> users = userService.getUsersByTheirId(userIds);
        for (int i = 0; i < users.size(); i++) {
            assertEquals(getUserTable().get(userIds.get(i)), users.get(i));
        }
    }
}

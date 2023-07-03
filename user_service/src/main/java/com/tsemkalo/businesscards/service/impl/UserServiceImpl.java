package com.tsemkalo.businesscards.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.ChangePasswordRequest;
import com.tsemkalo.businesscards.dao.NonActivatedUserDao;
import com.tsemkalo.businesscards.dao.UserDao;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.UserExistsException;
import com.tsemkalo.businesscards.mapper.NonActivatedUserMapper;
import com.tsemkalo.businesscards.mapper.UserMapper;
import com.tsemkalo.businesscards.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.EXPIRATION_TIME;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.SECRET;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.SECRET_ACTIVATE_ACCOUNT;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.SECRET_FORGOT_PASSWORD;

@Slf4j
@Component
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private NonActivatedUserDao nonActivatedUserDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NonActivatedUserMapper nonActivatedUserMapper;

    /**
     * @param username username of the searched user
     * @return found user
     * @throws UsernameNotFoundException if user is not found
     */
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    @Override
    public void saveUser(NonActivatedUser nonActivatedUser) {
        if (userDao.findByUsername(nonActivatedUser.getUsername()) != null || nonActivatedUserDao.findByUsername(nonActivatedUser.getUsername()) != null) {
            throw new UserExistsException(nonActivatedUser.getUsername());
        }
        nonActivatedUser.setEmail(nonActivatedUser.getEmail()); // check is built into the setter
        nonActivatedUser.setPassword(bCryptPasswordEncoder.encode(nonActivatedUser.getPassword()));
        nonActivatedUserDao.save(nonActivatedUser);
    }

    @Override
    public String changePassword(ChangePasswordRequest request) {
        if (request.getOldPassword().equals("")) {
            throw new IncorrectDataException("You didn't set old password");
        }
        if (request.getNewPassword().equals("")) {
            throw new IncorrectDataException("You didn't set new password");
        }
        User user = loadUserByUsername(request.getCurrentUsername());
        if (bCryptPasswordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(request.getNewPassword()));
            return user.getPassword();
        }
        throw new IncorrectDataException("Your old password is not correct.");
    }

    @Override
    public String activateAccount(String activationToken) {
        String username = JWT.require(Algorithm.HMAC512(SECRET_ACTIVATE_ACCOUNT.getBytes()))
                .build()
                .verify(activationToken)
                .getSubject();
        NonActivatedUser nonActivatedUser = nonActivatedUserDao.findByUsername(username);
        if (nonActivatedUser == null) {
            throw new UsernameNotFoundException(username);
        }
        User user = userMapper.nonActivatedToActivated(nonActivatedUser);
        userDao.save(user);
        nonActivatedUserDao.delete(nonActivatedUser);
        return user.getUsername();
    }

    @Override
    public void deleteUserIfNotActivated(String username) {
        NonActivatedUser nonActivatedUser = nonActivatedUserDao.findByUsername(username);
        if (nonActivatedUser != null) {
            nonActivatedUserDao.delete(nonActivatedUser);
        }
    }

    @Override
    public void editInfo(String currentUsername, SafeUserDTO editedInfo) throws IncorrectDataException {
        User user = userDao.findByUsername(currentUsername);
        if (!editedInfo.getName().isBlank() && ! editedInfo.getEmail().equals(user.getEmail())) {
            user.setEmail(editedInfo.getEmail());
            // TODO send email to check
        }
        if (!editedInfo.getName().isBlank()) {
            user.setName(editedInfo.getName());
        }
        if (!editedInfo.getSurname().isBlank()) {
            user.setSurname(editedInfo.getSurname());
        }
    }


//    /**
//     * @param currentUsername username of current user
//     * @param newUsername     new username
//     * @param password        password for checking with current
//     * @return message with new generated token
//     */
//    @Override
//    public String changeUsername(String currentUsername, String newUsername, String password) {
//        if (newUsername == null) {
//            throw new IncorrectDataException("You didn't set new username");
//        }
//        if (password == null) {
//            throw new IncorrectDataException("You didn't set your password");
//        }
//        User user = loadUserByUsername(currentUsername);
//        User userWithGivenUserName = userDao.findByUsername(newUsername);
//        if (userWithGivenUserName != null && !userWithGivenUserName.getId().equals(user.getId())) {
//            throw new UserExistsException(newUsername);
//        }
//        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
//            user.setUsername(newUsername);
//            String token = JWT.create()
//                    .withSubject(user.getUsername())
//                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                    .sign(Algorithm.HMAC512(SECRET.getBytes()));
//
//            return "Your username is changed successfully. Your new token: " + token;
//        }
//        throw new AccessDeniedException(user.getUsername() + "'s password is not correct.");
//    }


    /**
     * @param resetPasswordToken token from email by which the username is taken
     * @param newPassword new password
     */
    @Override
    public String resetPassword(String resetPasswordToken, String newPassword) {
        if (newPassword == null) {
            throw new IncorrectDataException("You didn't set new password");
        }
        String username = JWT.require(Algorithm.HMAC512(SECRET_FORGOT_PASSWORD.getBytes()))
                .build()
                .verify(resetPasswordToken)
                .getSubject();
        User user = loadUserByUsername(username);
        newPassword = bCryptPasswordEncoder.encode(newPassword);
        user.setPassword(newPassword);
        return newPassword;
    }
}

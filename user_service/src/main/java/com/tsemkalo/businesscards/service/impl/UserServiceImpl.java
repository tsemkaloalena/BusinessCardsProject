package com.tsemkalo.businesscards.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.dao.NonActivatedUserDao;
import com.tsemkalo.businesscards.dao.UserDao;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.exceptions.LinkExpiredException;
import com.tsemkalo.businesscards.exceptions.UserExistsException;
import com.tsemkalo.businesscards.mapper.NonActivatedUserMapper;
import com.tsemkalo.businesscards.mapper.UserMapper;
import com.tsemkalo.businesscards.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public NonActivatedUser loadNonActivateUserByUsername(String username) {
        NonActivatedUser user = nonActivatedUserDao.findByUsername(username);
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
    public String changePassword(String oldPassword, String newPassword, String currentUsername) {
        if (oldPassword.isBlank()) {
            throw new IncorrectDataException("You didn't set old password");
        }
        if (newPassword.isBlank()) {
            throw new IncorrectDataException("You didn't set new password");
        }
        User user = loadUserByUsername(currentUsername);
        if (bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(newPassword));
            return user.getPassword();
        }
        throw new IncorrectDataException("Your old password is not correct.");
    }

    @Override
    public String activateAccount(String activationToken) {
        String username;
        try {
            username = JWT.require(Algorithm.HMAC512(SECRET_ACTIVATE_ACCOUNT.getBytes()))
                    .build()
                    .verify(activationToken)
                    .getSubject();
        } catch (Exception exception) {
            throw new LinkExpiredException();
        }

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
        if (!editedInfo.getUsername().equals(currentUsername)) {
            throw new AccessDeniedException("You can not change username");
        }
        if (!editedInfo.getRoleDTO().getName().equals(user.getRole().getName())) {
            throw new AccessDeniedException("You can not change yor account type");
        }
        if (!editedInfo.getName().isBlank() && !editedInfo.getEmail().equals(user.getEmail())) {
            user.setEmail(editedInfo.getEmail());
        }
        if (!editedInfo.getName().isBlank()) {
            user.setName(editedInfo.getName());
        }
        if (!editedInfo.getSurname().isBlank()) {
            user.setSurname(editedInfo.getSurname());
        }
    }

    @Override
    public List<User> getUsersByTheirId(List<Long> userIds) {
        List<User> users = new ArrayList<>();
        for (Long userId : userIds) {
            Optional<User> optional = userDao.findById(userId);
            optional.ifPresent(users::add);
        }
        return users;
    }

    /**
     * @param resetPasswordToken token from email by which the username is taken
     * @param newPassword        new password
     */
    @Override
    public String resetPassword(String resetPasswordToken, String newPassword) {
        if (newPassword == null) {
            throw new IncorrectDataException("You didn't set new password");
        }
        String username;
        try {
            username = JWT.require(Algorithm.HMAC512(SECRET_FORGOT_PASSWORD.getBytes()))
                    .build()
                    .verify(resetPasswordToken)
                    .getSubject();
        } catch (Exception exception) {
            throw new LinkExpiredException();
        }
        User user = loadUserByUsername(username);
        newPassword = bCryptPasswordEncoder.encode(newPassword);
        user.setPassword(newPassword);
        return newPassword;
    }
}

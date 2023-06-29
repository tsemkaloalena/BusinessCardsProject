package com.tsemkalo.businesscards.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.ChangePasswordRequest;
import com.tsemkalo.businesscards.dao.NonActivatedUserDao;
import com.tsemkalo.businesscards.dao.UserDao;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.User;
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

import java.util.Date;

import static com.tsemkalo.businesscards.configuration.SecurityConstants.EXPIRATION_TIME;
import static com.tsemkalo.businesscards.configuration.SecurityConstants.SECRET;
import static com.tsemkalo.businesscards.configuration.SecurityConstants.SECRET_ACTIVATE_ACCOUNT;

@Slf4j
@Component
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
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
    }

    @Override
    public void deleteUserIfNotActivated(String username) {
        NonActivatedUser nonActivatedUser = nonActivatedUserDao.findByUsername(username);
        if (nonActivatedUser != null) {
            nonActivatedUserDao.delete(nonActivatedUser);
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
     * @param currentUsername username of current user
     * @param editedUser      user entity with fields that should be changed
     * @return id of the edited user
     */
//    @Override
//    public Long editInfo(String currentUsername, User editedUser) {
//        User user = loadUserByUsername(currentUsername);
//        if (editedUser.getName() == null && editedUser.getSurname() == null && editedUser.getEmail() == null) {
//            throw new IncorrectDataException("You didn't change any data");
//        }
//        if (editedUser.getEmail() != null) {
//            user.setEmail(editedUser.getEmail());
//        }
//        if (editedUser.getName() != null) {
//            user.setName(editedUser.getName());
//        }
//        if (editedUser.getSurname() != null) {
//            user.setSurname(editedUser.getSurname());
//        }
//
//        return user.getId();
//    }

    /**
     * Sending an email with generated link for resetting a password
     * @param username username of user for which the password should be reset
     */
//    @Override
//    public void sendForgotPasswordEmail(String username) {
//        try {
//            User user = loadUserByUsername(username);
//            MimeMessage message = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(message);
//            message.setFrom(emailFrom);
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
//            message.setSubject("Reset password");
//
//            String resetPasswordToken = JWT.create()
//                    .withSubject(username)
//                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                    .sign(Algorithm.HMAC512(SECRET_FORGOT_PASSWORD.getBytes()));
//
//            VelocityContext context = new VelocityContext();
//            context.put("name", user.getName());
//            context.put("surname", user.getSurname());
//            context.put("resetPasswordToken", resetPasswordToken);
//            StringWriter stringWriter = new StringWriter();
//            velocityEngine.mergeTemplate("forgot_password.vm", "UTF-8", context, stringWriter);
//            String text = stringWriter.toString();
//            helper.setText(text, true);
//            mailSender.send(message);
//        } catch (Exception exception) {
//            log.error(Arrays.toString(exception.getStackTrace()));
//            throw new MailSendingException(exception.getMessage());
//        }
//    }

//    /**
//     * @param resetPasswordToken token from email by which the username is taken
//     * @param newPassword new password
//     */
//    @Override
//    public void resetPassword(String resetPasswordToken, String newPassword) {
//        if (newPassword == null) {
//            throw new IncorrectDataException("You didn't set new password");
//        }
//        String username = JWT.require(Algorithm.HMAC512(SECRET_FORGOT_PASSWORD.getBytes()))
//                .build()
//                .verify(resetPasswordToken)
//                .getSubject();
//        User user = loadUserByUsername(username);
//        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
//    }
}

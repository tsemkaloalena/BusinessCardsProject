package com.tsemkalo.businesscards.service;

import com.tsemkalo.businesscards.ChangePasswordRequest;
import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import com.tsemkalo.businesscards.dao.entity.User;
import com.tsemkalo.businesscards.dto.SafeUserDTO;
import com.tsemkalo.businesscards.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void saveUser(NonActivatedUser nonActivatedUser);

    String changePassword(String oldPassword, String newPassword, String currentUsername);

    String activateAccount(String token);

    void deleteUserIfNotActivated(String username);

    void editInfo(String currentUsername, SafeUserDTO editedInfo);

    String resetPassword(String resetPasswordToken, String newPassword);

    List<User> getUsersByTheirId(List<Long> userIds);
}
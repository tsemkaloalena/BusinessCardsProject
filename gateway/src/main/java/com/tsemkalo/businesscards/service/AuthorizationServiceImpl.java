package com.tsemkalo.businesscards.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tsemkalo.businesscards.GRPCServiceNames;
import com.tsemkalo.businesscards.UserServiceGrpc;
import com.tsemkalo.businesscards.UsernameProto;
import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dto.cards.CardDTO;
import com.tsemkalo.businesscards.entity.User;
import com.tsemkalo.businesscards.exceptions.AuthorizationErrorException;
import com.tsemkalo.businesscards.exceptions.IncorrectDataException;
import com.tsemkalo.businesscards.mapper.UserMapper;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.EXPIRATION_TIME;
import static com.tsemkalo.businesscards.configuration.constants.SecurityConstants.SECRET;

@Component

public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GrpcClient(GRPCServiceNames.UserService)
    private UserServiceGrpc.UserServiceBlockingStub userService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public String loginUser(User user, String password) {
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return createToken(user.getUsername());
        } else {
            throw new AuthorizationErrorException("Wrong password");
        }
    }

    @Override
    public String createToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.protoToEntity(userService.getUserByUsername(UsernameProto.newBuilder().setUsername(username).build()));
    }
}

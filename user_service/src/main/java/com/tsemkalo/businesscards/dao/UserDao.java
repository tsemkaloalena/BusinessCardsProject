package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

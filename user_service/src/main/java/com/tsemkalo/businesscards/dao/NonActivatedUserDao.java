package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.NonActivatedUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NonActivatedUserDao extends JpaRepository<NonActivatedUser, Long> {
    NonActivatedUser findByUsername(String username);
}

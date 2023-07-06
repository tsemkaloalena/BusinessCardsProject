package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.configuration.enums.RoleType;
import com.tsemkalo.businesscards.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);
}

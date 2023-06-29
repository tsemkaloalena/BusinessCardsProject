package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Long> {
}

package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppearanceDao extends JpaRepository<Appearance, Long> {
}

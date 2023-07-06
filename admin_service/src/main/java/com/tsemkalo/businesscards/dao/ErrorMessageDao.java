package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entities.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorMessageDao extends JpaRepository<ErrorMessage, Long> {
}

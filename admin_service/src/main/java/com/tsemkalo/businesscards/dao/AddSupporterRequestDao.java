package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entities.AddSupporterRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddSupporterRequestDao extends JpaRepository<AddSupporterRequest, Long> {
    AddSupporterRequest findByUsername(String username);
    void deleteByUsername(String username);
}

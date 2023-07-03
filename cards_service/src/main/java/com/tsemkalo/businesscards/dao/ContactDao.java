package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact, Long> {
}

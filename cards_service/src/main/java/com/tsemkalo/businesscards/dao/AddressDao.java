package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Long> {
}

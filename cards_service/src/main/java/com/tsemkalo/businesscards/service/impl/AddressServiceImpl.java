package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.AddressDao;
import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class AddressServiceImpl extends AbstractServiceImpl<Address, AddressDao> implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    public void edit(Address oldAddress, Address editedAddress) {
        if (!oldAddress.getCard().getId().equals(editedAddress.getCard().getId())) {
            throw new AccessDeniedException("You can not change card id");
        }
        addressDao.save(editedAddress);
    }
}

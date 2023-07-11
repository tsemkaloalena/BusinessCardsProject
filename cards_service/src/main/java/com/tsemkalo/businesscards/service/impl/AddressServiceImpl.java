package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.AddressDao;
import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddressServiceImpl extends AbstractServiceImpl<Address, AddressDao> implements AddressService {
    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    public void edit(Address oldAddress, Address editedAddress) {
        if (!oldAddress.getCard().getId().equals(editedAddress.getCard().getId())) {
            throw new AccessDeniedException("You can not change card id");
        }
        getDefaultDao().save(editedAddress);
    }
}

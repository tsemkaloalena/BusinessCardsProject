package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.ContactDao;
import com.tsemkalo.businesscards.dao.entity.Appearance;
import com.tsemkalo.businesscards.dao.entity.Contact;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ContactServiceImpl extends AbstractServiceImpl<Contact, ContactDao> implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public Class<Contact> getEntityClass() {
        return Contact.class;
    }

    @Override
    public void edit(Contact oldContact, Contact editedContact) {
        if (!oldContact.getCard().getId().equals(editedContact.getCard().getId())) {
            throw new AccessDeniedException("You can not change card id");
        }
        contactDao.save(editedContact);
    }
}

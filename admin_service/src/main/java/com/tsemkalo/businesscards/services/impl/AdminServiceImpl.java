package com.tsemkalo.businesscards.services.impl;

import com.tsemkalo.businesscards.dao.AddSupporterRequestDao;
import com.tsemkalo.businesscards.dao.ErrorMessageDao;
import com.tsemkalo.businesscards.dao.entities.AddSupporterRequest;
import com.tsemkalo.businesscards.dao.entities.ErrorMessage;
import com.tsemkalo.businesscards.exceptions.AlreadyExistsException;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import com.tsemkalo.businesscards.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AddSupporterRequestDao addSupporterRequestDao;

    @Autowired
    private ErrorMessageDao errorMessageDao;

    @Override
    public void addTechSupportRequest(String username) {
        if (addSupporterRequestDao.findByUsername(username) != null) {
            throw new AlreadyExistsException("Request for adding tech supporter " + username + " already exists");
        }
        AddSupporterRequest addSupporterRequest = new AddSupporterRequest(username);
        addSupporterRequestDao.save(addSupporterRequest);
    }

    @Override
    public void saveErrorMessage(ErrorMessage errorMessage) {
        errorMessageDao.save(errorMessage);
    }

    @Override
    public List<AddSupporterRequest> getAddSupporterRequests() {
        return addSupporterRequestDao.findAll();
    }

    @Override
    public List<ErrorMessage> gerErrorMessages() {
        return errorMessageDao.findAll();
    }

    @Override
    public void deleteAddTechSupportRequest(String username) {
        AddSupporterRequest addSupporterRequest = addSupporterRequestDao.findByUsername(username);
        if (addSupporterRequest == null) {
            throw new NotFoundException("Request from user " + username + " is not found");
        }
        addSupporterRequestDao.delete(addSupporterRequest);
    }
}

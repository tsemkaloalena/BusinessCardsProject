package com.tsemkalo.businesscards.services;

import com.tsemkalo.businesscards.dao.entities.AddSupporterRequest;
import com.tsemkalo.businesscards.dao.entities.ErrorMessage;

import java.util.List;

public interface AdminService {
    void addTechSupportRequest(String username);

    void saveErrorMessage(ErrorMessage errorMessage);

    List<AddSupporterRequest> getAddSupporterRequests();

    List<ErrorMessage> gerErrorMessages();

    void deleteAddTechSupportRequest(String username);
}

package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.dao.AddSupporterRequestDao;
import com.tsemkalo.businesscards.dao.ErrorMessageDao;
import com.tsemkalo.businesscards.dao.entities.AddSupporterRequest;
import com.tsemkalo.businesscards.dao.entities.ErrorMessage;
import com.tsemkalo.businesscards.mappers.AddSupporterRequestMapper;
import com.tsemkalo.businesscards.mappers.ErrorMessageMapper;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@Setter
@Getter
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public abstract class AbstractTest {
    @Mock
    private AddSupporterRequestDao addSupporterRequestDao;
    @Mock
    private ErrorMessageDao errorMessageDao;

    @Spy
    @InjectMocks
    private AddSupporterRequestMapper addSupporterRequestMapper;
    @Spy
    @InjectMocks
    private ErrorMessageMapper errorMessageMapper;

    private Map<Long, AddSupporterRequest> addSupporterRequestTable;
    private Map<Long, ErrorMessage> errorMessageTable;

    private CommonMethodsSetUpper<AddSupporterRequest> addSupporterRequestCommonMethodsSetUpper = new CommonMethodsSetUpper();
    private CommonMethodsSetUpper<ErrorMessage> errorMessageCommonMethodsSetUpper = new CommonMethodsSetUpper();

    @BeforeEach
    public void fillDB() {
        addSupporterRequestTable = new HashMap<>();
        errorMessageTable = new HashMap<>();
        fillAddSupporterRequestTable();
        fillErrorMessageTable();
    }

    private void fillAddSupporterRequestTable() {
        addAddSupporterRequest(1L, "user1");
        addAddSupporterRequest(2L, "user2");
        addAddSupporterRequest(3L, "user3");
        addAddSupporterRequest(4L, "user4");
    }

    private void addAddSupporterRequest(Long id, String username) {
        AddSupporterRequest addSupporterRequest = new AddSupporterRequest();
        addSupporterRequest.setId(id);
        addSupporterRequest.setUsername(username);
        addSupporterRequestTable.put(id, addSupporterRequest);
    }

    private void fillErrorMessageTable() {
        addErrorMessage(1L, 404, "Entity with id 58 is not found");
        addErrorMessage(2L, 404, "Entity with id 9 is not found");
        addErrorMessage(3L, 500, "Connection with card service is aborted");
    }

    private void addErrorMessage(Long id, Integer code, String reason) {
        ErrorMessage errorMessage = new ErrorMessage(code, reason);
        errorMessage.setId(id);
        errorMessageTable.put(id, errorMessage);
    }

    @BeforeEach
    public void setup() {
        addSupporterRequestDaoSetup();
        errorMessageDaoSetup();
    }

    private void addSupporterRequestDaoSetup() {
        addSupporterRequestCommonMethodsSetUpper.findAllSetup(addSupporterRequestTable, addSupporterRequestDao);
        addSupporterRequestCommonMethodsSetUpper.findByIdSetup(addSupporterRequestTable, addSupporterRequestDao);
        addSupporterRequestCommonMethodsSetUpper.saveSetup(addSupporterRequestTable, addSupporterRequestDao, AddSupporterRequest.class);
        addSupporterRequestCommonMethodsSetUpper.deleteByIdSetup(addSupporterRequestTable, addSupporterRequestDao);
        addSupporterRequestCommonMethodsSetUpper.deleteSetup(addSupporterRequestTable, addSupporterRequestDao, AddSupporterRequest.class);
        lenient().doAnswer(invocationOnMock -> {
            String username = invocationOnMock.getArgument(0);
            for (AddSupporterRequest addSupporterRequest : addSupporterRequestTable.values()) {
                if (addSupporterRequest.getUsername().equals(username)) {
                    return addSupporterRequest;
                }
            }
            return null;
        }).when(addSupporterRequestDao).findByUsername(any(String.class));
    }

    private void errorMessageDaoSetup() {
        errorMessageCommonMethodsSetUpper.findAllSetup(errorMessageTable, errorMessageDao);
        errorMessageCommonMethodsSetUpper.findByIdSetup(errorMessageTable, errorMessageDao);
        errorMessageCommonMethodsSetUpper.saveSetup(errorMessageTable, errorMessageDao, ErrorMessage.class);
        errorMessageCommonMethodsSetUpper.deleteByIdSetup(errorMessageTable, errorMessageDao);
        errorMessageCommonMethodsSetUpper.deleteSetup(errorMessageTable, errorMessageDao, ErrorMessage.class);
    }
}

package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.dao.entities.AddSupporterRequest;
import com.tsemkalo.businesscards.dao.entities.ErrorMessage;
import com.tsemkalo.businesscards.exceptions.AlreadyExistsException;
import com.tsemkalo.businesscards.exceptions.NotFoundException;
import com.tsemkalo.businesscards.services.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest extends AbstractTest {
    @InjectMocks
    private AdminServiceImpl adminService;

    @Test
    public void addTechSupportRequest_whenUsernameDoesNotExist_thenAdd() {
        String username = "newSupporterName";
        int originalAddTechSupportRequestsAmount = getAddSupporterRequestTable().size();

        adminService.addTechSupportRequest(username);

        assertEquals(originalAddTechSupportRequestsAmount + 1, getAddSupporterRequestTable().size());
        boolean requestAdded = false;
        for (AddSupporterRequest addSupporterRequest : getAddSupporterRequestTable().values()) {
            if (username.equals(addSupporterRequest.getUsername())) {
                requestAdded = true;
                break;
            }
        }
        assertTrue(requestAdded);
    }

    @Test
    public void addTechSupportRequest_whenUsernameAlreadyExists_thenAlreadyExistsExceptionThrown() {
        String username = "user1";
        int originalAddTechSupportRequestsAmount = getAddSupporterRequestTable().size();

        assertThrows(AlreadyExistsException.class, () -> adminService.addTechSupportRequest(username));
        assertEquals(originalAddTechSupportRequestsAmount, getAddSupporterRequestTable().size());
    }

    @Test
    public void saveErrorMessage() {
        String reason = "Error text message";
        Integer code = 404;
        ErrorMessage newErrorMessage = new ErrorMessage(code, reason);

        int originalErrorMessagesAmount = getErrorMessageTable().size();

        adminService.saveErrorMessage(newErrorMessage);

        assertEquals(originalErrorMessagesAmount + 1, getErrorMessageTable().size());
        boolean errorAdded = false;
        for (ErrorMessage errorMessage : getErrorMessageTable().values()) {
            if (reason.equals(errorMessage.getReason()) && code.equals(errorMessage.getCode())) {
                errorAdded = true;
                break;
            }
        }
        assertTrue(errorAdded);
    }

    @Test
    public void getAddSupporterRequests() {
        List<AddSupporterRequest> addSupporterRequests = adminService.getAddSupporterRequests();

        assertEquals(getAddSupporterRequestTable().size(), addSupporterRequests.size());
        for (AddSupporterRequest addSupporterRequest : addSupporterRequests) {
            assertTrue(getAddSupporterRequestTable().containsKey(addSupporterRequest.getId()));
            assertEquals(getAddSupporterRequestTable().get(addSupporterRequest.getId()).getUsername(), addSupporterRequest.getUsername());
        }
    }

    @Test
    public void gerErrorMessages() {
        List<ErrorMessage> errorMessages = adminService.gerErrorMessages();

        assertEquals(getErrorMessageTable().size(), errorMessages.size());
        for (ErrorMessage errorMessage : errorMessages) {
            assertTrue(getErrorMessageTable().containsKey(errorMessage.getId()));
            assertEquals(getErrorMessageTable().get(errorMessage.getId()).getCode(), errorMessage.getCode());
            assertEquals(getErrorMessageTable().get(errorMessage.getId()).getReason(), errorMessage.getReason());
        }
    }

    @Test
    public void deleteAddTechSupportRequest_ifRequestExists_thenSuccess() {
        String username = "user3";

        adminService.deleteAddTechSupportRequest(username);

        for (AddSupporterRequest addSupporterRequest : getAddSupporterRequestTable().values()) {
            assertNotEquals(username, addSupporterRequest.getUsername());
        }
    }

    @Test
    public void deleteAddTechSupportRequest_ifRequestDoesNotExist_thenNotFoundExceptionThrown() {
        String username = "user90";

        assertThrows(NotFoundException.class, () -> adminService.deleteAddTechSupportRequest(username));
    }
}

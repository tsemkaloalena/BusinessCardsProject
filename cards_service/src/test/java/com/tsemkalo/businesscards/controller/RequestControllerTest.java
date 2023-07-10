package com.tsemkalo.businesscards.controller;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.AddressProto;
import com.tsemkalo.businesscards.AppearanceProto;
import com.tsemkalo.businesscards.CardListProto;
import com.tsemkalo.businesscards.CardProto;
import com.tsemkalo.businesscards.ContactProto;
import com.tsemkalo.businesscards.DeleteAddressProto;
import com.tsemkalo.businesscards.DeleteCardProto;
import com.tsemkalo.businesscards.DeleteContactProto;
import com.tsemkalo.businesscards.DeleteGalleryPhotoProto;
import com.tsemkalo.businesscards.EditAddressProto;
import com.tsemkalo.businesscards.EditAppearanceProto;
import com.tsemkalo.businesscards.EditCardProto;
import com.tsemkalo.businesscards.EditContactProto;
import com.tsemkalo.businesscards.EditGalleryPhotoProto;
import com.tsemkalo.businesscards.FollowProto;
import com.tsemkalo.businesscards.GalleryPhotoProto;
import com.tsemkalo.businesscards.IdValue;
import com.tsemkalo.businesscards.LikeProto;
import com.tsemkalo.businesscards.ProtoContactType;
import com.tsemkalo.businesscards.ProtoGalleryType;
import com.tsemkalo.businesscards.ProtoPictureStretchingType;
import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.dao.entity.Contact;
import com.tsemkalo.businesscards.dao.entity.Follow;
import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import com.tsemkalo.businesscards.dao.entity.Like;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.AlreadyExistsException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class RequestControllerTest extends AbstractTest {
    @InjectMocks
    private RequestController requestController;

    @Test
    public void addCard_whenDataIsCorrect_thenSuccess() throws Exception {
        CardProto cardProto = prepareCorrectCardProto().build();
        long currentUserId = 10L;
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<IdValue> responseObserver = StreamRecorder.create();
        requestController.addCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        IdValue idValue = results.get(0);
        assertNotNull(getCardTable().get(idValue.getId()));
        assertEquals(getCardTable().get(idValue.getId()).getUserId(), request.getCurrentUserId());
    }

    @Test
    public void addCard_whenOwnerIsNotSet_thenCurrentUserIsOwner() throws Exception {
        CardProto cardProto = prepareCorrectCardProto()
                .setUserId(0L).build();
        long currentUserId = 10L;
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<IdValue> responseObserver = StreamRecorder.create();
        requestController.addCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        IdValue idValue = results.get(0);
        assertNotNull(getCardTable().get(idValue.getId()));
        assertEquals(getCardTable().get(idValue.getId()).getUserId(), request.getCurrentUserId());
    }

    @Test
    public void addCard_whenCurrentUserIsAdmin_thenSuccess() throws Exception {
        CardProto cardProto = prepareCorrectCardProto().build();
        long currentUserId = 1L;
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .build();

        StreamRecorder<IdValue> responseObserver = StreamRecorder.create();
        requestController.addCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        IdValue idValue = results.get(0);
        assertNotNull(getCardTable().get(idValue.getId()));
        assertNotEquals(getCardTable().get(idValue.getId()).getUserId(), request.getCurrentUserId());
        assertEquals(getCardTable().get(idValue.getId()).getUserId(), cardProto.getUserId());
    }

    @Test
    public void addCard_whenCurrentUserAndCardOwnerUserDoNotMatch_thenAccessDeniedExceptionThrown() throws Exception {
        CardProto cardProto = prepareCorrectCardProto().build();
        long currentUserId = 14L;
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<IdValue> responseObserver = StreamRecorder.create();

        assertThrows(AccessDeniedException.class, () -> requestController.addCard(request, responseObserver));
        List<IdValue> results = responseObserver.getValues();
        assertEquals(0, results.size());
    }

    @Test
    public void addCard_whenContactsAreEmpty_thenSuccess() throws Exception {
        CardProto cardProto = prepareCardProtoWithoutContacts();
        long currentUserId = 10L;
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<IdValue> responseObserver = StreamRecorder.create();
        requestController.addCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<IdValue> results = responseObserver.getValues();
        assertEquals(1, results.size());
        IdValue idValue = results.get(0);
        assertNotNull(getCardTable().get(idValue.getId()));
        assertEquals(getCardTable().get(idValue.getId()).getUserId(), request.getCurrentUserId());
    }

    @Test
    public void editCard_whenDataIsCorrect_thenSuccess() throws Exception {
        long cardId = 1L;
        String newTitle = "New title";
        long currentUserId = 10L;
        CardProto cardProto = prepareCorrectCardProto()
                .setId(cardId)
                .setTitle(newTitle)
                .build();
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertEquals(newTitle, getCardTable().get(cardId).getTitle());
        assertEquals(request.getCurrentUserId(), getCardTable().get(cardId).getUserId());
    }

    @Test
    public void editCard_whenCardIdIsNotSet_thenNotFoundExceptionThrown() throws Exception {
        String newTitle = "New title";
        CardProto cardProto = prepareCorrectCardProto()
                .setTitle(newTitle)
                .build();
        long currentUserId = 10L;
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();
        
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.editCard(request, responseObserver));
    }

    @Test
    public void editCard_whenCurrentUserIsNotAnOwner_thenAccessDeniedExceptionThrown() {
        long cardId = 1L;
        long currentUserId = 11L;
        String newTitle = "New title";
        CardProto cardProto = prepareCorrectCardProto()
                .setId(cardId)
                .setTitle(newTitle)
                .build();
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editCard(request, responseObserver));

        assertNotEquals(newTitle, getCardTable().get(cardId).getTitle());
        assertNotEquals(request.getCurrentUserId(), getCardTable().get(cardId).getUserId());
    }

    @Test
    public void editCard_whenCurrentUserIsAdmin_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 1L;
        String newTitle = "New title";
        CardProto cardProto = prepareCorrectCardProto()
                .setId(cardId)
                .setTitle(newTitle)
                .build();
        EditCardProto request = EditCardProto.newBuilder()
                .setCardProto(cardProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertEquals(newTitle, getCardTable().get(cardId).getTitle());
        assertNotEquals(request.getCurrentUserId(), getCardTable().get(cardId).getUserId());
    }

    @Test
    public void deleteCard_whenDataIsCorrect_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 10L;
        DeleteCardProto request = DeleteCardProto.newBuilder()
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getCardTable().get(cardId));
    }

    @Test
    public void deleteCard_whenCardIdIsNotSet_thenNotFoundExceptionThrown() throws Exception {
        long currentUserId = 10L;
        DeleteCardProto request = DeleteCardProto.newBuilder()
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.deleteCard(request, responseObserver));
    }

    @Test
    public void deleteCard_whenCurrentUserIsNotAnOwner_thenAccessDeniedExceptionThrown() {
        long cardId = 1L;
        long currentUserId = 12L;
        DeleteCardProto request = DeleteCardProto.newBuilder()
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.deleteCard(request, responseObserver));
        assertNotNull(getCardTable().get(cardId));
    }

    @Test
    public void deleteCard_whenCurrentUserIsAdmin_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 1L;
        DeleteCardProto request = DeleteCardProto.newBuilder()
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteCard(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getCardTable().get(cardId));
    }

    @Test
    public void getCardInfoById_whenIdExists() throws Exception {
        long cardId = 1L;
        IdValue request = IdValue.newBuilder()
                .setId(cardId)
                .build();

        StreamRecorder<CardProto> responseObserver = StreamRecorder.create();
        requestController.getCardInfoById(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        List<CardProto> results = responseObserver.getValues();
        assertEquals(1, results.size());
        CardProto cardProto = results.get(0);
        assertEquals(getCardTable().get(cardId).getTitle(), cardProto.getTitle());
        assertEquals(getCardTable().get(cardId).getId(), cardProto.getId());
    }

    @Test
    public void getCardInfoById_whenIdDoesNotExist_thenNotFoundExceptionThrown() throws Exception {
        long cardId = 5L;
        IdValue request = IdValue.newBuilder()
                .setId(cardId)
                .build();

        StreamRecorder<CardProto> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.getCardInfoById(request, responseObserver));

        List<CardProto> results = responseObserver.getValues();
        assertEquals(0, results.size());
    }

    @Test
    public void getAllCardsInfoByUser_whenUserHasCards_thenReturnCardList() throws Exception {
        long userId = 10L;
        IdValue request = IdValue.newBuilder()
                .setId(userId)
                .build();

        StreamRecorder<CardListProto> responseObserver = StreamRecorder.create();
        requestController.getAllCardsInfoByUser(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<CardListProto> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<CardProto> cardProtos = results.get(0).getCardsList();
        assertFalse(cardProtos.isEmpty());
        for (CardProto cardProto : cardProtos) {
            assertEquals(userId, cardProto.getUserId());
        }
    }

    @Test
    public void getAllCardsInfoByUser_whenUserHasNoCards_thenReturnEmptyList() throws Exception {
        long userId = 16L;
        IdValue request = IdValue.newBuilder()
                .setId(userId)
                .build();

        StreamRecorder<CardListProto> responseObserver = StreamRecorder.create();
        requestController.getAllCardsInfoByUser(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        List<CardListProto> results = responseObserver.getValues();
        assertEquals(1, results.size());
        List<CardProto> cardProtos = results.get(0).getCardsList();
        assertTrue(cardProtos.isEmpty());
    }

    @Test
    public void editAppearance_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 10L;
        long cardId = 1L;
        long appearanceId = 1L;
        AppearanceProto appearanceProto = createAppearanceProto("Arial", "#fefeff",
                "https://lh3.googleusercontent.com/p/AF1QipOm02IDCOZAsKiJj3kU7XlLvKQWCQdjcfRV71wj=s1360-w1360-h1020",
                ProtoPictureStretchingType.FULL_SCREEN, "#000", "#234", ProtoGalleryType.GRID)
                .setId(appearanceId)
                .setCardId(cardId)
                .build();
        EditAppearanceProto request = EditAppearanceProto.newBuilder()
                .setAppearanceProto(appearanceProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editAppearance(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getAppearanceTable().get(appearanceId).getBackgroundColor(), appearanceProto.getBackgroundColor());
        assertEquals(getAppearanceTable().get(appearanceId).getCard().getId(), appearanceProto.getCardId());
        assertEquals(getAppearanceTable().get(appearanceId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editAppearance_whenCardBelongsToOtherUser_thenAccessDeniedExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        long appearanceId = 1L;
        AppearanceProto appearanceProto = createAppearanceProto("Arial", "#fefeff",
                "https://lh3.googleusercontent.com/p/AF1QipOm02IDCOZAsKiJj3kU7XlLvKQWCQdjcfRV71wj=s1360-w1360-h1020",
                ProtoPictureStretchingType.FULL_SCREEN, "#000", "#234", ProtoGalleryType.GRID)
                .setId(appearanceId)
                .setCardId(cardId)
                .build();
        EditAppearanceProto request = EditAppearanceProto.newBuilder()
                .setAppearanceProto(appearanceProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editAppearance(request, responseObserver));
    }

    @Test
    public void editAppearance_whenAppearanceBelongsToOtherCard_thenAccessDeniedExceptionThrown() {
        long currentUserId = 10L;
        long realCardId = 1L;
        long insertedCardId = 2L;
        long appearanceId = 1L;
        AppearanceProto appearanceProto = createAppearanceProto("Arial", "#fefeff",
                "https://lh3.googleusercontent.com/p/AF1QipOm02IDCOZAsKiJj3kU7XlLvKQWCQdjcfRV71wj=s1360-w1360-h1020",
                ProtoPictureStretchingType.FULL_SCREEN, "#000", "#234", ProtoGalleryType.GRID)
                .setId(appearanceId)
                .setCardId(insertedCardId)
                .build();
        EditAppearanceProto request = EditAppearanceProto.newBuilder()
                .setAppearanceProto(appearanceProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(realCardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editAppearance(request, responseObserver));
    }

    @Test
    public void editAppearance_whenCardBelongsToOtherUserAndCurrentUserIsAdmin_thenSuccess() throws Exception {
        long currentUserId = 1L;
        long cardId = 1L;
        long appearanceId = 1L;
        AppearanceProto appearanceProto = createAppearanceProto("Arial", "#fefeff",
                "https://lh3.googleusercontent.com/p/AF1QipOm02IDCOZAsKiJj3kU7XlLvKQWCQdjcfRV71wj=s1360-w1360-h1020",
                ProtoPictureStretchingType.FULL_SCREEN, "#000", "#234", ProtoGalleryType.GRID)
                .setId(appearanceId)
                .setCardId(cardId)
                .build();
        EditAppearanceProto request = EditAppearanceProto.newBuilder()
                .setAppearanceProto(appearanceProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editAppearance(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getAppearanceTable().get(appearanceId).getBackgroundColor(), appearanceProto.getBackgroundColor());
        assertEquals(getAppearanceTable().get(appearanceId).getCard().getId(), appearanceProto.getCardId());
        assertEquals(getAppearanceTable().get(appearanceId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editAppearance_whenIdDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        long appearanceId = 4L;
        AppearanceProto appearanceProto = createAppearanceProto("Arial", "#fefeff",
                "https://lh3.googleusercontent.com/p/AF1QipOm02IDCOZAsKiJj3kU7XlLvKQWCQdjcfRV71wj=s1360-w1360-h1020",
                ProtoPictureStretchingType.FULL_SCREEN, "#000", "#234", ProtoGalleryType.GRID)
                .setId(appearanceId)
                .setCardId(cardId)
                .build();
        EditAppearanceProto request = EditAppearanceProto.newBuilder()
                .setAppearanceProto(appearanceProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.editAppearance(request, responseObserver));
    }

    @Test
    public void addAddress_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 10L;
        long cardId = 1L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setCardId(cardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();
        int originalAddressesAmount = getAddressTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addAddress(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(originalAddressesAmount + 1, getAddressTable().size());
        boolean newAddressAdded = false;
        for (Address address : getAddressTable().values()) {
            if (address.getAddress().equals(addressProto.getAddress())) {
                newAddressAdded = true;
                break;
            }
        }
        assertTrue(newAddressAdded);
    }

    @Test
    public void addAddress_whenCardBelongsToOtherUser_thenAccessDeniedExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setCardId(cardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();
        int originalAddressesAmount = getAddressTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.addAddress(request, responseObserver));
        assertEquals(originalAddressesAmount, getAddressTable().size());
    }

    @Test
    public void addAddress_whenCardBelongsToOtherUserAndCurrentUserIsAdmin_thenSuccess() throws Exception {
        long currentUserId = 11L;
        long cardId = 1L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setCardId(cardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .setCardId(cardId)
                .build();
        int originalAddressesAmount = getAddressTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addAddress(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(originalAddressesAmount + 1, getAddressTable().size());
        boolean newAddressAdded = false;
        for (Address address : getAddressTable().values()) {
            if (address.getAddress().equals(addressProto.getAddress())) {
                newAddressAdded = true;
                break;
            }
        }
        assertTrue(newAddressAdded);
    }

    @Test
    public void editAddress_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 10L;
        long cardId = 1L;
        long addressId = 1L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setId(addressId)
                .setCardId(cardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editAddress(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getAddressTable().get(addressId).getAddress(), addressProto.getAddress());
        assertEquals(getAddressTable().get(addressId).getCard().getId(), addressProto.getCardId());
        assertEquals(getAddressTable().get(addressId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editAddress_whenCardBelongsToOtherUser_thenAccessDeniedExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        long addressId = 1L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setId(addressId)
                .setCardId(cardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editAddress(request, responseObserver));
    }

    @Test
    public void editAddress_whenAAddressBelongsToOtherCard_thenAccessDeniedExceptionThrown() {
        long currentUserId = 10L;
        long realCardId = 1L;
        long insertedCardId = 2L;
        long addressId = 1L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setId(addressId)
                .setCardId(insertedCardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(realCardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editAddress(request, responseObserver));
    }

    @Test
    public void editAddress_whenCardBelongsToOtherUserAndCurrentUserIsAdmin_thenSuccess() throws Exception {
        long currentUserId = 1L;
        long cardId = 1L;
        long addressId = 1L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setId(addressId)
                .setCardId(cardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editAddress(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getAddressTable().get(addressId).getAddress(), addressProto.getAddress());
        assertEquals(getAddressTable().get(addressId).getCard().getId(), addressProto.getCardId());
        assertEquals(getAddressTable().get(addressId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editAddress_whenIdDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        long addressId = 20L;
        AddressProto addressProto = createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true)
                .setId(addressId)
                .setCardId(cardId)
                .build();
        EditAddressProto request = EditAddressProto.newBuilder()
                .setAddressProto(addressProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.editAddress(request, responseObserver));
    }

    @Test
    public void deleteAddress_whenDataIsCorrect_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 10L;
        long addressId = 1L;
        DeleteAddressProto request = DeleteAddressProto.newBuilder()
                .setAddressId(addressId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteAddress(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getAddressTable().get(addressId));
    }

    @Test
    public void deleteAddress_whenCurrentUserIsNotAnOwner_thenAccessDeniedExceptionThrown() {
        long cardId = 1L;
        long currentUserId = 12L;
        long addressId = 1L;
        DeleteAddressProto request = DeleteAddressProto.newBuilder()
                .setAddressId(addressId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.deleteAddress(request, responseObserver));
        assertNotNull(getAddressTable().get(addressId));
    }

    @Test
    public void deleteAddress_whenCurrentUserIsAdmin_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 12L;
        long addressId = 1L;
        DeleteAddressProto request = DeleteAddressProto.newBuilder()
                .setAddressId(addressId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteAddress(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getAddressTable().get(addressId));
    }

    @Test
    public void addContact_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 10L;
        long cardId = 1L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setCardId(cardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();
        int originalContactsAmount = getContactTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addContact(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(originalContactsAmount + 1, getContactTable().size());
        boolean newContactAdded = false;
        for (Contact contact : getContactTable().values()) {
            if (contactProto.getContent().equals(contact.getContent())) {
                newContactAdded = true;
                break;
            }
        }
        assertTrue(newContactAdded);
    }

    @Test
    public void addContact_whenCardBelongsToOtherUser_thenAccessDeniedExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setCardId(cardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();
        int originalContactsAmount = getContactTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.addContact(request, responseObserver));
        assertEquals(originalContactsAmount, getContactTable().size());
    }

    @Test
    public void addContact_whenCardBelongsToOtherUserAndCurrentUserIsAdmin_thenSuccess() throws Exception {
        long currentUserId = 11L;
        long cardId = 1L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setCardId(cardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .setCardId(cardId)
                .build();
        int originalContactsAmount = getContactTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addContact(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(originalContactsAmount + 1, getContactTable().size());
        boolean newContactAdded = false;
        for (Contact contact : getContactTable().values()) {
            if (contactProto.getContent().equals(contact.getContent())) {
                newContactAdded = true;
                break;
            }
        }
        assertTrue(newContactAdded);
    }

    @Test
    public void editContact_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 10L;
        long cardId = 1L;
        long contactId = 1L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setId(contactId)
                .setCardId(cardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editContact(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getContactTable().get(contactId).getContent(), contactProto.getContent());
        assertEquals(getContactTable().get(contactId).getCard().getId(), contactProto.getCardId());
        assertEquals(getContactTable().get(contactId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editContact_whenCardBelongsToOtherUser_thenAccessDeniedExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        long contactId = 1L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setId(contactId)
                .setCardId(cardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();

        assertThrows(AccessDeniedException.class, () -> requestController.editContact(request, responseObserver));
    }

    @Test
    public void editContact_whenContactBelongsToOtherCard_thenAccessDeniedExceptionThrown() {
        long currentUserId = 10L;
        long realCardId = 1L;
        long insertedCardId = 2L;
        long contactId = 1L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setId(contactId)
                .setCardId(insertedCardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(realCardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editContact(request, responseObserver));
    }

    @Test
    public void editContact_whenCardBelongsToOtherUserAndCurrentUserIsAdmin_thenSuccess() throws Exception {
        long currentUserId = 1L;
        long cardId = 1L;
        long contactId = 1L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setId(contactId)
                .setCardId(cardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editContact(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getContactTable().get(contactId).getContent(), contactProto.getContent());
        assertEquals(getContactTable().get(contactId).getCard().getId(), contactProto.getCardId());
        assertEquals(getContactTable().get(contactId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editContact_whenIdDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 10L;
        long cardId = 1L;
        long contactId = 20L;
        ContactProto contactProto = createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com")
                .setId(contactId)
                .setCardId(cardId)
                .build();
        EditContactProto request = EditContactProto.newBuilder()
                .setContactProto(contactProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.editContact(request, responseObserver));
    }

    @Test
    public void deleteContact_whenDataIsCorrect_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 10L;
        long contactId = 1L;
        DeleteContactProto request = DeleteContactProto.newBuilder()
                .setContactId(contactId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteContact(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getContactTable().get(contactId));
    }

    @Test
    public void deleteContact_whenCurrentUserIsNotAnOwner_thenAccessDeniedExceptionThrown() {
        long cardId = 1L;
        long currentUserId = 12L;
        long contactId = 1L;
        DeleteContactProto request = DeleteContactProto.newBuilder()
                .setContactId(contactId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.deleteContact(request, responseObserver));
        assertNotNull(getContactTable().get(contactId));
    }

    @Test
    public void deleteContact_whenCurrentUserIsAdmin_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 12L;
        long contactId = 1L;
        DeleteContactProto request = DeleteContactProto.newBuilder()
                .setContactId(contactId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteContact(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getContactTable().get(contactId));
    }

    @Test
    public void addGalleryPhoto_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 10L;
        long cardId = 1L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setCardId(cardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();
        int originalGalleryPhotosAmount = getGalleryPhotoTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addGalleryPhoto(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(originalGalleryPhotosAmount + 1, getGalleryPhotoTable().size());
        boolean newGalleryPhotoAdded = false;
        for (GalleryPhoto galleryPhoto : getGalleryPhotoTable().values()) {
            if (galleryPhotoProto.getImgPath().equals(galleryPhoto.getImgPath())) {
                newGalleryPhotoAdded = true;
                break;
            }
        }
        assertTrue(newGalleryPhotoAdded);
    }

    @Test
    public void addGalleryPhoto_whenCardBelongsToOtherUser_thenAccessDeniedExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setCardId(cardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();
        int originalGalleryPhotosAmount = getGalleryPhotoTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.addGalleryPhoto(request, responseObserver));
        assertEquals(originalGalleryPhotosAmount, getGalleryPhotoTable().size());
    }

    @Test
    public void addGalleryPhoto_whenCardBelongsToOtherUserAndCurrentUserIsAdmin_thenSuccess() throws Exception {
        long currentUserId = 11L;
        long cardId = 1L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setCardId(cardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .setCardId(cardId)
                .build();
        int originalGalleryPhotosAmount = getGalleryPhotoTable().size();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addGalleryPhoto(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(originalGalleryPhotosAmount + 1, getGalleryPhotoTable().size());
        boolean newGalleryPhotoAdded = false;
        for (GalleryPhoto galleryPhoto : getGalleryPhotoTable().values()) {
            if (galleryPhotoProto.getImgPath().equals(galleryPhoto.getImgPath())) {
                newGalleryPhotoAdded = true;
                break;
            }
        }
        assertTrue(newGalleryPhotoAdded);
    }

    @Test
    public void editGalleryPhoto_whenDataIsCorrect_thenSuccess() throws Exception {
        long currentUserId = 10L;
        long cardId = 1L;
        long galleryPhotoId = 1L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setId(galleryPhotoId)
                .setCardId(cardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editGalleryPhoto(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getGalleryPhotoTable().get(galleryPhotoId).getImgPath(), galleryPhotoProto.getImgPath());
        assertEquals(getGalleryPhotoTable().get(galleryPhotoId).getCard().getId(), galleryPhotoProto.getCardId());
        assertEquals(getGalleryPhotoTable().get(galleryPhotoId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editGalleryPhoto_whenCardBelongsToOtherUser_thenAccessDeniedExceptionThrown() {
        long currentUserId = 11L;
        long cardId = 1L;
        long galleryPhotoId = 1L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setId(galleryPhotoId)
                .setCardId(cardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();

        assertThrows(AccessDeniedException.class, () -> requestController.editGalleryPhoto(request, responseObserver));
    }

    @Test
    public void editGalleryPhoto_whenGalleryPhotoBelongsToOtherCard_thenAccessDeniedExceptionThrown() {
        long currentUserId = 10L;
        long realCardId = 1L;
        long insertedCardId = 2L;
        long galleryPhotoId = 1L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setId(galleryPhotoId)
                .setCardId(insertedCardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(realCardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.editGalleryPhoto(request, responseObserver));
    }

    @Test
    public void editGalleryPhoto_whenCardBelongsToOtherUserAndCurrentUserIsAdmin_thenSuccess() throws Exception {
        long currentUserId = 1L;
        long cardId = 1L;
        long galleryPhotoId = 1L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setId(galleryPhotoId)
                .setCardId(cardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.editGalleryPhoto(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }
        assertEquals(getGalleryPhotoTable().get(galleryPhotoId).getImgPath(), galleryPhotoProto.getImgPath());
        assertEquals(getGalleryPhotoTable().get(galleryPhotoId).getCard().getId(), galleryPhotoProto.getCardId());
        assertEquals(getGalleryPhotoTable().get(galleryPhotoId).getCard(), getCardTable().get(cardId));
    }

    @Test
    public void editGalleryPhoto_whenIdDoesNotExist_thenNotFoundExceptionThrown() {
        long currentUserId = 10L;
        long cardId = 1L;
        long galleryPhotoId = 20L;
        GalleryPhotoProto galleryPhotoProto = createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1")
                .setId(galleryPhotoId)
                .setCardId(cardId)
                .build();
        EditGalleryPhotoProto request = EditGalleryPhotoProto.newBuilder()
                .setGalleryPhotoProto(galleryPhotoProto)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .setCardId(cardId)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.editGalleryPhoto(request, responseObserver));
    }

    @Test
    public void deleteGalleryPhoto_whenDataIsCorrect_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 10L;
        long galleryPhotoId = 1L;
        DeleteGalleryPhotoProto request = DeleteGalleryPhotoProto.newBuilder()
                .setGalleryPhotoId(galleryPhotoId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteGalleryPhoto(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getGalleryPhotoTable().get(galleryPhotoId));
    }

    @Test
    public void deleteGalleryPhoto_whenCurrentUserIsNotAnOwner_thenAccessDeniedExceptionThrown() {
        long cardId = 1L;
        long currentUserId = 12L;
        long galleryPhotoId = 1L;
        DeleteGalleryPhotoProto request = DeleteGalleryPhotoProto.newBuilder()
                .setGalleryPhotoId(galleryPhotoId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(false)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.deleteGalleryPhoto(request, responseObserver));
        assertNotNull(getGalleryPhotoTable().get(galleryPhotoId));
    }

    @Test
    public void deleteGalleryPhoto_whenCurrentUserIsAdmin_thenSuccess() throws Exception {
        long cardId = 1L;
        long currentUserId = 12L;
        long galleryPhotoId = 1L;
        DeleteGalleryPhotoProto request = DeleteGalleryPhotoProto.newBuilder()
                .setGalleryPhotoId(galleryPhotoId)
                .setCardId(cardId)
                .setCurrentUserId(currentUserId)
                .setAdmin(true)
                .build();

        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.deleteGalleryPhoto(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertNull(getGalleryPhotoTable().get(galleryPhotoId));
    }

    @Test
    public void addFollow_whenCardDoesNotExist_thenNotFoundExceptionThrown() {
        Long userId = 12L;
        Long cardId = 20L;
        FollowProto request = FollowProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalFollowsAmount = getFollowTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.addFollow(request, responseObserver));

        assertEquals(originalFollowsAmount, getFollowTable().size());
        boolean newFollowAdded = false;
        for (Follow follow : getFollowTable().values()) {
            if (cardId.equals(follow.getCard().getId()) && userId.equals(follow.getUserId())) {
                newFollowAdded = true;
                break;
            }
        }
        assertFalse(newFollowAdded);
    }

    @Test
    public void addFollow_whenCardIsAlreadyFollowed_thenAlreadyExistsExceptionThrown() {
        Long userId = 8L;
        Long cardId = 1L;
        FollowProto request = FollowProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalFollowsAmount = getFollowTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AlreadyExistsException.class, () -> requestController.addFollow(request, responseObserver));

        assertEquals(originalFollowsAmount, getFollowTable().size());
        int followsAmount = 0;
        for (Follow follow : getFollowTable().values()) {
            if (cardId.equals(follow.getCard().getId()) && userId.equals(follow.getUserId())) {
                followsAmount++;
            }
        }
        assertEquals(1, followsAmount);
    }

    @Test
    public void addFollow_whenUserOwnsFollowingCard_thenAccessDeniedExceptionThrown() {
        Long userId = 10L;
        Long cardId = 1L;
        FollowProto request = FollowProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalFollowsAmount = getFollowTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AccessDeniedException.class, () -> requestController.addFollow(request, responseObserver));

        assertEquals(originalFollowsAmount, getFollowTable().size());
        boolean newFollowAdded = false;
        for (Follow follow : getFollowTable().values()) {
            if (cardId.equals(follow.getCard().getId()) && userId.equals(follow.getUserId())) {
                newFollowAdded = true;
                break;
            }
        }
        assertFalse(newFollowAdded);
    }


    @Test
    public void addFollow_whenCardIsNotFollowedYet_thenSuccess() throws Exception {
        Long userId = 12L;
        Long cardId = 1L;
        FollowProto request = FollowProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalFollowsAmount = getFollowTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addFollow(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertEquals(originalFollowsAmount + 1, getFollowTable().size());
        boolean newFollowAdded = false;
        for (Follow follow : getFollowTable().values()) {
            if (cardId.equals(follow.getCard().getId()) && userId.equals(follow.getUserId())) {
                newFollowAdded = true;
                break;
            }
        }
        assertTrue(newFollowAdded);
    }


    @Test
    public void deleteFollow_whenCardDoesNotExist_thenNotFoundExceptionThrown() {
        Long userId = 12L;
        Long cardId = 20L;
        FollowProto request = FollowProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalFollowsAmount = getFollowTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.deleteFollow(request, responseObserver));

        assertEquals(originalFollowsAmount, getFollowTable().size());
    }

    @Test
    public void deleteFollow_whenCardIsNotFollowed_thenIncorrectDataExceptionThrown() {
        Long userId = 8L;
        Long cardId = 2L;
        FollowProto request = FollowProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalFollowsAmount = getFollowTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.deleteFollow(request, responseObserver));

        assertEquals(originalFollowsAmount, getFollowTable().size());
    }

    @Test
    public void addLike_whenCardDoesNotExist_thenNotFoundExceptionThrown() {
        Long userId = 12L;
        Long cardId = 20L;
        LikeProto request = LikeProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalLikesAmount = getLikeTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.addLike(request, responseObserver));

        assertEquals(originalLikesAmount, getLikeTable().size());
        boolean newLikeAdded = false;
        for (Like like : getLikeTable().values()) {
            if (cardId.equals(like.getCard().getId()) && userId.equals(like.getUserId())) {
                newLikeAdded = true;
                break;
            }
        }
        assertFalse(newLikeAdded);
    }

    @Test
    public void addLike_whenCardIsAlreadyLiked_thenAlreadyExistsExceptionThrown() {
        Long userId = 8L;
        Long cardId = 1L;
        LikeProto request = LikeProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalLikesAmount = getLikeTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(AlreadyExistsException.class, () -> requestController.addLike(request, responseObserver));

        assertEquals(originalLikesAmount, getLikeTable().size());
        int likesAmount = 0;
        for (Like like : getLikeTable().values()) {
            if (cardId.equals(like.getCard().getId()) && userId.equals(like.getUserId())) {
                likesAmount++;
            }
        }
        assertEquals(1, likesAmount);
    }

    @Test
    public void addLike_whenCardIsNotLikedYet_thenSuccess() throws Exception {
        Long userId = 12L;
        Long cardId = 1L;
        LikeProto request = LikeProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalLikesAmount = getLikeTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        requestController.addLike(request, responseObserver);

        if (!responseObserver.awaitCompletion(5, TimeUnit.SECONDS)) {
            fail("The call did not terminate in time");
        }

        assertEquals(originalLikesAmount + 1, getLikeTable().size());
        boolean newLikeAdded = false;
        for (Like like : getLikeTable().values()) {
            if (cardId.equals(like.getCard().getId()) && userId.equals(like.getUserId())) {
                newLikeAdded = true;
                break;
            }
        }
        assertTrue(newLikeAdded);
    }

    @Test
    public void deleteLike_whenCardDoesNotExist_thenNotFoundExceptionThrown() {
        long userId = 12L;
        long cardId = 20L;
        LikeProto request = LikeProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalLikesAmount = getLikeTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(NotFoundException.class, () -> requestController.deleteLike(request, responseObserver));

        assertEquals(originalLikesAmount, getLikeTable().size());
    }

    @Test
    public void deleteLike_whenCardIsNotLikeed_thenIncorrectDataExceptionThrown() {
        long userId = 8L;
        long cardId = 2L;
        LikeProto request = LikeProto.newBuilder()
                .setUserId(userId)
                .setCardId(cardId)
                .build();
        int originalLikesAmount = getLikeTable().size();
        StreamRecorder<Empty> responseObserver = StreamRecorder.create();
        assertThrows(IncorrectDataException.class, () -> requestController.deleteLike(request, responseObserver));

        assertEquals(originalLikesAmount, getLikeTable().size());
    }


    private GalleryPhotoProto.Builder createGalleryPhotoProto(String imgPath) {
        return GalleryPhotoProto.newBuilder()
                .setImgPath(imgPath);
    }

    private ContactProto.Builder createContactProto(ProtoContactType type, String content) {
        return ContactProto.newBuilder()
                .setType(type)
                .setContent(content);
    }

    private AddressProto.Builder createAddressProto(String address, boolean showOnMap) {
        return AddressProto.newBuilder()
                .setAddress(address)
                .setShowOnMap(showOnMap);
    }

    private AppearanceProto.Builder createAppearanceProto(String fontName, String backgroundColor, String backgroundImagePath, ProtoPictureStretchingType pictureStretching, String mainColor, String secondColor, ProtoGalleryType galleryType) {
        return AppearanceProto.newBuilder()
                .setFontName(fontName)
                .setBackgroundColor(backgroundColor)
                .setBackgroundImagePath(backgroundImagePath)
                .setPictureStretching(pictureStretching)
                .setMainColor(mainColor)
                .setSecondColor(secondColor)
                .setGalleryType(galleryType);
    }

    private CardProto.Builder prepareCorrectCardProto() {
        List<GalleryPhotoProto> photoProtos = new ArrayList<>();
        photoProtos.add(createGalleryPhotoProto("https://cdn.fs.teachablecdn.com/0fAXGi1SfKU6x5UF6Gj1").build());
        List<ContactProto> contactProtos = new ArrayList<>();
        contactProtos.add(createContactProto(ProtoContactType.WEB_SITE, "mosaicschool.com").build());
        contactProtos.add(createContactProto(ProtoContactType.MAIL_ADDRESS, "mosaicschool@gmail.com").build());
        List<AddressProto> addressProtos = new ArrayList<>();
        addressProtos.add(createAddressProto("Via Francesco Negri, 14, 48121 Ravenna RA, Italy", true).build());
        AppearanceProto appearanceProto = createAppearanceProto("Arial", "#fefeff",
                "https://lh3.googleusercontent.com/p/AF1QipOm02IDCOZAsKiJj3kU7XlLvKQWCQdjcfRV71wj=s1360-w1360-h1020",
                ProtoPictureStretchingType.FULL_SCREEN, "#000", "#234", ProtoGalleryType.GRID).build();

        return CardProto.newBuilder()
                .setUserId(10L)
                .setTitle("Mosaic Art School")
                .setLogoImgPath("/img/logo1.png")
                .setHeadline("Mosaic studio")
                .setDescription("Here will be description")
                .addAllPhotos(photoProtos)
                .addAllContacts(contactProtos)
                .addAllAddresses(addressProtos)
                .setAppearance(appearanceProto);
    }

    private CardProto prepareCardProtoWithoutContacts() {
        AppearanceProto appearanceProto = createAppearanceProto("Arial", "#fefeff",
                "https://lh3.googleusercontent.com/p/AF1QipOm02IDCOZAsKiJj3kU7XlLvKQWCQdjcfRV71wj=s1360-w1360-h1020",
                ProtoPictureStretchingType.FULL_SCREEN, "#000", "#234", ProtoGalleryType.GRID).build();

        return CardProto.newBuilder()
                .setUserId(10L)
                .setTitle("Mosaic Art School")
                .setLogoImgPath("/img/logo1.png")
                .setHeadline("Mosaic studio")
                .setDescription("Here will be description")
                .setAppearance(appearanceProto)
                .build();
    }
}

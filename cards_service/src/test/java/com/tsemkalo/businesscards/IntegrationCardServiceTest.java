package com.tsemkalo.businesscards;

import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.controller.RequestController;
import com.tsemkalo.businesscards.dao.AddressDao;
import com.tsemkalo.businesscards.dao.AppearanceDao;
import com.tsemkalo.businesscards.dao.CardDao;
import com.tsemkalo.businesscards.dao.ContactDao;
import com.tsemkalo.businesscards.dao.FollowDao;
import com.tsemkalo.businesscards.dao.GalleryPhotoDao;
import com.tsemkalo.businesscards.dao.LikeDao;
import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.dao.entity.Appearance;
import com.tsemkalo.businesscards.dao.entity.Card;
import com.tsemkalo.businesscards.dao.entity.Contact;
import com.tsemkalo.businesscards.dao.entity.Follow;
import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import com.tsemkalo.businesscards.dao.entity.Like;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.AlreadyExistsException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.mapper.AddressMapper;
import com.tsemkalo.businesscards.mapper.AppearanceMapper;
import com.tsemkalo.businesscards.mapper.CardMapper;
import com.tsemkalo.businesscards.mapper.ContactMapper;
import com.tsemkalo.businesscards.mapper.FollowMapper;
import com.tsemkalo.businesscards.mapper.GalleryPhotoMapper;
import com.tsemkalo.businesscards.mapper.LikeMapper;
import com.tsemkalo.businesscards.service.impl.AbstractServiceImpl;
import com.tsemkalo.businesscards.service.impl.AddressServiceImpl;
import com.tsemkalo.businesscards.service.impl.AppearanceServiceImpl;
import com.tsemkalo.businesscards.service.impl.CardServiceImpl;
import com.tsemkalo.businesscards.service.impl.ContactServiceImpl;
import com.tsemkalo.businesscards.service.impl.FollowServiceImpl;
import com.tsemkalo.businesscards.service.impl.GalleryPhotoServiceImpl;
import com.tsemkalo.businesscards.service.impl.LikeServiceImpl;
import io.grpc.internal.testing.StreamRecorder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.jdbc.Sql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@Sql("/createCardDB.sql")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntegrationCardServiceTest {
    @SpyBean
    private AddressDao addressDao;
    @SpyBean
    private AppearanceDao appearanceDao;
    @SpyBean
    private CardDao cardDao;
    @SpyBean
    private ContactDao contactDao;
    @SpyBean
    private FollowDao followDao;
    @SpyBean
    private GalleryPhotoDao galleryPhotoDao;
    @SpyBean
    private LikeDao likeDao;

    @Spy
    @InjectMocks
    private AddressMapper addressMapper;
    @Spy
    @InjectMocks
    private AppearanceMapper appearanceMapper;
    @Spy
    @InjectMocks
    private CardMapper cardMapper;
    @Spy
    @InjectMocks
    private ContactMapper contactMapper;
    @Spy
    @InjectMocks
    private FollowMapper followMapper;
    @Spy
    @InjectMocks
    private GalleryPhotoMapper galleryPhotoMapper;
    @Spy
    @InjectMocks
    private LikeMapper likeMapper;

    @Spy
    @InjectMocks
    private AddressServiceImpl addressService;
    @Spy
    @InjectMocks
    private AppearanceServiceImpl appearanceService;
    @Spy
    @InjectMocks
    private CardServiceImpl cardService;
    @Spy
    @InjectMocks
    private ContactServiceImpl contactService;
    @Spy
    @InjectMocks
    private FollowServiceImpl followService;
    @Spy
    @InjectMocks
    private GalleryPhotoServiceImpl galleryPhotoService;
    @Spy
    @InjectMocks
    private LikeServiceImpl likeService;

    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    public void setupServices() {
//        appearanceService.setDefaultDao(appearanceDao);
//        addressService.setDefaultDao(addressDao);
//        cardService.setDefaultDao(cardDao);
//        contactService.setDefaultDao(contactDao);
//        followService.setDefaultDao(followDao);
//        galleryPhotoService.setDefaultDao(galleryPhotoDao);
//        likeService.setDefaultDao(likeDao);
        try {
            Field defaultDaoFollowField = AbstractServiceImpl.class.getDeclaredField("defaultDao");
            defaultDaoFollowField.setAccessible(true);
            defaultDaoFollowField.set(appearanceService, appearanceDao);
            defaultDaoFollowField.set(addressService, addressDao);
            defaultDaoFollowField.set(cardService, cardDao);
            defaultDaoFollowField.set(contactService, contactDao);
            defaultDaoFollowField.set(followService, followDao);
            defaultDaoFollowField.set(galleryPhotoService, galleryPhotoDao);
            defaultDaoFollowField.set(likeService, likeDao);
            defaultDaoFollowField.setAccessible(false);

            Field cardDaoFollowField = FollowServiceImpl.class.getDeclaredField("cardDao");
            cardDaoFollowField.setAccessible(true);
            cardDaoFollowField.set(followService, cardDao);
            cardDaoFollowField.setAccessible(false);

            Field cardDaoLikeField = LikeServiceImpl.class.getDeclaredField("cardDao");
            cardDaoLikeField.setAccessible(true);
            cardDaoLikeField.set(likeService, cardDao);
            cardDaoLikeField.setAccessible(false);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

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
        Map<Long, Card> cardTable = getCardTable();
        assertNotNull(cardTable.get(idValue.getId()));
        assertEquals(cardTable.get(idValue.getId()).getUserId(), request.getCurrentUserId());
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
        Map<Long, Card> cardTable = getCardTable();
        assertNotNull(cardTable.get(idValue.getId()));
        assertEquals(cardTable.get(idValue.getId()).getUserId(), request.getCurrentUserId());
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
        Map<Long, Card> cardTable = getCardTable();
        assertNotNull(cardTable.get(idValue.getId()));
        assertNotEquals(cardTable.get(idValue.getId()).getUserId(), request.getCurrentUserId());
        assertEquals(cardTable.get(idValue.getId()).getUserId(), cardProto.getUserId());
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
        Map<Long, Card> cardTable = getCardTable();
        assertNotNull(cardTable.get(idValue.getId()));
        assertEquals(cardTable.get(idValue.getId()).getUserId(), request.getCurrentUserId());
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
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(newTitle, cardTable.get(cardId).getTitle());
        assertEquals(request.getCurrentUserId(), cardTable.get(cardId).getUserId());
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

        Map<Long, Card> cardTable = getCardTable();
        assertNotEquals(newTitle, cardTable.get(cardId).getTitle());
        assertNotEquals(request.getCurrentUserId(), cardTable.get(cardId).getUserId());
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
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(newTitle, cardTable.get(cardId).getTitle());
        assertNotEquals(request.getCurrentUserId(), cardTable.get(cardId).getUserId());
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
        Map<Long, Card> cardTable = getCardTable();
        assertNull(cardTable.get(cardId));
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

        Map<Long, Card> cardTable = getCardTable();
        assertNotNull(cardTable.get(cardId));
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
        Map<Long, Card> cardTable = getCardTable();
        assertNull(cardTable.get(cardId));
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
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(cardTable.get(cardId).getTitle(), cardProto.getTitle());
        assertEquals(cardTable.get(cardId).getId(), cardProto.getId());
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
        Map<Long, Card> cardTable = getCardTable();
        Map<Long, Appearance> appearanceTable = getAppearanceTable();
        assertEquals(appearanceTable.get(appearanceId).getBackgroundColor(), appearanceProto.getBackgroundColor());
        assertEquals(appearanceTable.get(appearanceId).getCard().getId(), appearanceProto.getCardId());
        assertEquals(appearanceTable.get(appearanceId).getCard(), cardTable.get(cardId));
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
        Map<Long, Card> cardTable = getCardTable();
        Map<Long, Appearance> appearanceTable = getAppearanceTable();
        assertEquals(appearanceTable.get(appearanceId).getBackgroundColor(), appearanceProto.getBackgroundColor());
        assertEquals(appearanceTable.get(appearanceId).getCard().getId(), appearanceProto.getCardId());
        assertEquals(appearanceTable.get(appearanceId).getCard(), cardTable.get(cardId));
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
        Map<Long, Address> addressTable = getAddressTable();
        assertEquals(originalAddressesAmount + 1, addressTable.size());
        boolean newAddressAdded = false;
        for (Address address : addressTable.values()) {
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
        Map<Long, Address> addressTable = getAddressTable();
        assertEquals(originalAddressesAmount + 1, addressTable.size());
        boolean newAddressAdded = false;
        for (Address address : addressTable.values()) {
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
        Map<Long, Address> addressTable = getAddressTable();
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(addressTable.get(addressId).getAddress(), addressProto.getAddress());
        assertEquals(addressTable.get(addressId).getCard().getId(), addressProto.getCardId());
        assertEquals(addressTable.get(addressId).getCard(), cardTable.get(cardId));
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
        Map<Long, Address> addressTable = getAddressTable();
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(addressTable.get(addressId).getAddress(), addressProto.getAddress());
        assertEquals(addressTable.get(addressId).getCard().getId(), addressProto.getCardId());
        assertEquals(addressTable.get(addressId).getCard(), cardTable.get(cardId));
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
        Map<Long, Contact> contactTable = getContactTable();
        assertEquals(originalContactsAmount + 1, contactTable.size());
        boolean newContactAdded = false;
        for (Contact contact : contactTable.values()) {
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
        Map<Long, Contact> contactTable = getContactTable();
        assertEquals(originalContactsAmount + 1, contactTable.size());
        boolean newContactAdded = false;
        for (Contact contact : contactTable.values()) {
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
        Map<Long, Contact> contactTable = getContactTable();
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(contactTable.get(contactId).getContent(), contactProto.getContent());
        assertEquals(contactTable.get(contactId).getCard().getId(), contactProto.getCardId());
        assertEquals(contactTable.get(contactId).getCard(), cardTable.get(cardId));
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
        Map<Long, Contact> contactTable = getContactTable();
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(contactTable.get(contactId).getContent(), contactProto.getContent());
        assertEquals(contactTable.get(contactId).getCard().getId(), contactProto.getCardId());
        assertEquals(contactTable.get(contactId).getCard(), cardTable.get(cardId));
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
        Map<Long, GalleryPhoto> galleryPhotoTable = getGalleryPhotoTable();
        assertEquals(originalGalleryPhotosAmount + 1, galleryPhotoTable.size());
        boolean newGalleryPhotoAdded = false;
        for (GalleryPhoto galleryPhoto : galleryPhotoTable.values()) {
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
        Map<Long, GalleryPhoto> galleryPhotoTable = getGalleryPhotoTable();
        assertEquals(originalGalleryPhotosAmount + 1, galleryPhotoTable.size());
        boolean newGalleryPhotoAdded = false;
        for (GalleryPhoto galleryPhoto : galleryPhotoTable.values()) {
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
        Map<Long, GalleryPhoto> galleryPhotoTable = getGalleryPhotoTable();
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(galleryPhotoTable.get(galleryPhotoId).getImgPath(), galleryPhotoProto.getImgPath());
        assertEquals(galleryPhotoTable.get(galleryPhotoId).getCard().getId(), galleryPhotoProto.getCardId());
        assertEquals(galleryPhotoTable.get(galleryPhotoId).getCard(), cardTable.get(cardId));
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
        Map<Long, GalleryPhoto> galleryPhotoTable = getGalleryPhotoTable();
        Map<Long, Card> cardTable = getCardTable();
        assertEquals(galleryPhotoTable.get(galleryPhotoId).getImgPath(), galleryPhotoProto.getImgPath());
        assertEquals(galleryPhotoTable.get(galleryPhotoId).getCard().getId(), galleryPhotoProto.getCardId());
        assertEquals(galleryPhotoTable.get(galleryPhotoId).getCard(), cardTable.get(cardId));
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

        Map<Long, Follow> followTable = getFollowTable();
        assertEquals(originalFollowsAmount, followTable.size());
        boolean newFollowAdded = false;
        for (Follow follow : followTable.values()) {
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

        Map<Long, Follow> followTable = getFollowTable();
        assertEquals(originalFollowsAmount, followTable.size());
        int followsAmount = 0;
        for (Follow follow : followTable.values()) {
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

        Map<Long, Follow> followTable = getFollowTable();
        assertEquals(originalFollowsAmount, followTable.size());
        boolean newFollowAdded = false;
        for (Follow follow : followTable.values()) {
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
        Map<Long, Follow> followTable = getFollowTable();
        assertEquals(originalFollowsAmount + 1, followTable.size());
        boolean newFollowAdded = false;
        for (Follow follow : followTable.values()) {
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
        long userId = 8L;
        long cardId = 2L;
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

        Map<Long, Like> likeTable = getLikeTable();
        assertEquals(originalLikesAmount, likeTable.size());
        boolean newLikeAdded = false;
        for (Like like : likeTable.values()) {
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

        Map<Long, Like> likeTable = getLikeTable();
        assertEquals(originalLikesAmount, likeTable.size());
        int likesAmount = 0;
        for (Like like : likeTable.values()) {
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
        Map<Long, Like> likeTable = getLikeTable();
        assertEquals(originalLikesAmount + 1, likeTable.size());
        boolean newLikeAdded = false;
        for (Like like : likeTable.values()) {
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

    private Map<Long, Address> getAddressTable() {
        Map<Long, Address> table = new HashMap<>();
        for (Address address : addressDao.findAll()) {
            table.put(address.getId(), address);
        }
        return table;
    }

    private Map<Long, Appearance> getAppearanceTable() {
        Map<Long, Appearance> table = new HashMap<>();
        for (Appearance appearance : appearanceDao.findAll()) {
            table.put(appearance.getId(), appearance);
        }
        return table;
    }

    private Map<Long, Card> getCardTable() {
        Map<Long, Card> table = new HashMap<>();
        for (Card card : cardDao.findAll()) {
            table.put(card.getId(), card);
        }
        return table;
    }

    private Map<Long, Contact> getContactTable() {
        Map<Long, Contact> table = new HashMap<>();
        for (Contact contact : contactDao.findAll()) {
            table.put(contact.getId(), contact);
        }
        return table;
    }

    private Map<Long, Follow> getFollowTable() {
        Map<Long, Follow> table = new HashMap<>();
        for (Follow follow : followDao.findAll()) {
            table.put(follow.getId(), follow);
        }
        return table;
    }

    private Map<Long, GalleryPhoto> getGalleryPhotoTable() {
        Map<Long, GalleryPhoto> table = new HashMap<>();
        for (GalleryPhoto galleryPhoto : galleryPhotoDao.findAll()) {
            table.put(galleryPhoto.getId(), galleryPhoto);
        }
        return table;
    }

    private Map<Long, Like> getLikeTable() {
        Map<Long, Like> table = new HashMap<>();
        for (Like like : likeDao.findAll()) {
            table.put(like.getId(), like);
        }
        return table;
    }
}

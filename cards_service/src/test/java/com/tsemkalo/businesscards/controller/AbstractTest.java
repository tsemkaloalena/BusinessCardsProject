package com.tsemkalo.businesscards.controller;

import com.tsemkalo.businesscards.configuration.enums.ContactType;
import com.tsemkalo.businesscards.configuration.enums.GalleryType;
import com.tsemkalo.businesscards.configuration.enums.PictureStretchingType;
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
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@Setter
@Getter
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public abstract class AbstractTest {
    @Mock
    private AddressDao addressDao;
    @Mock
    private AppearanceDao appearanceDao;
    @Mock
    private CardDao cardDao;
    @Mock
    private ContactDao contactDao;
    @Mock
    private FollowDao followDao;
    @Mock
    private GalleryPhotoDao galleryPhotoDao;
    @Mock
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
    private AddressServiceImpl addressService;
    @Spy
    private AppearanceServiceImpl appearanceService;
    @Spy
    private CardServiceImpl cardService;
    @Spy
    private ContactServiceImpl contactService;
    @Spy
    private FollowServiceImpl followService;
    @Spy
    private GalleryPhotoServiceImpl galleryPhotoService;
    @Spy
    private LikeServiceImpl likeService;

    private Map<Long, Address> addressTable = new HashMap<>();
    private Map<Long, Appearance> appearanceTable = new HashMap<>();
    private Map<Long, Card> cardTable = new HashMap<>();
    private Map<Long, Contact> contactTable = new HashMap<>();
    private Map<Long, Follow> followTable = new HashMap<>();
    private Map<Long, GalleryPhoto> galleryPhotoTable = new HashMap<>();
    private Map<Long, Like> likeTable = new HashMap<>();

    private CommonMethodsSetUpper<Address> addressCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Appearance> appearanceCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Card> cardCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Contact> contactCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Follow> followCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<GalleryPhoto> galleryPhotoCommonMethodsSetUpper = new CommonMethodsSetUpper<>();
    private CommonMethodsSetUpper<Like> likeCommonMethodsSetUpper = new CommonMethodsSetUpper<>();

    @BeforeEach
    public void fillDB() {
        addressTable = new HashMap<>();
        appearanceTable = new HashMap<>();
        cardTable = new HashMap<>();
        contactTable = new HashMap<>();
        followTable = new HashMap<>();
        galleryPhotoTable = new HashMap<>();
        likeTable = new HashMap<>();
        fillCardTable();
        fillAddressTable();
        fillAppearanceTable();
        fillContactTable();
        fillFollowTable();
        fillGalleryPhotoTable();
        fillLikeTable();
    }

    @BeforeEach
    public void setup() {
        addressDaoSetup();
        appearanceDaoSetup();
        cardDaoSetup();
        contactDaoSetup();
        followDaoSetup();
        galleryPhotoDaoSetup();
        likeDaoSetup();
    }

    @BeforeEach
    public void setupServices() {
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

    private void fillAddressTable() {
        addAddress(1L, "add1", true, 1L);
        addAddress(2L, "add2", false, 1L);
    }

    public void addAddress(Long id, String addressValue, Boolean showOnMap, Long cardId) {
        Address address = new Address();
        address.setId(id);
        address.setAddress(addressValue);
        address.setShowOnMap(showOnMap);
        Card card = cardTable.get(cardId);
        address.setCard(card);
        card.getAddresses().add(address);
        addressTable.put(id, address);
    }

    private void fillAppearanceTable() {
        addAppearance(1L, 1L, "font1", "#ffffff", "", PictureStretchingType.FULL_SCREEN, "#ff0000", "#f000ff", GalleryType.COLLAGE);
        addAppearance(2L, 2L, "font2", "#eeffff", "/img/path.jpg", PictureStretchingType.DOCUMENT_CENTER, "#ee0000", "#f0e0ff", GalleryType.GRID);
        addAppearance(3L, 3L, "font3", "#eeffff", "/img/path3.jpg", PictureStretchingType.FULL_DOCUMENT_STRETCH, "#ee0000", "#f0e0ff", GalleryType.CAROUSEL);
    }

    public void addAppearance(Long id, Long cardId, String fontName, String backgroundColor, String backgroundImagePath, PictureStretchingType pictureStretching, String mainColor, String secondColor, GalleryType galleryType) {
        Appearance appearance = new Appearance();
        appearance.setId(id);
        Card card = cardTable.get(cardId);
        appearance.setCard(card);
        appearance.setFontName(fontName);
        appearance.setBackgroundColor(backgroundColor);
        appearance.setBackgroundImagePath(backgroundImagePath);
        appearance.setPictureStretching(pictureStretching);
        appearance.setMainColor(mainColor);
        appearance.setSecondColor(secondColor);
        appearance.setGalleryType(galleryType);
        card.setAppearance(appearance);
        appearanceTable.put(id, appearance);
    }

    private void fillCardTable() {
        addCard(1L, 10L, "title2", "logo1", "line1", "d1");
        addCard(2L, 10L, "title3", "logo2", "line2", "d2");
        addCard(3L, 11L, "title4", "logo3", "line3", "d3");
    }

    public void addCard(Long id, Long userId, String title, String logoImgPath, String headline, String description) {
        Card card = new Card();
        card.setId(id);
        card.setUserId(userId);
        card.setTitle(title);
        card.setLogoImgPath(logoImgPath);
        card.setHeadline(headline);
        card.setDescription(description);
        card.setAddresses(new ArrayList<>());
        card.setContacts(new ArrayList<>());
        card.setPhotos(new ArrayList<>());
        card.setFollows(new ArrayList<>());
        card.setLikes(new ArrayList<>());
        cardTable.put(id, card);
    }

    private void fillContactTable() {
        addContact(1L, ContactType.SOCIAL_NETWORK, "inst_link", 1L);
        addContact(2L, ContactType.MAIL_ADDRESS, "test@gmail.com", 1L);
        addContact(3L, ContactType.PHONE_NUMBER, "909456480849", 2L);
        addContact(4L, ContactType.MAIL_ADDRESS, "test2@gmail.com", 3L);
    }

    public void addContact(Long id, ContactType type, String content, Long cardId) {
        Contact contact = new Contact();
        Card card = cardTable.get(cardId);
        contact.setId(id);
        contact.setContent(content);
        contact.setType(type);
        contact.setCard(card);
        card.getContacts().add(contact);
        contactTable.put(id, contact);
    }

    private void fillGalleryPhotoTable() {
        addGalleryPhoto(1L, "path1", 1L);
        addGalleryPhoto(2L, "path2", 1L);
        addGalleryPhoto(3L, "path3", 2L);
        addGalleryPhoto(4L, "path4", 2L);
        addGalleryPhoto(5L, "path5", 3L);
    }

    public void addGalleryPhoto(Long id, String imgPath, Long cardId) {
        GalleryPhoto galleryPhoto = new GalleryPhoto();
        Card card = cardTable.get(cardId);
        galleryPhoto.setId(id);
        galleryPhoto.setImgPath(imgPath);
        galleryPhoto.setCard(card);
        card.getPhotos().add(galleryPhoto);
        galleryPhotoTable.put(id, galleryPhoto);
    }

    private void fillFollowTable() {
        addFollow(1L, 8L, 1L);
        addFollow(2L, 11L, 1L);
        addFollow(3L, 5L, 2L);
        addFollow(4L, 5L, 3L);
    }

    public void addFollow(Long id, Long userId, Long cardId) {
        Follow follow = new Follow();
        Card card = cardTable.get(cardId);
        follow.setId(id);
        follow.setUserId(userId);
        follow.setCard(card);
        card.getFollows().add(follow);
        followTable.put(id, follow);
    }

    private void fillLikeTable() {
        addLike(1L, 8L, 1L);
        addLike(2L, 9L, 1L);
        addLike(3L, 10L, 1L);
        addLike(4L, 11L, 1L);
        addLike(5L, 4L, 2L);
        addLike(6L, 4L, 3L);
    }

    public void addLike(Long id, Long userId, Long cardId) {
        Like like = new Like();
        Card card = cardTable.get(cardId);
        like.setId(id);
        like.setUserId(userId);
        like.setCard(card);
        card.getLikes().add(like);
        likeTable.put(id, like);
    }

    private void addressDaoSetup() {
        addressCommonMethodsSetUpper.findAllSetup(addressTable, addressDao);
        addressCommonMethodsSetUpper.findByIdSetup(addressTable, addressDao);
        addressCommonMethodsSetUpper.saveSetup(addressTable, addressDao, Address.class);
        addressCommonMethodsSetUpper.deleteSetup(addressTable, addressDao, Address.class);
        addressCommonMethodsSetUpper.deleteByIdSetup(addressTable, addressDao);
        addressCommonMethodsSetUpper.existSetup(addressTable, addressDao);
    }

    private void appearanceDaoSetup() {
        appearanceCommonMethodsSetUpper.findAllSetup(appearanceTable, appearanceDao);
        appearanceCommonMethodsSetUpper.findByIdSetup(appearanceTable, appearanceDao);
        appearanceCommonMethodsSetUpper.saveSetup(appearanceTable, appearanceDao, Appearance.class);
        appearanceCommonMethodsSetUpper.deleteSetup(appearanceTable, appearanceDao, Appearance.class);
        appearanceCommonMethodsSetUpper.deleteByIdSetup(appearanceTable, appearanceDao);
        appearanceCommonMethodsSetUpper.existSetup(appearanceTable, appearanceDao);
    }

    private void cardDaoSetup() {
        cardCommonMethodsSetUpper.findAllSetup(cardTable, cardDao);
        cardCommonMethodsSetUpper.findByIdSetup(cardTable, cardDao);
        cardCommonMethodsSetUpper.saveSetup(cardTable, cardDao, Card.class);
        cardCommonMethodsSetUpper.deleteSetup(cardTable, cardDao, Card.class);
        cardCommonMethodsSetUpper.deleteByIdSetup(cardTable, cardDao);
        cardCommonMethodsSetUpper.existSetup(cardTable, cardDao);
        lenient().doAnswer(invocationOnMock -> {
            Long userId = invocationOnMock.getArgument(0);
            List<Card> cards = new ArrayList<>();
            for (Card card : cardTable.values()) {
                if (userId.equals(card.getUserId())) {
                    cards.add(card);
                }
            }
            return cards;
        }).when(cardDao).findByUserId(any(Long.class));
    }

    private void contactDaoSetup() {
        contactCommonMethodsSetUpper.findAllSetup(contactTable, contactDao);
        contactCommonMethodsSetUpper.findByIdSetup(contactTable, contactDao);
        contactCommonMethodsSetUpper.saveSetup(contactTable, contactDao, Contact.class);
        contactCommonMethodsSetUpper.deleteSetup(contactTable, contactDao, Contact.class);
        contactCommonMethodsSetUpper.deleteByIdSetup(contactTable, contactDao);
        contactCommonMethodsSetUpper.existSetup(contactTable, contactDao);
    }

    private void followDaoSetup() {
        followCommonMethodsSetUpper.findAllSetup(followTable, followDao);
        followCommonMethodsSetUpper.findByIdSetup(followTable, followDao);
        followCommonMethodsSetUpper.saveSetup(followTable, followDao, Follow.class);
        followCommonMethodsSetUpper.deleteSetup(followTable, followDao, Follow.class);
        followCommonMethodsSetUpper.deleteByIdSetup(followTable, followDao);
        followCommonMethodsSetUpper.existSetup(followTable, followDao);
        lenient().doAnswer(invocationOnMock -> {
            Long userId = invocationOnMock.getArgument(0);
            Long cardId = invocationOnMock.getArgument(1);
            for (Follow follow : followTable.values()) {
                if (userId.equals(follow.getUserId()) && cardId.equals(follow.getCard().getId())) {
                    return follow;
                }
            }
            return null;
        }).when(followDao).findByUserIdAndCardId(any(Long.class), any(Long.class));
        lenient().doAnswer(invocationOnMock -> {
            Long userId = invocationOnMock.getArgument(0);
            List<Follow> follows = new ArrayList<>();
            for (Follow follow : followTable.values()) {
                if (userId.equals(follow.getUserId())) {
                    follows.add(follow);
                }
            }
            return follows;
        }).when(followDao).findByUserId(any(Long.class));
    }

    private void galleryPhotoDaoSetup() {
        galleryPhotoCommonMethodsSetUpper.findAllSetup(galleryPhotoTable, galleryPhotoDao);
        galleryPhotoCommonMethodsSetUpper.findByIdSetup(galleryPhotoTable, galleryPhotoDao);
        galleryPhotoCommonMethodsSetUpper.saveSetup(galleryPhotoTable, galleryPhotoDao, GalleryPhoto.class);
        galleryPhotoCommonMethodsSetUpper.deleteSetup(galleryPhotoTable, galleryPhotoDao, GalleryPhoto.class);
        galleryPhotoCommonMethodsSetUpper.deleteByIdSetup(galleryPhotoTable, galleryPhotoDao);
        galleryPhotoCommonMethodsSetUpper.existSetup(galleryPhotoTable, galleryPhotoDao);
    }

    private void likeDaoSetup() {
        likeCommonMethodsSetUpper.findAllSetup(likeTable, likeDao);
        likeCommonMethodsSetUpper.findByIdSetup(likeTable, likeDao);
        likeCommonMethodsSetUpper.saveSetup(likeTable, likeDao, Like.class);
        likeCommonMethodsSetUpper.deleteSetup(likeTable, likeDao, Like.class);
        likeCommonMethodsSetUpper.deleteByIdSetup(likeTable, likeDao);
        likeCommonMethodsSetUpper.existSetup(likeTable, likeDao);
        lenient().doAnswer(invocationOnMock -> {
            Long userId = invocationOnMock.getArgument(0);
            Long cardId = invocationOnMock.getArgument(1);
            for (Like like : likeTable.values()) {
                if (userId.equals(like.getUserId()) && cardId.equals(like.getCard().getId())) {
                    return like;
                }
            }
            return null;
        }).when(likeDao).findByUserIdAndCardId(any(Long.class), any(Long.class));
    }
}

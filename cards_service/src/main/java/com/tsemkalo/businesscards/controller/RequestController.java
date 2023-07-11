package com.tsemkalo.businesscards.controller;


import com.google.protobuf.Empty;
import com.tsemkalo.businesscards.CardListProto;
import com.tsemkalo.businesscards.CardProto;
import com.tsemkalo.businesscards.CardServiceGrpc;
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
import com.tsemkalo.businesscards.IdValue;
import com.tsemkalo.businesscards.LikeProto;
import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.dao.entity.Appearance;
import com.tsemkalo.businesscards.dao.entity.Card;
import com.tsemkalo.businesscards.dao.entity.Contact;
import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.mapper.AddressMapper;
import com.tsemkalo.businesscards.mapper.AppearanceMapper;
import com.tsemkalo.businesscards.mapper.CardMapper;
import com.tsemkalo.businesscards.mapper.ContactMapper;
import com.tsemkalo.businesscards.mapper.FollowMapper;
import com.tsemkalo.businesscards.mapper.GalleryPhotoMapper;
import com.tsemkalo.businesscards.mapper.LikeMapper;
import com.tsemkalo.businesscards.service.AddressService;
import com.tsemkalo.businesscards.service.AppearanceService;
import com.tsemkalo.businesscards.service.CardService;
import com.tsemkalo.businesscards.service.ContactService;
import com.tsemkalo.businesscards.service.FollowService;
import com.tsemkalo.businesscards.service.GalleryPhotoService;
import com.tsemkalo.businesscards.service.LikeService;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@EnableRabbit
@GrpcService
@Transactional(rollbackFor = Exception.class)
public class RequestController extends CardServiceGrpc.CardServiceImplBase {
    @Autowired
    private CardService cardService;

    @Autowired
    private AppearanceService appearanceService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private FollowService followService;

    @Autowired
    private GalleryPhotoService galleryPhotoService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private GalleryPhotoMapper galleryPhotoMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private AppearanceMapper appearanceMapper;

    @Override
    public void addCard(EditCardProto request,
                        io.grpc.stub.StreamObserver<IdValue> responseObserver) {
        Card card = cardMapper.protoToEntity(request.getCardProto());
        Long userId = cardService.getAvailableCardOwnerId(card.getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        card.setUserId(userId);
        Long newCardId = cardService.add(card);
        card.setId(newCardId);
        card.getAppearance().setCard(card);
        appearanceService.add(card.getAppearance());
        for (GalleryPhoto galleryPhoto : card.getPhotos()) {
            galleryPhoto.setCard(card);
            galleryPhotoService.add(galleryPhoto);
        }
        for (Contact contact : card.getContacts()) {
            contact.setCard(card);
            contactService.add(contact);
        }
        for (Address address : card.getAddresses()) {
            address.setCard(card);
            addressService.add(address);
        }
        responseObserver.onNext(IdValue.newBuilder().setId(newCardId).build());
        responseObserver.onCompleted();
    }

    @Override
    public void editCard(EditCardProto request,
                         io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Card oldCard = cardService.getById(request.getCardProto().getId());
        Long userId = cardService.getAvailableCardOwnerId(request.getCardProto().getUserId(), request.getCurrentUserId(), request.getAdmin(), oldCard.getUserId());
        Card editedCard = cardMapper.protoToEntity(request.getCardProto());
        editedCard.setUserId(userId);
        cardService.edit(oldCard, editedCard);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCard(DeleteCardProto request,
                           io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Card card = cardService.getById(request.getCardId());
        cardService.getAvailableCardOwnerId(card.getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        cardService.delete(card.getId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getCardInfoById(IdValue request,
                                io.grpc.stub.StreamObserver<CardProto> responseObserver) {
        CardProto cardProto;
        Card card = cardService.getById(request.getId());
        cardProto = cardMapper.entityToProto(card);
        responseObserver.onNext(cardProto);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCardsInfoByUser(IdValue request,
                                      io.grpc.stub.StreamObserver<CardListProto> responseObserver) {
        List<CardProto> protos = new ArrayList<>();
        for (Card card : cardService.getCardsByUserId(request.getId())) {
            protos.add(cardMapper.entityToProto(card));
        }
        responseObserver.onNext(CardListProto.newBuilder().addAllCards(protos).build());
        responseObserver.onCompleted();
    }

    @Override
    public void editAppearance(EditAppearanceProto request,
                               io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Appearance oldAppearance = appearanceService.getById(request.getAppearanceProto().getId());
        cardService.getAvailableCardOwnerId(oldAppearance.getCard().getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        appearanceService.edit(oldAppearance, appearanceMapper.protoToEntity(request.getAppearanceProto()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void addAddress(EditAddressProto request,
                           io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Address address = addressMapper.protoToEntity(request.getAddressProto());
        cardService.getAvailableCardOwnerId(address.getCard().getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        addressService.add(address);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteAddress(DeleteAddressProto request,
                              io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Address address = addressService.getById(request.getAddressId());
        Card card = cardService.getById(request.getCardId());
        if (!address.getCard().getId().equals(card.getId())) {
            throw new IncorrectDataException("This address belongs to other card");
        }
        cardService.getAvailableCardOwnerId(card.getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        addressService.delete(address.getId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void editAddress(EditAddressProto request,
                            io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Address oldAddress = addressService.getById(request.getAddressProto().getId());
        cardService.getAvailableCardOwnerId(oldAddress.getCard().getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        addressService.edit(oldAddress, addressMapper.protoToEntity(request.getAddressProto()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void addContact(EditContactProto request,
                           io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Contact contact = contactMapper.protoToEntity(request.getContactProto());
        cardService.getAvailableCardOwnerId(contact.getCard().getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        contactService.add(contact);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void editContact(EditContactProto request,
                            io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Contact oldContact = contactService.getById(request.getContactProto().getId());
        cardService.getAvailableCardOwnerId(oldContact.getCard().getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        contactService.edit(oldContact, contactMapper.protoToEntity(request.getContactProto()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteContact(DeleteContactProto request,
                              io.grpc.stub.StreamObserver<Empty> responseObserver) {
        Contact contact = contactService.getById(request.getContactId());
        Card card = cardService.getById(request.getCardId());
        if (!contact.getCard().getId().equals(card.getId())) {
            throw new IncorrectDataException("This contact belongs to other card");
        }
        cardService.getAvailableCardOwnerId(card.getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        contactService.delete(contact.getId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void addGalleryPhoto(EditGalleryPhotoProto request,
                                io.grpc.stub.StreamObserver<Empty> responseObserver) {
        GalleryPhoto galleryPhoto = galleryPhotoMapper.protoToEntity(request.getGalleryPhotoProto());
        cardService.getAvailableCardOwnerId(galleryPhoto.getCard().getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        galleryPhotoService.add(galleryPhoto);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void editGalleryPhoto(EditGalleryPhotoProto request,
                                 io.grpc.stub.StreamObserver<Empty> responseObserver) {
        GalleryPhoto oldGalleryPhoto = galleryPhotoService.getById(request.getGalleryPhotoProto().getId());
        cardService.getAvailableCardOwnerId(oldGalleryPhoto.getCard().getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        galleryPhotoService.edit(oldGalleryPhoto, galleryPhotoMapper.protoToEntity(request.getGalleryPhotoProto()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteGalleryPhoto(DeleteGalleryPhotoProto request,
                                   io.grpc.stub.StreamObserver<Empty> responseObserver) {
        GalleryPhoto galleryPhoto = galleryPhotoService.getById(request.getGalleryPhotoId());
        Card card = cardService.getById(request.getCardId());
        if (!galleryPhoto.getCard().getId().equals(card.getId())) {
            throw new IncorrectDataException("This photo belongs to other card");
        }
        cardService.getAvailableCardOwnerId(card.getUserId(), request.getCurrentUserId(), request.getAdmin(), null);
        galleryPhotoService.delete(galleryPhoto.getId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void addFollow(FollowProto request,
                          io.grpc.stub.StreamObserver<Empty> responseObserver) {
        followService.add(request.getUserId(), request.getCardId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteFollow(FollowProto request,
                             io.grpc.stub.StreamObserver<Empty> responseObserver) {
        followService.delete(request.getUserId(), request.getCardId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void getUserFollowings(IdValue request,
                                  io.grpc.stub.StreamObserver<CardListProto> responseObserver) {
        List<Card> cards = followService.getUserFollowings(request.getId());
        CardListProto cardListProto = CardListProto.newBuilder()
                .addAllCards(cards.stream().map(cardMapper::entityToProto).collect(Collectors.toList()))
                .build();
        responseObserver.onNext(cardListProto);
        responseObserver.onCompleted();
    }

    @Override
    public void addLike(LikeProto request,
                        io.grpc.stub.StreamObserver<Empty> responseObserver) {
        likeService.add(request.getUserId(), request.getCardId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteLike(LikeProto request,
                           io.grpc.stub.StreamObserver<Empty> responseObserver) {
        likeService.delete(request.getUserId(), request.getCardId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}

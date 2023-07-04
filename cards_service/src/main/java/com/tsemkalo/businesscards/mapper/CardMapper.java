package com.tsemkalo.businesscards.mapper;

import com.tsemkalo.businesscards.AddressProto;
import com.tsemkalo.businesscards.CardProto;
import com.tsemkalo.businesscards.ContactProto;
import com.tsemkalo.businesscards.GalleryPhotoProto;
import com.tsemkalo.businesscards.dao.entity.Address;
import com.tsemkalo.businesscards.dao.entity.Card;
import com.tsemkalo.businesscards.dao.entity.Contact;
import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import com.tsemkalo.businesscards.dto.CardDTO;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapper implements Mapper<Card, CardDTO, CardProto> {
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
    public CardDTO entityToDTO(Card entity) {
        CardDTO dto = new CardDTO();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setUserId(entity.getUserId());
        dto.setTitle(entity.getTitle());
        dto.setLogoImgPath(entity.getLogoImgPath());
        dto.setHeadline(entity.getHeadline());
        dto.setDescription(entity.getDescription());
        dto.setAppearanceDTO(appearanceMapper.entityToDTO(entity.getAppearance()));
        dto.setPhotoDTOS(entity.getPhotos().stream().map(galleryPhotoMapper::entityToDTO).collect(Collectors.toList()));
        dto.setContactDTOS(entity.getContacts().stream().map(contactMapper::entityToDTO).collect(Collectors.toList()));
        dto.setAddressDTOS(entity.getAddresses().stream().map(addressMapper::entityToDTO).collect(Collectors.toList()));
        dto.setFollowersAmount(entity.getFollows().size());
        dto.setLikesAmount(entity.getLikes().size());
        return dto;
    }

    @Override
    public Card dtoToEntity(CardDTO dto) {
        Card card = new Card();
        if (dto.getId() != null) {
            card.setId(dto.getId());
        }
        card.setUserId(dto.getUserId());
        card.setTitle(dto.getTitle());
        card.setLogoImgPath(dto.getLogoImgPath());
        card.setHeadline(dto.getHeadline());
        card.setDescription(dto.getDescription());
        card.setAppearance(appearanceMapper.dtoToEntity(dto.getAppearanceDTO()));
        card.setPhotos(dto.getPhotoDTOS().stream().map(galleryPhotoMapper::dtoToEntity).collect(Collectors.toList()));
        card.setContacts(dto.getContactDTOS().stream().map(contactMapper::dtoToEntity).collect(Collectors.toList()));
        card.setAddresses(dto.getAddressDTOS().stream().map(addressMapper::dtoToEntity).collect(Collectors.toList()));
        return card;
    }

    @Override
    public Card protoToEntity(CardProto proto) {
        Card card = new Card();
        if (proto.getId() != 0) {
            card.setId(proto.getId());
        }
        if (proto.getUserId() != 0) {
            card.setUserId(proto.getUserId());
        }
        card.setTitle(proto.getTitle());
        card.setLogoImgPath(proto.getLogoImgPath());
        card.setHeadline(proto.getHeadline());
        card.setDescription(proto.getDescription());
        card.setAppearance(appearanceMapper.protoToEntity(proto.getAppearance()));
        List<GalleryPhoto> photos = proto.getPhotosList().stream().map(galleryPhotoMapper::protoToEntity).collect(Collectors.toList());
        card.setPhotos(photos);
        List<Contact> contacts = proto.getContactsList().stream().map(contactMapper::protoToEntity).collect(Collectors.toList());
        card.setContacts(contacts);
        List<Address> addresses = proto.getAddressesList().stream().map(addressMapper::protoToEntity).collect(Collectors.toList());
        card.setAddresses(addresses);
        return card;
    }

    @Transactional
    @Override
    public CardProto entityToProto(Card entity) {
        List<GalleryPhotoProto> photos = entity.getPhotos().stream().map(galleryPhotoMapper::entityToProto).collect(Collectors.toList());
        List<ContactProto> contacts = entity.getContacts().stream().map(contactMapper::entityToProto).collect(Collectors.toList());
        List<AddressProto> addresses = entity.getAddresses().stream().map(addressMapper::entityToProto).collect(Collectors.toList());
        CardProto.Builder builder = CardProto.newBuilder()
                .setUserId(entity.getUserId())
                .setTitle(entity.getTitle())
                .setLogoImgPath(entity.getLogoImgPath())
                .setHeadline(entity.getHeadline())
                .setDescription(entity.getDescription())
                .setAppearance(appearanceMapper.entityToProto(entity.getAppearance()))
                .addAllPhotos(photos)
                .addAllContacts(contacts)
                .addAllAddresses(addresses)
                .setFollowersAmount(entity.getFollows().size())
                .setLikesAmount(entity.getLikes().size());
        if (entity.getId() != null) {
            builder.setId(entity.getId());
        }
        return builder.build();
    }

    @Override
    public CardProto dtoToProto(CardDTO dto) {
        List<GalleryPhotoProto> photos = dto.getPhotoDTOS().stream().map(galleryPhotoMapper::dtoToProto).collect(Collectors.toList());
        List<ContactProto> contacts = dto.getContactDTOS().stream().map(contactMapper::dtoToProto).collect(Collectors.toList());
        List<AddressProto> addresses = dto.getAddressDTOS().stream().map(addressMapper::dtoToProto).collect(Collectors.toList());
        CardProto.Builder builder = CardProto.newBuilder()
                .setUserId(dto.getUserId())
                .setTitle(dto.getTitle())
                .setLogoImgPath(dto.getLogoImgPath())
                .setHeadline(dto.getHeadline())
                .setDescription(dto.getDescription())
                .setAppearance(appearanceMapper.dtoToProto(dto.getAppearanceDTO()))
                .addAllPhotos(photos)
                .addAllContacts(contacts)
                .addAllAddresses(addresses)
                .setFollowersAmount(dto.getFollowersAmount())
                .setLikesAmount(dto.getLikesAmount());
        if (dto.getId() != null) {
            builder.setId(dto.getId());
        }
        return builder.build();
    }

    @Override
    public CardDTO protoToDTO(CardProto proto) {
        CardDTO dto = new CardDTO();
        if (proto.getId() != 0) {
            dto.setId(proto.getId());
        }
        dto.setUserId(proto.getUserId());
        dto.setTitle(proto.getTitle());
        dto.setLogoImgPath(proto.getLogoImgPath());
        dto.setHeadline(proto.getHeadline());
        dto.setDescription(proto.getDescription());
        dto.setAppearanceDTO(appearanceMapper.protoToDTO(proto.getAppearance()));
        dto.setPhotoDTOS(proto.getPhotosList().stream().map(galleryPhotoMapper::protoToDTO).collect(Collectors.toList()));
        dto.setContactDTOS(proto.getContactsList().stream().map(contactMapper::protoToDTO).collect(Collectors.toList()));
        dto.setAddressDTOS(proto.getAddressesList().stream().map(addressMapper::protoToDTO).collect(Collectors.toList()));
        dto.setFollowersAmount(proto.getFollowersAmount());
        dto.setLikesAmount(proto.getLikesAmount());
        return dto;
    }
}

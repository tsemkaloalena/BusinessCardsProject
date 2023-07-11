package com.tsemkalo.businesscards.mapper.cards;

import com.tsemkalo.businesscards.AddressProto;
import com.tsemkalo.businesscards.CardProto;
import com.tsemkalo.businesscards.ContactProto;
import com.tsemkalo.businesscards.GalleryPhotoProto;
import com.tsemkalo.businesscards.dto.cards.CardDTO;
import com.tsemkalo.businesscards.mapper.DTOProtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapper implements DTOProtoMapper<CardDTO, CardProto> {
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
    public CardProto dtoToProto(CardDTO dto) {
        List<GalleryPhotoProto> photos = dto.getPhotoDTOS().stream().map(galleryPhotoMapper::dtoToProto).collect(Collectors.toList());
        List<ContactProto> contacts = dto.getContactDTOS().stream().map(contactMapper::dtoToProto).collect(Collectors.toList());
        List<AddressProto> addresses = dto.getAddressDTOS().stream().map(addressMapper::dtoToProto).collect(Collectors.toList());
        CardProto.Builder builder = CardProto.newBuilder()
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
        if (dto.getUserId() != null) {
            builder.setUserId(dto.getUserId());
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

package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.GalleryPhotoDao;
import com.tsemkalo.businesscards.dao.entity.Appearance;
import com.tsemkalo.businesscards.dao.entity.Follow;
import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.GalleryPhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class GalleryPhotoServiceImpl extends AbstractServiceImpl<GalleryPhoto, GalleryPhotoDao> implements GalleryPhotoService {
    @Autowired
    private GalleryPhotoDao galleryPhotoDao;

    @Override
    public Class<GalleryPhoto> getEntityClass() {
        return GalleryPhoto.class;
    }

    @Override
    public void edit(GalleryPhoto oldGalleryPhoto, GalleryPhoto editedGalleryPhoto) {
        if (!oldGalleryPhoto.getCard().getId().equals(editedGalleryPhoto.getCard().getId())) {
            throw new AccessDeniedException("You can not change card id");
        }
        galleryPhotoDao.save(editedGalleryPhoto);
    }
}

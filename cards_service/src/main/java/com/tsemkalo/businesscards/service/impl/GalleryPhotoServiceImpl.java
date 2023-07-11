package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.GalleryPhotoDao;
import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.service.GalleryPhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GalleryPhotoServiceImpl extends AbstractServiceImpl<GalleryPhoto, GalleryPhotoDao> implements GalleryPhotoService {
    @Override
    public Class<GalleryPhoto> getEntityClass() {
        return GalleryPhoto.class;
    }

    @Override
    public void edit(GalleryPhoto oldGalleryPhoto, GalleryPhoto editedGalleryPhoto) {
        if (!oldGalleryPhoto.getCard().getId().equals(editedGalleryPhoto.getCard().getId())) {
            throw new AccessDeniedException("You can not change card id");
        }
        getDefaultDao().save(editedGalleryPhoto);
    }
}

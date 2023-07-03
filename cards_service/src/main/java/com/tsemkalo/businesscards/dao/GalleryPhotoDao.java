package com.tsemkalo.businesscards.dao;

import com.tsemkalo.businesscards.dao.entity.GalleryPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryPhotoDao extends JpaRepository<GalleryPhoto, Long> {
}

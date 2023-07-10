package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.dao.AppearanceDao;
import com.tsemkalo.businesscards.dao.entity.Appearance;
import com.tsemkalo.businesscards.exception.AccessDeniedException;
import com.tsemkalo.businesscards.exception.IncorrectDataException;
import com.tsemkalo.businesscards.exception.NotFoundException;
import com.tsemkalo.businesscards.service.AppearanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class AppearanceServiceImpl extends AbstractServiceImpl<Appearance, AppearanceDao> implements AppearanceService {
    @Override
    public Class<Appearance> getEntityClass() {
        return Appearance.class;
    }

    @Override
    public void edit(Appearance oldAppearance, Appearance editedAppearance) {
        if (!oldAppearance.getCard().getId().equals(editedAppearance.getCard().getId())) {
            throw new AccessDeniedException("You can not change card id");
        }
        getDefaultDao().save(editedAppearance);
    }
}

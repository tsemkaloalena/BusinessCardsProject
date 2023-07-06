package com.tsemkalo.businesscards.service.impl;

import com.tsemkalo.businesscards.AbstracServicetTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest extends AbstracServicetTest {
    @InjectMocks
    private AddressServiceImpl addressService = new AddressServiceImpl();

    @Test
    public void addAddress_whenCardIdDoesNotExists() {

    }
}

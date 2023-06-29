package com.tsemkalo.businesscards.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    @Getter
    @Setter
    private Long id;
}

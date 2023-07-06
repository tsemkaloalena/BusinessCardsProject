package com.tsemkalo.businesscards.dao.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "errors")
@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage extends AbstractEntity {
    @NotNull
    @Column
    private Integer code;

    @NotNull
    @Column
    private String reason;
}

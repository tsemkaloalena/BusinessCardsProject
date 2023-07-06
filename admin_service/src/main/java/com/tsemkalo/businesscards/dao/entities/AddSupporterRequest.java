package com.tsemkalo.businesscards.dao.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "add_supporter_requests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddSupporterRequest extends AbstractEntity {
    @NotNull
    @Column
    private String username;
}

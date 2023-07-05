package com.tsemkalo.businesscards.dao.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chat_members")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatMember extends AbstractEntity {
    @NotNull
    @Column
    private Long userId;

    @NotNull
    @Column
    private String memberName;
    // for each chat user can have different displaying names

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    private Boolean notify;
}

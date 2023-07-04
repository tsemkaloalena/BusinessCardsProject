package com.tsemkalo.businesscards.dao.entities;

import com.sun.istack.NotNull;
import com.tsemkalo.businesscards.configuration.enums.ChatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "chats")
@NoArgsConstructor
@Getter
@Setter
public class Chat extends AbstractEntity {
    @Column
    private String name;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    private ChatType chatType;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.REMOVE)
    private List<Message> messages;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.REMOVE)
    private List<ChatMember> chatMembers;
}

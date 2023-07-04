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
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "member_id")
    private ChatMember chatMember;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @Column(columnDefinition = "TIMESTAMP")
    @NotNull
    private LocalDateTime sendingTime;

    @Column
    @NotNull
    private String text;

    @Column
    private Boolean read;
}

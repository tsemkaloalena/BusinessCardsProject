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
import java.util.Objects;

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
    private Boolean isRead;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Message message = (Message) o;
        return Objects.equals(this.getId(), message.getId()) &&
                Objects.equals(this.getChatMember().getId(), message.getChatMember().getId()) &&
                Objects.equals(this.getChat().getId(), message.getChat().getId()) &&
                Objects.equals(this.getSendingTime(), message.getSendingTime()) &&
                Objects.equals(this.getText(), message.getText()) &&
                Objects.equals(this.getIsRead(), message.getIsRead());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(),
                this.getChatMember().getId(),
                this.getChat().getId(),
                this.getSendingTime(),
                this.getText(),
                this.getIsRead());
    }
}

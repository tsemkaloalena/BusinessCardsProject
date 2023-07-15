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
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ChatMember chatMember = (ChatMember) o;
        return Objects.equals(this.getId(), chatMember.getId()) &&
                Objects.equals(this.getUserId(), chatMember.getUserId()) &&
                Objects.equals(this.getMemberName(), chatMember.getMemberName()) &&
                Objects.equals(this.getChat().getId(), chatMember.getChat().getId()) &&
                Objects.equals(this.getNotify(), chatMember.getNotify());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getUserId(), this.getMemberName(), this.getNotify(), this.getChat().getId());
    }
}

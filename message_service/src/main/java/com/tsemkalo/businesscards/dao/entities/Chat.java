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
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Chat chat = (Chat) o;
        return Objects.equals(this.getId(), chat.getId()) &&
                Objects.equals(this.getName(), chat.getName()) &&
                Objects.equals(this.getChatType(), chat.getChatType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getChatType());
    }
}

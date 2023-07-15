package com.tsemkalo.businesscards.dao.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "error_messages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage extends AbstractEntity {
    @NotNull
    @Column
    private Integer code;

    @NotNull
    @Column
    private String reason;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ErrorMessage errorMessage = (ErrorMessage) o;
        return Objects.equals(this.getId(), errorMessage.getId()) &&
                Objects.equals(this.getCode(), errorMessage.getCode()) &&
                Objects.equals(this.getReason(), errorMessage.getReason());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getCode(), this.getReason());
    }
}

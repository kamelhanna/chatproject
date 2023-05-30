package com.iti.chatproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authorities", schema = "public")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesEntity {
    @Id
    @Basic
    @Column(name = "user_id")
    private String userId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "authority")
    private String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthoritiesEntity that = (AuthoritiesEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(username, that.username) && Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, authority);
    }
}

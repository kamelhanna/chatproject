package com.iti.chatproject.entity;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid",strategy = GenerationType.AUTO)
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "user_id", nullable = false, length = 32)
    private String id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password", length = 64)
    private String userPassword;

    @Column(name = "user_email", length = 400)
    private String userEmail;

    @OneToMany(mappedBy = "messageUser")
    private List<Message> messageList;

}
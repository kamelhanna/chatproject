package com.iti.chatproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(generator = "system-uuid",strategy = GenerationType.AUTO)
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "chat_id", nullable = false, length = 32)
    private String id;

    @Column(name = "chat_topic", length = 32)
    private String chatTopic;

    @Column(name = "chat_password", length = 64)
    private String chatPassword;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "messageChat", cascade = CascadeType.ALL)
    private List<Message> messageList;

}
package com.iti.chatproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(generator = "system-uuid",strategy = GenerationType.AUTO)
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "message_id", nullable = false, length = 32)
    private String id;

    @Column(name = "message_datetime")
    private Instant messageDatetime;

    @Lob
    @Column(name = "message_text")
    private String messageText;

    @JoinColumn(name = "message_chat_id")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private Chat messageChat;

    @JoinColumn(name = "message_user_id")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    private User messageUser;

}
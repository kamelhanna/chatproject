CREATE TABLE message
(
    message_id CHAR(32),
    message_datetime DATETIME,
    message_text TEXT,
    message_chat_id CHAR(32),
    message_user_id CHAR(32),
    PRIMARY KEY (message_id)
);

CREATE TABLE user_chat
(
    user_chat_chat_id CHAR(32),
    user_chat_user_id CHAR(32),
    PRIMARY KEY (user_chat_chat_id,user_chat_user_id)
);

CREATE TABLE chat
(
    chat_id CHAR(32),
    chat_topic VARCHAR(32),
    chat_password CHAR(64),
    user_chat_user_id CHAR(32),
    PRIMARY KEY (chat_id)
);

CREATE INDEX user_login_idx ON user (user_login);
ALTER TABLE message ADD FOREIGN KEY message_chat_id_idxfk (message_chat_id) REFERENCES chat (chat_id);

ALTER TABLE message ADD FOREIGN KEY message_user_id_idxfk (message_user_id) REFERENCES user (user_id);

ALTER TABLE user_chat ADD FOREIGN KEY user_chat_user_id_idxfk (user_chat_user_id) REFERENCES user (user_id);

ALTER TABLE chat ADD FOREIGN KEY chat_id_idxfk (chat_id,user_chat_user_id) REFERENCES user_chat (user_chat_chat_id,user_chat_user_id);
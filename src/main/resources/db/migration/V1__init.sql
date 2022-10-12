CREATE TABLE user
(
    user_id CHAR(32),
    user_login VARCHAR(255),
    user_password CHAR(64),
    user_email VARCHAR(400),
    PRIMARY KEY (user_id)
);

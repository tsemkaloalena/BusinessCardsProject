CREATE TABLE IF NOT EXISTS chats (
id bigserial PRIMARY KEY,
name varchar(64) NOT NULL,
chat_type varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS messages (
id bigserial PRIMARY KEY,
user_id bigint NOT NULL,
chat_id bigint REFERENCES chats(id),
sending_time TIMESTAMP NOT NULL,
text varchar(1024) NOT NULL,
read boolean NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS chat_members (
id bigserial PRIMARY KEY,
user_id bigint NOT NULL,
chat_id bigint REFERENCES chats(id),
member_name varchar(64) NOT NULL,
send_notifications_to_email boolean NOT NULL DEFAULT TRUE
);

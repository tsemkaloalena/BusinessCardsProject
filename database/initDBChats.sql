CREATE TABLE IF NOT EXISTS message_types (
id SERIAL PRIMARY KEY,
type varchar(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS admin_messages (
id SERIAL PRIMARY KEY,
sender varchar(64) NOT NULL,
subject varchar(64) NOT NULL,
text varchar(1024) NOT NULL,
message_type_id bigint REFERENCES message_types(id),
priority integer NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS chats ();
CREATE TABLE IF NOT EXISTS chats (
id bigserial PRIMARY KEY,
name varchar(64) NOT NULL,
chat_type varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS messages (
id bigserial PRIMARY KEY,
member_id bigint NOT NULL,
chat_id bigint REFERENCES chats(id),
sending_time TIMESTAMP NOT NULL,
text varchar(1024) NOT NULL,
is_read boolean NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS chat_members (
id bigserial PRIMARY KEY,
user_id bigint NOT NULL,
chat_id bigint REFERENCES chats(id),
member_name varchar(64) NOT NULL,
notify boolean NOT NULL DEFAULT TRUE
);

INSERT INTO chats(id, name, chat_type) VALUES
(1, 'chat1', 'GROUP'),
(2, 'chat2', 'PRIVATE'),
(3, 'help', 'SUPPORT_QUESTION'),
(4, 'help', 'SUPPORT_UNASSIGNED'),
(5, 'chat3', 'GROUP'),
(6, 'help3', 'SUPPORT_CLOSED'),
(7, 'help4', 'SUPPORT_UNASSIGNED');
SELECT setval('chats_id_seq', 7, true);

INSERT INTO chat_members (id, user_id, chat_id, member_name, notify) VALUES
(1, 4, 1, 'm1', true),
(2, 5, 1, 'm2', true),
(3, 6, 1, 'm3', false),
(4, 4, 2, 'Tomas', false),
(5, 5, 2, 'Petos', true),
(6, 5, 3, 'm6', true),
(7, 2, 3, 'm7', true),
(8, 7, 4, 'm8', true),
(9, 8, 5, 'm9', true),
(10, 9, 5, 'm10', true),
(11, 10, 5, 'm11', true),
(12, 10, 6, 'm12', true),
(13, 2, 6, 'm13', true),
(14, 5, 7, 'm14', true);
SELECT setval('chat_members_id_seq', 14, true);

INSERT INTO messages (id, member_id, chat_id, sending_time, text, is_read) VALUES
(1, 1, 1, '2023-07-04 08:41:20', 'text1', true),
(2, 1, 1, '2023-07-04 08:41:40', 'text1', true),
(3, 2, 1, '2023-07-04 08:42:20', 'text2', true),
(4, 3, 1, '2023-07-04 08:43:20', 'text3', true),
(5, 4, 2, '2023-07-04 08:44:20', 'text4', false),
(6, 6, 3, '2023-07-04 08:45:20', 'text6', false),
(7, 7, 3, '2023-07-04 08:45:20', 'text7', false);
SELECT setval('messages_id_seq', 7, true);

--INSERT INTO chats(name, chat_type) VALUES
--('chat1', 'GROUP'),
--('chat2', 'PRIVATE'),
--('help', 'SUPPORT_QUESTION'),
--('help', 'SUPPORT_UNASSIGNED'),
--('chat3', 'GROUP'),
--('help3', 'SUPPORT_CLOSED'),
--('help4', 'SUPPORT_UNASSIGNED');
--
--INSERT INTO chat_members (user_id, chat_id, member_name, notify) VALUES
--(4, 1, 'm1', true),
--(5, 1, 'm2', true),
--(6, 1, 'm3', false),
--(4, 2, 'Tomas', false),
--(5, 2, 'Petos', true),
--(5, 3, 'm6', true),
--(2, 3, 'm7', true),
--(7, 4, 'm8', true),
--(8, 5, 'm9', true),
--(9, 5, 'm10', true),
--(10, 5, 'm11', true),
--(10, 6, 'm12', true),
--(2, 6, 'm13', true),
--(5, 7, 'm14', true);
--
--INSERT INTO messages (member_id, chat_id, sending_time, text, is_read) VALUES
--(1, 1, '2023-07-04 08:41:20', 'text1', true),
--(1, 1, '2023-07-04 08:41:40', 'text1', true),
--(2, 1, '2023-07-04 08:42:20', 'text2', true),
--(3, 1, '2023-07-04 08:43:20', 'text3', true),
--(4, 2, '2023-07-04 08:44:20', 'text4', false),
--(6, 3, '2023-07-04 08:45:20', 'text6', false),
--(7, 3, '2023-07-04 08:45:20', 'text7', false);

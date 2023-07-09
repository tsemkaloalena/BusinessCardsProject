INSERT INTO chats(id, name, chat_type) VALUES
(1, 'chat1', 'GROUP'),
(2, 'chat2', 'PRIVATE'),
(3, 'help', 'SUPPORT_QUESTION'),
(4, 'help', 'SUPPORT_QUESTION'),
(5, 'chat3', 'GROUP');

INSERT INTO messages (id, member_id, chat_id, sending_time, text, is_read) VALUES
(1, 1, 1, '2023-07-04 08:41:20', 'text1', true),
(2, 1, 1, '2023-07-04 08:41:40', 'text1', true),
(3, 2, 1, '2023-07-04 08:42:20', 'text2', true),
(4, 3, 1, '2023-07-04 08:43:20', 'text3', true),
(5, 4, 2, '2023-07-04 08:44:20', 'text4', false),
(6, 6, 3, '2023-07-04 08:45:20', 'text6', false),
(7, 7, 3, '2023-07-04 08:45:20', 'text7', false);

INSERT INTO chat_members (id, user_id, chat_id, member_name, notify) VALUES
(1, 4, 1, 'm1', true),
(2, 5, 1, 'm2', true),
(3, 6, 1, 'm3', false),
(4, 4, 2, 'm4', false),
(5, 5, 2, 'm5', true),
(6, 5, 3, 'm6', true),
(7, 2, 3, 'm7', true),
(8, 7, 4, 'm8', true),
(9, 3, 4, 'm9', true),
(10, 8, 4, 'm10', true),
(11, 9, 4, 'm11', true),
(12, 10, 4, 'm12', true);
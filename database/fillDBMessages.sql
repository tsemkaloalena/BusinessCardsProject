INSERT INTO chats(id, name, chat_type) VALUES
(1, 'chat1', 'GROUP'),
(2, 'chat2', 'PRIVATE'),
(3, 'help', 'SUPPORT_QUESTION'),
(4, 'help', 'SUPPORT_QUESTION');

INSERT INTO messages (id, user_id, chat_id, sending_time, text) VALUES
(1, 4, 1, '2023-07-04 08:41:20', 'text1'),
(2, 4, 1, '2023-07-04 08:42:20', 'text2'),
(3, 5, 1, '2023-07-04 08:43:20', 'text3'),
(4, 5, 2, '2023-07-04 08:44:20', 'text4'),
(5, 4, 2, '2023-07-04 08:45:20', 'text5'),
(6, 4, 3, '2023-07-04 08:45:20', 'text6'),
(7, 2, 3, '2023-07-04 08:45:20', 'text7'),
(8, 5, 4, '2023-07-04 08:45:20', 'text8');

INSERT INTO chat_members (id, user_id, chat_id, member_name) VALUES
(1, 4, 1, 'm1'),
(2, 5, 1, 'm2'),
(3, 6, 1, 'm3'),
(4, 4, 2, 'm4'),
(5, 5, 2, 'm5');

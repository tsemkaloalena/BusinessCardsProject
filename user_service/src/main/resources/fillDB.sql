INSERT INTO roles(id, name) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'COMPANY_REPRESENTATIVE');

INSERT INTO permissions (id, name, role_id) VALUES
(1, 'READ', 1),
(2, 'READ', 2),
(3, 'READ', 3),
(4, 'ADD', 1),
(5, 'ADD', 3),
(6, 'EDIT', 1),
(7, 'EDIT', 3),
(8, 'DELETE', 1),
(9, 'DELETE', 3),
(10, 'FOLLOW', 1),
(11, 'FOLLOW', 2),
(12, 'FOLLOW', 3);

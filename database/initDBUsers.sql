CREATE TABLE IF NOT EXISTS roles (
id SERIAL PRIMARY KEY,
name varchar(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS permissions (
id SERIAL PRIMARY KEY,
name varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS users (
id SERIAL PRIMARY KEY,
username varchar(64) NOT NULL UNIQUE,
password varchar(64) NOT NULL,
name varchar(64) NOT NULL,
surname varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id),
email varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS nonactivated_users (
id SERIAL PRIMARY KEY,
username varchar(64) NOT NULL UNIQUE,
password varchar(64) NOT NULL,
name varchar(64) NOT NULL,
surname varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id),
email varchar(64) NOT NULL
);


INSERT INTO roles(id, name) VALUES
(1, 'ADMIN'),
(2, 'USER');
--(3, 'COMPANY_REPRESENTATIVE');

INSERT INTO permissions (id, name, role_id) VALUES
(1, 'READ', 1),
(2, 'READ', 2),
--(3, 'READ', 3),
(2, 'EDIT', 1),
(3, 'EDIT', 2),
--(6, 'EDIT', 3),
--(7, 'CREATE_FOR_OTHER_USERS', 3),
(4, 'FOLLOW_LIKE', 2),
--(9, 'FOLLOW_LIKE', 3),
(5, 'CHAT', 1),
(6, 'CHAT', 2);
--(12, 'CHAT', 3);
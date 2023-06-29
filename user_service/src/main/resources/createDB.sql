CREATE TABLE roles (
id bigserial PRIMARY KEY NOT NULL,
name varchar(64) NOT NULL
);

CREATE TABLE permissions (
id bigserial PRIMARY KEY NOT NULL,
name varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id)
);

CREATE TABLE users (
id bigserial PRIMARY KEY NOT NULL,
username varchar(64) NOT NULL,
password varchar(64) NOT NULL,
name varchar(64) NOT NULL,
surname varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id),
email varchar(64) NOT NULL
);
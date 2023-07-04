CREATE TABLE IF NOT EXISTS roles (
id bigserial PRIMARY KEY,
name varchar(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS permissions (
id bigserial PRIMARY KEY,
name varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS users (
id bigserial PRIMARY KEY,
username varchar(64) NOT NULL UNIQUE,
password varchar(64) NOT NULL,
name varchar(64) NOT NULL,
surname varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id),
email varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS nonactivated_users (
id bigserial PRIMARY KEY,
username varchar(64) NOT NULL UNIQUE,
password varchar(64) NOT NULL,
name varchar(64) NOT NULL,
surname varchar(64) NOT NULL,
role_id bigint REFERENCES roles(id),
email varchar(64) NOT NULL
);

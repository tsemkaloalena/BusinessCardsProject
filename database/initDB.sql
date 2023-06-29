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

CREATE TABLE IF NOT EXISTS admin_messages (
id SERIAL PRIMARY KEY,
sender varchar(64) NOT NULL,
subject varchar(64) NOT NULL,
text varchar(1024) NOT NULL,
priority integer NOT NULL DEFAULT 1
);
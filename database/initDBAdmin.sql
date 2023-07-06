CREATE TABLE IF NOT EXISTS add_supporter_requests (
id bigserial PRIMARY KEY,
username varchar(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS error_messages (
id bigserial PRIMARY KEY,
code integer NOT NULL,
reason varchar(1024) NOT NULL
);
CREATE TABLE IF NOT EXISTS cards (
id bigserial PRIMARY KEY,
title varchar(64) NOT NULL,
logo_img_path varchar(256) NOT NULL,
headline varchar(64) NOT NULL,
description varchar(1024) NOT NULL,
user_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS gallery_photos (
id bigserial PRIMARY KEY,
card_id bigint REFERENCES cards(id),
img_path varchar(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS contacts (
id bigserial PRIMARY KEY,
type varchar(64) NOT NULL,
content varchar(64) NOT NULL,
card_id bigint REFERENCES cards(id)
);

CREATE TABLE IF NOT EXISTS addresses (
id bigserial PRIMARY KEY,
address varchar(256) NOT NULL,
card_id bigint REFERENCES cards(id),
show_on_map boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS follows (
id bigserial PRIMARY KEY,
user_id bigint NOT NULL,
card_id bigint REFERENCES cards(id)
);

CREATE TABLE IF NOT EXISTS likes (
id bigserial PRIMARY KEY,
user_id bigint NOT NULL,
card_id bigint REFERENCES cards(id)
);

CREATE TABLE IF NOT EXISTS appearances (
id bigserial PRIMARY KEY,
card_id bigint REFERENCES cards(id),
font_name varchar(64) NOT NULL,
background_color varchar(64) NOT NULL,
background_image_path varchar(64),
picture_stretching varchar(64),
main_color varchar(64) NOT NULL,
second_color varchar(64) NOT NULL,
gallery_type varchar(64) NOT NULL
);
INSERT INTO cards (id, title, logo_img_path, headline, description, user_id) VALUES
(1, 'title2', 'logo1', 'line1', 'd1', 10),
(2, 'title3', 'logo2', 'line2', 'd2', 10),
(3, 'title4', 'logo3', 'line3', 'd3', 11);
SELECT setval('cards_id_seq', 3, true);

INSERT INTO gallery_photos (id, card_id, img_path) VALUES
(1, 1, 'path1'),
(2, 1, 'path2'),
(3, 2, 'path3'),
(4, 2, 'path4'),
(5, 3, 'path5');
SELECT setval('gallery_photos_id_seq', 5, true);

INSERT INTO contacts (id, type, content, card_id) VALUES
(1, 'SOCIAL_NETWORK', 'inst_link', 1),
(2, 'MAIL_ADDRESS', 'test@gmail.com', 1),
(3, 'PHONE_NUMBER', '909456480849', 2),
(4, 'MAIL_ADDRESS', 'test2@gmail.com', 3);
SELECT setval('contacts_id_seq', 4, true);

INSERT INTO addresses (id, address, card_id, show_on_map) VALUES
(1, 'add1', 1, true),
(2, 'add2', 1, false);
SELECT setval('addresses_id_seq', 2, true);

INSERT INTO follows (id, user_id, card_id) VALUES
(1, 8, 1),
(2, 11, 1),
(3, 5, 2),
(4, 5, 3);
SELECT setval('follows_id_seq', 4, true);

INSERT INTO likes (id, user_id, card_id) VALUES
(1, 8, 1),
(2, 9, 1),
(3, 10, 1),
(4, 11, 1),
(5, 4, 2),
(6, 4, 3);
SELECT setval('likes_id_seq', 6, true);

INSERT INTO appearances (id, card_id, font_name, background_color, background_image_path, picture_stretching, main_color, second_color, gallery_type) VALUES
(1, 1, 'font1', '#ffffff', '', 'FULL_SCREEN', '#ff0000', '#f000ff', 'COLLAGE'),
(2, 2, 'font2', '#eeffff', '/img/path.jpg', 'DOCUMENT_CENTER', '#ee0000', '#f0e0ff', 'GRID'),
(3, 3, 'font3', '#eeffff', '/img/path3.jpg', 'FULL_DOCUMENT_STRETCH', '#ee0000', '#f0e0ff', 'CAROUSEL');
SELECT setval('appearances_id_seq', 3, true);


{
    "title":"title2",
    "logoImgPath":"logo1",
    "headline":"line1",
    "description":"d1",
    "appearanceDTO":{
        "fontName":"font1",
        "backgroundColor":"#ffffff",
        "backgroundImagePath":"",
        "pictureStretching":"FULL_SCREEN",
        "mainColor":"#ff0000",
        "secondColor":"#f000ff",
        "galleryType":"COLLAGE"
    },
    "photoDTOS":[
        {
            "imgPath":"path1"
        },
        {
            "imgPath":"path2"
        }
    ],
    "contactDTOS":[
        {
            "type":"SOCIAL_NETWORK",
            "content":"inst_link"
        }
    ],
    "addressDTOS":[
        {
            "address":"add1",
            "showOnMap":true
        },
        {
            "address":"add2",
            "showOnMap":false
        }
    ]
}
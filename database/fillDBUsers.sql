INSERT INTO roles(id, name) VALUES
(1, 'ADMIN'),
(2, 'TECHNICAL_SUPPORT'),
(3, 'USER');

INSERT INTO permissions (id, name, role_id) VALUES
(1, 'READ', 1),
(2, 'READ', 2),
(3, 'READ', 3),
(4, 'EDIT', 1),
(5, 'EDIT', 2),
(6, 'EDIT', 3),
(7, 'FOLLOW_LIKE', 3),
(8, 'CHAT', 1),
(9, 'CHAT', 2),
(10, 'CHAT', 3),
(11, 'CONTROL_SUPPORT', 1),
(12, 'RESOLVE_QUESTIONS', 2);

INSERT INTO users (id, username, password, name, surname, role_id, email) VALUES
(1, 'svetlana', '$2a$10$eHrKX3q0Gi.K3IXxDVSnmevyIf.LLq/DEAoHCMSCkIPDsOQsrix7W', 'Svetlana', 'Oleina', 1, 'tsemkaloalena@gmail.com'),
(2, 'amy', '$2a$10$uURzRp0Dr/iC5GEP3POsPeEvpF8GBfy1WNx0l2eNbM/WyvyrZHV4S', 'Amy', 'Norton', 2, 'tsemkaloalena@gmail.com'),
(3, 'rav', '$2a$10$K9VIDic.2ZRNlDUn5Ex8p.WztqJ9VnFz935itAylM3/zMCV9TGTjW', 'Rav', 'Ahuja', 2, 'tsemkaloalena@gmail.com'),
(4, 'robby', '$2a$10$YIePp00IQCDH5cSjZdcBAeBmKJUJ8QjaJh.bKjPA51kW30PBpic.K', 'Robert', 'Shiller', 3, 'tsemkaloalena@gmail.com'),
(5, 'nadya', '$2a$10$6pY.lRuSXtWLupFhyHzZD.uyoRojk6ecvKGBqlJ5WllPdfFdOE3Vi', 'Nader', 'Tavassoli', 3, 'tsemkaloalena@gmail.com'),
(6, 'rohit', '$2a$10$d4rss2UUzw1jY0m6m8eZxOIJSAwocb0oelOhpPTjHw1GW/1XlBw42', 'Rohit', 'Rahi', 3, 'tsemkaloalena@gmail.com'),
(7, 'pasha', '$2a$10$YAy0lNUFouUPvxJZoFaYR.uwV2uKNJz8hdbmJ9dA4M.LCJbgD/jXi', 'Pavel', 'Pevzner', 3, 'tsemkaloalena@gmail.com'),
(8, 'philya', '$2a$10$gLr2A2aU1w8C6JV2x0CZKuAtaUvbtHO.whMinTKaOnvx.ggTwPyme', 'Phillip', 'Compeau', 3, 'tsemkaloalena@gmail.com'),
(9, 'lisa', '$2a$10$bbP1/bhs/ByqDYsQtg.FFO3M7Qwoiug5p8cPhQWX2xqBtn7anYoOq', 'Lisa', 'Mazzola', 3, 'tsemkaloalena@gmail.com'),
(10, 'marik', '$2a$10$h2O/buH8cHiKx6eSgFuhs..c5fB15lu2Bi1SRSMpq3d8nTJBhJROW', 'Marik', 'Thewho', 3, 'tsemkaloalena@gmail.com'),
(11, 'edik', '$2a$10$5ufPvlwI5MBXQDa/7wIdsuHneB2/ppWSAn5cz5tmhA2NuMjwrg2DS', 'Edik', 'NotYarik', 3, 'tsemkaloalena@gmail.com'),
(12, 'derevo', '$2a$10$qOIhlqKOgDb0Ftrv5cn/zOGnPIa1Rv5p83TxhiHZOnOMORkXwBVuC', 'Drevo', 'Obrabotka', 3, 'tsemkaloalena@gmail.com'),
(13, 'sashenka', '$2a$10$bo4DgfkF4rXX2x0iO3Xn0eMvBGm4wOvxOkx0utSPrdnml2/V/r32.', 'Danya', 'Saharok', 3, 'tsemkaloalena@gmail.com');



--(1, 'svetlana', 'nevazhno', 'Svetlana', 'Oleina', 1),
--(2, 'amy', 'amyteach', 'Amy', 'Norton', 2),
--(3, 'rav', 'ravteach', 'Rav', 'Ahuja', 2),
--(4, 'robby', 'bobby', 'Robert', 'Shiller', 2),
--(5, 'nadya', 'male', 'Nader', 'Tavassoli', 2),
--(6, 'rohit', 'nobronhit', 'Rohit', 'Rahi', 2),
--(7, 'pasha', 'drinksbeer', 'Pavel', 'Pevzner', 2),
--(8, 'philya', 'philyateach', 'Phillip', 'Compeau', 2),
--(9, 'lisa', 'moma', 'Lisa', 'Mazzola', 2),
--(10, 'marik', 'who', 'Marik', 'Thewho', 3),
--(11, 'edik', 'blue', 'Edik', 'NotYarik', 3),
--(12, 'derevo', 'tree', 'Drevo', 'Obrabotka', 3),
--(13, 'sashenka', 'sladkiy', 'Danya', 'Saharok', 3);

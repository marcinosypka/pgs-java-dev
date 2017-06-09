INSERT INTO user (id, first_name, last_name, email, password, role) VALUES (1, 'Krzysztof', 'Krawczyk', 'kk@gmail.com', 'kk123', 'ADMIN');
INSERT INTO user (id, first_name, last_name, email, password, role) VALUES (2, 'Andrzej', 'Andrzej', 'aa@gmail.com', 'aa123', 'STUDENT');
INSERT INTO user (id, first_name, last_name, email, password, role) VALUES (3, 'Michał', 'Wiśniewski', 'mw@gmail.com', 'mw123', 'STUDENT');
INSERT INTO user (id, first_name, last_name, email, password, role) VALUES (4, 'Ryszard', 'Rynkowski', 'rr@gmail.com', 'rr123', 'STUDENT');

INSERT INTO activity (id, name, start_date) VALUES (1, 'Java Dev 1', '2017-10-01 18:00:00');
INSERT INTO activity (id, name, start_date) VALUES (2, 'Java Dev 2', '2017-10-08 18:00:00');
INSERT INTO activity (id, name, start_date) VALUES (3, 'Java Dev 3', '2017-10-15 18:00:00');
INSERT INTO activity (id, name, start_date) VALUES (4, 'Java Dev 4', '2017-10-22 18:00:00');

INSERT INTO attendance(user_id, activity_id) VALUES (1,1);
INSERT INTO attendance(user_id, activity_id) VALUES (2,1);
INSERT INTO attendance(user_id, activity_id) VALUES (3,1);
INSERT INTO attendance(user_id, activity_id) VALUES (4,1);
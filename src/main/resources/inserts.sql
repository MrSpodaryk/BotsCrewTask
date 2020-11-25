INSERT INTO `BotsCrewDB`.`degree` (name)
VALUES ('assistant'),
       ('associate professor'),
       ('professor');


INSERT INTO `BotsCrewDB`.`lector` (name, surname, age, salary, degree_id)
VALUES ('Nazar', 'Skoropad', 20, 1212, 1),
       ('Roman', 'Spodaryk', 21, 7777, 3),
       ('Ostap', 'Vovk', 24, 999, 1),
       ('Oleh', 'Dzura', 18, 3333, 2),
       ('Vika', 'Nova', 27, 400, 1),
       ('Ivan', 'Zabava', 25, 1500, 3),
       ('Yura', 'Strogush', 22, 7000, 2),
       ('Oksana', 'Popova', 32, 3200, 1);


INSERT INTO `BotsCrewDB`.`department` (name, head_of_department_id)
VALUES ('History', 2),
       ('Mathematics', 3),
       ('Philosophy', 3),
       ('Physics', 1),
       ('Law', 5),
       ('Business', 4),
       ('Medicine', 6);


INSERT INTO `BotsCrewDB`.`department_lector`
VALUES (1, 1),
       (2, 1),
       (1, 5),
       (2, 7),
       (1, 6),
       (5, 1),
       (4, 1),
       (3, 2),
       (3, 3),
       (3, 7),
       (6, 3),
       (6, 6),
       (7, 2),
       (7, 3),
       (4, 3),
       (4, 7);
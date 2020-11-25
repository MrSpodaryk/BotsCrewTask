CREATE SCHEMA IF NOT EXISTS `BotsCrewDB` DEFAULT CHARACTER SET utf8;
USE `BotsCrewDB`;

DROP TABLE IF EXISTS department_lector;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS lector;
DROP TABLE IF EXISTS degree;

CREATE TABLE IF NOT EXISTS `BotsCrewDB`.`degree`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `BotsCrewDB`.`lector`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(45) NOT NULL,
    `surname`   VARCHAR(45) NOT NULL,
    `age`       INT         NOT NULL,
    `salary`    VARCHAR(45) NOT NULL,
    `degree_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_lector_degree_idx` (`degree_id` ASC) VISIBLE,
    CONSTRAINT `fk_lector_degree`
        FOREIGN KEY (`degree_id`)
            REFERENCES `BotsCrewDB`.`degree` (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `BotsCrewDB`.`department`
(
    `id`                    INT         NOT NULL AUTO_INCREMENT,
    `name`                  VARCHAR(45) NOT NULL,
    `head_of_department_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_department_lector1_idx` (`head_of_department_id` ASC) VISIBLE,
    CONSTRAINT `fk_department_lector1`
        FOREIGN KEY (`head_of_department_id`)
            REFERENCES `BotsCrewDB`.`lector` (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `BotsCrewDB`.`department_lector`
(
    `department_id` INT NOT NULL,
    `lector_id`     INT NOT NULL,
    PRIMARY KEY (`department_id`, `lector_id`),
    INDEX `fk_department_lector_lector1_idx` (`lector_id` ASC) VISIBLE,
    INDEX `fk_department_lector_department1_idx` (`department_id` ASC) VISIBLE,
    CONSTRAINT `fk_department_lector_department1`
        FOREIGN KEY (`department_id`)
            REFERENCES `BotsCrewDB`.`department` (`id`),
    CONSTRAINT `fk_department_lector_lector1`
        FOREIGN KEY (`lector_id`)
            REFERENCES `BotsCrewDB`.`lector` (`id`)
)
    ENGINE = InnoDB;


INSERT INTO degree (name)
VALUES ('assistant'),
       ('associate professor'),
       ('professor');

INSERT INTO lector (name, surname, age, salary, degree_id)
VALUES ('Nazar', 'Skoropad', 20, 1212, 1),
       ('Roman', 'Spodaryk', 21, 7777, 3),
       ('Ostap', 'Vovk', 24, 999, 1),
       ('Oleh', 'Dzura', 18, 3333, 2),
       ('Vika', 'Nova', 27, 400, 1),
       ('Ivan', 'Zabava', 25, 1500, 3),
       ('Yura', 'Strogush', 22, 7000, 2),
       ('Oksana', 'Popova', 32, 3200, 1);


INSERT INTO department (name, head_of_department_id)
VALUES ('History', 2),
       ('Mathematics', 3),
       ('Philosophy', 3),
       ('Physics', 1),
       ('Law', 5),
       ('Business', 4),
       ('Medicine', 6);


INSERT INTO department_lector
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






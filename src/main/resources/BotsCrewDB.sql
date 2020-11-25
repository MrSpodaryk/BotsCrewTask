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

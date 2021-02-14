CREATE
    DATABASE newsagent;
USE
    newsagent;
CREATE TABLE `newsagent`.`customer`
(
    `id`          int(10) AUTO_INCREMENT,
    `name`        VARCHAR(45) NULL,
    `email`       varchar(20) DEFAULT NULL,
    `address`     VARCHAR(45) DEFAULT NULL,
    `phoneNumber` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `newsagent`.`employee`
(
    `id`          int(10) AUTO_INCREMENT,
    `name`        VARCHAR(45) NULL,
    `email`       varchar(20) DEFAULT NULL,
    `address`     VARCHAR(45) DEFAULT NULL,
    `phoneNumber` VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `newsagent`.`publication`
(
    `id`     int(10) AUTO_INCREMENT,
    `name`   VARCHAR(45) NULL,
    `amount` int         not null,
    PRIMARY KEY (`id`)
);

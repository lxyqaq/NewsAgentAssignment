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
CREATE TABLE `newsagent`.`order`
(
    `id`              int(10) AUTO_INCREMENT,
    `customerName`    VARCHAR(45) NULL,
    `publicationName` VARCHAR(45) NULL,
    `date`            VARCHAR(45) null,
    PRIMARY KEY (`id`)
);
CREATE TABLE `newsagent`.`bill`
(
    `id`              int(10) AUTO_INCREMENT,
    `customerName`    VARCHAR(45) NULL,
    `customerAddress` VARCHAR(45) NULL,
    `fee`            DOUBLE null,
    `date`            VARCHAR(45) null,
    PRIMARY KEY (`id`)
);


CREATE
DATABASE newsagent;
USE
newsagent;
CREATE TABLE `newsagent`.`customer`
(
    `id`    int(10) NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(45) NULL,
    `email` varchar(20) DEFAULT NULL,
    `birth` date        DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `newsagent`.`employee`
(
    `id`    int(10) NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(45) NULL,
    `email` varchar(20) DEFAULT NULL,
    `birth` date        DEFAULT NULL,
    PRIMARY KEY (`id`)
);

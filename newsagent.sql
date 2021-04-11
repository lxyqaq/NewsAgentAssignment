CREATE
    DATABASE News;
USE
    News;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
                        `bid` int NOT NULL AUTO_INCREMENT,
                        `oid` int NOT NULL,
                        `cname` varchar(50) NOT NULL,
                        `caddress` varchar(50) NOT NULL,
                        `cphone` varchar(50) NOT NULL,
                        `fee` double(20,2) NOT NULL,
                        `odate` varchar(50) NOT NULL,
                        PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
                            `cid` int NOT NULL AUTO_INCREMENT,
                            `cname` varchar(50) NOT NULL,
                            `cemail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `caddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `cphone` varchar(50) NOT NULL,
                            PRIMARY KEY (`cid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
                            `eid` int NOT NULL AUTO_INCREMENT,
                            `ename` varchar(50) NOT NULL,
                            `eemail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `eaddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `ephone` varchar(50) NOT NULL,
                            PRIMARY KEY (`eid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
                           `iid` int NOT NULL AUTO_INCREMENT,
                           `cname` varchar(255) NOT NULL,
                           `pname` varchar(255) NOT NULL,
                           `quantity` int NOT NULL,
                           `caddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `odate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                           `total` double(10,2) NOT NULL,
                           PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of invoice
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
                         `oid` int NOT NULL AUTO_INCREMENT,
                         `cname` varchar(50) NOT NULL,
                         `cemail` varchar(50) NOT NULL,
                         `caddress` varchar(50) NOT NULL,
                         `cphone` varchar(50) NOT NULL,
                         `pname` varchar(50) NOT NULL,
                         `price` double(10,2) NOT NULL,
                         `quantity` int NOT NULL,
                         `odate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for publication
-- ----------------------------
DROP TABLE IF EXISTS `publication`;
CREATE TABLE `publication` (
                               `pid` int NOT NULL AUTO_INCREMENT,
                               `pname` varchar(50) NOT NULL,
                               `price` double(10,2) NOT NULL,
                               `amount` int NOT NULL,
                               PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publication
-- ----------------------------
BEGIN;
INSERT INTO `publication` VALUES (1, 'Magazine', 5.00, 700);
INSERT INTO `publication` VALUES (2, 'Newspaper', 4.00, 800);
INSERT INTO `publication` VALUES (3, 'Journal', 6.00, 600);
COMMIT;

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `ordertest`;
delimiter ;;
CREATE TRIGGER `ordertest` AFTER INSERT ON `order` FOR EACH ROW BEGIN
    INSERT INTO customer(cname,cemail,caddress,cphone)VALUES(NEW.cname,NEW.cemail,NEW.caddress,NEW.cphone);
    UPDATE publication SET amount = amount - NEW.quantity WHERE pname = NEW.pname;
    INSERT INTO bill(oid,cname,caddress,cphone,fee,odate)VALUES(NEW.oid,NEW.cname,NEW.caddress,NEW.cphone,NEW.price*NEW.quantity,NEW.odate);
    INSERT INTO invoice(cname,pname,quantity,caddress,odate,total)VALUES(NEW.cname,NEW.pname,NEW.quantity,NEW.caddress,NEW.odate,NEW.price*NEW.quantity);
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `ordertest2`;
delimiter ;;
CREATE TRIGGER `ordertest2` AFTER UPDATE ON `order` FOR EACH ROW BEGIN
    UPDATE customer SET cemail = NEW.cemail,caddress = NEW.caddress,cphone = NEW.cphone WHERE cname = NEW.cname;
    UPDATE publication SET amount = amount + OLD.quantity - NEW.quantity WHERE pname = NEW.pname;
    UPDATE bill SET caddress = NEW.caddress,cphone = NEW.cphone,fee = NEW.price*NEW.quantity,odate = NEW.odate WHERE cname = NEW.cname;
    UPDATE invoice SET pname = NEW.pname,quantity = NEW.quantity,caddress = NEW.caddress,odate = NEW.odate,total = NEW.price*NEW.quantity WHERE cname = NEW.cname;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table order
-- ----------------------------
DROP TRIGGER IF EXISTS `ordertest3`;
delimiter ;;
CREATE TRIGGER `ordertest3` AFTER DELETE ON `order` FOR EACH ROW BEGIN
    DELETE FROM bill WHERE oid = OLD.oid;
    DELETE FROM invoice WHERE cname = OLD.cname;
    UPDATE publication SET amount = amount + OLD.quantity WHERE pname = OLD.pname;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;


/*
SQLyog Community v13.0.0 (64 bit)
MySQL - 10.1.31-MariaDB : Database - eqpos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eqpos` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `eqpos`;

/*Table structure for table `accounts` */

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `Account_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FName` varchar(20) DEFAULT NULL,
  `LName` varchar(20) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `AccessType` varchar(20) DEFAULT NULL,
  `Status` varchar(20) DEFAULT NULL,
  `Insentives` int(11) DEFAULT '0',
  PRIMARY KEY (`Account_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

/*Data for the table `accounts` */

insert  into `accounts`(`Account_ID`,`FName`,`LName`,`Username`,`Password`,`AccessType`,`Status`,`Insentives`) values 
(1,'Joe','Quitalig','admin','admin','Super Admin','Active',0),
(26,'Diowinard','Medrano','madarafireon','password','Cashier','Active',0),
(31,'a','a','a','a','Cashier','De-Active',0);

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `Customers_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FName` varchar(50) DEFAULT NULL,
  `MName` varchar(50) DEFAULT NULL,
  `LName` varchar(50) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  `Address` text,
  `Points` int(11) DEFAULT '0',
  PRIMARY KEY (`Customers_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `customers` */

insert  into `customers`(`Customers_ID`,`FName`,`MName`,`LName`,`Contact`,`Address`,`Points`) values 
(3,'Joe','e','e','2','2',0),
(4,'Jose','w','ee','213','qwe',0);

/*Table structure for table `prices` */

DROP TABLE IF EXISTS `prices`;

CREATE TABLE `prices` (
  `Product_ID` int(11) NOT NULL,
  `UnitPrice` varchar(50) DEFAULT NULL,
  `Color` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Product_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `prices` */

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `Product_ID` int(11) NOT NULL,
  `Distributor` varchar(50) DEFAULT NULL,
  `Product` varchar(50) DEFAULT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `UOM` varchar(50) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Size` varchar(50) DEFAULT NULL,
  `Section` varchar(50) DEFAULT NULL,
  `Accessories` varchar(50) DEFAULT NULL,
  `Color` varchar(50) DEFAULT NULL,
  `UnitPrice` double NOT NULL,
  PRIMARY KEY (`Product_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `products` */

insert  into `products`(`Product_ID`,`Distributor`,`Product`,`Description`,`UOM`,`Quantity`,`Size`,`Section`,`Accessories`,`Color`,`UnitPrice`) values 
(1810000,'a','ab','a','Pcs',431,'',NULL,'Sealant','HA (Brown)',234),
(1810001,'100','qw','qw','Pcs',28,'','38 Series Section',NULL,'HA (Brown)',2),
(1810002,'abc company','wire','wire','Pcs',1098,'','38 Series Section',NULL,'A (Anodized)',1000);

/*Table structure for table `stockslogs` */

DROP TABLE IF EXISTS `stockslogs`;

CREATE TABLE `stockslogs` (
  `logsID` int(11) NOT NULL AUTO_INCREMENT,
  `Product_ID` varchar(255) DEFAULT NULL,
  `Product_name` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `Size` varchar(255) DEFAULT NULL,
  `Color` varchar(255) DEFAULT NULL,
  `UnitPrice` double DEFAULT NULL,
  PRIMARY KEY (`logsID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `stockslogs` */

insert  into `stockslogs`(`logsID`,`Product_ID`,`Product_name`,`Quantity`,`Size`,`Color`,`UnitPrice`) values 
(0,'1','1','2','1','1',2),
(2,'2',NULL,NULL,NULL,NULL,NULL),
(3,'1','1','2','1','1',2),
(4,'1','1','2',NULL,NULL,NULL),
(5,'0',' ','0',NULL,NULL,NULL),
(6,'',' ','',NULL,NULL,NULL),
(7,'',' ','',NULL,NULL,NULL),
(8,'',' ','',NULL,NULL,NULL),
(9,'','','',NULL,NULL,NULL),
(10,'1810002','wire','23',NULL,NULL,NULL);

/*Table structure for table `transaction` */

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `Transaction_ID` int(11) DEFAULT NULL,
  `Product_ID` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `UnitPrice` double DEFAULT NULL,
  `Discount` double DEFAULT NULL,
  `Total` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `transaction` */

insert  into `transaction`(`Transaction_ID`,`Product_ID`,`Date`,`Name`,`Quantity`,`UnitPrice`,`Discount`,`Total`) values 
(1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

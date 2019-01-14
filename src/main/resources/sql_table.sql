-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.24-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mybasket
CREATE DATABASE IF NOT EXISTS `mybasket` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mybasket`;

-- Dumping structure for table mybasket.corporate_schedule_details
CREATE TABLE IF NOT EXISTS `corporate_schedule_details` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `contact_person_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `locality` varchar(255) DEFAULT NULL,
  `mobile_no` bigint(20) DEFAULT NULL,
  `pickup_date` date DEFAULT NULL,
  `pickup_time` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `scrap_type` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp97s9ha56dy62r2rfr328pqcl` (`user_id`),
  CONSTRAINT `FKp97s9ha56dy62r2rfr328pqcl` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table mybasket.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table mybasket.notification_details
CREATE TABLE IF NOT EXISTS `notification_details` (
  `id` bigint(20) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `corporate_schedule_id` bigint(20) NOT NULL,
  `schedule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg4baif7hv3x17vg67y4wi3fdl` (`corporate_schedule_id`),
  KEY `FKfbfi4fbf5xbjwd78wimwph380` (`schedule_id`),
  CONSTRAINT `FKfbfi4fbf5xbjwd78wimwph380` FOREIGN KEY (`schedule_id`) REFERENCES `schedule_details` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKg4baif7hv3x17vg67y4wi3fdl` FOREIGN KEY (`corporate_schedule_id`) REFERENCES `corporate_schedule_details` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table mybasket.schedule_details
CREATE TABLE IF NOT EXISTS `schedule_details` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `locality` varchar(255) DEFAULT NULL,
  `mobile_no` bigint(20) DEFAULT NULL,
  `pickup_date` date DEFAULT NULL,
  `pickup_time` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `scrap_type` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2dtvrnyv9wdq5p142uk9r5ta9` (`user_id`),
  CONSTRAINT `FK2dtvrnyv9wdq5p142uk9r5ta9` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table mybasket.scraptype
CREATE TABLE IF NOT EXISTS `scraptype` (
  `scraptype` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table mybasket.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

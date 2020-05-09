-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jan 05, 2019 at 07:09 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cork`
--

-- --------------------------------------------------------

--
-- Table structure for table `cork`
--

DROP TABLE IF EXISTS `cork`;
CREATE TABLE IF NOT EXISTS `cork` (
  `registration_number` int(11) NOT NULL,
  `model` varchar(50) NOT NULL,
  `manfacturer` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `city` varchar(50) NOT NULL,
  `isRent` tinyint(1) NOT NULL,
  PRIMARY KEY (`registration_number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cork`
--

INSERT INTO `cork` (`registration_number`, `model`, `manfacturer`, `price`, `city`, `isRent`) VALUES
(1000, 'scion', 'toyota', 100, 'Cork', 0),
(1001, 'dodge', 'benz', 150, 'Cork', 0),
(1002, 'fiat', 'maserati', 160, 'Cork', 0),
(1003, 'mercury', 'ford', 800, 'Cork', 0),
(1004, 'volvo', 'ford', 543, 'Cork', 0),
(1005, 'fiat', 'maserati', 52413, 'Cork', 0),
(1006, 'fiat', 'alfaromeo', 125, 'Cork', 0),
(1007, 'rover', 'MG', 250, 'Cork', 0),
(1008, 'honda', 'honda', 1235, 'Cork', 0),
(1009, 'fiat', 'fiat', 512, 'Cork', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

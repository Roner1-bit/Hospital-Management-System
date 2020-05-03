-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2020 at 07:21 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `bloodbank`
--

CREATE TABLE `bloodbank` (
  `Name` varchar(255) NOT NULL,
  `Age` int(2) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Litres` float NOT NULL,
  `Bag` float NOT NULL,
  `BloodType` varchar(3) NOT NULL,
  `Number` varchar(11) NOT NULL,
  `Address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bloodbank`
--

INSERT INTO `bloodbank` (`Name`, `Age`, `Gender`, `Email`, `Date`, `Time`, `Litres`, `Bag`, `BloodType`, `Number`, `Address`) VALUES
('Mos', 1, 'Male', 'alse@gmail.com', '2020-04-30', '06:12:46', 1, 0.5, 'A+', '1100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-04-30', '07:02:32', 1, 0.5, 'A+', '1100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-04-30', '07:02:48', 1, 0.5, 'A-', '1100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-04-30', '07:07:51', 1, 0.5, 'A-', '01100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-04-30', '07:09:19', 1, 0.5, 'A-', '01100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-04-30', '07:13:41', 1, 0.5, 'A-', '01100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-04-30', '07:13:55', 1, 0.5, 'A-', '01100531517', 'daas');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

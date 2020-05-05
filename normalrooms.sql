-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2020 at 11:22 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `normalrooms`
--

CREATE TABLE `normalrooms` (
  `IDs` tinyint(11) NOT NULL,
  `PatientID` tinyint(11) DEFAULT 0,
  `PatientName` varchar(50) DEFAULT NULL,
  `RoomStatus` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `normalrooms`
--

INSERT INTO `normalrooms` (`IDs`, `PatientID`, `PatientName`, `RoomStatus`) VALUES
(5, 1, 'Mosalah', 1),
(6, 1, 'Mosalah', 1),
(7, 25, 'za8lol', 1),
(8, 0, '', 0),
(9, NULL, '', 0),
(10, NULL, '', 0),
(11, NULL, '', 0),
(12, NULL, '', 0),
(13, NULL, '', 0),
(14, NULL, '', 0),
(15, NULL, '', 0),
(16, NULL, '', 0),
(17, NULL, '', 0),
(18, NULL, '', 0),
(19, NULL, '', 0),
(20, NULL, '', 0),
(21, NULL, '', 0),
(22, NULL, '', 0),
(23, NULL, '', 0),
(24, NULL, '', 0),
(25, NULL, '', 0),
(26, NULL, '', 0),
(27, NULL, '', 0),
(28, NULL, '', 0),
(29, NULL, '', 0),
(30, NULL, '', 0),
(31, 2, 'test', 1),
(32, NULL, '', 0),
(33, NULL, '', 0),
(34, NULL, '', 0),
(35, NULL, '', 0),
(36, NULL, '', 0),
(37, NULL, '', 0),
(38, NULL, '', 0),
(39, NULL, '', 0),
(40, NULL, '', 0),
(41, NULL, '', 0),
(42, NULL, '', 0),
(43, NULL, '', 0),
(44, NULL, '', 0),
(45, NULL, '', 0),
(46, NULL, '', 0),
(47, NULL, '', 0),
(48, NULL, '', 0),
(49, NULL, '', 0),
(50, 4, '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `normalrooms`
--
ALTER TABLE `normalrooms`
  ADD PRIMARY KEY (`IDs`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `normalrooms`
--
ALTER TABLE `normalrooms`
  MODIFY `IDs` tinyint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

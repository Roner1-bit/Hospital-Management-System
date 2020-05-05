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
-- Table structure for table `surgeryrooms`
--

CREATE TABLE `surgeryrooms` (
  `IDs` int(11) NOT NULL,
  `SurgeryName` tinytext DEFAULT NULL,
  `PatientName` tinytext DEFAULT NULL,
  `PatientID` int(11) NOT NULL DEFAULT 0,
  `NumberOfMedicalStaff` tinyint(4) DEFAULT NULL,
  `DateAndTime` tinytext DEFAULT NULL,
  `DoctorsName` tinytext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `surgeryrooms`
--

INSERT INTO `surgeryrooms` (`IDs`, `SurgeryName`, `PatientName`, `PatientID`, `NumberOfMedicalStaff`, `DateAndTime`, `DoctorsName`) VALUES
(51, '0', '0', 0, 0, '0', NULL),
(52, ' ', NULL, 0, NULL, NULL, NULL),
(53, ' ', NULL, 0, NULL, NULL, NULL),
(54, ' ', NULL, 0, NULL, NULL, NULL),
(55, ' ', NULL, 0, NULL, NULL, NULL),
(56, ' ', NULL, 0, NULL, NULL, NULL),
(57, ' ', NULL, 0, NULL, NULL, NULL),
(58, ' ', NULL, 0, NULL, NULL, NULL),
(59, ' ', NULL, 0, NULL, NULL, NULL),
(60, ' ', NULL, 0, NULL, NULL, NULL),
(61, ' ', NULL, 0, NULL, NULL, NULL),
(62, ' ', NULL, 0, NULL, NULL, NULL),
(63, ' ', NULL, 0, NULL, NULL, NULL),
(64, ' ', NULL, 0, NULL, NULL, NULL),
(65, ' ', NULL, 0, NULL, NULL, NULL),
(66, ' ', NULL, 0, NULL, NULL, NULL),
(67, ' ', NULL, 0, NULL, NULL, NULL),
(68, ' ', NULL, 0, NULL, NULL, NULL),
(69, ' ', NULL, 0, NULL, NULL, NULL),
(70, ' ', NULL, 0, NULL, NULL, NULL),
(71, ' ', NULL, 0, NULL, NULL, NULL),
(72, NULL, NULL, 0, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `surgeryrooms`
--
ALTER TABLE `surgeryrooms`
  ADD PRIMARY KEY (`IDs`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `surgeryrooms`
--
ALTER TABLE `surgeryrooms`
  MODIFY `IDs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

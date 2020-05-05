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
-- Table structure for table `clinics`
--

CREATE TABLE `clinics` (
  `ClinicName` tinytext NOT NULL,
  `DoctorID` int(11) NOT NULL,
  `NurseName` tinytext NOT NULL,
  `PatientName` tinytext NOT NULL,
  `PatientID` int(11) NOT NULL,
  `HealthRecord` tinytext NOT NULL,
  `TypeOfVisit` tinytext NOT NULL,
  `DateAndTime` tinytext DEFAULT NULL,
  `DoctorName` tinytext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clinics`
--

INSERT INTO `clinics` (`ClinicName`, `DoctorID`, `NurseName`, `PatientName`, `PatientID`, `HealthRecord`, `TypeOfVisit`, `DateAndTime`, `DoctorName`) VALUES
('Clinic 2', 555, 'fat7ya', 'Mosalah', 1, 'sick', 'consultation', '2020/05/05 11:21:25', 'Mosalah');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2020 at 04:14 AM
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
-- Table structure for table `bloodtests`
--

CREATE TABLE `bloodtests` (
  `ID` int(12) NOT NULL,
  `PatientID` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Age` varchar(11) NOT NULL,
  `Sex` varchar(5) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Status` text NOT NULL,
  `DRID` varchar(50) NOT NULL,
  `Result` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bloodtests`
--

INSERT INTO `bloodtests` (`ID`, `PatientID`, `Name`, `Age`, `Sex`, `Address`, `Email`, `Status`, `DRID`, `Result`) VALUES
(1, 'null', 'null', 'null', 'null', 'null', 'null', 'null', '555', 'result'),
(2, '19', 'Mo', '50', 'Male', 'Address', 'Email', 'in', '555', 'result');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bloodtests`
--
ALTER TABLE `bloodtests`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bloodtests`
--
ALTER TABLE `bloodtests`
  MODIFY `ID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

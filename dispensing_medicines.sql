-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2020 at 02:57 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

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
-- Table structure for table `dispensing_medicines`
--

CREATE TABLE `dispensing_medicines` (
  `invoice_number` int(100) NOT NULL,
  `Drug_Name` varchar(100) NOT NULL,
  `Category` text NOT NULL,
  `Company` varchar(100) NOT NULL,
  `Amount` int(100) NOT NULL,
  `Patients_Names` text NOT NULL,
  `Patients_ID` int(100) NOT NULL,
  `Drug_Code` int(100) NOT NULL,
  `Date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dispensing_medicines`
--

INSERT INTO `dispensing_medicines` (`invoice_number`, `Drug_Name`, `Category`, `Company`, `Amount`, `Patients_Names`, `Patients_ID`, `Drug_Code`, `Date`) VALUES
(1, 'Augmentin', 'Antibiotic', 'Birzeit', 1, 'Mosalah', 1, 5162318, '29/4/2020');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dispensing_medicines`
--
ALTER TABLE `dispensing_medicines`
  ADD PRIMARY KEY (`invoice_number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dispensing_medicines`
--
ALTER TABLE `dispensing_medicines`
  MODIFY `invoice_number` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

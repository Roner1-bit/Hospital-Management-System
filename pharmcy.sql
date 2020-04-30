-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2020 at 02:58 AM
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
-- Table structure for table `pharmcy`
--

CREATE TABLE `pharmcy` (
  `Barcode` int(100) NOT NULL,
  `Drug_Name` varchar(100) NOT NULL,
  `Category` text NOT NULL,
  `Company` varchar(100) NOT NULL,
  `Amounts` int(100) NOT NULL,
  `Validity` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pharmcy`
--

INSERT INTO `pharmcy` (`Barcode`, `Drug_Name`, `Category`, `Company`, `Amounts`, `Validity`) VALUES
(5162318, 'Augmentin', 'Antibiotic', 'Birzeit', 100, '20/5/2025'),
(5162319, 'Lantus', 'Diabetes', 'Sanofi-Aventis', 50, '30/8/2023');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pharmcy`
--
ALTER TABLE `pharmcy`
  ADD PRIMARY KEY (`Barcode`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pharmcy`
--
ALTER TABLE `pharmcy`
  MODIFY `Barcode` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5162321;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2020 at 04:51 AM
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
-- Table structure for table `bloodbags`
--

CREATE TABLE `bloodbags` (
  `BloodType` varchar(3) NOT NULL,
  `Count` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bloodbags`
--

INSERT INTO `bloodbags` (`BloodType`, `Count`) VALUES
('A+', 4.5),
('A-', 2);

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
('Moas', 1, 'Male', 'alse@gmail.com', '2020-04-30', '07:13:55', 1, 0.5, 'A-', '01100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-05-03', '07:29:43', 1, 0.5, 'A-', '01100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-05-03', '07:33:32', 1, 0.5, 'A-', '01100531517', 'daas'),
('Moas', 1, 'Male', 'alse@gmail.com', '2020-05-03', '07:34:37', 1, 0.5, 'A-', '01100531517', 'daas');

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

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `id` int(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fname` text NOT NULL,
  `lname` text NOT NULL,
  `age` int(100) NOT NULL,
  `addr` varchar(100) NOT NULL,
  `salary` float DEFAULT NULL,
  `hours` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `IDs` int(100) NOT NULL,
  `Names` text NOT NULL,
  `Age` int(100) NOT NULL,
  `Sex` text NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Health_Record` varchar(100) NOT NULL,
  `Status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`IDs`, `Names`, `Age`, `Sex`, `Address`, `Email`, `Health_Record`, `Status`) VALUES
(1, 'Mosalah', 22, 'Male', 'Cairo', 'Mosalah.fuck@gmail.com', 'big dick', 'in'),
(2, 'Mosalah', 22, 'Male', 'Cairo', 'Mosalah.fuck@gmail.com', 'Tonsillectomy', 'in'),
(4, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(5, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(6, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(7, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(8, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(9, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(10, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(11, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(12, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(13, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(14, 'Mo', 50, 'Male', 'Address', 'Email', '1 : com.mysql.jdbc.JDBC4ResultSet@1698c449', 'in'),
(15, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(16, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(17, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(18, 'Mo', 50, 'Male', 'Address', 'Email', '', 'in'),
(19, 'Mo', 50, 'Male', 'Address', 'Email', '2 : result', 'in');

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
(5162318, 'Augmentin', 'Antibiotic', 'Birzeit', 99, '20/5/2025'),
(5162319, 'Lantus', 'Diabetes', 'Sanofi-Aventis', 50, '30/8/2023');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `IDs` int(100) NOT NULL,
  `Names` text NOT NULL,
  `Jop` text NOT NULL,
  `Department` text NOT NULL,
  `Age` int(100) NOT NULL,
  `Sex` text NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`IDs`, `Names`, `Jop`, `Department`, `Age`, `Sex`, `Address`, `Email`, `Salary`) VALUES
(555, 'Mosalah', 'Doctor', 'Surgery', 22, 'male', 'cairo', 'Mosalah@gmail.com', 50000),
(558, 'Mosalah', 'Doctor', 'Surgery', 21, 'male', 'cairo', 'Mosalah@gmail.com', 50000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bloodtests`
--
ALTER TABLE `bloodtests`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dispensing_medicines`
--
ALTER TABLE `dispensing_medicines`
  ADD PRIMARY KEY (`invoice_number`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`IDs`);

--
-- Indexes for table `pharmcy`
--
ALTER TABLE `pharmcy`
  ADD PRIMARY KEY (`Barcode`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`IDs`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bloodtests`
--
ALTER TABLE `bloodtests`
  MODIFY `ID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `dispensing_medicines`
--
ALTER TABLE `dispensing_medicines`
  MODIFY `invoice_number` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `manager`
--
ALTER TABLE `manager`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `IDs` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `pharmcy`
--
ALTER TABLE `pharmcy`
  MODIFY `Barcode` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5162320;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `IDs` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=559;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

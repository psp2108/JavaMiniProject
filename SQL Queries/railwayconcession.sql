-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 26, 2018 at 03:52 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `railwayconcession`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `credential_check` (IN `sap_id_ip` VARCHAR(12), IN `student_password_ip` VARCHAR(255))  BEGIN

	DECLARE ROW_COUNT INT;
    
    SET ROW_COUNT = (SELECT COUNT(*) from student_profile where 
       sap_id=sap_id_ip AND student_password=student_password_ip);

    IF(ROW_COUNT <> 0) THEN 
    
    	SELECT "true";
    ELSE
    	SELECT "false";
    END IF;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `rail_concess`
--

CREATE TABLE `rail_concess` (
  `sap_id` varchar(12) NOT NULL,
  `rc_id` int(11) NOT NULL,
  `request_date` date DEFAULT NULL,
  `class_type` int(11) DEFAULT NULL,
  `approved_from` date DEFAULT NULL,
  `approved_till` date DEFAULT NULL,
  `status` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rail_concess`
--

INSERT INTO `rail_concess` (`sap_id`, `rc_id`, `request_date`, `class_type`, `approved_from`, `approved_till`, `status`) VALUES
('60004188006', 1, '2018-10-26', 1, NULL, NULL, 0),
('60004188022', 2, '2018-10-26', 2, NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `student_profile`
--

CREATE TABLE `student_profile` (
  `sap_id` varchar(12) NOT NULL,
  `student_name` varchar(255) NOT NULL,
  `student_password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `hometown` varchar(255) NOT NULL,
  `department` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_profile`
--

INSERT INTO `student_profile` (`sap_id`, `student_name`, `student_password`, `email`, `hometown`, `department`) VALUES
('60004188006', 'Pratik Panchal', '1234', 'pratik.sp.1112@gmail.com', 'Badlapur', 'Comps'),
('60004188022', 'Rucha Shinde', '1234', 'rucha@gmail.com', 'Thane', 'Comps');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rail_concess`
--
ALTER TABLE `rail_concess`
  ADD PRIMARY KEY (`rc_id`),
  ADD KEY `sap_id` (`sap_id`);

--
-- Indexes for table `student_profile`
--
ALTER TABLE `student_profile`
  ADD PRIMARY KEY (`sap_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rail_concess`
--
ALTER TABLE `rail_concess`
  MODIFY `rc_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rail_concess`
--
ALTER TABLE `rail_concess`
  ADD CONSTRAINT `rail_concess_ibfk_1` FOREIGN KEY (`sap_id`) REFERENCES `student_profile` (`sap_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

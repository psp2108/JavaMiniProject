-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 27, 2018 at 04:36 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

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

CREATE DEFINER=`root`@`localhost` PROCEDURE `pending_status` (IN `status_ip` INT)  BEGIN

    DECLARE ROW_COUNT INT;
	
    SET ROW_COUNT = (
        SELECT COUNT(*) from rail_concess
    	WHERE
    	rail_concess.application_status=status_ip
    );


    IF (ROW_COUNT <> 0) THEN
        SELECT 
        rail_concess.sap_id as "SAP ID",
        rail_concess.rc_id as "Concession ID",
        student_profile.student_name as "Name",
        student_profile.hometown as "Station From",
        rail_concess.class_type as "Class",
        student_profile.department as "Deptartment",
        rail_concess.request_date as "Request Date"
        FROM student_profile, rail_concess 
        WHERE
        rail_concess.sap_id=student_profile.sap_id AND
        rail_concess.application_status=status_ip;
    END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `request_application` (IN `sap_id_ip` VARCHAR(12), IN `class_type_ip` INT)  BEGIN

DECLARE is_pending int;
DECLARE is_accepted int;
DECLARE is_rejected int;
DECLARE curr_date date;
DECLARE last_date date;
DECLARE number_of_days int;




SET is_pending = (SELECT COUNT(*) from rail_concess where sap_id = sap_id_ip and application_status = 0);

SET is_accepted = (SELECT COUNT(*) from rail_concess where sap_id = sap_id_ip and application_status = 1);

SET is_rejected = (SELECT COUNT(*) from rail_concess where sap_id = sap_id_ip and application_status = -1);

set curr_date = (select now());

	if(is_accepted > 0 OR is_rejected > 0) THEN
		set last_date = (select approved_till from rail_concess where sap_id = sap_id_ip 
                         and application_status = 1
                         order by approved_till desc
                         limit 1);
                         
        set number_of_days = (select datediff(last_date, curr_date));
	else 
    	set number_of_days = (0);
    end if;
     
     
if(is_pending > 0) THEN
	select "Your request is already waiting for approval!";
else
	if(number_of_days <= 15) THEN
    	
        INSERT INTO rail_concess 
        (sap_id,request_date,class_type) VALUES
        (sap_id_ip,now(),class_type_ip);
        
    	select "Request accepted and waiting for approval";
    ELSE
    	select "Request accepted only 15 days prior to last date";
    end if;
end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `show_app_status` (IN `sap_id_ip` VARCHAR(12))  BEGIN
	
    DECLARE ROW_COUNT INT;
	
    SET ROW_COUNT = (
        SELECT COUNT(*) from rail_concess, student_profile
    	WHERE
    	Student_Profile.sap_id = rail_concess.sap_id AND
    	rail_concess.sap_id = sap_id_ip
    	order by rc_id DESC
    	limit 1
    );
	
    IF (ROW_COUNT <> 0) THEN
    	select 
        student_name, rail_concess.sap_id, "Ville Parle", hometown, 
        email, department, class_type, application_status
        from rail_concess, student_profile
        WHERE
        Student_Profile.sap_id = rail_concess.sap_id AND
        rail_concess.sap_id = sap_id_ip
        order by rc_id DESC
        limit 1;
    ELSE
    	SELECT "false";
    END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `status_change` (IN `rc_id_ip` INT, IN `status_ip` INT)  BEGIN

	IF(status_ip = -1) THEN
		UPDATE rail_concess 
        SET 
        application_status = -1,
        approved_from = now(),
        approved_till = DATE_ADD(now(), INTERVAL 3 MONTH)
        
        WHERE rc_id = rc_id_ip;
    ELSE
		UPDATE rail_concess
        SET 
        application_status = status_ip,
        approved_from = now(),
        approved_till = DATE_ADD(now(), INTERVAL 3 MONTH)
        WHERE rc_id = rc_id_ip;
    END IF; 
    

	select "true";

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
  `application_status` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
('60004188001', 'Prem Bhajaj', '1234', 'Prem@gmail.com', 'Govandi', 'Comps'),
('60004188002', 'Ankit Gupta', '1234', 'Ankit@gmail.com', 'Mankhurd', 'Comps'),
('60004188003', 'Harshil Vakharia', '1234', 'Harshil@gmail.com', 'Vashi', 'Comps'),
('60004188004', 'Madhura Shanbhag', '1234', 'Madhura@gmail.com', 'Sanpada', 'Comps'),
('60004188005', 'Harsh Mistry', '1234', 'Harsh@gmail.com', 'Juinagar', 'Comps'),
('60004188006', 'Shanay Panchal', '1234', 'Shanay@gmail.com', 'Nerul', 'Comps'),
('60004188007', 'Pratik Shah', '1234', 'Pratik@gmail.com', 'Seawoods-Darave', 'Comps'),
('60004188008', 'Fenil Gholani', '1234', 'Fenil@gmail.com', 'CBD Belapur', 'Comps'),
('60004188009', 'Atharva Tawate', '1234', 'Atharva@gmail.com', 'Kharghar', 'Comps'),
('60004188010', 'Dharmik Parikh', '1234', 'Dharmik@gmail.com', 'Mansarovar', 'Comps'),
('60004188011', 'Divya Shah', '1234', 'Divya@gmail.com', 'Khandeshwar', 'Comps'),
('60004188012', 'Kirti Gupta', '1234', 'Kirti@gmail.com', 'Panvel', 'Comps'),
('60004188013', 'Ananya Malik', '1234', 'Ananya@gmail.com', 'Churchgate', 'Comps'),
('60004188014', 'Arnav Parekhji', '1234', 'Arnav@gmail.com', 'Marine Lines', 'Comps'),
('60004188015', 'Heet Kanani', '1234', 'Heet@gmail.com', 'Charni Road', 'Comps'),
('60004188016', 'Amogh Parab', '1234', 'Amogh@gmail.com', 'Grant Road', 'Comps'),
('60004188017', 'Ayush Shah', '1234', 'Ayush@gmail.com', 'Mumbai Central', 'Comps'),
('60004188018', 'Harshil Jhaveri', '1234', 'Harshil@gmail.com', 'Mahalaxmi', 'Comps'),
('60004188019', 'Jashan Singh Banga', '1234', 'Jashan Singh@gmail.com', 'Lower Parel', 'Comps'),
('60004188020', 'Jay Shah', '1234', 'Jay@gmail.com', 'Elphinstone Road', 'Comps'),
('60004188021', 'Kaustubh Shinde', '1234', 'Kaustubh@gmail.com', 'Dadar', 'Comps'),
('60004188022', 'Jash Kekre', '1234', 'Jash@gmail.com', 'Matunga Road', 'Comps'),
('60004188023', 'Rucha Amin', '1234', 'Rucha@gmail.com', 'Mahim', 'Comps'),
('60004188024', 'Hrishikesh Shenai', '1234', 'Hrishikesh@gmail.com', 'Bandra', 'Comps'),
('60004188025', 'Arnesh Vaidya', '1234', 'Arnesh@gmail.com', 'Khar Road', 'Comps'),
('60004188026', 'Jai Mehta', '1234', 'Jai@gmail.com', 'Santacruz', 'Comps'),
('60004188027', 'Dhyey Thumar', '1234', 'Dhyey@gmail.com', 'Andheri', 'Comps'),
('60004188028', 'Ayushi Lodaria', '1234', 'Ayushi@gmail.com', 'Andheri', 'Comps'),
('60004188029', 'Dhairya Shah', '1234', 'Dhairya@gmail.com', 'Jogeshwari', 'Comps'),
('60004188030', 'Pranjal Chitale', '1234', 'Pranjal@gmail.com', 'Goregaon', 'Comps'),
('60004188031', 'Jainam Shah', '1234', 'Jainam@gmail.com', 'Malad', 'Comps'),
('60004188032', 'Danish Jain', '1234', 'Danish@gmail.com', 'Kandivali', 'Comps'),
('60004188033', 'Hrithika Dodia', '1234', 'Hrithika@gmail.com', 'Borivali', 'Comps'),
('60004188034', 'Harsh Mehta', '1234', 'Harsh@gmail.com', 'Dahisar', 'Comps'),
('60004188035', 'Heeket Mehta', '1234', 'Heeket@gmail.com', 'Mira Road', 'Comps'),
('60004188036', 'Arish Damania', '1234', 'Arish@gmail.com', 'Bhayandar', 'Comps'),
('60004188037', 'Adit Kalyani', '1234', 'Adit@gmail.com', 'Naigaon', 'Comps'),
('60004188038', 'Kalpesh Patil', '1234', 'Kalpesh@gmail.com', 'Vasai Road', 'Comps'),
('60004188039', 'Jay Gala', '1234', 'Jay@gmail.com', 'Nala Sopara', 'Comps'),
('60004188040', 'Aniruddha Das', '1234', 'Aniruddha@gmail.com', 'Virar', 'Comps'),
('60004188041', 'Himanshu Tandel', '1234', 'Himanshu@gmail.com', 'valtarna', 'Comps'),
('60004188042', 'Abhi Thummar', '1234', 'Abhi@gmail.com', 'Saphale', 'Comps'),
('60004188043', 'Aniket Shahane', '1234', 'Aniket@gmail.com', 'Kelve Road', 'Comps'),
('60004188044', 'Drashti Shah', '1234', 'Drashti@gmail.com', 'Palghar', 'Comps'),
('60004188045', 'Devansh Shah', '1234', 'Devansh@gmail.com', 'Umroli', 'Comps'),
('60004188046', 'Jigar Mav', '1234', 'Jigar@gmail.com', 'Boisar', 'Comps'),
('60004188047', 'Shreya Pathak', '1234', 'Shreya@gmail.com', 'Vangaon', 'Comps'),
('60004188048', 'Dev Savla', '1234', 'Dev@gmail.com', 'Dahanu Road', 'Comps'),
('60004188049', 'Devansh Agarwal', '1234', 'Devansh@gmail.com', 'Badlapur', 'Comps'),
('60004188050', 'Dhruv Patil', '1234', 'Dhruv@gmail.com', 'Thane', 'Comps'),
('60004188051', 'Tanmai Prabhune', '1234', 'Tanmai@gmail.com', 'Malad', 'Comps');

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
  MODIFY `rc_id` int(11) NOT NULL AUTO_INCREMENT;
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

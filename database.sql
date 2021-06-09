-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 30, 2021 at 02:00 PM
-- Server version: 10.1.9-MariaDB-log
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ums`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance_student`
--

CREATE TABLE `attendance_student` (
  `id` int(11) NOT NULL,
  `rollno` int(11) NOT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `first` varchar(45) DEFAULT NULL,
  `second` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_student`
--

INSERT INTO `attendance_student` (`id`, `rollno`, `Date`, `first`, `second`) VALUES
(1, 15, 'Sun May 30 18:28:03 PKT 2021', 'Present', 'Absent');

-- --------------------------------------------------------

--
-- Table structure for table `attendance_teacher`
--

CREATE TABLE `attendance_teacher` (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `Date` varchar(45) DEFAULT NULL,
  `first` varchar(45) DEFAULT NULL,
  `second` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_teacher`
--

INSERT INTO `attendance_teacher` (`id`, `emp_id`, `Date`, `first`, `second`) VALUES
(1, 11, 'Sun May 30 18:28:26 PKT 2021', 'Absent', 'Present');

-- --------------------------------------------------------

--
-- Table structure for table `fee`
--

CREATE TABLE `fee` (
  `id` int(11) NOT NULL,
  `rollno` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `fathers_name` varchar(45) DEFAULT NULL,
  `course` varchar(45) DEFAULT NULL,
  `branch` varchar(45) DEFAULT NULL,
  `semester` varchar(45) DEFAULT NULL,
  `fee_paid` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='fee(rollno, name, fathers_name, course, branch, semester, fee_paid)';

--
-- Dumping data for table `fee`
--

INSERT INTO `fee` (`id`, `rollno`, `name`, `fathers_name`, `course`, `branch`, `semester`, `fee_paid`) VALUES
(1, 15, 'Ali', 'Ali Shah', 'B.Tech', 'Mechanical', '1st', '500');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='select * from login where username=''"+u+"'' and password=''"+v+"''"';

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `username`, `password`) VALUES
(1, 'murad', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `id` int(11) NOT NULL,
  `rollno` int(11) NOT NULL,
  `marks1` int(11) NOT NULL,
  `marks2` int(11) NOT NULL,
  `marks3` int(11) NOT NULL,
  `marks4` int(11) NOT NULL,
  `marks5` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`id`, `rollno`, `marks1`, `marks2`, `marks3`, `marks4`, `marks5`) VALUES
(1, 15, 98, 50, 65, 56, 80);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `std_id` int(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `fathers_name` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `dob` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `class_x` varchar(45) NOT NULL,
  `class_xii` varchar(45) NOT NULL,
  `aadhar` varchar(45) NOT NULL,
  `rollno` int(10) NOT NULL,
  `branch` varchar(45) NOT NULL,
  `course` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='"update student set name=,fathers_name=,age=, dob=,address=,phone=,email=,class_x=,class_xii=aadhar=,course=,branch=where rollno=''";\n                ';

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`std_id`, `name`, `fathers_name`, `age`, `dob`, `address`, `phone`, `email`, `class_x`, `class_xii`, `aadhar`, `rollno`, `branch`, `course`) VALUES
(2, 'Ali', 'Ali Shah', '15', '10-10-2006', 'G-10 islamabad', '123456789', 'ali@recmail.net', '50', '50', '123456789', 15, 'Bsc', 'Computer Science');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `rollno` int(11) NOT NULL,
  `subject1` varchar(45) DEFAULT NULL,
  `subject2` varchar(45) DEFAULT NULL,
  `subject3` varchar(45) DEFAULT NULL,
  `subject4` varchar(45) DEFAULT NULL,
  `subject5` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id`, `rollno`, `subject1`, `subject2`, `subject3`, `subject4`, `subject5`) VALUES
(1, 15, 'Maths', 'DLD', 'DSA', 'SDA', 'Software flare');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `fathers_name` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `class_x` varchar(45) DEFAULT NULL,
  `class_xii` varchar(45) DEFAULT NULL,
  `aadhar` varchar(45) DEFAULT NULL,
  `course` varchar(45) DEFAULT NULL,
  `dept` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='"update teacher set name='''',fathers_name='''',age='''', dob='''',address='''',phone='''',email='''',class_x='''',class_xii='''',aadhar='''', emp_id = '''',course='''',dept='''' where emp_id=";';

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `emp_id`, `name`, `fathers_name`, `age`, `dob`, `address`, `phone`, `email`, `class_x`, `class_xii`, `aadhar`, `course`, `dept`) VALUES
(1, 11, 'Murad Ali', 'Murads Father', '25', '11/05/1994', 'G-10/2 Islamabad', '03315700276', 'murad@recmail.net', '50', '50', '12345-123456-5', 'Bsc', 'Computer Science');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance_student`
--
ALTER TABLE `attendance_student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendance_teacher`
--
ALTER TABLE `attendance_teacher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fee`
--
ALTER TABLE `fee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`std_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance_student`
--
ALTER TABLE `attendance_student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `attendance_teacher`
--
ALTER TABLE `attendance_teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `fee`
--
ALTER TABLE `fee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `std_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

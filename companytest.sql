-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2017 at 08:13 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `companytest`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `appnumber` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `ownername` varchar(50) NOT NULL,
  `ownerfirstname` varchar(50) NOT NULL,
  `fathername` varchar(50) NOT NULL,
  `mothername` varchar(50) NOT NULL,
  `birthdate` varchar(50) NOT NULL,
  `birthplace` varchar(50) NOT NULL,
  `carplatenumber` double NOT NULL,
  `carmark` varchar(40) NOT NULL,
  `modelname` varchar(30) NOT NULL,
  `caryear` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `telephone` int(11) NOT NULL,
  `limitcovering` varchar(20) NOT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`appnumber`, `date`, `ownername`, `ownerfirstname`, `fathername`, `mothername`, `birthdate`, `birthplace`, `carplatenumber`, `carmark`, `modelname`, `caryear`, `address`, `telephone`, `limitcovering`, `username`) VALUES
('1', '11/01/17 13:08:26', 'ali', 'kassem', 'hasan', 'lana', '12-10-2000', 'saida', 12345, 'bmw', 'new', 2003, 'saida', 76009988, '10000$', NULL),
('2', '11/01/17 13:08:26', 'ali', 'kassem', 'hasan', 'lana', '12-10-2000', 'saida', 12345, 'bmw', 'new', 2003, 'saida', 76009988, '10000$', 'aloush'),
('10', '11/01/17 16:11:15', 'maya', 'kassem', 'ali', 'nada', '9-1-1992', 'saida', 687876, 'bmw', 'new', 2000, 'saida', 76661166, '25000$', NULL),
('11', '11/01/17 16:23:05', 'fadi', 'kassem', 'hadi', 'sahar', '1-1-1970', 'saida', 7654, 'bmw', 'new', 1999, 'saida', 78009900, '25000$', NULL),
('12', '11/01/17 16:43:00', 'alaa', 'zreik', 'walid', 'nada', '2-2-2000', 'saida', 6576, 'bmw', 'new', 1999, 'saida', 76551122, '10000$', NULL),
('16', '11/01/17 17:00:41', 'hasan', 'hamdan', 'ali', 'fatima', '8-9-2000', 'saida', 765, 'bmw', 'new', 1998, 'saida', 78654123, '10000$', NULL),
('16', '12/01/17 00:36:06', 'mahdi', 'mokbel', 'mohamad', 'sharife', '1-1-1993', 'kafarmlki', 786578, 'porche', 'nna', 2000, 'kafarmlki', 78004455, '25000$', 'mahdi'),
('565565', '17/01/17 09:07:38', 'q', 'q', 'q', 'q', '23-9-2000', 'q', 8347346, 'bmw', 'new', 1990, 'saida', 79000999, '25000$', NULL),
('678968', '20/01/17 13:25:51', 'maysa', 'abo jamra', 'lemi3', 'florida', '23-9-1995', 'dermimes', 111, 'bmw', 'new', 2016, 'dermimes', 766665, '25000$', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `health`
--

CREATE TABLE `health` (
  `application` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `insuredname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `fathername` varchar(50) NOT NULL,
  `mothername` varchar(50) NOT NULL,
  `birthdate` varchar(50) NOT NULL,
  `birthplace` varchar(50) NOT NULL,
  `maritalstate` varchar(50) NOT NULL,
  `nbchildren` int(11) NOT NULL,
  `job` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `tel` int(11) NOT NULL,
  `limitcovering` varchar(10) NOT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `health`
--

INSERT INTO `health` (`application`, `date`, `insuredname`, `firstname`, `fathername`, `mothername`, `birthdate`, `birthplace`, `maritalstate`, `nbchildren`, `job`, `address`, `tel`, `limitcovering`, `username`) VALUES
('1', '11/01/17 13:25:37', 'ali', 'kassem', 'hasan', 'lana', '12-10-2000', 'saida', 'single', 0, 'dr', 'saida', 78099090, '5000$', 'aloush'),
('2', '11/01/17 16:33:16', 'ali', 'madi', 'nader', 'alaa', '1-1-2001', 'saida', 'single', 0, 'dr', 'saida', 78551155, '5000$', NULL),
('5', '11/01/17 16:44:24', 'hadi', 'zreik', 'walid', 'nada', '2-2-2000', 'saida', 'married', 2, 'dr', 'saida', 76551122, '5000$', NULL),
('19', '13/01/17 00:26:33', 'mahdi', 'mokbil', 'mohamad', 'sharife', '1-1-1993', 'kafarmlki', 'single', 0, 'security', 'kafarmlki', 76122121, '10000$', 'mahdi'),
('20', '13/01/17 00:39:25', 'ibrahim', 'hamoud', 'ali', 'zeinab', '18-06-1970', 'kafarmlki', 'married', 5, 'police', 'kafarmlki', 78009988, '7500$', 'hamoud');

-- --------------------------------------------------------

--
-- Table structure for table `life`
--

CREATE TABLE `life` (
  `application` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `insuredname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `fathername` varchar(50) NOT NULL,
  `mothername` varchar(50) NOT NULL,
  `birthdate` varchar(50) NOT NULL,
  `birthplace` varchar(50) NOT NULL,
  `maritalstate` varchar(50) NOT NULL,
  `nbchildren` int(11) NOT NULL,
  `job` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `tel` int(11) NOT NULL,
  `limitcovering` varchar(50) NOT NULL,
  `ben1` varchar(50) NOT NULL,
  `ben2` varchar(50) NOT NULL,
  `disease` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `life`
--

INSERT INTO `life` (`application`, `date`, `insuredname`, `firstname`, `fathername`, `mothername`, `birthdate`, `birthplace`, `maritalstate`, `nbchildren`, `job`, `address`, `tel`, `limitcovering`, `ben1`, `ben2`, `disease`, `username`) VALUES
('1', '11/01/17 13:28:45', 'ali', 'kassem', 'hasan', 'lana', '12-10-1-2000', 'saida', 'single', 0, 'dr', 'saida', 871562542, '5000$', 'hasan', 'zeinab', 'hello', 'aloush'),
('2', '11/01/17 16:25:14', 'chadi', 'kassem', 'hadi', 'sahar', '1-1-1970', 'saida', 'single', 0, 'dr', 'saida', 121212, '7500$', 'aliu', 'hasan', 'none', NULL),
('3', '11/01/17 16:27:46', 'mohamad', 'kassem', 'hasan', 'zeinab', '23-9-1992', 'kafarmlki', 'single', 0, 'student', 'kafarmlki', 76089439, '20000$', 'hasan', 'zeinab', 'none', NULL),
('8', '13/01/17 00:22:41', 'mahdi', 'mokbil', 'mohamad', 'sharife', '1-1-1993', 'kafarmlki', 'single', 0, 'security', 'kafarmlki', 78122121, '20000$', 'ahmad', 'hassan', 'none', 'mahdi');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`name`, `password`, `state`) VALUES
('mohamad', '11111', 'employee'),
('alaa', '22222', 'employee'),
('mahdi', 'mmmmm', 'client'),
('hamoud', 'hhhhh', 'client');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

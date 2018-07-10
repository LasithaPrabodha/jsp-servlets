-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2018 at 09:59 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `auction`
--

-- --------------------------------------------------------

--
-- Table structure for table `auctiondetails`
--

CREATE TABLE `auctiondetails` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET ascii NOT NULL,
  `category` tinyint(4) DEFAULT NULL,
  `min-bid` double NOT NULL,
  `dateadded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auctiondetails`
--

INSERT INTO `auctiondetails` (`id`, `name`, `category`, `min-bid`, `dateadded`) VALUES
(2, 'A ring', 1, 20000, '2018-05-08 17:51:59'),
(3, 'A chain', 1, 50000, '2018-05-08 17:51:59');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `categoryname` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `dateadded` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `categoryname`, `status`, `dateadded`) VALUES
(1, 'Jewelry', 1, '2018-05-08 16:15:56');

-- --------------------------------------------------------

--
-- Table structure for table `itemstatus`
--

CREATE TABLE `itemstatus` (
  `id` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `itemstatus`
--

INSERT INTO `itemstatus` (`id`, `status`) VALUES
(2, 0),
(3, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auctiondetails`
--
ALTER TABLE `auctiondetails`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auctiondetails`
--
ALTER TABLE `auctiondetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

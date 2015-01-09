-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-01-09 11:12:56
-- 服务器版本： 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `uy_business_manager`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
`id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `userpass` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`id`, `username`, `userpass`, `role`) VALUES
(1, 'admin', '123456', 1);

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--

CREATE TABLE IF NOT EXISTS `goods` (
`id` int(11) NOT NULL,
  `goodname` varchar(255) NOT NULL,
  `goodprice` int(11) NOT NULL,
  `goodpic` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `goods`
--

INSERT INTO `goods` (`id`, `goodname`, `goodprice`, `goodpic`) VALUES
(11, 'phone1', 3500, 'img/3.jpg'),
(12, 'phone1', 3500, 'img/3.jpg'),
(13, 'face', 100, 'img/3.jpg'),
(14, 'phone1', 3500, 'img/3.jpg'),
(15, 'phone1', 3500, 'img/3.jpg'),
(16, 'phone1', 3500, 'img/3.jpg'),
(17, 'phone1', 3500, 'img/3.jpg'),
(18, 'phone1', 3500, 'img/3.jpg'),
(19, 'phone1', 3500, 'img/3.jpg'),
(20, 'phone1', 3500, 'img/3.jpg'),
(21, 'phone1', 3500, 'img/3.jpg'),
(22, 'phone1', 3500, 'img/3.jpg'),
(23, 'phone1', 3500, 'img/3.jpg'),
(24, 'phone1', 3500, 'img/3.jpg'),
(25, 'phone1', 3500, 'img/3.jpg'),
(26, 'phone1', 3500, 'img/3.jpg'),
(27, 'phone1', 3500, 'img/3.jpg'),
(28, 'a', 1, '1'),
(29, 'a', 1, 'a'),
(30, '1', 1, '1'),
(31, '1', 1, '1'),
(32, 'ruzi', 1000, 'no picture'),
(33, 'qqq', 100, 'img/1.jpg'),
(34, 'qqq', 100, 'img/1.jpg'),
(35, 'www', 100, 'img/1.jpg'),
(36, 'eee', 111, '111'),
(37, 'qwe', 1, 'qwe'),
(38, '123', 123, '123'),
(39, '1', 1, 'null'),
(42, '100', 100, 'null'),
(43, '100', 100, 'null');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `goods`
--
ALTER TABLE `goods`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `goods`
--
ALTER TABLE `goods`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

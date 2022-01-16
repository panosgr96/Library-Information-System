-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2016 at 04:23 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.6
CREATE DATABASE UniversityLibrary DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

use UniversityLibrary;
--
-- Database: `universitylibrary`
--

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `AUTHORID` int(11) NOT NULL,
  `NAME` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`AUTHORID`, `NAME`) VALUES
(1, 'Μουτσόπουλος Χαράλαμπος Μ.'),
(2, 'Schopenhauer Arthur'),
(3, 'Gombrich Ernst Hans'),
(4, 'Hubert Reeves'),
(5, 'Wiseman Richard'),
(6, 'Dawkins Richard');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `ISBN` int(11) NOT NULL,
  `TITLE` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`ISBN`, `TITLE`) VALUES
(1, 'Όταν ο Ιπποκράτης συναντά... τη Θέμιδα'),
(2, 'Η τέχνη να ζεις με τις γυναίκες'),
(3, 'Μικρή ιστορία του κόσμου'),
(4, 'Μιλώντας για το σύμπαν στα εγγόνια μου'),
(5, 'Όλα όσα δεν ξέρεις για σένα'),
(6, 'Η περί Θεού αυταπάτη'),
(7, 'Το εγωιστικό γονίδιο'),
(8, 'TEST');

-- --------------------------------------------------------

--
-- Table structure for table `books_author`
--

CREATE TABLE `books_author` (
  `ISBN` int(11) NOT NULL,
  `AUTHORID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books_author`
--

INSERT INTO `books_author` (`ISBN`, `AUTHORID`) VALUES
(1, 4),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 6),
(8, 1),
(8, 2);

-- --------------------------------------------------------

--
-- Table structure for table `books_categories`
--

CREATE TABLE `books_categories` (
  `ISBN` int(11) NOT NULL,
  `CATEGORYID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books_categories`
--

INSERT INTO `books_categories` (`ISBN`, `CATEGORYID`) VALUES
(1, 2),
(1, 4),
(2, 3),
(3, 2),
(4, 1),
(5, 1),
(6, 3),
(7, 3),
(8, 1),
(8, 3);

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--

CREATE TABLE `brands` (
  `BRANDSID` int(11) NOT NULL,
  `NAME` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brands`
--

INSERT INTO `brands` (`BRANDSID`, `NAME`) VALUES
(1, 'Προπτυχιακός Φοιτητής'),
(2, 'Μεταπτυχιακοί	 Φοιτητές'),
(3, 'Μέλη ΔΕΠ'),
(4, 'Επιστημονικό Προσωπικό'),
(5, 'wetrwerwer'),
(6, 'testcat');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `CATEGORYID` int(11) NOT NULL,
  `NAME` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`CATEGORYID`, `NAME`) VALUES
(1, 'Εκλαϊκευμένης Επιστήμης'),
(2, 'Ιστορίας'),
(3, 'Φιλοσοφίας'),
(4, 'Ιατρικής');

-- --------------------------------------------------------

--
-- Table structure for table `copies`
--

CREATE TABLE `copies` (
  `COPYID` int(11) NOT NULL,
  `ISBN` int(11) NOT NULL,
  `FREEFLAG` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `copies`
--

INSERT INTO `copies` (`COPYID`, `ISBN`, `FREEFLAG`) VALUES
(1, 1, 0),
(2, 1, 0),
(3, 2, 1),
(4, 3, 1),
(5, 8, 0),
(6, 8, 0),
(7, 8, 0),
(8, 1, 0),
(9, 1, 0),
(11, 8, 0);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CUSTOMERSID` int(11) NOT NULL,
  `NAME` varchar(80) NOT NULL,
  `BRANDSID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CUSTOMERSID`, `NAME`, `BRANDSID`) VALUES
(1, 'Μαρία', 1),
(2, 'Γιώργος', 2),
(3, 'Παναγιώτης', 3),
(4, 'Ηλιάνα', 4),
(5, 'Αλεξης', 1);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `ORDERID` int(11) NOT NULL,
  `CUSTOMERSID` int(11) NOT NULL,
  `COPYID` int(11) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `RETURNFLG` tinyint(1) NOT NULL DEFAULT '0',
  `ACTIVE` tinyint(1) NOT NULL DEFAULT '0',
  `ISBN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`ORDERID`, `CUSTOMERSID`, `COPYID`, `START_DATE`, `END_DATE`, `RETURNFLG`, `ACTIVE`, `ISBN`) VALUES
(1, 1, 3, '2016-06-16', '2016-06-18', 1, 1, 2),
(2, 2, 4, '2016-06-18', '2016-06-18', 1, 1, 3),
(3, 1, 8, '2016-06-18', '2016-06-18', 1, 1, 1),
(4, 4, 7, '2016-06-18', '2016-06-18', 1, 1, 8),
(5, 1, 3, '2016-06-18', NULL, 0, 1, 2),
(6, 5, 4, '2016-06-18', NULL, 0, 1, 3);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_authors`
--
CREATE TABLE `v_authors` (
`ISBN` int(11)
,`AUTHORS_NAME` text
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_categories`
--
CREATE TABLE `v_categories` (
`ISBN` int(11)
,`CATEGORY` text
);

-- --------------------------------------------------------

--
-- Structure for view `v_authors`
--
DROP TABLE IF EXISTS `v_authors`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_authors`  AS  select `books_author`.`ISBN` AS `ISBN`,group_concat(`author`.`NAME` separator ', ') AS `AUTHORS_NAME` from (`books_author` join `author` on((`author`.`AUTHORID` = `books_author`.`AUTHORID`))) group by `books_author`.`ISBN` ;

-- --------------------------------------------------------

--
-- Structure for view `v_categories`
--
DROP TABLE IF EXISTS `v_categories`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_categories`  AS  select `books_categories`.`ISBN` AS `ISBN`,group_concat(`categories`.`NAME` separator ', ') AS `CATEGORY` from (`books_categories` join `categories` on((`categories`.`CATEGORYID` = `books_categories`.`CATEGORYID`))) group by `books_categories`.`ISBN` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`AUTHORID`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indexes for table `books_author`
--
ALTER TABLE `books_author`
  ADD PRIMARY KEY (`ISBN`,`AUTHORID`),
  ADD KEY `FK_FK_BOOKS_AUTHOR_AUTHOR` (`AUTHORID`);

--
-- Indexes for table `books_categories`
--
ALTER TABLE `books_categories`
  ADD PRIMARY KEY (`ISBN`,`CATEGORYID`),
  ADD KEY `FK_FK_BOOKS_CAT_CATEGORIES` (`CATEGORYID`);

--
-- Indexes for table `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`BRANDSID`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`CATEGORYID`);

--
-- Indexes for table `copies`
--
ALTER TABLE `copies`
  ADD PRIMARY KEY (`COPYID`),
  ADD KEY `FK_FK_COPIES_BOOKS` (`ISBN`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CUSTOMERSID`),
  ADD KEY `FK_FK_CUSTOMERS_BRANDS` (`BRANDSID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ORDERID`),
  ADD KEY `FK_FK_COPIES_ORDERS` (`COPYID`),
  ADD KEY `FK_FK_ORDERS_CUSTOMERS` (`CUSTOMERSID`),
  ADD KEY `FK_FK_ORDERS_BOOKS` (`ISBN`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `AUTHORID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `ISBN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `brands`
--
ALTER TABLE `brands`
  MODIFY `BRANDSID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `CATEGORYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `copies`
--
ALTER TABLE `copies`
  MODIFY `COPYID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `CUSTOMERSID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `ORDERID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `books_author`
--
ALTER TABLE `books_author`
  ADD CONSTRAINT `FK_FK_BOOKS_AUTHOR_AUTHOR` FOREIGN KEY (`AUTHORID`) REFERENCES `author` (`AUTHORID`),
  ADD CONSTRAINT `FK_FK_BOOKS_AUTHOR_BOOKS` FOREIGN KEY (`ISBN`) REFERENCES `books` (`ISBN`);

--
-- Constraints for table `books_categories`
--
ALTER TABLE `books_categories`
  ADD CONSTRAINT `FK_FK_BOOKS_CAT_BOOKS` FOREIGN KEY (`ISBN`) REFERENCES `books` (`ISBN`),
  ADD CONSTRAINT `FK_FK_BOOKS_CAT_CATEGORIES` FOREIGN KEY (`CATEGORYID`) REFERENCES `categories` (`CATEGORYID`);

--
-- Constraints for table `copies`
--
ALTER TABLE `copies`
  ADD CONSTRAINT `FK_FK_COPIES_BOOKS` FOREIGN KEY (`ISBN`) REFERENCES `books` (`ISBN`);

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `FK_FK_CUSTOMERS_BRANDS` FOREIGN KEY (`BRANDSID`) REFERENCES `brands` (`BRANDSID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_FK_COPIES_ORDERS` FOREIGN KEY (`COPYID`) REFERENCES `copies` (`COPYID`),
  ADD CONSTRAINT `FK_FK_ORDERS_BOOKS` FOREIGN KEY (`ISBN`) REFERENCES `books` (`ISBN`),
  ADD CONSTRAINT `FK_FK_ORDERS_CUSTOMERS` FOREIGN KEY (`CUSTOMERSID`) REFERENCES `customers` (`CUSTOMERSID`);

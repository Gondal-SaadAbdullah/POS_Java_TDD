-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 11, 2017 at 12:29 PM
-- Server version: 5.6.35
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `pos_tdd`
--

-- --------------------------------------------------------

--
-- Table structure for table `Items`
--

CREATE TABLE `Items` (
  `ItemId` int(11) NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `CreateDate` date NOT NULL,
  `Name` varchar(50) NOT NULL,
  `OrganizationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Operator`
--

CREATE TABLE `Operator` (
  `OperatorId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `OperatorLogin` varchar(5) NOT NULL,
  `Password` int(11) NOT NULL,
  `OrganizationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Organizations`
--

CREATE TABLE `Organizations` (
  `OrganizationId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Organizations`
--

INSERT INTO `Organizations` (`OrganizationId`, `Name`) VALUES
(1, 'Fulda_Markt');

-- --------------------------------------------------------

--
-- Table structure for table `Stock`
--

CREATE TABLE `Stock` (
  `StockId` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL,
  `CurrentStock` int(11) NOT NULL,
  `CreateDate` date NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `OrganizationId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Stock_Details`
--

CREATE TABLE `Stock_Details` (
  `StockDetailsId` int(11) NOT NULL,
  `StockId` int(11) NOT NULL,
  `OriginalPrice` double NOT NULL,
  `RetailPrice` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `Active` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Transaction`
--

CREATE TABLE `Transaction` (
  `TransactionId` int(11) NOT NULL,
  `OperatorId` int(11) NOT NULL,
  `TotalQuantity` int(11) NOT NULL,
  `TotalAmount` double NOT NULL,
  `TotalDiscount` double NOT NULL,
  `OrganizationId` int(11) NOT NULL,
  `CreateDate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Transaction_Line`
--

CREATE TABLE `Transaction_Line` (
  `TransactionLineId` int(11) NOT NULL,
  `TransactionId` int(11) NOT NULL,
  `Retail_Price` double NOT NULL,
  `Discount` double NOT NULL,
  `Quantity` int(11) NOT NULL,
  `ItemId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Items`
--
ALTER TABLE `Items`
  ADD PRIMARY KEY (`ItemId`);

--
-- Indexes for table `Operator`
--
ALTER TABLE `Operator`
  ADD PRIMARY KEY (`OperatorId`);

--
-- Indexes for table `Organizations`
--
ALTER TABLE `Organizations`
  ADD PRIMARY KEY (`OrganizationId`);

--
-- Indexes for table `Stock`
--
ALTER TABLE `Stock`
  ADD PRIMARY KEY (`StockId`);

--
-- Indexes for table `Stock_Details`
--
ALTER TABLE `Stock_Details`
  ADD PRIMARY KEY (`StockDetailsId`);

--
-- Indexes for table `Transaction`
--
ALTER TABLE `Transaction`
  ADD PRIMARY KEY (`TransactionId`);

--
-- Indexes for table `Transaction_Line`
--
ALTER TABLE `Transaction_Line`
  ADD PRIMARY KEY (`TransactionLineId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Items`
--
ALTER TABLE `Items`
  MODIFY `ItemId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Operator`
--
ALTER TABLE `Operator`
  MODIFY `OperatorId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Organizations`
--
ALTER TABLE `Organizations`
  MODIFY `OrganizationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `Stock`
--
ALTER TABLE `Stock`
  MODIFY `StockId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Stock_Details`
--
ALTER TABLE `Stock_Details`
  MODIFY `StockDetailsId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Transaction`
--
ALTER TABLE `Transaction`
  MODIFY `TransactionId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Transaction_Line`
--
ALTER TABLE `Transaction_Line`
  MODIFY `TransactionLineId` int(11) NOT NULL AUTO_INCREMENT;
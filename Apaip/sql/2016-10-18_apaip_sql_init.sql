/*
Navicat MySQL Data Transfer

Source Server         : Apaip
Source Server Version : 50541
Source Host           : localhost:3306
Source Database       : apaip

Target Server Type    : MYSQL
Target Server Version : 50541
File Encoding         : 65001

Date: 2016-10-18 12:38:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alleviation_result
-- ----------------------------
DROP TABLE IF EXISTS `alleviation_result`;
CREATE TABLE `alleviation_result` (
  `alleviationResultID` int(11) NOT NULL AUTO_INCREMENT,
  `applicantID` int(11) DEFAULT NULL,
  `registrant` varchar(30) DEFAULT NULL,
  `registerTime` date DEFAULT NULL,
  `alleviationStartTime2` date DEFAULT NULL,
  `alleviationEndTime2` date DEFAULT NULL,
  `resultDescription` varchar(50) DEFAULT NULL,
  `alleviationStatus` int(11) DEFAULT '1',
  PRIMARY KEY (`alleviationResultID`),
  KEY `FK_Relationship_7` (`applicantID`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`applicantID`) REFERENCES `applicant_info` (`applicantID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alleviation_result
-- ----------------------------

-- ----------------------------
-- Table structure for alleviation_situation
-- ----------------------------
DROP TABLE IF EXISTS `alleviation_situation`;
CREATE TABLE `alleviation_situation` (
  `alleviationSituationID` int(11) NOT NULL AUTO_INCREMENT,
  `applicantID` int(11) DEFAULT NULL,
  `startTime` date DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  `alleviationDetail` text,
  `alleviationDelete` int(11) DEFAULT NULL,
  PRIMARY KEY (`alleviationSituationID`),
  KEY `FK_Relationship_8` (`applicantID`),
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`applicantID`) REFERENCES `applicant_info` (`applicantID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of alleviation_situation
-- ----------------------------

-- ----------------------------
-- Table structure for applicant_info
-- ----------------------------
DROP TABLE IF EXISTS `applicant_info`;
CREATE TABLE `applicant_info` (
  `applicantID` int(11) NOT NULL AUTO_INCREMENT,
  `applicantName` varchar(20) DEFAULT NULL,
  `applicantSex` varchar(10) DEFAULT NULL,
  `applicantNation` varchar(20) DEFAULT NULL,
  `applicantIdNumber` varchar(30) DEFAULT NULL,
  `applicantPhone` varchar(30) DEFAULT NULL,
  `applicantAddress` varchar(50) DEFAULT NULL,
  `applicantFamilyNumber` int(11) DEFAULT NULL,
  `applicantDisabilityNumber` varchar(30) DEFAULT NULL,
  `applicantDisablityCondition` varchar(50) DEFAULT NULL,
  `applicantIncome` double(11,0) DEFAULT NULL,
  `houseArea` double DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `marriage` varchar(20) DEFAULT NULL,
  `applicationTime` date DEFAULT NULL,
  `povertyRank` varchar(20) DEFAULT NULL,
  `applicantStatus` int(11) DEFAULT '1',
  `bankCardNumber` varchar(20) DEFAULT NULL,
  `applicantReason` text,
  PRIMARY KEY (`applicantID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicant_info
-- ----------------------------

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `dicID` int(11) NOT NULL AUTO_INCREMENT,
  `dicName` varchar(50) DEFAULT NULL,
  `dicType` varchar(30) DEFAULT NULL,
  `dicDescription` varchar(100) DEFAULT NULL,
  `dicDelFlag` int(11) DEFAULT '1',
  PRIMARY KEY (`dicID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_content` varchar(200) DEFAULT NULL,
  `message_time` varchar(30) DEFAULT NULL,
  `message_people` varchar(20) DEFAULT NULL,
  `message_status` int(11) DEFAULT '1',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_info
-- ----------------------------

-- ----------------------------
-- Table structure for poor_demand_condition
-- ----------------------------
DROP TABLE IF EXISTS `poor_demand_condition`;
CREATE TABLE `poor_demand_condition` (
  `poorDemandConditionID` int(11) NOT NULL AUTO_INCREMENT,
  `demandID` int(11) DEFAULT NULL,
  `applicantID` int(11) DEFAULT NULL,
  PRIMARY KEY (`poorDemandConditionID`),
  KEY `FK_Relationship_5` (`demandID`),
  KEY `FK_Relationship_6` (`applicantID`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`applicantID`) REFERENCES `applicant_info` (`applicantID`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`demandID`) REFERENCES `poor_demand_item` (`demandID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poor_demand_condition
-- ----------------------------

-- ----------------------------
-- Table structure for poor_demand_item
-- ----------------------------
DROP TABLE IF EXISTS `poor_demand_item`;
CREATE TABLE `poor_demand_item` (
  `demandID` int(11) NOT NULL AUTO_INCREMENT,
  `demandName` varchar(20) DEFAULT NULL,
  `demandDescription` varchar(100) DEFAULT NULL,
  `poorDemandItemStatus` int(11) DEFAULT '1',
  PRIMARY KEY (`demandID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poor_demand_item
-- ----------------------------

-- ----------------------------
-- Table structure for poverty_measure
-- ----------------------------
DROP TABLE IF EXISTS `poverty_measure`;
CREATE TABLE `poverty_measure` (
  `measureID` int(11) NOT NULL AUTO_INCREMENT,
  `planID` int(11) DEFAULT NULL,
  `measureName` varchar(20) DEFAULT NULL,
  `poorNumber` int(11) DEFAULT NULL,
  `poorVillage` varchar(20) DEFAULT NULL,
  `budgetAmount` double DEFAULT NULL,
  `measureContent` varchar(50) DEFAULT NULL,
  `measureTime` date DEFAULT NULL,
  `measureStatus` int(11) DEFAULT '1',
  PRIMARY KEY (`measureID`),
  KEY `FK_Relationship_4` (`planID`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`planID`) REFERENCES `poverty_plan` (`planID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poverty_measure
-- ----------------------------

-- ----------------------------
-- Table structure for poverty_plan
-- ----------------------------
DROP TABLE IF EXISTS `poverty_plan`;
CREATE TABLE `poverty_plan` (
  `planID` int(11) NOT NULL AUTO_INCREMENT,
  `planName` varchar(20) DEFAULT NULL,
  `planTime` date DEFAULT NULL,
  `planContent` varchar(50) DEFAULT NULL,
  `planMaker` varchar(30) DEFAULT NULL,
  `planTotalMoney` double DEFAULT NULL,
  `planAim` varchar(40) DEFAULT NULL,
  `planPredictTime` varchar(20) DEFAULT NULL,
  `planStartTime` date DEFAULT NULL,
  `planStatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`planID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of poverty_plan
-- ----------------------------

-- ----------------------------
-- Table structure for selection_notes
-- ----------------------------
DROP TABLE IF EXISTS `selection_notes`;
CREATE TABLE `selection_notes` (
  `selectionNotesID` int(11) NOT NULL AUTO_INCREMENT,
  `notesName` varchar(50) DEFAULT NULL,
  `applyTime` date DEFAULT NULL,
  `applyPerson` varchar(30) DEFAULT NULL,
  `applyStartTime` date DEFAULT NULL,
  `applyEndTime` date DEFAULT NULL,
  `applyContent` text,
  `applyStatus` int(11) DEFAULT '1',
  PRIMARY KEY (`selectionNotesID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of selection_notes
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `userPassword` varchar(30) NOT NULL,
  `userTrueName` varchar(20) DEFAULT NULL,
  `userSex` varchar(2) DEFAULT NULL,
  `IDCard` varchar(20) DEFAULT NULL,
  `userPhone` varchar(15) DEFAULT NULL,
  `userAddr` varchar(50) DEFAULT NULL,
  `userStatus` int(11) DEFAULT '1',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

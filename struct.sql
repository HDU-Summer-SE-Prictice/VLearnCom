-- MySQL dump 10.11
--
-- Host: localhost    Database: vlearncom
-- ------------------------------------------------------
-- Server version	5.0.96-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `B_ID` int(32) NOT NULL,
  `B_Name` varchar(255) NOT NULL,
  `B_Type` varchar(255) NOT NULL,
  `B_Pubtime` time NOT NULL,
  `B_Pubhouse` varchar(255) NOT NULL,
  PRIMARY KEY  (`B_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `C_ID` int(32) NOT NULL,
  `C_Name` varchar(255) NOT NULL,
  `C_Price` double(32,0) NOT NULL,
  `C_Time` varchar(255) NOT NULL,
  PRIMARY KEY  (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `M_ID` int(32) NOT NULL,
  `M_details` varchar(255) NOT NULL,
  PRIMARY KEY  (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_deliever`
--

DROP TABLE IF EXISTS `message_deliever`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_deliever` (
  `M_ID` int(32) NOT NULL,
  `Sender_ID` int(32) NOT NULL,
  `Receiver_ID` int(32) NOT NULL,
  PRIMARY KEY  (`Sender_ID`,`Receiver_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_deliever`
--

LOCK TABLES `message_deliever` WRITE;
/*!40000 ALTER TABLE `message_deliever` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_deliever` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sharedata`
--

DROP TABLE IF EXISTS `sharedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sharedata` (
  `Share_ID` int(32) NOT NULL,
  `Share_Name` varchar(255) NOT NULL,
  `Share_Type` varchar(255) NOT NULL,
  PRIMARY KEY  (`Share_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sharedata`
--

LOCK TABLES `sharedata` WRITE;
/*!40000 ALTER TABLE `sharedata` DISABLE KEYS */;
/*!40000 ALTER TABLE `sharedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `S_ID` int(32) NOT NULL,
  `S_Name` varchar(255) NOT NULL,
  `S_Range` int(32) NOT NULL,
  `S_Email` varchar(255) default NULL,
  `S_TEL` int(11) default NULL,
  `S_PWD` varchar(255) NOT NULL,
  PRIMARY KEY  (`S_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course` (
  `S_ID` int(32) NOT NULL,
  `C_ID` int(32) NOT NULL,
  `Score` int(32) NOT NULL,
  PRIMARY KEY  (`S_ID`,`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_sharedata`
--

DROP TABLE IF EXISTS `student_sharedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_sharedata` (
  `S_ID` int(32) NOT NULL default '0',
  `Share_ID` int(32) NOT NULL,
  PRIMARY KEY  (`S_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_sharedata`
--

LOCK TABLES `student_sharedata` WRITE;
/*!40000 ALTER TABLE `student_sharedata` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_sharedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_topic`
--

DROP TABLE IF EXISTS `student_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_topic` (
  `S_ID` int(32) NOT NULL default '0',
  `Topic_ID` int(32) NOT NULL,
  PRIMARY KEY  (`S_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_topic`
--

LOCK TABLES `student_topic` WRITE;
/*!40000 ALTER TABLE `student_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `T_ID` int(32) NOT NULL,
  `T_Name` varchar(255) NOT NULL,
  `T_Email` varchar(255) NOT NULL,
  `T_TEL` int(11) NOT NULL,
  `T_PWD` varchar(255) NOT NULL,
  PRIMARY KEY  (`T_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_course`
--

DROP TABLE IF EXISTS `teacher_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_course` (
  `T_ID` int(32) NOT NULL,
  `C_ID` int(32) NOT NULL default '0',
  PRIMARY KEY  (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_course`
--

LOCK TABLES `teacher_course` WRITE;
/*!40000 ALTER TABLE `teacher_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_sharedata`
--

DROP TABLE IF EXISTS `teacher_sharedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_sharedata` (
  `T_ID` int(32) NOT NULL,
  `Share_ID` int(32) NOT NULL,
  PRIMARY KEY  (`T_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_sharedata`
--

LOCK TABLES `teacher_sharedata` WRITE;
/*!40000 ALTER TABLE `teacher_sharedata` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_sharedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_topic`
--

DROP TABLE IF EXISTS `teacher_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_topic` (
  `T_ID` int(32) NOT NULL,
  `Topic_ID` int(32) NOT NULL,
  PRIMARY KEY  (`T_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_topic`
--

LOCK TABLES `teacher_topic` WRITE;
/*!40000 ALTER TABLE `teacher_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `Topic_ID` int(11) NOT NULL,
  `Topic_Name` varchar(255) NOT NULL,
  `Topic_Keyword` varchar(255) NOT NULL,
  PRIMARY KEY  (`Topic_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-12 17:07:53

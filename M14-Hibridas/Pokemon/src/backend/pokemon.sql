SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `pokemon`
--
DROP DATABASE IF EXISTS pokemon;
CREATE DATABASE IF NOT EXISTS pokemon;
drop user if exists 'roger'@'localhost';
create user 'roger'@'localhost' identified by 'roger';
GRANT ALL PRIVILEGES ON *.* TO 'roger'@'localhost';
use pokemon;

-- --------------------------------------------------------

--
-- Table structure for table `POKEMON`
--
DROP TABLE IF EXISTS POKEMON;

CREATE TABLE `POKEMON` (
  `ID` int NOT NULL,
  `NAME` varchar(25) NOT NULL,
  `TYPES` JSON NOT NULL,
  `HEIGHT` float NOT NULL,
  `WEIGHT` float NOT NULL,
  `IMAGE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

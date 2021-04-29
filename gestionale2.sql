-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.22 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database gestionale
CREATE DATABASE IF NOT EXISTS `gestionale` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestionale`;

-- Dump della struttura di tabella gestionale.dipendenti
CREATE TABLE IF NOT EXISTS `dipendenti` (
  `ID_dip` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cognome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `numero` int NOT NULL DEFAULT '0',
  `ruolo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stipendio` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_dip`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella gestionale.fornitori
CREATE TABLE IF NOT EXISTS `fornitori` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p_iva` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sede` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella gestionale.movimenti
CREATE TABLE IF NOT EXISTS `movimenti` (
  `ID_mov` int NOT NULL AUTO_INCREMENT,
  `id_prod` int NOT NULL,
  `id_forn` int NOT NULL,
  `data` date NOT NULL,
  `quantita` int NOT NULL,
  `prezzo` float NOT NULL,
  `totale` float NOT NULL,
  PRIMARY KEY (`ID_mov`) USING BTREE,
  KEY `FK1_mov_forn` (`id_forn`) USING BTREE,
  KEY `FK2_mov_prod` (`id_prod`) USING BTREE,
  CONSTRAINT `FK1_mov_forn` FOREIGN KEY (`id_forn`) REFERENCES `fornitori` (`ID`),
  CONSTRAINT `FK2_mov_prod` FOREIGN KEY (`id_prod`) REFERENCES `prodotti` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella gestionale.ordini
CREATE TABLE IF NOT EXISTS `ordini` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella gestionale.ord_prod
CREATE TABLE IF NOT EXISTS `ord_prod` (
  `ID_ORD` int NOT NULL DEFAULT '0',
  `ID_PROD` int NOT NULL DEFAULT '0',
  `quantita` int NOT NULL DEFAULT '0',
  KEY `FK_ord_prod_ordini` (`ID_ORD`) USING BTREE,
  KEY `FK_ord_prod_prodotti` (`ID_PROD`) USING BTREE,
  CONSTRAINT `FK_ord_prod_ordini` FOREIGN KEY (`ID_ORD`) REFERENCES `ordini` (`ID`),
  CONSTRAINT `FK_ord_prod_prodotti` FOREIGN KEY (`ID_PROD`) REFERENCES `prodotti` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella gestionale.prodotti
CREATE TABLE IF NOT EXISTS `prodotti` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descrizione` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `giacenza` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- L’esportazione dei dati non era selezionata.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

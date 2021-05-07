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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.dipendenti: ~2 rows (circa)
/*!40000 ALTER TABLE `dipendenti` DISABLE KEYS */;
INSERT INTO `dipendenti` (`ID_dip`, `nome`, `cognome`, `numero`, `ruolo`, `stipendio`) VALUES
	(1, 'giovanni', 'cozza', 0, 'commesso', 0),
	(2, 'TestNome', 'testCognome', 1, 'commesso', 0);
/*!40000 ALTER TABLE `dipendenti` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.fornitori
CREATE TABLE IF NOT EXISTS `fornitori` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p_iva` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sede` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.fornitori: ~2 rows (circa)
/*!40000 ALTER TABLE `fornitori` DISABLE KEYS */;
INSERT INTO `fornitori` (`ID`, `nome`, `p_iva`, `sede`) VALUES
	(1, 'testdb', 'testpiva', 'testsede'),
	(2, 'testdb2', 'testpiva2', 'testsede2');
/*!40000 ALTER TABLE `fornitori` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.movimenti: ~1 rows (circa)
/*!40000 ALTER TABLE `movimenti` DISABLE KEYS */;
INSERT INTO `movimenti` (`ID_mov`, `id_prod`, `id_forn`, `data`, `quantita`, `prezzo`, `totale`) VALUES
	(1, 1, 1, '2021-05-05', 20, 5, 100);
/*!40000 ALTER TABLE `movimenti` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.ordini
CREATE TABLE IF NOT EXISTS `ordini` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.ordini: ~0 rows (circa)
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.ord_prod
CREATE TABLE IF NOT EXISTS `ord_prod` (
  `ID_ORD` int NOT NULL DEFAULT '0',
  `ID_PROD` int NOT NULL DEFAULT '0',
  `quantita` int NOT NULL DEFAULT '0',
  `ID_Ord_Prod` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_Ord_Prod`),
  KEY `FK_ord_prod_ordini` (`ID_ORD`) USING BTREE,
  KEY `FK_ord_prod_prodotti` (`ID_PROD`) USING BTREE,
  CONSTRAINT `FK_ord_prod_ordini` FOREIGN KEY (`ID_ORD`) REFERENCES `ordini` (`ID`),
  CONSTRAINT `FK_ord_prod_prodotti` FOREIGN KEY (`ID_PROD`) REFERENCES `prodotti` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.ord_prod: ~0 rows (circa)
/*!40000 ALTER TABLE `ord_prod` DISABLE KEYS */;
/*!40000 ALTER TABLE `ord_prod` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.prodotti
CREATE TABLE IF NOT EXISTS `prodotti` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descrizione` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `giacenza` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.prodotti: ~1 rows (circa)
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` (`ID`, `nome`, `descrizione`, `giacenza`) VALUES
	(1, 'giacca', 'giacca bella', 10);
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

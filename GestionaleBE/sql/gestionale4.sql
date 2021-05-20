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
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cognome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `numero` int NOT NULL DEFAULT '0',
  `ruolo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stipendio` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.dipendenti: ~2 rows (circa)
/*!40000 ALTER TABLE `dipendenti` DISABLE KEYS */;
INSERT INTO `dipendenti` (`id`, `nome`, `cognome`, `numero`, `ruolo`, `stipendio`) VALUES
	(1, 'giovanni', 'cozza', 0, 'commesso', 0),
	(2, 'TestNome', 'testCognome', 1, 'commesso', 0);
/*!40000 ALTER TABLE `dipendenti` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.fornitori
CREATE TABLE IF NOT EXISTS `fornitori` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `p_iva` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sede` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.fornitori: ~3 rows (circa)
/*!40000 ALTER TABLE `fornitori` DISABLE KEYS */;
INSERT INTO `fornitori` (`id`, `nome`, `p_iva`, `sede`) VALUES
	(1, 'testdb', 'testpiva', 'testsede'),
	(2, 'testdb2', 'testpiva2', 'testsede2'),
	(3, 'nome', 'it2345678', 'milano');
/*!40000 ALTER TABLE `fornitori` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.movdetails
CREATE TABLE IF NOT EXISTS `movdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_prod` int NOT NULL,
  `id_mov` int NOT NULL,
  `quantity` int NOT NULL,
  `prezzo` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_prod` (`id_prod`),
  KEY `id_mov` (`id_mov`),
  CONSTRAINT `FK_movdetails_movimenti` FOREIGN KEY (`id_mov`) REFERENCES `movimenti` (`id`),
  CONSTRAINT `FK_movdetails_prodotti` FOREIGN KEY (`id_prod`) REFERENCES `prodotti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.movdetails: ~5 rows (circa)
/*!40000 ALTER TABLE `movdetails` DISABLE KEYS */;
INSERT INTO `movdetails` (`id`, `id_prod`, `id_mov`, `quantity`, `prezzo`) VALUES
	(1, 1, 13, 10, 1),
	(2, 2, 14, 4, 2),
	(3, 3, 15, 1, 4),
	(4, 4, 14, 7, 5),
	(5, 3, 17, 6, 2);
/*!40000 ALTER TABLE `movdetails` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.movimenti
CREATE TABLE IF NOT EXISTS `movimenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_forn` int NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK1_mov_forn` (`id_forn`) USING BTREE,
  CONSTRAINT `FK1_mov_forn` FOREIGN KEY (`id_forn`) REFERENCES `fornitori` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.movimenti: ~4 rows (circa)
/*!40000 ALTER TABLE `movimenti` DISABLE KEYS */;
INSERT INTO `movimenti` (`id`, `id_forn`, `data`) VALUES
	(13, 1, '2021-06-19'),
	(14, 3, '2021-06-19'),
	(15, 2, '2021-06-19'),
	(17, 2, '2021-05-20');
/*!40000 ALTER TABLE `movimenti` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.ordini
CREATE TABLE IF NOT EXISTS `ordini` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.ordini: ~1 rows (circa)
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
INSERT INTO `ordini` (`id`, `data`) VALUES
	(1, '2021-05-09');
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.ord_prod
CREATE TABLE IF NOT EXISTS `ord_prod` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Id_ord` int NOT NULL DEFAULT '0',
  `Id_prod` int NOT NULL DEFAULT '0',
  `quantity` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_ord_prod_ordini` (`Id_ord`) USING BTREE,
  KEY `FK_ord_prod_prodotti` (`Id_prod`) USING BTREE,
  CONSTRAINT `FK_ord_prod_ordini` FOREIGN KEY (`Id_ord`) REFERENCES `ordini` (`id`),
  CONSTRAINT `FK_ord_prod_prodotti` FOREIGN KEY (`Id_prod`) REFERENCES `prodotti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.ord_prod: ~2 rows (circa)
/*!40000 ALTER TABLE `ord_prod` DISABLE KEYS */;
INSERT INTO `ord_prod` (`id`, `Id_ord`, `Id_prod`, `quantity`) VALUES
	(1, 1, 1, 1),
	(2, 1, 2, 1);
/*!40000 ALTER TABLE `ord_prod` ENABLE KEYS */;

-- Dump della struttura di tabella gestionale.prodotti
CREATE TABLE IF NOT EXISTS `prodotti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descrizione` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `giacenza` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella gestionale.prodotti: ~4 rows (circa)
/*!40000 ALTER TABLE `prodotti` DISABLE KEYS */;
INSERT INTO `prodotti` (`id`, `nome`, `descrizione`, `giacenza`) VALUES
	(1, 'giacca', 'giacca bella', 10),
	(2, 'giacca 2', 'giacca bella 2', 15),
	(3, 'scarpe', 'scarpe belle', 2),
	(4, 'cappello', 'cappello', 11);
/*!40000 ALTER TABLE `prodotti` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

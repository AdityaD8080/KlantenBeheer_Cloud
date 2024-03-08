CREATE TABLE `klant` (
                         `klantID` int NOT NULL AUTO_INCREMENT,
                         `Achternaam` varchar(50) NOT NULL,
                         `Adres` varchar(255) DEFAULT NULL,
                         `Email` varchar(100) NOT NULL,
                         `Gebruikersnaam` varchar(50) NOT NULL,
                         `Voornaam` varchar(50) NOT NULL,
                         PRIMARY KEY (`klantID`),
                         UNIQUE KEY `UK_mbs75ubqbhprxja4wva4m842w` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `producten` (
                             `productID` int NOT NULL AUTO_INCREMENT,
                             `Merk` varchar(50) DEFAULT NULL,
                             `Omschrijving` text,
                             `Prijs` decimal(12,2) NOT NULL,
                             `ProductNaam` varchar(255) NOT NULL,
                             `VoorraadAantal` int NOT NULL,
                             PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bestellingitems` (
                                   `bestellingItemID` int NOT NULL AUTO_INCREMENT,
                                   `Hoeveelheid` int NOT NULL,
                                   `PrijsPerStuk` decimal(12,2) NOT NULL,
                                   `TotaalPrijs` decimal(12,2) NOT NULL,
                                   `BestellingID` int NOT NULL,
                                   `ProductID` int NOT NULL,
                                   PRIMARY KEY (`bestellingItemID`),
                                   KEY `FKj7nvi4kde9it18brxq13rl1wx` (`BestellingID`),
                                   KEY `FKu780ba5ysbo1jaeunb3wvxen` (`ProductID`),
                                   CONSTRAINT `FKj7nvi4kde9it18brxq13rl1wx` FOREIGN KEY (`BestellingID`) REFERENCES `bestellingen` (`bestellingID`),
                                   CONSTRAINT `FKu780ba5ysbo1jaeunb3wvxen` FOREIGN KEY (`ProductID`) REFERENCES `producten` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bestellingen` (
                                `bestellingID` int NOT NULL AUTO_INCREMENT,
                                `BestelDatum` varchar(255) NOT NULL,
                                `BetaalStatus` varchar(50) DEFAULT 'In Afwachting',
                                `TotaalBedrag` decimal(12,2) NOT NULL,
                                `Verzendadres` varchar(255) NOT NULL,
                                `KlantID` int NOT NULL,
                                PRIMARY KEY (`bestellingID`),
                                KEY `FKfrls64lykbemtv1hwhweqtisk` (`KlantID`),
                                CONSTRAINT `FKfrls64lykbemtv1hwhweqtisk` FOREIGN KEY (`KlantID`) REFERENCES `klant` (`klantID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
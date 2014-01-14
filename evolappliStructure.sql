-- phpMyAdmin SQL Dump
-- version 2.11.0
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 07 Janvier 2014 à 17:06
-- Version du serveur: 4.1.22
-- Version de PHP: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `evolappli`
--

-- --------------------------------------------------------

--
-- Structure de la table `application`
--

CREATE TABLE IF NOT EXISTS `application` (
  `idApplication` int(11) NOT NULL auto_increment,
  `nomApplication` varchar(50) character set utf8 NOT NULL default '',
  `visibiliteApplication` varchar(8) character set utf8 NOT NULL default '0',
  PRIMARY KEY  (`idApplication`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `application`
--

INSERT INTO `application` (`idApplication`, `nomApplication`, `visibiliteApplication`) VALUES
(1, 'Ulis CS', 'Archivée'),
(2, 'Ulis Web', ''),
(3, 'Kristina', ''),
(4, 'Ulis Thot', ''),
(5, 'fute', 'Archivée'),
(6, 'e-rh', ''),
(7, 'Ulis VM', 'Archivée');

-- --------------------------------------------------------

--
-- Structure de la table `cellule`
--

CREATE TABLE IF NOT EXISTS `cellule` (
  `idCellule` int(11) NOT NULL auto_increment,
  `nomCellule` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idCellule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `cellule`
--

INSERT INTO `cellule` (`idCellule`, `nomCellule`) VALUES
(1, 'Maladies'),
(2, 'Congés'),
(3, 'SPMT');

-- --------------------------------------------------------

--
-- Structure de la table `compocellule`
--

CREATE TABLE IF NOT EXISTS `compocellule` (
  `idCellule` int(11) NOT NULL default '0',
  `idUtilisateur` int(11) NOT NULL default '0',
  `dateDebutCellule` date NOT NULL default '0000-00-00',
  `dateFinCellule` date default NULL,
  PRIMARY KEY  (`idCellule`,`idUtilisateur`),
  KEY `idUtilisateur` (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compocellule`
--

INSERT INTO `compocellule` (`idCellule`, `idUtilisateur`, `dateDebutCellule`, `dateFinCellule`) VALUES
(1, 1, '2013-12-18', NULL),
(2, 1, '2014-01-07', NULL),
(2, 2, '2014-01-30', NULL),
(3, 1, '2014-01-07', NULL),
(3, 5, '2014-01-21', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `compoprofil`
--

CREATE TABLE IF NOT EXISTS `compoprofil` (
  `idProfil` int(11) NOT NULL default '0',
  `idUtilisateur` int(11) NOT NULL default '0',
  `dateDebutCompoProf` date NOT NULL default '0000-00-00',
  `dateFinCompoProf` date default NULL,
  PRIMARY KEY  (`idProfil`,`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compoprofil`
--


-- --------------------------------------------------------

--
-- Structure de la table `criteresucces`
--

CREATE TABLE IF NOT EXISTS `criteresucces` (
  `idCritere` int(11) NOT NULL auto_increment,
  `nomCritere` varchar(50) NOT NULL default '',
  `dateDebutCritere` date NOT NULL default '0000-00-00',
  `dateFinCritere` date NOT NULL default '0000-00-00',
  `numCritere` varchar(5) NOT NULL default '',
  `fkPriorite` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idCritere`),
  KEY `fkPriorite` (`fkPriorite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `criteresucces`
--


-- --------------------------------------------------------

--
-- Structure de la table `demandeur`
--

CREATE TABLE IF NOT EXISTS `demandeur` (
  `idPoint` int(11) NOT NULL default '0',
  `idUtilisateur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idUtilisateur`),
  KEY `idPoint` (`idPoint`),
  KEY `demandeur` (`idPoint`,`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `demandeur`
--


-- --------------------------------------------------------

--
-- Structure de la table `direction`
--

CREATE TABLE IF NOT EXISTS `direction` (
  `idDirection` int(11) NOT NULL auto_increment,
  `nomDirection` varchar(50) NOT NULL default '',
  `idDG` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idDirection`),
  KEY `idDG` (`idDG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `direction`
--

INSERT INTO `direction` (`idDirection`, `nomDirection`, `idDG`) VALUES
(1, 'Administration du Personnel', 1),
(2, 'Gestion Pécuniaire', 2),
(3, 'Fonctionnelle et Appui du SG', 1);

-- --------------------------------------------------------

--
-- Structure de la table `directiongeneral`
--

CREATE TABLE IF NOT EXISTS `directiongeneral` (
  `idDG` int(11) NOT NULL auto_increment,
  `nomDG` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idDG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `directiongeneral`
--

INSERT INTO `directiongeneral` (`idDG`, `nomDG`) VALUES
(1, 'Secrétariat général'),
(2, 'DGO1'),
(3, 'DGO2');

-- --------------------------------------------------------

--
-- Structure de la table `exigencefonctionnelle`
--

CREATE TABLE IF NOT EXISTS `exigencefonctionnelle` (
  `idExigence` int(11) NOT NULL auto_increment,
  `nomExigence` varchar(50) NOT NULL default '',
  `descriptioExigence` longtext NOT NULL,
  `raisonExigence` longtext NOT NULL,
  `dateDebutExi` date NOT NULL default '0000-00-00',
  `dateFinExi` date default NULL,
  `numExi` varchar(5) NOT NULL default '',
  `fkSFonct` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idExigence`),
  KEY `fkSFonct` (`fkSFonct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `exigencefonctionnelle`
--


-- --------------------------------------------------------

--
-- Structure de la table `fichier`
--

CREATE TABLE IF NOT EXISTS `fichier` (
  `idFichier` int(11) NOT NULL auto_increment,
  `nomFichier` varchar(50) NOT NULL default '',
  `cheminFichier` text NOT NULL,
  PRIMARY KEY  (`idFichier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fichier`
--


-- --------------------------------------------------------

--
-- Structure de la table `fonctionnalite`
--

CREATE TABLE IF NOT EXISTS `fonctionnalite` (
  `idFonctionnalité` int(11) NOT NULL auto_increment,
  `nom` varchar(50) character set latin1 NOT NULL default '',
  `description` longtext character set latin1 NOT NULL,
  `dabutDebutFonct` date NOT NULL default '0000-00-00',
  `dateFinFonct` date default NULL,
  `numFonct` varchar(5) character set latin1 NOT NULL default '',
  `fkAppli` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idFonctionnalité`),
  KEY `fkAppli` (`fkAppli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `fonctionnalite`
--


-- --------------------------------------------------------

--
-- Structure de la table `lot`
--

CREATE TABLE IF NOT EXISTS `lot` (
  `idLot` int(11) NOT NULL auto_increment,
  `nomLot` varchar(50) character set utf8 NOT NULL default '',
  `dateDebutLot` date NOT NULL default '0000-00-00',
  `dureeLot` int(2) NOT NULL default '0',
  `dureeAd1` int(1) default NULL,
  `dureeAd2` int(11) default NULL,
  `fkMarche` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idLot`),
  UNIQUE KEY `fkMarche` (`fkMarche`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `lot`
--


-- --------------------------------------------------------

--
-- Structure de la table `marche`
--

CREATE TABLE IF NOT EXISTS `marche` (
  `idMarche` int(11) NOT NULL auto_increment,
  `nomMarche` varchar(50) character set utf8 NOT NULL default '',
  PRIMARY KEY  (`idMarche`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `marche`
--

INSERT INTO `marche` (`idMarche`, `nomMarche`) VALUES
(1, 'Gestion administrative et pécuniaire');

-- --------------------------------------------------------

--
-- Structure de la table `msieajour`
--

CREATE TABLE IF NOT EXISTS `msieajour` (
  `idMiseAJour` int(11) NOT NULL auto_increment,
  `dateProposition` date NOT NULL default '0000-00-00',
  `dateValidation` date default NULL,
  `numCallBmc` varchar(20) default NULL,
  `dateMiseProd` date default NULL,
  PRIMARY KEY  (`idMiseAJour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `msieajour`
--


-- --------------------------------------------------------

--
-- Structure de la table `origineexigence`
--

CREATE TABLE IF NOT EXISTS `origineexigence` (
  `fkExigence` int(11) NOT NULL default '0',
  `fkUtilisateur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`fkExigence`,`fkUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `origineexigence`
--


-- --------------------------------------------------------

--
-- Structure de la table `pointmaj`
--

CREATE TABLE IF NOT EXISTS `pointmaj` (
  `idPoint` int(11) NOT NULL auto_increment,
  `nom` varchar(50) NOT NULL default '',
  `descriptionPoint` longtext NOT NULL,
  `solutionPoint` longtext,
  `fkOrigine` int(11) NOT NULL default '0',
  `fkTest` int(11) default NULL,
  `fkRisque` int(11) default NULL,
  PRIMARY KEY  (`idPoint`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `pointmaj`
--


-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE IF NOT EXISTS `poste` (
  `idPoste` int(11) NOT NULL auto_increment,
  `nomPoste` varchar(50) NOT NULL default '',
  `descriptionPoste` longtext NOT NULL,
  `optionnelPoste` tinyint(1) NOT NULL default '0',
  `activationPoste` tinyint(1) NOT NULL default '0',
  `dateActivation` date default NULL,
  `idLot` int(11) NOT NULL default '0',
  `idApplication` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idPoste`),
  KEY `idLot` (`idLot`),
  KEY `idApplication` (`idApplication`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `poste`
--


-- --------------------------------------------------------

--
-- Structure de la table `priorite`
--

CREATE TABLE IF NOT EXISTS `priorite` (
  `idPriorite` int(11) NOT NULL auto_increment,
  `nomPriorite` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idPriorite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `priorite`
--


-- --------------------------------------------------------

--
-- Structure de la table `probabiliterisque`
--

CREATE TABLE IF NOT EXISTS `probabiliterisque` (
  `idProbabilite` int(11) NOT NULL auto_increment,
  `probabilite` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idProbabilite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `probabiliterisque`
--


-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE IF NOT EXISTS `profil` (
  `idProfil` int(11) NOT NULL auto_increment,
  `nomProfil` varchar(50) NOT NULL default '',
  `dateDebutProfil` date NOT NULL default '0000-00-00',
  `dateFinProfil` date default NULL,
  PRIMARY KEY  (`idProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `profil`
--


-- --------------------------------------------------------

--
-- Structure de la table `raison`
--

CREATE TABLE IF NOT EXISTS `raison` (
  `idRaison` int(11) NOT NULL auto_increment,
  `resume` varchar(50) NOT NULL default '',
  `description` longtext NOT NULL,
  `dateDebutRaison` date NOT NULL default '0000-00-00',
  `dateFinRaison` date NOT NULL default '0000-00-00',
  `numRaison` varchar(5) NOT NULL default '',
  `fkExigence` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idRaison`),
  KEY `fkExigence` (`fkExigence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `raison`
--


-- --------------------------------------------------------

--
-- Structure de la table `risque`
--

CREATE TABLE IF NOT EXISTS `risque` (
  `idRisque` int(11) NOT NULL auto_increment,
  `nomRisque` varchar(50) NOT NULL default '',
  `descriptionRisque` longtext NOT NULL,
  `fkType` int(11) NOT NULL default '0',
  `fkProbabilite` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idRisque`),
  KEY `fkType` (`fkType`),
  KEY `fkProbabilite` (`fkProbabilite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `risque`
--


-- --------------------------------------------------------

--
-- Structure de la table `sousfonctionnalite`
--

CREATE TABLE IF NOT EXISTS `sousfonctionnalite` (
  `idSousFonct` int(11) NOT NULL auto_increment,
  `nomSFonct` varchar(50) character set utf8 NOT NULL default '',
  `descriptionSFonct` longtext character set utf8 NOT NULL,
  `raisonSFoncti` longtext character set utf8 NOT NULL,
  `dateDebutSFonct` date NOT NULL default '0000-00-00',
  `dateFinSFonct` date default NULL,
  `numSFonct` varchar(5) NOT NULL default '',
  `fkFonct` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idSousFonct`),
  KEY `fkFonct` (`fkFonct`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `sousfonctionnalite`
--


-- --------------------------------------------------------

--
-- Structure de la table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `idTest` int(11) NOT NULL auto_increment,
  `descriptionTest` longtext NOT NULL,
  `dateTest` date NOT NULL default '0000-00-00',
  `fkResulTest` int(11) NOT NULL default '0',
  `fkFichier` int(11) default NULL,
  `fkTesteur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idTest`),
  KEY `fkResulTest` (`fkResulTest`),
  KEY `fkFichier` (`fkFichier`),
  KEY `fkTesteur` (`fkTesteur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `test`
--


-- --------------------------------------------------------

--
-- Structure de la table `typeresultat`
--

CREATE TABLE IF NOT EXISTS `typeresultat` (
  `idTypeResultat` int(11) NOT NULL auto_increment,
  `resultat` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idTypeResultat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typeresultat`
--


-- --------------------------------------------------------

--
-- Structure de la table `typerisque`
--

CREATE TABLE IF NOT EXISTS `typerisque` (
  `idType` int(11) NOT NULL auto_increment,
  `nomType` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `typerisque`
--


-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL auto_increment,
  `nomUtilisateur` varchar(50) NOT NULL default '',
  `prenomUtilisateur` varchar(50) NOT NULL default '',
  `numUlis` varchar(6) NOT NULL default '',
  `mailUtilisateur` varchar(60) NOT NULL default '',
  `utilisateurActif` varchar(8) NOT NULL default '',
  `directionUtilisateur` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idUtilisateur`),
  KEY `directionUtilisateur` (`directionUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nomUtilisateur`, `prenomUtilisateur`, `numUlis`, `mailUtilisateur`, `utilisateurActif`, `directionUtilisateur`) VALUES
(1, 'Dauphin', 'Rudi', '103223', 'rudi.dauphin@spw.wallonie.be', 'Inactif', 1),
(2, 'Deceuleneer', 'Cédric', '34744', 'cedric.deceuleneer@spw.wallonie.be', 'Inactif', 1),
(3, 'Yans', 'Elodie', '38183', 'elodie.yans@spw.wallonie.be', '', 1),
(4, 'Stassin', 'Nathalie', '124950', 'nathalie.stassin@spw.wallonie.be', '', 2),
(5, 'Dussart', 'Isabelle', '103257', 'isabelle.dussart@spw.wallonie.be', '', 3),
(6, 'Jaupart', 'Alexandra', '37183', 'alexandra.jaupart@spw.wallonie.be', '', 3),
(7, 'Hamès', 'Anne-Marie', '102583', 'annemarie.hames@spw.wallonie.be', 'Inactif', 3),
(8, 'Hérion', 'Christelle', '2542', 'christelle.herion@spw.wallonie.be', '', 1),
(9, 'Maeck', 'Isabelle', '123465', 'isabelle.maeck@spw.wallonie.be', '', 3),
(10, 'Anzalone', 'Sandra', '123456', 'sandra.anzalone@spw.wallonie.be', '', 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compocellule`
--
ALTER TABLE `compocellule`
  ADD CONSTRAINT `compocellule_ibfk_4` FOREIGN KEY (`idCellule`) REFERENCES `cellule` (`idCellule`),
  ADD CONSTRAINT `compocellule_ibfk_5` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

--
-- Contraintes pour la table `criteresucces`
--
ALTER TABLE `criteresucces`
  ADD CONSTRAINT `criteresucces_ibfk_1` FOREIGN KEY (`fkPriorite`) REFERENCES `criteresucces` (`fkPriorite`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `direction`
--
ALTER TABLE `direction`
  ADD CONSTRAINT `direction_ibfk_1` FOREIGN KEY (`idDG`) REFERENCES `directiongeneral` (`idDG`);

--
-- Contraintes pour la table `exigencefonctionnelle`
--
ALTER TABLE `exigencefonctionnelle`
  ADD CONSTRAINT `exigencefonctionnelle_ibfk_1` FOREIGN KEY (`fkSFonct`) REFERENCES `sousfonctionnalite` (`idSousFonct`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `fonctionnalite`
--
ALTER TABLE `fonctionnalite`
  ADD CONSTRAINT `fonctionnalite_ibfk_1` FOREIGN KEY (`fkAppli`) REFERENCES `application` (`idApplication`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `lot`
--
ALTER TABLE `lot`
  ADD CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`fkMarche`) REFERENCES `marche` (`idMarche`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `poste`
--
ALTER TABLE `poste`
  ADD CONSTRAINT `poste_ibfk_1` FOREIGN KEY (`idLot`) REFERENCES `lot` (`idLot`),
  ADD CONSTRAINT `poste_ibfk_2` FOREIGN KEY (`idApplication`) REFERENCES `application` (`idApplication`);

--
-- Contraintes pour la table `raison`
--
ALTER TABLE `raison`
  ADD CONSTRAINT `raison_ibfk_1` FOREIGN KEY (`fkExigence`) REFERENCES `exigencefonctionnelle` (`idExigence`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `risque`
--
ALTER TABLE `risque`
  ADD CONSTRAINT `risque_ibfk_1` FOREIGN KEY (`fkType`) REFERENCES `typerisque` (`idType`) ON UPDATE CASCADE,
  ADD CONSTRAINT `risque_ibfk_2` FOREIGN KEY (`fkProbabilite`) REFERENCES `probabiliterisque` (`idProbabilite`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `sousfonctionnalite`
--
ALTER TABLE `sousfonctionnalite`
  ADD CONSTRAINT `sousfonctionnalite_ibfk_1` FOREIGN KEY (`fkFonct`) REFERENCES `fonctionnalite` (`idFonctionnalité`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `test_ibfk_3` FOREIGN KEY (`fkResulTest`) REFERENCES `typeresultat` (`idTypeResultat`) ON UPDATE CASCADE,
  ADD CONSTRAINT `test_ibfk_4` FOREIGN KEY (`fkFichier`) REFERENCES `fichier` (`idFichier`) ON UPDATE CASCADE,
  ADD CONSTRAINT `test_ibfk_5` FOREIGN KEY (`fkTesteur`) REFERENCES `utilisateur` (`idUtilisateur`) ON UPDATE CASCADE;

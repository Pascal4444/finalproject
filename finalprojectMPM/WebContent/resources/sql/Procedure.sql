Use projet_final_db

-- Procedure Selection par identifiant (sel<table>)

DELIMITER $$
DROP Procedure IF EXISTS seladresse $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `seladresse`(a1 int(11))
BEGIN
	SELECT * FROM projet_final_db.adresse where id = a1;  
END$$

-- DELIMITER $$	-- execution indépendant

DROP Procedure IF EXISTS selarticle $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selarticle`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.article where id = a1;  
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selcarte_paiement $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selcarte_paiement`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.carte_paiement where id = a1;   
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selcategorie $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selcategorie`(a1 int(11))
BEGIN
	SELECT * FROM projet_final_db.categorie where id = a1;
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selcommande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selcommande`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.commande where id = a1;  
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selcommentaire $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selcommentaire`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.commentaire where id = a1;   
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selligne_de_commande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selligne_de_commande`(a1 int(11))
BEGIN
	SELECT * FROM projet_final_db.ligne_de_commande where id = a1;
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selparams $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selparams`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.params where id = a1;  
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selutilisateur $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selutilisateur`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.utilisateur where id = a1;   
END$$

DELIMITER ;


-- ------------------------------------------------------------------------
-- ------------------------------------------------------------------------
-- Procedure selection complet table (selall<table>)

DELIMITER $$
DROP Procedure IF EXISTS selalladresse $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selalladresse`()
BEGIN
	SELECT * FROM projet_final_db.adresse;
END$$

-- DELIMITER $$	-- execution indépendant

DROP Procedure IF EXISTS selallarticle $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallarticle`()
BEGIN
     SELECT * FROM projet_final_db.article;  
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selallcarte_paiement $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallcarte_paiement`()
BEGIN
     SELECT * FROM projet_final_db.carte_paiement;   
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selallcategorie $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallcategorie`()
BEGIN
	SELECT * FROM projet_final_db.categorie;
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selallcommande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallcommande`()
BEGIN
     SELECT * FROM projet_final_db.commande;  
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selallcommentaire $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallcommentaire`()
BEGIN
     SELECT * FROM projet_final_db.commentaire;   
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selallligne_de_commande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallligne_de_commande`()
BEGIN
	SELECT * FROM projet_final_db.ligne_de_commande;
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selallparams $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallparams`()
BEGIN
     SELECT * FROM projet_final_db.params;  
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS selallutilisateur $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selallutilisateur`()
BEGIN
     SELECT * FROM projet_final_db.utilisateur;   
END$$

DELIMITER ;

-- ------------------------------------------------------------------------
-- ------------------------------------------------------------------------
-- Procedure Selection par clé étrangère (<table>as<clé etrangère table>)

-- Adresse 1/1
DELIMITER $$
DROP Procedure IF EXISTS adresseasutilisateur $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `adresseasutilisateur`(a1 int(11))
BEGIN
	SELECT * FROM utilisateur where id = a1;
END$$

-- Article 3/3
-- DELIMITER $$	-- execution indépendant

DROP Procedure IF EXISTS articleasligne_de_commande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `articleasligne_de_commande`(a1 int(11))
BEGIN
     SELECT * FROM ligne_de_commande where id = a1; 
END$$

-- DELIMITER $$	-- execution indépendant

DROP Procedure IF EXISTS articleascategorie $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `articleascategorie`(a1 int(11))
BEGIN
     SELECT * FROM categorie where id = a1; 
END$$

-- DELIMITER $$	-- execution indépendant

DROP Procedure IF EXISTS articleascommentaire $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `articleascommentaire`(a1 int(11))
BEGIN
     SELECT * 
     FROM commentaire 
     where article = a1; 
END$$

-- Carte_Paiement 1/1
-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS carte_paiementasutilisateur $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `carte_paiementasutilisateur`(a1 int(11))
BEGIN
     SELECT * FROM utilisateur where id = a1;  
END$$

-- Categorie 1/1
-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS categorieasarticle $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `categorieasarticle`(a1 int(11))
BEGIN
	SELECT * 
	FROM article
    where categorie = a1; 
END$$

-- Commande 2/2
-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS commandeasutilisateur $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `commandeasutilisateur`(a1 int(11))
BEGIN
     SELECT * FROM utilisateur where id = a1; 
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS commandeasligne_de_commande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `commandeasligne_de_commande`(a1 int(11))
BEGIN
	SELECT * 
	FROM ligne_de_commande
    where commande = a1;  
END$$

-- Commentaire 2/2
-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS commentaireasutilisateur $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `commentaireasutilisateur`(a1 int(11))
BEGIN
	SELECT * FROM utilisateur where id = a1; 
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS commentaireasarticle $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `commentaireasarticle`(a1 int(11))
BEGIN
	SELECT * FROM article where id = a1;  
END$$

-- Ligne_de_commande 2/2
-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS ligne_de_commandeascommande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `ligne_de_commandeascommande`(a1 int(11))
BEGIN
	SELECT * FROM commande where id = a1;  
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS ligne_de_commandeasarticle $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `ligne_de_commandeasarticle`(a1 int(11))
BEGIN
	SELECT * FROM article where id = a1;  
END$$

-- Utilisateur 5/5
-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS utilisateurascommentaire $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `utilisateurascommentaire`(a1 int(11))
BEGIN
    SELECT * 
	FROM commentaire
    where utilisateur = a1;     
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS utilisateurascarte_paiement $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `utilisateurascarte_paiement`(a1 int(11))
BEGIN
	SELECT * 
	FROM carte_paiement
    where utilisateur = a1;   
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS utilisateurasadresse $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `utilisateurasadresse`(a1 int(11))
BEGIN
    SELECT * 
	FROM adresse
    where utilisateur = a1;    
END$$

-- DELIMITER $$	-- execute indépendant

DROP Procedure IF EXISTS utilisateurascommande $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `utilisateurascommande`(a1 int(11))
BEGIN
	SELECT * 
	FROM commande
    where utilisateur = a1;
END$$

DELIMITER ;

-- ------------------------------------------------------------------------
-- ------------------------------------------------------------------------
-- Procedure Selection Autre (c<table> ou c<table>_<element>)

DELIMITER $$

DROP Procedure IF EXISTS cutilisateur_email $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `cutilisateur_email`(s1 varchar(45))
BEGIN
     SELECT * FROM projet_final_db.utilisateur where email = s1;   
END$$

DELIMITER ;
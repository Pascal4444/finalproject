Use projet_final_db

-- Procedure Categorie Select

DELIMITER $$
DROP Procedure seladresse $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `seladresse`(a1 int(11))
BEGIN
	SELECT * FROM projet_final_db.adresse where id = a1;
END$$

DROP Procedure selarticle $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selarticle`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.adresse where id = a1;  
END$$

DROP Procedure selcategorie $$
CREATE DEFINER=`projetdb`@`localhost` PROCEDURE `selcategorie`(a1 int(11))
BEGIN
     SELECT * FROM projet_final_db.adresse where id = a1;   
END$$
DELIMITER ;
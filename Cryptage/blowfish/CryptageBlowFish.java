package fr.doranco.pf_cryptage.blowfish;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



public static void main(String[] args) {
	// TODO Auto-generated method stub

}

public class CryptageBlowFish {
	

private SecretKey secretKey;

/**
 * Retourne toutes les informations de la clE sous forme d'un tableau de bytes.
 * Elle peut ainsi être stockée puis reconstruire ultérieurement en utilisant 
 * la méthode setSecretKey(byte[] keyData)
 */
	public byte[] getSecretKeyBytes() {
		return SecretKey.getEncoded();
	}

/**
 * 	Permet de reconstruire la clé secrète à partir de ses données, stockées dans
 * un tableau de bytes.
 */
	public void setSecretKeyToBytes(byte[] keyData) {
		secretKey = new SecretKeySpec(keyData, "Blowfish");
		
	}

/**
* 	Permet de générer la clé à partir de l'algorithme BlowFish.
*/

	public  void genetateKey() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("BlowFish");
			KeyGen.init(KEY_SIZE);
			secretKey = keyGen.generateKey();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
		

}

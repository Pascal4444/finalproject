package fr.doranco.pf_cryptage.pbe;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.sql.Connection;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class CryptagePBE_Main {
	
	public static void main(String[] args) {
		
		String message = "Vive les cours Java";
		System.out.println("message à crypter = " + message);
	
		char[] password = {'t', 'h', 'e', ' ', 'p', 'a', 's', 's'};
		
		// Le salt est choisis aléatoirement et le nombre d'itérations par défaut vaut 10 
	    PBEKeySpec PBEKeySpec = new PBEKeySpec(password);
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[]messageInByte = message.getBytes();
		byte[]ciphertext = cipher.doFinal(messageInByte);
		System.out.println("Message crypté = " + new BigInteger(ciphertext));
		
		// On récupère les paramètres, comme le salt et le nombre d'itérations  
		AlgorithmParameters params = cipher.getParameters();		
		cipher.init(Cipher.DECRYPT_MODE, secretKey, params);
		byte[]messageDecrypteInByte = cipher.doFinal(ciphertext);	
		String messageDecrypte = new String(messageDecrypteInByte);
		System.out.println("Message décrypté = " + messageDecrypte);
		
	
  }

}
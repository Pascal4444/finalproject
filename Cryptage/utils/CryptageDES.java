package fr.doranco.pf_cryptage.utils;

import java.security.NoSuchAlgorithmException;

import javax.crypto.SecretKey;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public final class CryptageDES {

	private SecretKey key = null;
	
	public CryptageDES() {
	    KeyGenerator generator = null;
	    try {
	    	generator = KeyGenerator.getInstance("DES");
	    } catch (Exception e) {
	    	// TODO Auto.generated catch block
	    	e.printStackTrace();
	    }
	    generator.init(56);  // The DES ey size in number of bits
	    key = generator.generateKey();
	    System.out.println("Clef" + key);
	    
	}
	    
	
//   public SecretKey generateDESKey() throws Exception {
//      return key;
//   }
		
	public byte [] getEncryptedMessage(String message) throws Exception{
		System.out.println("début du chiffrement");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] messageBytes = message.getBytes("UTF8");
		byte[] messageCrypte = cipher.doFinal(messageBytes);
		return messageCrypte;
	}
		
	public String getDecryptedMessage(byte[] EncryptedMessage) throws Exception{
		System.out.println("début du chiffrement");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] messageBytes = EncryptedMessage.getBytes("UTF8");
		byte[] cipherBytes = cipher.doFinal(messageBytes);
		String messageDecrypte = new String(cipherBytes, "UTF8");
		return messageDecrypte;
	}	
		
		
	
}

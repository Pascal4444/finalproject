package fr.doranco.pf_cryptage.blowfish;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.sql.Connection;
import fr.doranco.cryptage.blowfish.CryptageBlowFish;


public class CryptageBlowFish_Main {
	
	public static void main(String[] args) {
		
		String message = "Ceci est texte d'exemple";
		System.out.println("message d'origine = " + message);
		CryptageBlowFish bf = new CryptageBlowfish();
		bf.generatKey();
		byte[]secretKey = bf.getSecretKeyInBytes();
		byte[]messageCrypte = bf.crypt(message);
		System.out.println("Message crypté = " + new BigInteger(messageCrypte));
				
		bf.SecretKeyToBytes(secretKey);
		String messageDecrypte = bf.decrypt(messageCrypte);
		System.out.println("Message décrypté = " + messageDecrypte);
		if (!messageDecrypte.equals(message))
			System.out.println("Error : Message crypté != Message décrypté");
			
		
		try {
			String message = "Transfer $200 to account 5314542.0";
			byte[] text = message.getBytes();
			System.out.println("\nGenerating a pair of DSA keys ...");
			KeyPairGenerator KeyPairGen = KeyPairGenerator.getInstance("DSA");
			KeyPairGen.initialize(KEY_SIZE, new SecureRandom());
			KeyPair kp = KeyPairGen.generateKeyPair();
			System.out.println("Signing the text...");
			Signature signature = Signature.getInstance("DSA");
			signature.initSign(kp.getPrivate());
			signature.update(text);
			byte[] sig = signature.sign();
			
			if (CHEAT_TEXT)
				text[0]++;
			if (CHEAT_SIGNATURE)
				sig[4]++; // changing sig [0] produces an exception
			
			System.out.println("\nVerifying the signature...");
			signature.initVerify(kp.getPublic());
			signature.update(text);
			boolean ok = signature.verify(sig);
			System.out.println("Signature is " + (ok ? "OK" : "NOT OK") + " !\n");
			
	 } catch (Exception e) {
		System.out.println(e);
	 }

  }

}
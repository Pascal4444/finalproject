package fr.doranco.pf_cryptage.dsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import fr.doranco.pf_cryptage.blowfish.SecureRandom;

public class CryptageDSA {

	public CryptageDSA() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		try {
			String message = "Transfer $2000 to account 5314542.0";
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
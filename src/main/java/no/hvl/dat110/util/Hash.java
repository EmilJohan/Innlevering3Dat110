package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;

		try {
			MessageDigest mD = MessageDigest.getInstance("MD5");
			byte[] hashbyte = mD.digest(entity.getBytes());
			String hashS = toHex(hashbyte);
			hashint = new BigInteger(hashS, 16);

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		int bits = bitSize();

		return BigInteger.valueOf(2).pow(bits);
	}
	
	public static int bitSize() {
		
		int digestlen = 16;
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}

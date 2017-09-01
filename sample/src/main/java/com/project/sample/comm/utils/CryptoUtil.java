package com.project.sample.comm.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class CryptoUtil {

    public static final String MD5 = "MD5";
    public static final String SHA256 = "SHA-256";

    //AES
    //RCA
    //SEED
    //-encrypt

    public static String encrypt(String dec, String key, String iv){
	return dec;
    }

    public static String decrypt(String enc, String key, String iv){
	return enc;
    }

    public static String getHash(String data, String algorithm){
	String result = null;
	if(!StringUtil.isEmpty(data)){
	    try {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		byte[] b = md.digest(data.getBytes());
		result = Base64.encodeBase64String(b);
	    } catch (NoSuchAlgorithmException e) {}
	}
	return result;
    }

    public static byte[] toByteArray(String hexArray){
	byte[] b = null;
	if(!StringUtil.isEmpty(hexArray)){
	    BigInteger bi = new BigInteger(hexArray, 16);
	    b = bi.toByteArray();
	    if(b.length > hexArray.length()/2){
		byte[] dest = new byte[b.length-1];
		System.arraycopy(b, 1, dest, 0, dest.length);
		return dest;
	    }
	}
	return b;
    }
}

package ru.tiger.bookprototype.security;

import java.security.*;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class MD5Util {
    public static String getHash(String str) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        
        try {
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(str.getBytes("UTF-8"));
        digest = messageDigest.digest();
        } catch(NoSuchAlgorithmException e) {
            
        } catch (UnsupportedEncodingException e) {
            
        }
     
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);
     
        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }
     
        return md5Hex;
    }
    
    /*public static String getHash2(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
     
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(str.getBytes("UTF-8"));
        digest = messageDigest.digest();
     
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);
        
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0, count = 32 - md5Hex.length(); i < count; i++) {
                sb.append("0");
        }
        return sb.append(md5Hex).toString();
    }*/
    
    /*public static String getHash3(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
     
        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(str.getBytes("UTF-8"));
        digest = messageDigest.digest();
     
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digest.length; ++i) {
          sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString();
    }*/
}

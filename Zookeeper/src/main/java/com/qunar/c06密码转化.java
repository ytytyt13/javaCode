package com.qunar;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
/**
 * @author yang
 * 2021年02月09日 19:44:00
 */
public class c06密码转化 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String usernameAndPassword = "author:123456";
        byte digest[] = MessageDigest.getInstance("SHA1").digest(usernameAndPassword.getBytes());
        Base64 base64 = new Base64();
        String encodeToString = base64.encodeToString(digest);
        System.out.println(encodeToString);
    }
}

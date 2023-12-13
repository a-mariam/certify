package com.example.certify;


import org.apache.tomcat.util.net.openssl.ciphers.MessageDigest;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Encryptor {

    public static String hash(String info){
//         byte [] encode =  info.getBytes(StandardCharsets.UTF_8);
//        Map <String, String >
//           String result =
        return null;
    }
//    public static String hashPassword(String password) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//
//            // Convert the byte array to a hexadecimal representation
//            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
//            for (byte b : encodedHash) {
//                String hex = Integer.toHexString(0xff & b);
//                if (hex.length() == 1) {
//                    hexString.append('0');
//                }
//                hexString.append(hex);
//            }
//
//            return hexString.toString();
//        } catch (NoSuchAlgorithmException e) {
//            // Handle the exception or rethrow as needed
//            throw new RuntimeException("Error hashing password", e);
//        }
//    }
}

package com.notrew.url.shortener.ddd.domain.shared.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UrlEncryptionService {
    private static final String SECRET_KEY = "YourSecretKey"; // Replace with your own secret key
    private static final int MAX_URL_LENGTH = 8; // Maximum length for the encrypted URL

    public static String encrypt(String url) {
        try {
            byte[] originalBytes = url.getBytes();
            byte[] secretKeyBytes = SECRET_KEY.getBytes();
            byte[] encryptedBytes = new byte[originalBytes.length];

            for (int i = 0; i < originalBytes.length; i++) {
                encryptedBytes[i] = (byte) (originalBytes[i] ^ secretKeyBytes[i % secretKeyBytes.length]);
            }

            byte[] hashBytes = generateHash(encryptedBytes);
            String base64Encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);
            return base64Encoded.substring(0, MAX_URL_LENGTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encryptedUrl) {
        try {
            String base64Encoded = encryptedUrl + "=="; // Restore the padding characters
            byte[] hashBytes = Base64.getUrlDecoder().decode(base64Encoded);
            byte[] decryptedBytes = generateHash(hashBytes);
            byte[] secretKeyBytes = SECRET_KEY.getBytes();
            byte[] originalBytes = new byte[decryptedBytes.length];

            for (int i = 0; i < decryptedBytes.length; i++) {
                originalBytes[i] = (byte) (decryptedBytes[i] ^ secretKeyBytes[i % secretKeyBytes.length]);
            }

            return new String(originalBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] generateHash(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data);
    }
}
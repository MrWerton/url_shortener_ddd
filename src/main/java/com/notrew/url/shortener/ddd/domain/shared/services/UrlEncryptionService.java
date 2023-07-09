package com.notrew.url.shortener.ddd.domain.shared.services;

import java.util.Base64;

public class UrlEncryptionService {
    private static final String SECRET_KEY = "notrew123";

    public String encrypt(String url) {
        try {
            byte[] originalBytes = url.getBytes();
            byte[] secretKeyBytes = SECRET_KEY.getBytes();
            byte[] encryptedBytes = new byte[originalBytes.length];

            for (int i = 0; i < originalBytes.length; i++) {
                encryptedBytes[i] = (byte) (originalBytes[i] ^ secretKeyBytes[i % secretKeyBytes.length]);
            }

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String encryptedUrl) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedUrl);
            byte[] secretKeyBytes = SECRET_KEY.getBytes();
            byte[] decryptedBytes = new byte[encryptedBytes.length];

            for (int i = 0; i < encryptedBytes.length; i++) {
                decryptedBytes[i] = (byte) (encryptedBytes[i] ^ secretKeyBytes[i % secretKeyBytes.length]);
            }

            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.tech.adira.app.management.civillab.utils;

import java.security.SecureRandom;

public class ShortIdGenerator {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String random() {
        StringBuilder sb = new StringBuilder(6);

        // First character must be a letter
        sb.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));

        // Remaining 5 characters can be alphanumeric
        for (int i = 1; i < 6; i++) {
            sb.append(ALPHANUM.charAt(RANDOM.nextInt(ALPHANUM.length())));
        }
        return sb.toString();
    }
}

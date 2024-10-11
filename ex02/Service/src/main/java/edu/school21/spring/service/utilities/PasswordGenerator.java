package edu.school21.spring.service.utilities;

import java.security.SecureRandom;

public class PasswordGenerator {

    public static final String CHAR_POOL = "qwertyuiopasdfghjklzxcvbnm";

    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            password.append(CHAR_POOL.charAt(index));
        }
        return password.toString();
    }
}

package com.example.springapi;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {

    @Test
    void testPasswordEncoder() {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = "admin123";

        String hash1 = encoder.encode(password);
        String hash2 = encoder.encode(password);

        System.out.println("Password: " + password);
        System.out.println("Hash 1: " + hash1);
        System.out.println("Hash 2: " + hash2);

        System.out.println("Hash 1 equals Hash 2: "
                + hash1.equals(hash2));

        System.out.println("Hash 1 matches password: "
                + encoder.matches(password, hash1));

        System.out.println("Hash 2 matches password: "
                + encoder.matches(password, hash2));

        System.out.println("Wrong password matches Hash 1: "
                + encoder.matches("123456", hash1));
    }
}
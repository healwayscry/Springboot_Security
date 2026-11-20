package com.example.springapi.config;

import com.example.springapi.entity.Account;
import com.example.springapi.repository.AccountRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initAccounts(
            AccountRepository accountRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (accountRepository.count() == 0) {

                accountRepository.save(
                    new Account(
                        "admin1",
                        passwordEncoder.encode("admin123"),
                        "ADMIN"
                    )
                );

                accountRepository.save(
                    new Account(
                        "admin2",
                        passwordEncoder.encode("admin123"),
                        "ADMIN"
                    )
                );

                accountRepository.save(
                    new Account(
                        "admin3",
                        passwordEncoder.encode("admin123"),
                        "ADMIN"
                    )
                );

                accountRepository.save(
                    new Account(
                        "user1",
                        passwordEncoder.encode("user123"),
                        "USER"
                    )
                );

                accountRepository.save(
                    new Account(
                        "user2",
                        passwordEncoder.encode("user123"),
                        "USER"
                    )
                );

                accountRepository.save(
                    new Account(
                        "user3",
                        passwordEncoder.encode("user123"),
                        "USER"
                    )
                );

                System.out.println("=================================");
                System.out.println("6 ACCOUNTS CREATED");
                System.out.println("admin1 / admin123");
                System.out.println("admin2 / admin123");
                System.out.println("admin3 / admin123");
                System.out.println("user1 / user123");
                System.out.println("user2 / user123");
                System.out.println("user3 / user123");
                System.out.println("=================================");
            }
        };
    }
}
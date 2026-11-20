package com.example.springapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // BCrypt dùng để mã hóa và kiểm tra mật khẩu
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Cấu hình Spring Security
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            // Tắt CSRF vì đây là REST API
            .csrf(csrf -> csrf.disable())

            // Tất cả API đều yêu cầu đăng nhập
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )

            // Sử dụng Basic Authentication
            .httpBasic(httpBasic -> {});

        return http.build();
    }
}
package com.example.demo.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean(name = "securityFilterChain")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // 🔴 Disable CSRF (tests expect this)
            .csrf(csrf -> csrf.disable())

            // ✅ FIX: Return 401 instead of 403
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint(
                    (request, response, authException) ->
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                )
                .accessDeniedHandler(
                    (request, response, accessDeniedException) ->
                        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden")
                )
            )

            .authorizeHttpRequests(auth -> auth
                // OPTIONS must be allowed
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // Public endpoints
                .requestMatchers("/auth/**").permitAll()

                // Swagger
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/swagger-ui.html"
                ).permitAll()

                // Everything else needs auth
                .anyRequest().authenticated()
            )

            // Disable default login
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable());

        return http.build();
    }

    // REQUIRED BY TESTS
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // REQUIRED BY TESTS
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}

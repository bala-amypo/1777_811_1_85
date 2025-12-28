@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((req, res, ex1) ->
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .accessDeniedHandler((req, res, ex1) ->
                    res.sendError(HttpServletResponse.SC_FORBIDDEN))
            )

            .authorizeHttpRequests(auth -> auth
                // ✅ Public
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/swagger-ui.html"
                ).permitAll()

                // 🔥 Role based API authorization
                .requestMatchers(HttpMethod.POST, "/properties/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/properties/**").hasAnyRole("ADMIN", "ANALYST")

                .requestMatchers("/scores/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.POST, "/ratings/generate/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/ratings/**").hasAnyRole("ADMIN", "ANALYST")

                .anyRequest().authenticated()
            )

            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}

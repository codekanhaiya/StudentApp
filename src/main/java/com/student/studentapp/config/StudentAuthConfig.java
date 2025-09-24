package com.student.studentapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class StudentAuthConfig {


    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authz -> authz
                        // Public endpoints
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/studentauth/public").permitAll()

                        // Protected endpoints - require JWT authentication
                        .requestMatchers("/students/**").authenticated()
                        .requestMatchers("/studentauth/profile").hasRole("USER")
                        .requestMatchers("/studentauth/admin").hasRole("ADMIN")

                        // All other requests require authentication
                        .anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    //     httpSecurity.authorizeHttpRequests((requests) -> requests
    //             .requestMatchers("/students/profile").hasRole("USER")
    //             .requestMatchers("/students/admin").hasRole("ADMIN")
    //             .requestMatchers("/students/public").authenticated() // everyone logged-in
    //             .requestMatchers("/students/**").authenticated() // CRUD endpoints
    //             .anyRequest().denyAll() // deny any other route
    //     )
    //             .httpBasic(Customizer.withDefaults()) // basic auth popup
    //             .csrf(csrf -> csrf.disable()); // optional, disable CSRF for testing REST endpoints

    //     return httpSecurity.build();
    // }

    // @Bean
    // public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
    //     UserDetails admin = User.withUsername("admin")
    //             .password(passwordEncoder.encode("admin"))
    //             .roles("ADMIN", "USER") // admin can do everything
    //             .build();

    //     UserDetails user = User.withUsername("user")
    //             .password(passwordEncoder.encode("user"))
    //             .roles("USER")
    //             .build();

    //     return new InMemoryUserDetailsManager(admin, user);
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    // }
}

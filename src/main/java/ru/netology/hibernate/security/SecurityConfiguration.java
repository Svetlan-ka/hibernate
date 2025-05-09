package ru.netology.hibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers(HttpMethod.GET, "/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/read").hasRole("READ")
                        .requestMatchers(HttpMethod.GET, "/write").hasRole("WRITE")
                        .requestMatchers(HttpMethod.GET, "/write-and-delete").hasAnyRole("WRITE", "DELETE")
                        .anyRequest().authenticated())
                .headers(Customizer.withDefaults())
                .sessionManagement(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .anonymous(Customizer.withDefaults())
                .csrf(Customizer.withDefaults())
                .userDetailsService(InMemoryUserDetailsService())
                .logout(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService InMemoryUserDetailsService() {
        User.UserBuilder users = User.builder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(users
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("WRITE", "READ", "DELETE")
                .build());

        manager.createUser(users
                .username("writer")
                .password(passwordEncoder().encode("writer"))
                .roles("WRITE")
                .build());

        manager.createUser(users
                .username("reader")
                .password(passwordEncoder().encode("reader"))
                .roles("READ")
                .build());

        manager.createUser(users
                .username("delete")
                .password(passwordEncoder().encode("delete"))
                .roles("DELETE")
                .build());

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

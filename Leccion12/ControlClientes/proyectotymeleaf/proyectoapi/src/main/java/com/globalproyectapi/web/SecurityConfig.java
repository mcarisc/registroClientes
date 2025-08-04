package com.globalproyectapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/webjars/**", "/css/**", "/js/**").permitAll() // permite recursos estáticos
                        .requestMatchers("/agregar/**", "/guardar","/editar/**", "/eliminar/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/")
                        .hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/errores/**").permitAll()
        ).formLogin(form-> form
                .loginPage("/login")   // Ruta de tu login personalizado
                .defaultSuccessUrl("/", true)  // Redirección si el login es exitoso
                .permitAll()
        ).exceptionHandling(errors -> errors
                .accessDeniedPage("/errores/403")
        );
        return http.build();
    }
}

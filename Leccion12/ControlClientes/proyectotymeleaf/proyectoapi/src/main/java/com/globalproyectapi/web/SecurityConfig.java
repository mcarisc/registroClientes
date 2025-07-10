package com.globalproyectapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
    //@Autowired
    //public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
    //    build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    //}

//    @Bean
//    public UserDetailsService userDetailsService(){
//        //Crear manualmente usuarios
//        var admin = User.builder()
//                .username("admin")
//                .password("{noop}123")
//                .roles("ADMIN", "USER") // 🔹 múltiples roles
//                .build();
//        var user = User.builder()
//                .username("user")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }

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

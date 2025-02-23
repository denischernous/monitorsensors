package org.chernous.test.task.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${admin.password}")
    private String adminPassword;
    @Value("${user.password}")
    private String userPassword;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/sensors").hasAnyRole("VIEWER", "ADMINISTRATOR")
                        .requestMatchers("/api/sensors/**").hasRole("ADMINISTRATOR")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()) // Используем форму входа
                .logout(logout -> logout
                        .logoutUrl("/logout") // Эндпоинт для выхода
                        .logoutSuccessUrl("/api/sensors") // Перенаправление после выхода
                        .invalidateHttpSession(true) // Уничтожение сессии
                        .deleteCookies("JSESSIONID") // Удаление cookies
                        .addLogoutHandler(new HeaderWriterLogoutHandler(
                                        new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.COOKIES) // Очистка cookies
                                )
                        ));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode(adminPassword))
                .roles("ADMINISTRATOR")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode(userPassword))
                .roles("VIEWER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package de.neuefische.ffmjava221.auth.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Value("${app.user.daniel.password}")
    String danielPassword;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/api/excavators").authenticated()
                .anyRequest().denyAll()
                .and().build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsService() {
        return new UserDetailsManager() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                if ("daniel".equals(username)) {
                    return User.builder()
                            .username("daniel")
                            .password(danielPassword)
                            .roles("BASIC")
                            .build();
                }
                throw new UsernameNotFoundException("Username not found");
            }

            @Override
            public void createUser(UserDetails user) {
                throw new UnsupportedOperationException("You cannot use this custom UserDetailsManager for this action.");
            }

            @Override
            public void updateUser(UserDetails user) {
                throw new UnsupportedOperationException("You cannot use this custom UserDetailsManager for this action.");
            }

            @Override
            public void deleteUser(String username) {
                throw new UnsupportedOperationException("You cannot use this custom UserDetailsManager for this action.");
            }

            @Override
            public void changePassword(String oldPassword, String newPassword) {
                throw new UnsupportedOperationException("You cannot use this custom UserDetailsManager for this action.");
            }

            @Override
            public boolean userExists(String username) {
                throw new UnsupportedOperationException("You cannot use this custom UserDetailsManager for this action.");
            }
        };
    }
}

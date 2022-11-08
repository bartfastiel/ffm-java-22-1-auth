package de.neuefische.ffmjava221.auth.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SecurityConfigTest {

    @Test
    void userDetailsService() {
        // given
        String username = "daniel";
        String rawPassword = "test12345454";
        String encodedTestPassword = "$2a$10$P/T2Qj9l4YVaetFv3xT5lutqyT.IFx0v5ozHne1iYYROGkNDa9KSu";

        // when
        SecurityConfig securityConfig = new SecurityConfig();
        securityConfig.danielPassword = encodedTestPassword;
        String actual = securityConfig.userDetailsService()
                .loadUserByUsername(username)
                .getPassword();

        // then
        assertTrue(securityConfig.encoder().matches(rawPassword, actual));
    }
}
package de.neuefische.ffmjava221.auth.backend;

public record AppUser(
        String id,
        String username,
        String passwordBcrypt
) {
}

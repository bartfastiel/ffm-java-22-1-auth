package de.neuefische.ffmjava221.auth.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<AppUser, String> {

    AppUser findByUsername(String username);
}

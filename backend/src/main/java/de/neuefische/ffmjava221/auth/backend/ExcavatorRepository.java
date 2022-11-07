package de.neuefische.ffmjava221.auth.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExcavatorRepository extends MongoRepository<Excavator, String> {
}

package de.neuefische.ffmjava221.auth.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcavatorService {

    private final ExcavatorRepository excavatorRepository;

    List<Excavator> findAll() {
        return excavatorRepository.findAll();
    }
}

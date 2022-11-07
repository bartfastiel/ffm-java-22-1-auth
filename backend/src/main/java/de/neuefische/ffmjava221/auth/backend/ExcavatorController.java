package de.neuefische.ffmjava221.auth.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/excavators")
@RequiredArgsConstructor
public class ExcavatorController {

    private final ExcavatorService excavatorService;

    @GetMapping
    List<Excavator> findAll() {
        return excavatorService.findAll();
    }
}

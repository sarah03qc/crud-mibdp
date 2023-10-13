package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/entities")
public class YourEntityController {
    private final YourEntityService entityService;

    @Autowired
    public YourEntityController(YourEntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    public List<Map<String, Object>> getAllEntities() {
        return entityService.getAllEntities();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getEntityById(@PathVariable Long id) {
        return entityService.getEntityById(id);
    }

    @PostMapping
    public void saveEntity(@RequestParam String name) {
        entityService.saveEntity(name);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        entityService.deleteEntity(id);
    }
}

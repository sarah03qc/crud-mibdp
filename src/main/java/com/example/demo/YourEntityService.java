package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class YourEntityService {
    private final YourEntityRepository repository;

    @Autowired
    public YourEntityService(YourEntityRepository repository) {
        this.repository = repository;
    }

    public List<Map<String, Object>> getAllEntities() {
        return repository.getAllEntities();
    }

    public Map<String, Object> getEntityById(Long id) {
        return repository.getEntityById(id);
    }

    public void saveEntity(String name) {
        repository.saveEntity(name);
    }

    public void deleteEntity(Long id) {
        repository.deleteEntity(id);
    }
}

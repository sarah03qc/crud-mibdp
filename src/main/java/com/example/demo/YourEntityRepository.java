package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class YourEntityRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public YourEntityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAllEntities() {
        String query = "SELECT * FROM pelicula";
        return jdbcTemplate.queryForList(query);
    }

    public Map<String, Object> getEntityById(Long id) {
        String query = "SELECT * FROM pelicula WHERE id=?";
        return jdbcTemplate.queryForMap(query, id);
    }

    public void saveEntity(String name) {
        String query = "INSERT INTO pelicula(titulo) VALUES (?)";
        jdbcTemplate.update(query, name);
    }

    public void deleteEntity(Long id) {
        String query = "DELETE FROM pelicula WHERE id=?";
        jdbcTemplate.update(query, id);
    }
}

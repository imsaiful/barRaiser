package com.example.bar.bar.repository;

import com.example.bar.bar.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer,Long> {
    List<Developer> findByTeamId(Long id);
}

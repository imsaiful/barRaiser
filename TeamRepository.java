package com.example.bar.bar.repository;

import com.example.bar.bar.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}

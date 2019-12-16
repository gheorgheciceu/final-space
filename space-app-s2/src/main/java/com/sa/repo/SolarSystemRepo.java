package com.sa.repo;

import com.sa.entity.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarSystemRepo extends JpaRepository<SolarSystem, Integer> {
}

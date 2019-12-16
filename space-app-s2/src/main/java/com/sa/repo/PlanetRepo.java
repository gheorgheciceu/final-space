package com.sa.repo;

import com.sa.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepo extends JpaRepository<Planet,Integer> {
}

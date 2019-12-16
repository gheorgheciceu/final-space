package com.sa.repo;

import com.sa.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepo extends JpaRepository<Crew,Integer> {
}

package com.sa.repo;

import com.sa.entity.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptainRepo extends JpaRepository<Captain, Integer> {
}

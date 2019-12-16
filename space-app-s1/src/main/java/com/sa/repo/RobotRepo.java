package com.sa.repo;

import com.sa.entity.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepo extends JpaRepository<Robot, Integer> {
}

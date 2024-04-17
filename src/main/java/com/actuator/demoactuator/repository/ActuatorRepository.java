package com.actuator.demoactuator.repository;

import com.actuator.demoactuator.entity.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuatorRepository extends JpaRepository<Actuator, String> {
}

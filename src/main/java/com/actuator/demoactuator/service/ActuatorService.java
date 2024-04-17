package com.actuator.demoactuator.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ActuatorService {
    ResponseEntity<?> getActuatorResponse() throws IOException;
}

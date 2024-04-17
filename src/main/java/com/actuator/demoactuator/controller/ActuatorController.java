package com.actuator.demoactuator.controller;

import com.actuator.demoactuator.service.ActuatorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ActuatorController {
    @Autowired
    private ActuatorService service;

    @GetMapping("/actuator/healths")
    public ResponseEntity<?> getActuatorResponse() throws IOException {
        return service.getActuatorResponse();
    }

}

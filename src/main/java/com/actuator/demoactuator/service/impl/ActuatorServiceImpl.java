package com.actuator.demoactuator.service.impl;

import com.actuator.demoactuator.entity.Actuator;
import com.actuator.demoactuator.payload.response.StatusResponse;
import com.actuator.demoactuator.repository.ActuatorRepository;
import com.actuator.demoactuator.service.ActuatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@Slf4j
public class ActuatorServiceImpl implements ActuatorService {

    @Autowired
    WebClient webClient;

    @Autowired
    ActuatorRepository repository;

    @Override
    public ResponseEntity<?> getActuatorResponse() throws IOException {
        String url2 = "http://localhost:8080/api/prod/actuator/health";

        StatusResponse response = webClient.get().uri(url2)
                .retrieve()
                .bodyToMono(StatusResponse.class)
                .onErrorResume(e -> {
                    if (e instanceof WebClientResponseException responseException) {

                        if (responseException.getStatusCode().is4xxClientError()) {
                            System.out.println(e.getMessage());
                            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
                        }
                        else if (responseException.getStatusCode().is5xxServerError()) {
                            System.out.println(String.valueOf(Health.down()));
                            repository.save(
                                    Actuator.builder()
                                            .createdDt(LocalDateTime.now())
                                            .dbStatus("DOWN")
                                            .mongoStatus("DOWN")
                                            .redisStatus("DOWN")
                                            .pingStatus("DOWN")
                                            .actuatorResponse(String.valueOf(e.getMessage()))
                                            .build());
                            throw  new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage(), e);
                        } else if (responseException.getStatusCode().is2xxSuccessful()) {
                            System.out.println(e.getMessage());
                            return Mono.error(new ResponseStatusException(responseException.getStatusCode()));
                        }
                    }

                    return Mono.error(e);
                })
                .block();
        assert response != null;
        repository.save(
                Actuator.builder()
                        .createdDt(LocalDateTime.now())
                        .dbStatus(response.getComponents().getDb().getStatus())
                        .mongoStatus(response.getComponents().getMongo().getStatus())
                        .redisStatus(response.getComponents().getRedis().getStatus())
                        .pingStatus(response.getComponents().getPing().getStatus())
                        .actuatorResponse(response.toString())
                        .build());
        return ResponseEntity.ok().body(response);
    }
}

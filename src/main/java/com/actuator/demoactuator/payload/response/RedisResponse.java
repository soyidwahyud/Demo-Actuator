package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RedisResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("details")
    private RedisDetailResponse details;

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", details=" + details.toString() +
                '}';
    }
}

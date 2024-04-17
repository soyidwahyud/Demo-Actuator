package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RedisDetailResponse {
    @JsonProperty("version")
    private String version;

    @Override
    public String toString() {
        return "{" +
                "version='" + version + '\'' +
                '}';
    }
}

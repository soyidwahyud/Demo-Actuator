package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PingResponse {
    @JsonProperty("status")
    private String status;

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                '}';
    }
}

package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("components")
    private ComponentResponse components;

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", components=" + components.toString() +
                '}';
    }
}

package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DbResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("details")
    private DbDetailResponse details;

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", details=" + details.toString() +
                '}';
    }
}

package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MongoResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("details")
    private MongoDetailResponse details;

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", details=" + details.toString() +
                '}';
    }
}

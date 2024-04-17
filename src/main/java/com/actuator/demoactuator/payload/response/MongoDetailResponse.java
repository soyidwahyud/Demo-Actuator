package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MongoDetailResponse {
    @JsonProperty("maxWireVersion")
    private String maxWireVersion;

    @Override
    public String toString() {
        return "{" +
                "maxWireVersion='" + maxWireVersion + '\'' +
                '}';
    }
}

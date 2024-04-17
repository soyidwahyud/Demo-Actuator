package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DbDetailResponse {
    @JsonProperty("database")
    private String database;
    @JsonProperty("validationQuery")
    private String validationQuery;

    @Override
    public String toString() {
        return "{" +
                "database='" + database + '\'' +
                ", validationQuery='" + validationQuery + '\'' +
                '}';
    }
}

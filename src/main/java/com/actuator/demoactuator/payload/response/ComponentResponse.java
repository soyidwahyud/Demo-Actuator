package com.actuator.demoactuator.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComponentResponse {
    @JsonProperty("db")
    private DbResponse db;
    @JsonProperty("mongo")
    private MongoResponse mongo;
    @JsonProperty("ping")
    private PingResponse ping;
    @JsonProperty("redis")
    private RedisResponse redis;

    @Override
    public String toString() {
        return "{" +
                "db=" + db.toString() +
                ", mongo=" + mongo.toString() +
                ", ping=" + ping.toString() +
                ", redis=" + redis.toString() +
                '}';
    }
}

package com.actuator.demoactuator.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_actuator",schema="public")
@Builder(toBuilder = true)
public class Actuator {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private String id;

    @Column(name = "created_dt")
    private LocalDateTime createdDt;
    @Column(name = "db_status")
    private String dbStatus;
    @Column(name = "mongo_status")
    private String mongoStatus;
    @Column(name = "redis_status")
    private String redisStatus;
    @Column(name = "ping_status")
    private String pingStatus;
    @Column(name = "actuator_response")
    private String actuatorResponse;
}

package com.actuator.demoactuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

//@SpringBootApplication
@SpringBootApplication
public class DemoActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoActuatorApplication.class, args);
    }

}

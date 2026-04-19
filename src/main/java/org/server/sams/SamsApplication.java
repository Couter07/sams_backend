package org.server.sams;

import org.server.sams.auth.AuthService;
import org.server.sams.auth.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class SamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamsApplication.class, args);
    }

}

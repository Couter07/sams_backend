package org.server.sams.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
public class JwtProperties {

    @Value("${jwt.secret-key}")
    public static String SECRET_KEY;

    @Value("${jwt.expiration}")
    public static long EXPIRATION;


}

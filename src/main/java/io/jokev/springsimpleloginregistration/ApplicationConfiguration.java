package io.jokev.springsimpleloginregistration;

import org.springframework.context.annotation.Configuration;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Application wide Configuration
 */
@Configuration
public class ApplicationConfiguration {
    public static final DateTimeFormatter RFC_3339_MICRO = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .withZone(ZoneOffset.UTC);

}

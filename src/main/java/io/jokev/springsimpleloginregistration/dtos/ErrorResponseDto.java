package io.jokev.springsimpleloginregistration.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static io.jokev.springsimpleloginregistration.ApplicationConfiguration.RFC_3339_MICRO;

/**
 * Should be used in {@link io.jokev.springsimpleloginregistration.exceptions.ExceptionHandler}.
 * Used for better Error Response formatting.
 */
@Data
@Builder
public class ErrorResponseDto {
    @Builder.Default
    private String timestamp = ZonedDateTime.now(ZoneOffset.UTC).format(RFC_3339_MICRO);
    private int status;
    private String error;
    private String message;
}

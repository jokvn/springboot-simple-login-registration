package io.jokev.springsimpleloginregistration.exceptions;

import io.jokev.springsimpleloginregistration.dtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Global exception handler. Catches Exception and transforms them into an {@link io.jokev.springsimpleloginregistration.dtos.ErrorResponseDto}
 */
@ControllerAdvice
public class ExceptionHandler {

    /**
     * Checks for FailedLoginException. Throws if login failed.
     *
     * @param e The thrown Exception
     * @return @{@link io.jokev.springsimpleloginregistration.dtos.ErrorResponseDto} for better format
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(FailedLoginException.class)
    ResponseEntity<ErrorResponseDto> handleFailedLoginException(FailedLoginException e) {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    /**
     * Checks for PermissionException. Throws if an email or username is already registered.
     *
     * @param e The thrown Exception
     * @return @{@link ErrorResponseDto} for better format
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(UserAlreadyRegisteredException.class)
    ResponseEntity<ErrorResponseDto> handleUserAlreadyRegisteredException(UserAlreadyRegisteredException e) {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .status(HttpStatus.FORBIDDEN.value())
                .error(HttpStatus.FORBIDDEN.getReasonPhrase())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }
}

package io.jokev.springsimpleloginregistration.exceptions;

/**
 * Thrown when the entered username or email is already used.
 */
public class UserAlreadyRegisteredException extends RuntimeException{

    public UserAlreadyRegisteredException(String message) {
        super(message);
    }

    public UserAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}

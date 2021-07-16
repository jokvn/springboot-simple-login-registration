package io.jokev.springsimpleloginregistration.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Dto meant fro response after login or registration.
 * This does not contain sensetive data and is not meant as a full User account.
 */
@Data
@AllArgsConstructor
@Builder
public class UserAccountDto {
    private int id;
    private String username;
    private String email;
    private String role;
    private boolean blocked;
    private boolean enabled;
}

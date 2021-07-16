package io.jokev.springsimpleloginregistration.dtos;

import io.jokev.springsimpleloginregistration.models.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/**
 * Dto which is used at registration.
 */
@Getter
@Builder
public class RegisterUserAccountDto {

    @NonNull
    private final String email;
    @NonNull
    private final String username;
    @NonNull
    private final String password;
    @Builder.Default
    private final String role = Role.ROLE_USER.name();
    @Builder.Default
    private final boolean blocked = false;
    @Builder.Default
    private final boolean enabled = true;
}

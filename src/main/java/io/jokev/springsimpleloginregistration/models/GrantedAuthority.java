package io.jokev.springsimpleloginregistration.models;

import lombok.RequiredArgsConstructor;

/**
 * Own implementation for Granted Authority, so we can have a custom name.
 */
@RequiredArgsConstructor
public class GrantedAuthority implements org.springframework.security.core.GrantedAuthority {

    private final String name;

    @Override
    public String getAuthority() {
        return name;
    }
}

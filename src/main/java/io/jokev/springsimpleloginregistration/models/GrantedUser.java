package io.jokev.springsimpleloginregistration.models;


import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

/**
 * Custom Granted User so we have a reference of the authenticated user with the user Id
 */
public class GrantedUser extends User {

    @Getter
    private final int userId;

    public GrantedUser(String username, String password, boolean enabled, boolean locked, Collection<? extends GrantedAuthority> authorities, int userId) {
        //For my scope I don't need accounts/credentials to expire
        super(username, password, enabled, true, true, !locked, authorities);
        this.userId = userId;
    }
}

package io.jokev.springsimpleloginregistration.services;

import io.jokev.springsimpleloginregistration.models.GrantedUser;
import io.jokev.springsimpleloginregistration.models.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Our custom Granted User Details Service.
 * Used to customize our Granted user e.g isBlocked / isEnabled.
 */
@Service
@RequiredArgsConstructor
public class CustomGrantedUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Account with email " + email + " does not exist"));

        System.out.println(userAccount.isBlocked());

        return new GrantedUser(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.isEnabled(),
                userAccount.isBlocked(),
                getAllAuthorities(userAccount),
                userAccount.getId()
        );
    }

    /*
    Add user roles to Granted authority.
     */
    private Set<GrantedAuthority> getAllAuthorities(UserAccount userAccount) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        authorities.add(new io.jokev.springsimpleloginregistration.models.GrantedAuthority(userAccount.getRole()));

        return authorities;
    }
}

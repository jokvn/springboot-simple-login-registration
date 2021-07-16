package io.jokev.springsimpleloginregistration.services;

import io.jokev.springsimpleloginregistration.dtos.RegisterUserAccountDto;
import io.jokev.springsimpleloginregistration.models.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service related to User Data.
 */
@Service
@RequiredArgsConstructor
public class UserAccountDataServiceImpl implements UserAccountDataService {

    private final UserAccountRepository userAccountRepository;

    /**
     * Gets the full Account Object with all of the user's data from email.
     *
     * @param email the users email aka. username
     * @return {@link UserAccount} object will a data of the user.
     */
    @Override
    public UserAccount getUserAccountByEmail(String email) {
        return userAccountRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("email not found " + email));
    }

    //getUserById, updateClientData, enableUser, deleteUserAccount ...

    /**
     * Check if the given email is already used.
     *
     * @param email the given email
     * @return true/false depending if the email is already registered.
     */
    @Override
    public boolean checkIfEmailIsAlreadyUsed(String email) {
        return userAccountRepository.existsByEmail(email);
    }

    /**
     * Check if the given username is already used.
     *
     * @param username the given username
     * @return true/false depending if the username is already registered.
     */
    @Override
    public boolean checkIfUsernameIsAlreadyUsed(String username) {
        return userAccountRepository.existsByUsername(username);
    }

    /**
     * This will insert the user account into the db.
     *
     * @param registerUserAccountDto The given RegisterUserAccountDto with registration info.
     */
    @Override
    public void createUser(RegisterUserAccountDto registerUserAccountDto) {

        UserAccount account = UserAccount.builder()
                .email(registerUserAccountDto.getEmail())
                .username(registerUserAccountDto.getUsername())
                .password(registerUserAccountDto.getPassword())
                .role(registerUserAccountDto.getRole())
                .blocked(registerUserAccountDto.isBlocked())
                .enabled(registerUserAccountDto.isEnabled())
                .build();

        userAccountRepository.save(account);
    }
}

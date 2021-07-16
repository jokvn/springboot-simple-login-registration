package io.jokev.springsimpleloginregistration.controller;

import io.jokev.springsimpleloginregistration.dtos.RegisterUserAccountDto;
import io.jokev.springsimpleloginregistration.dtos.UserAccountDto;
import io.jokev.springsimpleloginregistration.exceptions.UserAlreadyRegisteredException;
import io.jokev.springsimpleloginregistration.models.UserAccount;
import io.jokev.springsimpleloginregistration.services.UserAccountDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.jokev.springsimpleloginregistration.ApiConstants.GLOBAL_REQUEST_MAPPING_PATH;
import static io.jokev.springsimpleloginregistration.ApiConstants.USERS_RESOURCE;

/**
 * Rest Controller for user registration.
 */
@RestController
@AllArgsConstructor
@RequestMapping(path = GLOBAL_REQUEST_MAPPING_PATH + "/" + USERS_RESOURCE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RegistrationController {

    private final PasswordEncoder passwordEncoder;
    private final UserAccountDataService userAccountDataService;

    @PostMapping("/register")
    public ResponseEntity<UserAccountDto> registerUser(@RequestBody RegisterUserAccountDto accountDto) {

        RegisterUserAccountDto userAccountDto = RegisterUserAccountDto.builder()
                .email(accountDto.getEmail())
                .username(accountDto.getUsername())
                .password(passwordEncoder.encode(accountDto.getPassword()))
                .build();

        if (userAccountDataService.checkIfEmailIsAlreadyUsed(accountDto.getEmail())) {
            throw new UserAlreadyRegisteredException("The email " + accountDto.getEmail() + " is already registered");
        }

        if (userAccountDataService.checkIfUsernameIsAlreadyUsed(accountDto.getUsername())) {
            throw new UserAlreadyRegisteredException("The username " + accountDto.getUsername() + " is already used");
        }

        userAccountDataService.createUser(userAccountDto);

        UserAccount userAccount = userAccountDataService.getUserAccountByEmail(userAccountDto.getEmail());
        return ResponseEntity.ok(userAccount.mapToUserAccountDto());

    }

}

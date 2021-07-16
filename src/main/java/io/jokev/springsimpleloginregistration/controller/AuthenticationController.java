package io.jokev.springsimpleloginregistration.controller;

import io.jokev.springsimpleloginregistration.dtos.AuthenticationDto;
import io.jokev.springsimpleloginregistration.dtos.UserAccountDto;
import io.jokev.springsimpleloginregistration.exceptions.FailedLoginException;
import io.jokev.springsimpleloginregistration.services.UserAccountDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.jokev.springsimpleloginregistration.ApiConstants.GLOBAL_REQUEST_MAPPING_PATH;
import static io.jokev.springsimpleloginregistration.ApiConstants.USERS_RESOURCE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = GLOBAL_REQUEST_MAPPING_PATH + "/" + USERS_RESOURCE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final UserAccountDataService userAccountDataService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<UserAccountDto> checkLogin(@RequestBody AuthenticationDto authenticationDto) {
        Authentication auth = new UsernamePasswordAuthenticationToken(authenticationDto.getEmail(),
                authenticationDto.getPassword());

        try {
            Authentication result = authenticationManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(result);

            UserAccountDto userAccountDto = userAccountDataService
                    .getUserAccountByEmail(authenticationDto.getEmail())
                    .mapToUserAccountDto();

            return ResponseEntity.ok(userAccountDto);

        } catch (BadCredentialsException e) {
            throw new FailedLoginException("Username or password wrong.");
        } catch (LockedException e) {
            throw new FailedLoginException("Your account is currently blocked.");
        } catch (DisabledException e) {
            throw new FailedLoginException("Your account isn't enabled.");
        }
    }
}

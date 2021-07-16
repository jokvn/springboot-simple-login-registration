package io.jokev.springsimpleloginregistration.services;

import io.jokev.springsimpleloginregistration.dtos.RegisterUserAccountDto;
import io.jokev.springsimpleloginregistration.models.UserAccount;

public interface UserAccountDataService {

    UserAccount getUserAccountByEmail(String email);
    boolean checkIfEmailIsAlreadyUsed(String email);
    boolean checkIfUsernameIsAlreadyUsed(String username);
    void createUser(RegisterUserAccountDto userAccount);
}

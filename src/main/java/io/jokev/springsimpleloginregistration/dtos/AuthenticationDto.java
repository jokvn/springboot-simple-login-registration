package io.jokev.springsimpleloginregistration.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * Used for email and password authentication
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDto implements Serializable {
    private static final long serialVersionUID = 2844800788165643382L;

    @NonNull
    private String email;
    @NonNull
    private String password;
}

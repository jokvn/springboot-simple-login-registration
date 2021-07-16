package io.jokev.springsimpleloginregistration.models;

import io.jokev.springsimpleloginregistration.dtos.UserAccountDto;
import lombok.*;

import javax.persistence.*;

/**
 * This is the full User Account.
 * Gets mapped from DB or get's written to DB.
 */
@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserAccount {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private boolean blocked;

    @Column(nullable = false)
    private boolean enabled;

    public UserAccountDto mapToUserAccountDto() {
        return UserAccountDto.builder()
                .id(id)
                .email(email)
                .username(username)
                .role(role)
                .blocked(blocked)
                .enabled(enabled)
                .build();
    }
}

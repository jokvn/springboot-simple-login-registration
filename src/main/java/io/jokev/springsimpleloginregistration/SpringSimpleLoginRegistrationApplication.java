package io.jokev.springsimpleloginregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.jokev.springsimpleloginregistration")
public class SpringSimpleLoginRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSimpleLoginRegistrationApplication.class, args);
    }

}

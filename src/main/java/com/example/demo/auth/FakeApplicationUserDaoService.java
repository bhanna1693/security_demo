package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        USER.getGrantedAuthorities(),
                        passwordEncoder.encode("password"),
                        "briansmith",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password123"),
                        "susan",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("password123"),
                        "shawn",
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}

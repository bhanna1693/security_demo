package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.demo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(MY_USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails brainSmithUser = User.builder()
                .username("briansmith")
                .password(passwordEncoder.encode("password"))
                .roles(MY_USER.name())  // ROLE_USER
                .build();

        UserDetails sueSmithUser = User.builder()
                .username("susansmith")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())  // ROLE_ADMIN
                .build();

        UserDetails shawnSmithUser = User.builder()
                .username("shawnsmith")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN_TRAINEE.name())  // ROLE_ADMIN_TRAINEE
                .build();

        return new InMemoryUserDetailsManager(
                brainSmithUser,
                sueSmithUser,
                shawnSmithUser
        );
    }
}

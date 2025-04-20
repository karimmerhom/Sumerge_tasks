package com.example.task_1.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return User.withUsername("user")
                    .password("{noop}password")
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}

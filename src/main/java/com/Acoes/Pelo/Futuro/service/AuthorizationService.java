package com.Acoes.Pelo.Futuro.service;

import com.Acoes.Pelo.Futuro.repository.UserReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserReository userReository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userReository.findByLogin(username);
    }
}

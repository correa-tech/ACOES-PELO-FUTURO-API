package com.Acoes.Pelo.Futuro.repository;

import com.Acoes.Pelo.Futuro.Model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserReository extends JpaRepository<Users, Long> {

    UserDetails findByLogin(String login);


    
}

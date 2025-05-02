package com.Acoes.Pelo.Futuro.controller;


import com.Acoes.Pelo.Futuro.DTO.AutentificationDTO;
import com.Acoes.Pelo.Futuro.DTO.LoginResponseDTO;
import com.Acoes.Pelo.Futuro.DTO.RegisterDTO;
import com.Acoes.Pelo.Futuro.Model.users.Users;
import com.Acoes.Pelo.Futuro.infra.security.TokenServices;
import com.Acoes.Pelo.Futuro.repository.UserReository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutentificationController {

    @Autowired
    TokenServices tokenServices;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserReository userReository;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AutentificationDTO data){
        var UsernamaPassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(UsernamaPassword);




        var token = tokenServices.generateToken((Users) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO data){
        if(this.userReository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptePassword =  new BCryptPasswordEncoder().encode(data.password());
        Users newUser = new Users(data.login(), encryptePassword, data.role());

        this.userReository.save(newUser);

        return ResponseEntity.ok().build();
    }
}

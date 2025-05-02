package com.Acoes.Pelo.Futuro.DTO;

import com.Acoes.Pelo.Futuro.Model.users.UsersEnums;

public record RegisterDTO(String login, String password, UsersEnums role) {


}

package com.Acoes.Pelo.Futuro.Model.users;

public enum UsersEnums {
    ADMIN("admin"),
    USER("user");

    private String role;

    UsersEnums (String role){
        this.role = role;
    }

    public String getRole (){
        return role;
    }

}

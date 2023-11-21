package com.marcos.desenvolvimento.authapi.models;

public enum UserRoles {

    ADMIN("admin"),
    USER("user");

    private String role;

    UserRoles(String role){
        this.role  = role;
    }

    public String getrRole(){
        return role;
    }



}

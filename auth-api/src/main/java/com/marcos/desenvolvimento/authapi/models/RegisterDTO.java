package com.marcos.desenvolvimento.authapi.models;

public record RegisterDTO (String login, String password, UserRoles role){
}

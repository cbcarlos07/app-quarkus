package br.britosoftware.service;

import br.britosoftware.dto.User;
import br.britosoftware.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped

public class UserService {
    private final List<User> users = new ArrayList<>();

    public UserService(){
        users.add( new User(UUID.randomUUID(), "Carlos") );
        users.add( new User(UUID.randomUUID(), "Gui") );
    }

    public List<User> getUsers(){
        return this.users;
    }

    public User getUser(String name){
        return users.stream().filter(u -> u.getNome().toLowerCase().equals(name)).findFirst().orElse(new User(UUID.randomUUID(), "Usuario encontrado"));
    }

    public User insertUser(User userParam){
        //UserEntity.findAll();
        User user = new User( UUID.randomUUID(), userParam.getNome() );
        users.add( user );
        return user;
    }
}

package com.api.crud.service;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepositories;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //inyeccion de dependecias
    IUserRepositories userRepositories;

    public ArrayList<UserModel> getUsers(){
    return (ArrayList<UserModel>) userRepositories.findAll();//buscar todos
    }

    public UserModel saveUser (UserModel user) {
        return userRepositories.save(user);
    }
    public Optional<UserModel> getById(Long id) {
        return userRepositories.findById(id);
    }

    public UserModel updateById(UserModel request,  Long id){
       UserModel user = userRepositories.findById(id).get();
       user.setFirstName(request.getFirstName());
       user.setLastName(request.getLastName());
       user.setEmail(request.getEmail());
       return user;
    }

    public Boolean deleteUser (Long id){
        try{
            userRepositories.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

}

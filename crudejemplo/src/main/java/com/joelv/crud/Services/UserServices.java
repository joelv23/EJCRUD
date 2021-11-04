package com.joelv.crud.Services;


import com.joelv.crud.Model.User;
import com.joelv.crud.Repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepo;

    @Transactional(readOnly = true)
    public List<User> obtUsers(){

        return (List<User>) userRepo.findAll();
    }

    @Transactional
    public User saveUser(User user){

        return userRepo.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> obtPorId(Long id){

        return userRepo.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> obtPorName(String nombre)
    {
        return (List<User>) userRepo.findByNombre(nombre);
    }

    public boolean deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}

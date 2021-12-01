package com.joelv.crud.services;

import com.joelv.crud.model.User;
import com.joelv.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepo;

    public UserServices(UserRepository repository) {
    }

    public ArrayList<User> obtUsers() {
        return (ArrayList<User>) userRepo.findAll();
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> obtPorId(Long id) {
        return userRepo.findById(id);
    }

    public ArrayList<User> obtPorName(String nombre) {
        return (ArrayList<User>) userRepo.findByNombre(nombre);
    }

    public boolean deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}

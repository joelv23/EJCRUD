package com.joelv.crud.services;

import com.joelv.crud.modelo.Usuario;
import com.joelv.crud.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    UserRepository userRepo;

    public ArrayList<Usuario> obtUsers(){
        return (ArrayList<Usuario>) userRepo.findAll();
    }

    public Usuario saveUser(Usuario user){
        return userRepo.save(user);
    }

    public Optional<Usuario> obtPorId(Long id){
        return userRepo.findById(id);
    }

    public ArrayList<Usuario> obtPorName(String nombre){
        return (ArrayList<Usuario>) userRepo.findByNombre(nombre);
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

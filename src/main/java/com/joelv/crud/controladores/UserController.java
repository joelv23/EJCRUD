package com.joelv.crud.controladores;

import com.joelv.crud.modelo.Usuario;
import com.joelv.crud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping("users")
    public ArrayList<Usuario> obtUser(){
        return userService.obtUsers();
    }

    @PostMapping("/register")
    public Usuario saveUser(@RequestBody Usuario user){
        return this.userService.saveUser(user);
    }

    @GetMapping( path = "/{id}")
    public Optional<Usuario> obtUserPorId(@PathVariable("id") Long id){
        return this.userService.obtPorId(id);
    }

    @GetMapping( path = "/query")
    public ArrayList<Usuario> obtUserPorName(@RequestParam("nombre") String nombre){
        return this.userService.obtPorName(nombre);
    }
    @DeleteMapping( path = "/{id}")
    public String deletePorId(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "Se elimino el usuario con id " + id;
        }else {
            return "No se pudo eliminar el usuario con id" + id;
        }
    }

}

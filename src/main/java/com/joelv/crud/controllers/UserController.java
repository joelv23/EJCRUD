package com.joelv.crud.controllers;

import com.joelv.crud.model.User;
import com.joelv.crud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userService;

    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<User> obtUser() {
        return userService.obtUsers();
    }

    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> obtUserPorId(@PathVariable("id") Long id) {
        return this.userService.obtPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<User> obtUserPorName(@RequestParam("nombre") String nombre) {
        return this.userService.obtPorName(nombre);
    }

    @DeleteMapping(path = "/{id}")
    public String deletePorId(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "Se elimino el usuario con id " + id;
        } else {
            return "No se pudo eliminar el usuario con id" + id;
        }
    }

}

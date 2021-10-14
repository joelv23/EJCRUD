package Controladores;


import Modelo.Usuario;
import Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServices userService;

    //Listar todos los Users
    @GetMapping("users")
    public List<Usuario> obtUser(){
        return this.userService.obtUsers();
    }

    // Crear User
    @PostMapping("/register")
    public ResponseEntity<Usuario> saveUser(@RequestBody Usuario user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @GetMapping( path = "/{id}")
    public ResponseEntity<Optional<Usuario>> obtUserPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.obtPorId(id));
    }

    //Listar por parametro "nombre"
    @GetMapping( path = "/query")
    public ResponseEntity<ArrayList<Usuario>> obtUserPorName(@RequestParam("nombre") String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(userService.obtPorName(nombre));
    }

    //Borrar por id
    @DeleteMapping( path = "/{id}")
    public String deletePorId(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "Se elimino el usuario con id " + id;
        }else {
            return "No se pudo eliminar el usuario con id" + id;
        }
    }

    //Borrar por id
   /* @DeleteMapping( path = "/{id}")
    public ResponseEntity<String> deletePorId(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id))
            "Se elimino el usuario con id " + id;
        }else {
            return "No se pudo eliminar el usuario con id" + id;
        }
    }
    */

}

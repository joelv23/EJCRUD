package com.joelv.crud;

import com.joelv.crud.Model.User;

import java.util.Optional;

public class Datos {
    //  public static User USER_1 = new User(1L,"Jorge", "Lara", "jlara@acl.cl");

    public static Optional<User> newUser01(){
        return Optional.of(new User(1L, "Juan", "Perez","jperez@acl.cl"));
    }
}

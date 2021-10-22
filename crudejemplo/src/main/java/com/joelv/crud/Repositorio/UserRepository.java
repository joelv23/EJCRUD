package com.joelv.crud.Repositorio;

import com.joelv.crud.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.AbstractList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public AbstractList<User> findByNombre(String nombre);
}

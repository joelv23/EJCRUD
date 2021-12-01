package com.joelv.crud.repository;

import com.joelv.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.AbstractList;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    AbstractList<User> findByNombre(String nombre);
}

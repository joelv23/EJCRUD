package com.joelv.crud.repositorio;

import com.joelv.crud.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.AbstractList;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    AbstractList<Usuario> findByNombre(String nombre);
}

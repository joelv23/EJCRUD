package Repositorio;

import Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.AbstractList;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
    public AbstractList<Usuario> findByNombre(String nombre);
}

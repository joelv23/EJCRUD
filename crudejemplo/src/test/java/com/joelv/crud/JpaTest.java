package com.joelv.crud;

import com.joelv.crud.Exception.ResourceNotFoundException;
import com.joelv.crud.Model.User;
import com.joelv.crud.Repositorio.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class JpaTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void testFindById(){
        Optional<User> user = userRepository.findById(1L);
        assertTrue(user.isPresent());
        //assertEquals("Juan", user.orElseThrow().getNombre());
    }
    @Test
    void testFindAll(){
        List<User> users = userRepository.findAll();
        assertFalse(users.isEmpty());
        assertEquals(1,users.size());
    }

    @Test
    void TestSave(){
        //GIVEN
        User userJuan = new User(null, "Juan", "Lara", "juanla@acl.cl");


        //HWEN
        User user =  userRepository.save(userJuan);
        //AbstractList<User> user = userRepository.findByNombre("Juan");
        // User user = userRepository.findById(save.getId()).orElseThrow();

        //THEN
        assertEquals("Juan", user.getNombre());

    }

    @Test
    void TestUpdate(){
        //GIVEN
        User userJuan = new User(null, "Juan", "Lara", "juanla@acl.cl");


        //HWEN
        User user =  userRepository.save(userJuan);
        //AbstractList<User> user = userRepository.findByNombre("Juan");
        // User user = userRepository.findById(save.getId()).orElseThrow();

        //THEN
        assertEquals("Juan", user.getNombre());

        user.setNombre("Pedro");
        User userUpdate = userRepository.save(user);

        assertEquals("Pedro", userUpdate.getNombre());


    }

    @Test
    void TestDelete(){
       //User user = userRepository.findById(1L).orElseThrow();
       // assertEquals("Juan", user.getNombre());

       // userRepository.delete(user);

      //  assertThrows(ResourceNotFoundException.class, ()->{
       //     userRepository.findByNombre("Juan");
        //});

    }
}

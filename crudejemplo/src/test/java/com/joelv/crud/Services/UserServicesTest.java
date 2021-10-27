package com.joelv.crud.Services;

import com.joelv.crud.Model.User;
import com.joelv.crud.Repositorio.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.joelv.crud.Datos.*;
import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {

    @MockBean
    UserRepository repository;

    @Autowired
    UserServices services;


    @BeforeEach
    void setUp(){
        //repository = mock(UserRepository.class);
        //services = new UserServices(repository);
    }



    @Test
    void obtUsers() {
        //when(repository.findAll()).thenReturn((List<Datos>));

        //given
        List<User> dates = Arrays.asList(newUser01().get());
        when(services.obtUsers()).thenReturn((ArrayList<User>) dates);

        //when
        List<User> users = services.obtUsers();



        //then

        assertFalse(users.isEmpty());
        assertEquals(2, users.size());
        assertTrue(users.contains(newUser01().get()));

        verify(repository).findAll();


    }

    @Test
    void saveUser() {
        User userJ = new User(null, "Juan" , "Lara"
                , "jlara@acl.cl");

        when(repository.save(any())).then(invocation ->{
            User u = invocation.getArguments(0);
            u.setId(2L);
            return u;
        });

        //when

        User user = services.saveUser(userJ);

        //then
        assertEquals("Juan", user.getNombre());
        assertEquals(2, user.getId());
        assertEquals("Lara", user.getApellido());
        assertEquals("jlara@acl.cl", user.getEmail());

        verify(repository.save(any()));
    }

    @Test
    void obtPorId() {
        //GIVEN
        //  when(repository.findById(1L)).thenReturn(newUser01());

        //WHEN
        // Optional<User> userId = services.obtPorId(1L);
        // assertEquals(1, userId.toString());
    }

    @Test
    void obtPorName() {


    }

    @Test
    void deleteUser() {
    }
}
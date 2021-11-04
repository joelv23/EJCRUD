package com.joelv.crud.Services;

import com.joelv.crud.Model.User;
import com.joelv.crud.Repositorio.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.joelv.crud.Datos.*;
import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServices services;

    private User user;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setId(new Long(1));
        user.setNombre("Juan");
        user.setApellido("Perez");
        user.setEmail("jperez@acl.cl");

    }

    @Test
    void obtUsers() {
        when(repository.findAll()).thenReturn(Arrays.asList(user));
        assertNotNull(services.obtUsers());
        verify(repository).findAll();

    }

    @Test
    void saveUser() {

        when(repository.save(any(User.class))).thenReturn(user);
        assertNotNull(services.saveUser(new User()));

    }

    @Test
    void obtPorId() {
        //given
           when(repository.findById(1L)).thenReturn(newUser01());
           assertNotNull(services.obtPorId(1L));

    }

    @Test
    void obtPorName() {
        //given
        //when(repository.findByNombre("Juan")).thenReturn((List<User>) user);
        //assertEquals("Juan", "Juan", user.getNombre());

    }

    @Test
    void deleteUser() {



    }
}







//obtusers

//given
// List<User> dates = Arrays.asList(newUser01().get());
// when(services.obtUsers()).thenReturn((ArrayList<User>) dates);

//when
// List<User> users = services.obtUsers();



//then

// assertFalse(users.isEmpty());
// assertEquals(2, users.size());
// assertTrue(users.contains(newUser01().get()));

// verify(repository).findAll();

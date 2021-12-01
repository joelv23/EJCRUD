package com.joelv.crud.services;

import com.joelv.crud.model.User;

import com.joelv.crud.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static com.joelv.crud.Datos.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {

    @MockBean
    UserRepository repository;

    @Autowired
    UserServices services;


    @BeforeEach
    void setUp() {
        //repository = mock(UserRepository.class);
        //services = new UserServices(repository);
    }


    @Test
    void obtUsers() {
        //when(repository.findAll()).thenReturn((List<Datos>));


    }

    @Test
    void saveUser() {
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
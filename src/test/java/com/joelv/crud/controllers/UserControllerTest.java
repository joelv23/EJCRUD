package com.joelv.crud.controllers;

import static com.joelv.crud.Datos.*;

import com.joelv.crud.model.User;
import com.joelv.crud.repository.UserRepository;
import com.joelv.crud.services.UserServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserServices userServices;

    @Test
    void obtUser() {

    }


    @Test
    void saveUser() {

    }

    @Test
    void obtUserPorId() {
        when(userServices.obtPorId(1L)).thenReturn(newUser01().orElseThrow());
    }

    @Test
    void obtUserPorName() {
    }

    @Test
    void deletePorId() {
    }
}
package com.joelv.crud.Controllers;

import com.joelv.crud.Services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.joelv.crud.Datos.newUser01;
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
     //   when(userServices.obtPorId(1L)).thenReturn(newUser01().orElseThrow());
    }

    @Test
    void obtUserPorName() {
    }

    @Test
    void deletePorId() {
    }
}
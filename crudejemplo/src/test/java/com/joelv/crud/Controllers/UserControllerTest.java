package com.joelv.crud.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joelv.crud.Exception.ResourceNotFoundException;
import com.joelv.crud.Model.User;
import com.joelv.crud.Repositorio.UserRepository;
import com.joelv.crud.Services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static com.joelv.crud.Datos.newUser01;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserServices userServices;

    User user;

    ObjectMapper mapper;


    @Test
    void obtUser() {
        //given
        List<User> dates = Arrays.asList(newUser01().get());
        when(userServices.obtUsers()).thenReturn((ArrayList<User>) dates);

        //when
        List<User> users = userServices.obtUsers();

       // try {
         //   mvc.perform(get("/api/users").contentType(MediaType.APPLICATION_JSON))
           //         .andExpect(status().isOk())
             //       .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               //     .andExpect(jsonPath("$[0].id").value(1))
                 //   .andExpect(jsonPath("$[1].nombre").value("Juan"))
               //     .andExpect(jsonPath("$[2].apellido").value("Lara"))
                //    .andExpect(jsonPath("$[3].email").value("jlara@acl.cl"))
                 //   .andExpect(jsonPath("$", hasSize(4)))
                 //   .andExpect(content().json(mapper.writeValueAsString(users)));
       // } catch (Exception e) {
        //    e.printStackTrace();
       // }

        //then

        assertFalse(users.isEmpty());
        assertEquals(2, users.size());
        assertTrue(users.contains(newUser01().get()));

        verify(userRepository).findAll();
    }
    //    when(userServices.obtUsers).thenReturn(Arrays.asList(user));
    //            try {
    //            mvc.perform(get("/api/users"))
    //                    .andExpect(status().isOk())
    //                    .andDo(print())
    //                    .andExpect(content().string(containsString(user.getNombre())));
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }

    @Test
    void saveUser() throws Exception {

        User user;
        user = new user(null, "Juan", "Lara", "jlara@acl.cl");
        when(userServices.saveUser(any())).then(invocation -> {
            User u = invocation.getArguments(0);
            u.setId(2L);
            return u;

        });

        mvc.perform(post("api/users").contentType(MediaType.APPLICATION_JSON))
                .content(mapper.writeValueAsString(user))
                .andExpect(status().isCreated()).andExpect(content()
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.nombre", is("Juan")))
                .andExpect(jsonPath("$.apellido", is("Lara")))
                .andExpect(jsonPath("$.email", is("jlara@acl.cl")));

        verify(userServices).saveUser(any());
        }


      //  when(userServices.saveUser(any(User.class))).thenReturn(user);
       // try {
       // mvc.perform(post("/api/users").with(csrf())
        //        .content(asJsonString(user))
         //       .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
          //      .accept(MediaType.APPLICATION_JSON))
           //     .andExpect(status().isOk())
            //    .andDo(print())
             //   .andExpect(content().string(containsString(user.getNombre())));

   // } catch (Exception e) {
     //   e.printStackTrace();
   // }
    //    public static String asJsonString(final Object obj) {
    //        try {
    //            return new ObjectMapper().writeValueAsString(mapper);
    //        } catch (Exception e) {
    //            throw new RuntimeException(e);
     //       }
     //   }
        @Test
        void obtUserPorId () throws Exception {
            //given
            //   when(userServices.obtPorId(1L)).thenReturn(newUser01().orElseThrow());

            //When
            mvc.perform(get("/api/users/1").contentType(MediaType.APPLICATION_JSON))
                    //THEN
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.nombre").value("Juan"))
                    .andExpect(jsonPath("$.apellido").value("Lara"))
                    .andExpect(jsonPath("$.email").value("jlara@acl.cl"));
            verify(userServices).obtPorId(1L);
        }

       // try {
       //     when(userServices.obtPorId(1)).thenReturn(user);
       //     try {
       //         mvc.perform(get("/api/users/id/1"))
       //                 .andExpect(status().isOk())
       //                 .andDo(print())
       //                 .andExpect(content().string(containsString(user.getNombre())));
       //         verify(userServices, times(1)).obtPorId(1);
       //         verifyNoMoreInteractions(userServices);
       //     } catch (Exception e) {
       //         e.printStackTrace();
       //     }
       // } catch (
       //     ResourceNotFoundException e) {
       //     e.printStackTrace();
       // }

        @Test
        void obtUserPorName () throws Exception {
            //given
               when(userServices.obtPorName("Juan")).thenReturn(newUser01().get());

            //When
            mvc.perform(get("/api/users/").contentType(MediaType.APPLICATION_JSON))
                    //THEN
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").value(1))
                    .andExpect(jsonPath("$.nombre").value("Juan"))
                    .andExpect(jsonPath("$.apellido").value("Lara"))
                    .andExpect(jsonPath("$.email").value("jlara@acl.cl"));
            verify(userServices).obtPorId(1L);
        }

        //try {
        //    when(userServices.obtPorName("Juan")).thenReturn(user);
        //         RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users", "Juan"); // with id url path = 3
            // Http Response Checking
        //        ResultMatcher expextedStatus = MockMvcResultMatchers.status().is(HttpStatus.OK.value()); // status = 200
            // Controller Test
        //    try {
        //        mvc.perform(requestBuilder).andExpect(expextedStatus)
        //                .andExpect(status().isOk())
        //                .andDo(print());
                //.andExpect(content().string(containsString(client)));
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //    }
       // } catch (ResourceNotFoundException e) {
       //     e.printStackTrace();
       // }
        @Test
        void deletePorId () {
           // try {
           //     when(userServices.deleteUser(1)).thenReturn(user);
           //     try {
           //         mvc.perform(MockMvcRequestBuilders
           //                 .delete("/api/users/id").with(csrf())
           //                 .contentType(MediaType.APPLICATION_JSON)
           //                 .accept(MediaType.APPLICATION_JSON))
           //                 .andExpect(status().isOk());
           //     } catch (Exception e) {
           //         e.printStackTrace();
           //     }
           // } catch (ResourceNotFoundException e) {
           //     e.printStackTrace();
           // }
        }


    }

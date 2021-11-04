package com.joelv.crud.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joelv.crud.Exception.ResourceNotFoundException;
import com.joelv.crud.Model.User;
import com.joelv.crud.Repositorio.UserRepository;
import com.joelv.crud.Services.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

import static com.joelv.crud.Datos.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @MockBean
    UserServices userServices;

    private User user;

    @Autowired
    ObjectMapper mapper;


    @BeforeEach
    void setUp(){
        //New user
        user = new User();
        user.setId(1L);
        user.setNombre("Juan");
        user.setApellido("Perez");
        user.setEmail("jperez@acl.cl");
    }


    @Test
    void obtUser() {
          Mockito.when(userServices.obtUsers()).thenReturn(Arrays.asList(user));
               try {
                mvc.perform(get("/api/users/users"))
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andExpect(content().string(containsString(user.getNombre())));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    @Test
    void saveUser() throws Exception {

          when(userServices.saveUser(any(User.class))).thenReturn(user);
          try {
            mvc.perform(post("/api/users/save")
                .content(asJsonString(user))
                //.content(mapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(content().string(containsString(user.getNombre())));



          } catch (Exception e) {
               e.printStackTrace();
          }
        verify(userServices).saveUser(any());
    }

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
        void obtUserPorId() throws Exception {
            //given
               when(userServices.obtPorId(1L)).thenReturn(java.util.Optional.of(newUser01().get()));

            //When
            mvc.perform(get("/api/users/1").contentType(MediaType.APPLICATION_JSON))
                    //THEN
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.nombre").value("Juan"))
                    .andExpect(jsonPath("$.apellido").value("Perez"))
                    .andExpect(jsonPath("$.email").value("jperez@acl.cl"));
            verify(userServices).obtPorId(1L);
        }

        @Test
        void obtUserPorName() throws Exception {
            //given
            // List<User> list = Arrays.asList(newUser01().get());
            // when(userServices.obtUsers()).thenReturn((ArrayList<User>) list);

            //when
           // List<User> use = userServices.obtPorName("Juan");

            //When
            // mvc.perform(get("/api/users/query").contentType(MediaType.APPLICATION_JSON))
                    //THEN
           //         .andExpect(status().isOk())
           //         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
           //         .andExpect(jsonPath("$.id").value(1))
           //         .andExpect(jsonPath("$.nombre").value("Juan"))
           //         .andExpect(jsonPath("$.apellido").value("Perez"))
           //         .andExpect(jsonPath("$.email").value("jperez@acl.cl"));
           //   verify(userServices).obtPorName("Juan");



           //   ArrayList<User> list = Arrays.asList(newUser01().get());
          //    when(userServices.obtPorName("Juan")).thenReturn((List<User>) user);
           //      RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/query", "Juan");
                 //Http Response Checking
           //     ResultMatcher expextedStatus = status().is(HttpStatus.OK.value());
                //Controller Test;
          //      mvc.perform(requestBuilder).andExpect(expextedStatus)
            //            .andExpect(status().isOk())
             //           .andDo(print());
                        //.andExpect(content().string(containsString(String.valueOf(user))));

        }
        @Test
        void deletePorId () throws Exception {

                when(userServices.deleteUser(1L)).thenReturn(true);

                    mvc.perform(MockMvcRequestBuilders
                            .delete("/api/users/2")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk());

        }

    }








//obtusers

//given
//   List<User> dates = Arrays.asList(newUser01().get());
//   when(userServices.obtUsers()).thenReturn((ArrayList<User>) dates);

//when
//   List<User> users = userServices.obtUsers();

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

// assertFalse(users.isEmpty());
// assertEquals(2, users.size());
// assertTrue(users.contains(newUser01().get()));

// verify(userRepository).findAll();


//saveuser

//  user = new User(null, "Juan", "Perez", "jperez@acl.cl");
//  when(userServices.saveUser(any())).then(invocation -> {
//  user = invocation.getArguments(0);
//  user.setId(2L);
//  return user;

//   });


//    mvc.perform(post("api/users/save").contentType(MediaType.APPLICATION_JSON))
//            .content(mapper.writeValueAsString(user))
//            .andExpect(status().isCreated()).andExpect(content()
//            .contentType(MediaType.APPLICATION_JSON))
//           .andExpect(jsonPath("$.id", is(2)))
//          .andExpect(jsonPath("$.nombre", is("Juan")))
//         .andExpect(jsonPath("$.apellido", is("Perez")))
//        .andExpect(jsonPath("$.email", is("jperez@acl.cl")));

//        verify(userServices).saveUser(any());
//}



//obtporid

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
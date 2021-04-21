package com.epam.cinema.controllers;

import com.epam.cinema.controllers.assemblers.UserAssembler;
import com.epam.cinema.controllers.models.UserModel;
import com.epam.cinema.dtos.UserDto;
import com.epam.cinema.services.UserService;
import com.epam.cinema.test.config.TestConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.epam.cinema.test.util.TestDataUtil.TEST_EMAIL;
import static com.epam.cinema.test.util.TestDataUtil.createUserDTO;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@Import(TestConfig.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserAssembler userAssembler;

//    @MockBean
//    private UserValidator userValidator;

    @Test
    void getUserTest() throws Exception {
        UserDto userDTO = createUserDTO();
        UserModel userModel = new UserModel(userDTO);

        when(userService.getUser(TEST_EMAIL)).thenReturn(userDTO);
        when(userAssembler.toModel(userDTO)).thenReturn(userModel);

        mockMvc.perform(get("/api/v1/users/" + TEST_EMAIL))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value(TEST_EMAIL));
    }

    @Test
    void createUserTest() throws Exception {
        UserDto userDTO = createUserDTO();
        UserModel userModel = new UserModel(userDTO);

        when(userService.createUser(Mockito.any(UserDto.class))).thenReturn(userDTO);
        when(userAssembler.toModel(userDTO)).thenReturn(userModel);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userModel);

        mockMvc.perform(post("/api/v1/users")
                .content(requestJson)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void updateUserTest() throws Exception {
        UserDto userDTO = createUserDTO();
        UserModel userModel = new UserModel(userDTO);

        when(userService.updateUser(Mockito.any(UserDto.class), Mockito.anyString())).thenReturn(userDTO);
        when(userAssembler.toModel(userDTO)).thenReturn(userModel);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userModel);

        mockMvc.perform(put("/api/v1/users/" + TEST_EMAIL)
                .content(requestJson)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteUserTest() throws Exception {
        UserDto userDTO = createUserDTO();
        when(userService.createUser(Mockito.any(UserDto.class))).thenReturn(userDTO);

        mockMvc.perform(delete("/api/v1/users/" + userDTO.getEmail())
                .contentType(APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());

    }

    @Test
    void getAllUsersTest() throws Exception {
        List<UserDto> userDtos = new ArrayList<>();

        UserDto userDTO = createUserDTO();
        UserDto userDTO1 = createUserDTO();

        userDtos.add(userDTO);
        userDtos.add(userDTO1);

        when(userService.getAllUsers()).thenReturn(userDtos);

        mockMvc.perform(get("/api/v1/users/all"))
                .andDo(print())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
package com.apitemplate.security.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void SignIn_ShouldReturn_200() throws Exception {

        JSONObject json = new JSONObject();
        json.put("username", "default");
        json.put("password", "password");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signin").
                        content(String.valueOf(json)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void SignUp_ShouldReturn_200() throws Exception {


        JSONObject json = new JSONObject();
        json.put("username", "user200");
        json.put("email", "user200@gmail.com");
        json.put("password", "password");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signup").
                        content(String.valueOf(json)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void Logout_ShouldReturn_200() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/auth/logout")).andExpect(status().is3xxRedirection());

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/auth/logoutSuccess")).andExpect(status().isOk());

    }

    @Test
    public void UpdateShouldReturn_200() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/general/2")
                .content("test").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void findByIdShouldReturn_200() throws Exception {
        this.mockMvc.perform(get("/api/general/3")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("This is get by Id 3"));
    }


}

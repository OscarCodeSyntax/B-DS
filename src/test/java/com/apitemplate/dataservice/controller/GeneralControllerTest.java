package com.apitemplate.dataservice.controller;

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

//Best way to test. Uses the full stack, its logic and processes - MockMvc
@SpringBootTest
@AutoConfigureMockMvc
public class GeneralControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void FindAllShouldReturnString_200() throws Exception {
        this.mockMvc.perform(get("/api/general")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("[\"this\",\"is\",\"find\",\"all\"]"));
    }

    @Test
    public void DeleteShouldReturn_200() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/general/2"))
                .andExpect(status().isOk());
    }

    @Test
    public void CreateShouldReturn_200() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/general")
                .content("test").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

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
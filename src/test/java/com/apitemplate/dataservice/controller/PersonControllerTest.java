package com.apitemplate.dataservice.controller;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void FindAll_ShouldReturnArrayOfPeople_200() throws Exception {
        this.mockMvc.perform(get("/api/person")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void FindById_ShouldReturnPersonId_200() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/person/654b49ebe3f26e4978644617"))
                .andExpect(status().isOk());
    }

    @Test
    public void CreatePerson_ShouldReturn_200() throws Exception {

        JSONObject json = new JSONObject();
        json.put("name", "barry");
        json.put("age", 21);


        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/person")
                .content(String.valueOf(json)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void UpdatePersonName_ShouldReturn_200() throws Exception {

        JSONObject json = new JSONObject();
        json.put("name", "barry");
        json.put("age", 21);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/person/Chuckie")
                    .content(String.valueOf(String.valueOf(json))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void UpdatePersonAge_ShouldReturn_200() throws Exception {

        JSONObject json = new JSONObject();
        json.put("name", "barry");
        json.put("age", 21);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/person/Chuckie")
                .content(String.valueOf(String.valueOf(json))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
}

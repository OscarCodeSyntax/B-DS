package com.apitemplate.dataservice;

import static org.assertj.core.api.Assertions.assertThat;

import com.apitemplate.dataservice.controller.APIController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private APIController controller;

    //Assert that the APIController loads
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}

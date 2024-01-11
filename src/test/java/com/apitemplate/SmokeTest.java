package com.apitemplate;

import static org.assertj.core.api.Assertions.assertThat;

import com.apitemplate.dataservice.controller.GeneralController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private GeneralController controller;

    //Assert that the APIController loads
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}

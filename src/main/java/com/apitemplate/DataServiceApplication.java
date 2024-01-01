package com.apitemplate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class DataServiceApplication {

    private static final Log log = LogFactory.getLog(DataServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DataServiceApplication.class, args);
    }

}
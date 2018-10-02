/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fwgreeter;

/**
 *
 * @author Dylan.Lynch
 */

import com.mycompany.fwgreeter.Configuration.Configuration;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /**
     * This is the entry point of the application. It is configured to run 
     * On a port entered by the user after the jar(first command-line option entered).
     * @param args
     */
    public static void main(String[] args) {
        Configuration config  = new Configuration();
        config.setPort(args);
//        SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", config.getPort()));
        app.run(args);
    }
}
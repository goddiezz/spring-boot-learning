package com.potatorice.boot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author loorzve
 */
@SpringBootApplication
@EnableOpenApi
@ImportResource(locations = {"classpath:beans.xml"})
public class SpringBootBasicApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringBootBasicApplication.class, args);
    }
}

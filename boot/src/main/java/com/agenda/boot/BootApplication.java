package com.agenda.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@ComponentScan({"com.agenda.restapi", "com.agenda.restapiimpl",
//        "com.agenda.serviceapi", "com.agenda.serviceapiimpl"})
//

@ComponentScan({"com.agenda.*"})
@EnableJpaRepositories({"com.agenda.model.repository"})
@EntityScan({"com.agenda.model.entity"})
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}

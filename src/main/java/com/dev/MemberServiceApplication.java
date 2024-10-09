package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ComponentScan
@EnableJpaAuditing
@SpringBootApplication
public class MemberServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(MemberServiceApplication.class, args);

    }

}

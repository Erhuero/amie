package com.mgen.amie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@CrossOrigin
@EnableSwagger2
@ComponentScan(basePackages = {"com.mgen.amie", "com.mgen.amie.service"})
public class AmieApplication {

    public static void main(String[] args) {SpringApplication.run(AmieApplication.class, args);}

    @Configuration
    public class AppConfig {

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

}
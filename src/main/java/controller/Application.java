package controller;

//import DL.UserRepository;
import DL.*;
import Service.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"domain","DL","controller"})
@EnableJpaRepositories(basePackages = { "domain","DL","controller"})
@EntityScan(basePackages ={ "domain"})

@ComponentScan(basePackageClasses = UserController.class)
@ComponentScan(basePackageClasses = UserService.class)
@ComponentScan(basePackageClasses = UserRepository.class)
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

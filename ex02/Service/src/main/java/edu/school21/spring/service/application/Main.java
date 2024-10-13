package edu.school21.spring.service.application;

import edu.school21.spring.service.config.ApplicationConfig;
import edu.school21.spring.service.services.UsersService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UsersService usersRepository = context.getBean("usersServiceImpl", UsersService.class);
    }
}

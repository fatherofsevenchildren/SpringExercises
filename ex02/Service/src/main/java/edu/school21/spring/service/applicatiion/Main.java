package edu.school21.spring.service.applicatiion;

import edu.school21.spring.service.config.ApplicationConfig;
import edu.school21.spring.service.repositories.UsersRepository;
import edu.school21.spring.service.services.UsersService;
import edu.school21.spring.service.services.UsersServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UsersService usersRepository = context.getBean("usersServiceImpl", UsersService.class);
    }
}

package edu.school21.spring.service.services;

import edu.school21.spring.service.config.TestApplicationConfig;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UsersServiceImplTest {

    private static UsersService usersService;

    @BeforeAll
    static void init() {
        var context = new AnnotationConfigApplicationContext(TestApplicationConfig.class);
        usersService = context.getBean("usersServiceImpl", UsersService.class);
    }

    @org.junit.jupiter.api.Test
    void signUp() {
        String password = usersService.signUp("kudienko");
        assertNotNull(password);
    }
}
package edu.school21.spring.service.applicatiion;

import edu.school21.spring.service.models.User;
import edu.school21.spring.service.repositories.UserRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserRepository userRepository = context.getBean("usersRepositoryJdbc", UserRepository.class);
        User user2 = new User(10, "kalaka");
        userRepository.save(user2);
        if(userRepository.findByEmail("kalaka").isPresent()) {
            User user = userRepository.findByEmail("kalaka").get();
            System.out.println(user.getId());
        }
    }
}

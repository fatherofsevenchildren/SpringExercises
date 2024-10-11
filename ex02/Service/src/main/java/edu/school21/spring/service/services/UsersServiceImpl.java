package edu.school21.spring.service.services;

import edu.school21.spring.service.models.User;
import edu.school21.spring.service.repositories.UsersRepository;
import edu.school21.spring.service.utilities.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repository;

    @Autowired
    public UsersServiceImpl(@Qualifier("usersRepositoryJdbcTemplate") UsersRepository usersRepository) {
        this.repository = usersRepository;
    }

    @Override
    public String signUp(String email) {
        long id = repository.findAll().size();
        String password = PasswordGenerator.generatePassword();
        repository.save(new User(id, email, password));
        return password;
    }
}

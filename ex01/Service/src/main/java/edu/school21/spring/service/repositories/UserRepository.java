package edu.school21.spring.service.repositories;

import edu.school21.spring.service.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findByEmail(String email);
}

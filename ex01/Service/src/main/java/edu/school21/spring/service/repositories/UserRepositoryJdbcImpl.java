package edu.school21.spring.service.repositories;

import edu.school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

public class UserRepositoryJdbcImpl implements UserRepository {

    private final DataSource dataSource;

    public UserRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM users WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"), email);
            }
        } catch (SQLException e) {
            out.println(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void save(User entity) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO users (email) VALUES (?) RETURNING id";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            out.println(e);
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Long id) {

    }
}

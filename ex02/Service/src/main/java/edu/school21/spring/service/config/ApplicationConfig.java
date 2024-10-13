package edu.school21.spring.service.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan(basePackages = "edu.school21.spring.service")
@PropertySource("classpath:db.properties")
@RequiredArgsConstructor
public class ApplicationConfig {

    private final Environment environment;

    @Bean
    @Primary
    DataSource hikariDataSource() {
        return new HikariDataSource(new HikariConfig("/db.properties"));
    }

    @Bean
    DataSource DriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("dataSourceClassName")));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.user"));
        dataSource.setPassword(environment.getProperty("dataSource.password"));
        return dataSource;
    }
}

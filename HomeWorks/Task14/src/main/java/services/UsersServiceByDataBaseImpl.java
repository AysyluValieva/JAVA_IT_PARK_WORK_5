package services;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import models.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcTemplateImpl;

import java.util.List;

public class UsersServiceByDataBaseImpl implements UsersService {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    private UsersRepository usersRepository;

    public UsersServiceByDataBaseImpl() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);
        this.usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
    }

    @Override
    public List<User> findAllUsersFromDataBase() {
        return usersRepository.findAll();
    }
}
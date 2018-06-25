package services;

import models.User;

import java.util.List;

public interface UsersService {
    List<User>  findAllUsersFromDataBase();
}

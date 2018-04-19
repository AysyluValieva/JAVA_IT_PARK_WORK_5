package com.company.repository;
import com.company.models.User;

public interface UsersRepository {
    int getNewUserId();
    User find(int id);
    void delete(int id);
    void save(User user);
    void update(User user);
}

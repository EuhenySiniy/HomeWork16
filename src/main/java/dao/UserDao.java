package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User findUserById(int id);

    List<User> getAllUsers();
}

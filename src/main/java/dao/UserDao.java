package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    Optional<User> findUserById(int id);

    List<User> getAllUsers();
}

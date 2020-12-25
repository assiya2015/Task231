package web.dao;


import web.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUser(long id);
    void saveUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);
}

package web.dao;


import web.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    User getUser(long id);
    void saveUser(User user);
    void deleteUser(Long id);

    List<User> searchUsers(String theSearchName);
    void updateUser(long id, User user);
}

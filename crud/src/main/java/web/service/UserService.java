package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(long id);
    void saveUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);
}

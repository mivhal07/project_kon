package pl.coderslab.Services;

import pl.coderslab.entities.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
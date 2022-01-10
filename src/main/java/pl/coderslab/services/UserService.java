package pl.coderslab.services;

import pl.coderslab.entities.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
    void saveAdmin(User user);
}
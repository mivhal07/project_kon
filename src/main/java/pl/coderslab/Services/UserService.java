package pl.coderslab.Services;

import pl.coderslab.Entities.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entities.Role;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.RoleRepository;
import pl.coderslab.services.UserService;

import java.util.Arrays;
import java.util.HashSet;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    //testowa
    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        Role userRole = roleRepository.findById(1);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));

        userService.saveAdmin(user);
        return "admin/adminAdded";
    }

}
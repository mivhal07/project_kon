package pl.coderslab.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Dao.RoleDao;
import pl.coderslab.Entities.Role;
import pl.coderslab.Entities.User;
import pl.coderslab.Repositories.RoleRepository;
import pl.coderslab.Services.UserService;

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

        userService.saveUser(user);
        return "admin";
    }

}
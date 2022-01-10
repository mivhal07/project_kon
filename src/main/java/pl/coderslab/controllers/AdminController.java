package pl.coderslab.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.RoleDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.entities.Role;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.RoleRepository;
import pl.coderslab.repositories.UserRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    private final RoleDao roleDao;
    private final UserDao userDao;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminController(RoleDao roleDao, UserDao userDao, UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "admin/add";
    }

    @PostMapping("/add")
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "Admin/addFail";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
        return "admin/adminAdded";
    }

}
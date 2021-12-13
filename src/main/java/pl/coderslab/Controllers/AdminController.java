package pl.coderslab.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Dao.RoleDao;
import pl.coderslab.Dao.UserDao;
import pl.coderslab.Entities.Category;
import pl.coderslab.Entities.Role;
import pl.coderslab.Entities.User;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    private final RoleDao roleDao;
    private final UserDao userDao;

    public AdminController(RoleDao roleDao, UserDao userDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleDao.getAllRoles());
        return "admin/add";
    }

    @PostMapping("/add")
    public String addResult( @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", roleDao.getAllRoles());
            return "admin/addFail";
        }
        userDao.addUser(user);
        return "product/productAdded";
    }

    @ModelAttribute("roles")
    public Collection<Role> roles(){
        return this.roleDao.getAllRoles();
    }
}
package pl.coderslab.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Dao.RoleDao;
import pl.coderslab.Entities.Role;

import javax.validation.Valid;

@Controller
@RequestMapping("/role")
public class RoleController {
    private final RoleDao roleDao;

    public RoleController(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @GetMapping("/add")
    public String addRole(Role role, Model model){
        model.addAttribute("role", new Role());
        return "role/add";
    }

    @PostMapping("/add")
    public String addRoleResult(@Valid Role role, BindingResult result){
        if (result.hasErrors()){
            return "role/addFail";
        }
        roleDao.createRole(role);
        return "role/roleAdded";
    }

}

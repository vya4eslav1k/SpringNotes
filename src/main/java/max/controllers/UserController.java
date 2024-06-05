package max.controllers;

import max.dao.UserDao;
import max.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model){
        User user = userDao.show(id);
        model.addAttribute("user", user);
        return "users/show";
    }

    @GetMapping()
    public String index(, Model model){
        User user = userDao.index(); //TODO finish
        model.addAttribute("user", user);
        return "users/show";
    }
}

package max.controllers;

import max.dao.UserDao;
import max.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDao.show(id));
        return "users/show";
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userDao.index());
        return "users/index";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute User user){
        return "redirect:/users/" + userDao.add(user).getId();
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDao.show(id));
        return "users/update";
    }

    @PatchMapping()
    public String update(@ModelAttribute("user") User user){
        userDao.update(user);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String delete(@ModelAttribute("user") User user){
        userDao.delete(user);
        return "redirect:/users";
    }
}

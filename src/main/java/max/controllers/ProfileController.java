package max.controllers;

import max.dao.NoteDao;
import max.dao.UserDao;
import max.models.Profile;
import max.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/profiles")
public class ProfileController {
    UserDao userDao;
    NoteDao noteDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @GetMapping("/{userId}")
    public String show(@PathVariable("userId") int id, Model model) {
        Profile profile = new Profile(userDao.show(id), noteDao.getByUserId(id));
        model.addAttribute("profile", profile);
        return "profiles/show";
    }

    @GetMapping("{userId}/edit")
    public String edit(@PathVariable("userId") int id, Model model) {
        User user = userDao.show(id);
        model.addAttribute("user", user);
        return "profiles/update";
    }

    @PatchMapping()
    public String update(@ModelAttribute("user") User user) {
        userDao.update(user);
        return "redirect:/profiles/" + user.getId();
    }

    @DeleteMapping("{userId}/delete")
    public String delete(@PathVariable("userId") int id) {
        userDao.delete(userDao.show(id));
       return null; //todo enterPage
    }
}

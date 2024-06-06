package max.controllers;

import max.dao.NoteDao;
import max.dao.UserDao;
import max.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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
}

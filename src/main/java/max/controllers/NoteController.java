package max.controllers;

import max.dao.NoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes")
public class NoteController {
    private int myId = 1; //TODO remove(cmn, its for testing...)
    private NoteDao noteDao;

    @Autowired
    public NoteController(NoteDao noteDao){
        this.noteDao = noteDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("notes", noteDao.index());
        return "notes/index";
    }

//    @GetMapping()
//    public String index(Model model){
//        model.addAttribute("notes", noteDao.index());
//        return "notes/index";
//    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("note", noteDao.show(id));
        return "notes/show";
    }
}

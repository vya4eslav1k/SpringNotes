package max.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @GetMapping()
    public String index(Model model){
         return null; //TODO all notes
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        return null; //TODO one note
    }


}

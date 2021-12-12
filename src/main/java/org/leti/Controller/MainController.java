package org.leti.Controller;

import org.leti.Repo.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    EntryRepo entryRepo;

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        model.put("entries", entryRepo.findAll());
        return "main";
    }
    /*@PostMapping("/main")
    public String addEntry(Model model) {
        model.addAttribute("main_text","Создание проводки");
        return "entryEdit";
    }*/

    //z
}

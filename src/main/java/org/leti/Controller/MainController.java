package org.leti.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        return "main";
    }
    /*@PostMapping("/main")
    public String addEntry(Model model) {
        model.addAttribute("main_text","Создание проводки");
        return "entryEdit";
    }*/
}

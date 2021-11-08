package org.leti.Controller;

import org.leti.Domain.User;
import org.leti.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("message", "На указанную почту придет код активации");

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        if (!userService.addUser(user)) {
            model.put("message", "Логин занят!");
            return "registration";
        }

        model.put("check_mail","Проверьте почту");
        return "redirect:/login";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {

        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message1", "Пользователь успешно активирован!");
        } else
            model.addAttribute("message2", "Код активации не найден");

        return "login";
    }
}

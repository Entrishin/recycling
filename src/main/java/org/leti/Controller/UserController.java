package org.leti.Controller;

import org.leti.Domain.Role;
import org.leti.Domain.User;
import org.leti.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Map<String,Object> model) {
        model.put("users", userService.findAll());

        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{user}")
    public String userEdit(@PathVariable User user, Model model) {
        model.addAttribute("user",user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String saveUser(@RequestParam("userId") User user,
                           @RequestParam String username,
                           @RequestParam Map<String,String> form) {

        userService.saveUser(user,username,form);
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",user.getEmail());
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user, @RequestParam String password, @RequestParam String email, Model model){
        model.addAttribute("username",user.getUsername());
        model.addAttribute("email",email);
        if (!StringUtils.isEmpty(email))
            model.addAttribute("checkMailMsg","???? ?????????????????? ?????????? ???????????? ?????? ??????????????????");

        userService.updateProfile(user,password,email);
        return "profile";
    }



}







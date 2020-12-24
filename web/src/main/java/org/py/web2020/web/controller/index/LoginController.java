package org.py.web2020.web.controller.index;

import org.py.web2020.web.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping({"login"})
    public String index(UserModel user) {
        return "index/login";
    }

    @PostMapping({"login"})
    public String form(@Valid UserModel user, BindingResult result) {
        if (result.hasErrors()) {
            return "index/login";
        }
        return "redirect:/admin";
    }
}

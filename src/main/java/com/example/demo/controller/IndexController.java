package com.example.demo.controller;

import com.example.demo.model.dto.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    UserDto globalUser;

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", globalUser);

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String index(UserDto user, Model model) {

        globalUser.setUser(user.getUser());

        if (StringUtils.isNotBlank(user.getUser())) {
            model.addAttribute("opcion", "Bienvenido " + user.getUser().toUpperCase());
            model.addAttribute("user", user);
            return "index";
        }

        return "redirect:/";
    }

}

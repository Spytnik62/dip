package ru.Tar.diplomTar.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/homePage")
public class HomePageController {

    @GetMapping()
    public String getUserProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("nickname", userDetails.getUsername());
        return "homePage"; // Имя вашего шаблона для личного кабинета
    }
}

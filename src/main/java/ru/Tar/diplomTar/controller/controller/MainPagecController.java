package ru.Tar.diplomTar.controller.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainPagecController {

    @GetMapping("/mainPage")
    private String getPage(){return "mainPage.html";}


}


package com.springweb.web_starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping(path = "/home")
    public String WelcomeHome() {
        return "Welcome home!";
    }
}

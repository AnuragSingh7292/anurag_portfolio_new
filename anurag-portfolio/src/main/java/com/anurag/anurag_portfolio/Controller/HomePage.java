package com.anurag.anurag_portfolio.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomePage {

    @GetMapping({"/", "/home", "/anurag","/portfolio",""})
    public String homePage() {
        return "portfolio";
    }

}

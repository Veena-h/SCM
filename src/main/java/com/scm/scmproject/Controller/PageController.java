package com.scm.scmproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{

    @RequestMapping("/home")
    public String home(Model model)
    {
        model.addAttribute("youtubechannel" ,"https://www.youtube.com");
        model.addAttribute("github" ,"https://www.google.com");
        System.out.println("home page");
        return  "home";
    }

    @RequestMapping("/about")
    public String about()
    {
        System.out.println("about page");
        return "about";

    }

    @RequestMapping("/services")
    public String services()
    {
        System.out.println("services page");
        return "services";

    }

}
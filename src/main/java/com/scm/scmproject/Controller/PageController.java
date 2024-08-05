package com.scm.scmproject.Controller;

import com.scm.scmproject.Services.ServicesImple.UserServicesImple;
import com.scm.scmproject.entities.*;
import com.scm.scmproject.forms.Userform;
import com.scm.scmproject.helpers.Message;
import com.scm.scmproject.helpers.MessageType;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController
{

    @Autowired
    UserServicesImple userServicesImple;


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


    @RequestMapping("/contact")
    public String contact()
    {
        System.out.println("contact page");
        return "contact";

    }



    @RequestMapping("/registration")
    public String registration(Model model)
    {
        System.out.println("registration page");
        Userform userform=new Userform();

        model.addAttribute("userform" ,userform);
        userform.setName("veena");

        return "registration";

    }



    @RequestMapping("/login")
    public String login()
    {
        System.out.println("login page");
        return "login";

    }


    @RequestMapping(value = "/do-register" ,method = RequestMethod.POST)
    public  String Processregister(@ModelAttribute Userform userform, HttpSession session)
    {

        System.out.println("registration started");
        //fetch the data
        //userform
        System.out.println(userform);

        //validate for data


        //save to db
        //convertion userform --> user
//        Users users = Users.builder()
//                .name(userform.getName())
//                .email(userform.getEmail())
//                .password(userform.getPassword())
//                .about(userform.getAbout())
//                .phoneNumber(userform.getPhoneNumber())
//                .profilePic("https://pixabay.com/vectors/blank-profile-picture-mystery-man-973460/")
//                .build();


        Users users=new Users();
        users.setName(userform.getName());
        users.setEmail(userform.getEmail());
        users.setPassword(userform.getPassword());
        users.setAbout(userform.getAbout());
        users.setPhoneNumber(userform.getPhoneNumber());
        users.setProfilePic("https://pixabay.com/vectors/blank-profile-picture-mystery-man-973460/");


        Users users1 = userServicesImple.saveUsers(users);
        System.out.println(users1);

        //show message using http session

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message",message);

        //session.setAttribute("message","Registration Successful");


        //redirect


        return "redirect:/registration";
    }

}

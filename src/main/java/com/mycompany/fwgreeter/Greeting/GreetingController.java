/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fwgreeter.Greeting;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.mycompany.fwgreeter.User.User;
import com.mycompany.fwgreeter.User.UserRepository;


@Controller
public class GreetingController {
    
    @Autowired
    private UserRepository userRepository;
    
    public String visitNumberOfUser;

    //Show the add user form and creates a new oject
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        //Parameter in quotes is used to get values from view
        model.addAttribute("user", new User());
        //Return is the template that is rendered
        return "greeting";
    }
    //Form goes to /greeting but uses POST action this time.
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute User user) {
        //Creates a new user and gets 
        visitNumberOfUser = userRepository.findByFirstLastName(user.getFirstName(), user.getLastName());
        if(visitNumberOfUser != null) {
            user.addVisitNumber(Integer.parseInt(visitNumberOfUser));
            userRepository.addVisitNumber(user.getFirstName(), user.getLastName());
        } else {
            User n = new User();
            n.setVisitNumber(1);
            n.setFirstName(user.getFirstName());
            n.setLastName(user.getLastName());
            user.setVisitNumber(1);
            userRepository.save(n);
        }
        return "result";
    }

    @GetMapping(path="/all")
    public @ResponseBody String getAllUsers() {
        //Grabs all of the neccessary data for constructing the JSON object: first names,
        //last names, visitor count, and information about the visitors
        final String[] firstNames = userRepository.allFirstNames();
	final String[] lastNames = userRepository.allLastNames();
        final Integer totalVisitorCount = userRepository.totalVisitorCount();
        String message;
        JSONObject obj = new JSONObject();
        
        //Concstructing the JSON object
        obj.put("visitorLastNames", lastNames);
        obj.put("visitorFirstNames", firstNames);
        obj.put("totalVisits", totalVisitorCount);
        obj.put("visitors", userRepository.findAll());
        //Converting the JSON object to a string and returning it.
        message = obj.toString();
        // This returns a JSON or XML with the users
        return message;
	//return userRepository.findAll();
    }

}




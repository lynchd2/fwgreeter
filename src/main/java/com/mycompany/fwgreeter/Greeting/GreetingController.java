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

    /**
     * This is the route for the /greeting GET request.
     * @param model Interface that holds the form attributes that the user fills out 
     * @return the "greeting" template
     */
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        //Parameter in quotes is used to get values from view
        model.addAttribute("user", new User());
        return "greeting";
    }
    //Form goes to /greeting but uses POST action this time.

    /**
     * This is the route for the /greeting POST request that creates a user. If
     * the user has never visited(depending on their first and last name), a new
     * user is created in the database and their visit number starts at 1. If a user 
     * has visited before, their information is pulled and their visit number goes
     * up by one.
     * @param user The model attribute that was filled out from the /greeting GET request.
     * @return the "result" HTML template
     */
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute User user) {
        //Creates a new user and gets 
        visitNumberOfUser = userRepository.findVisitNumberByFirstLastName(user.getFirstName(), user.getLastName());
        if(visitNumberOfUser != null) {
            user.addVisitNumber(Integer.parseInt(visitNumberOfUser));
            userRepository.addVisitNumber(user.getFirstName(), user.getLastName());
        } else if (user.getFirstName() == "")  {
            user.visitNumber = null;
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

    /**
     * This is the route for the /all GET request. This method creates arrays containing strings of all of the
     * unique first, unique last names, each user's information and the total visitor count for everyone
     * that has been greeted. Then a JSON object is created, all of the keys and values are created, and the JSON 
     * object is converted back to a string and returned.
     * @return the JSON object that is now a string of all the data in the database. 
     */
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




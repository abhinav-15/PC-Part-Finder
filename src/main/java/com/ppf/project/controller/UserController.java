package com.ppf.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ppf.project.model.Role;
import com.ppf.project.model.User;
import com.ppf.project.dao.UserDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/new")
    public String newUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/user_listing";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userDao.findById(id).orElse(null);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userDao.deleteById(id);
        return "redirect:/user_listing";
    }

    @RequestMapping("/user_listing")
    public String viewUserListing(Model model) {
        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);
        return "user_listing";
    }
    
    @GetMapping("/signup")
    public String signupPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupUser(@ModelAttribute("user") User user) {
        // Set user role as "USER"
        Role userRole = new Role();
        userRole.setName("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        user.setRoles(roles);

        // Encrypt password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setEnabled(true); 
        userDao.save(user);

        return "redirect:/login"; 
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/aboutus")
    public String about() {
        return "about";
	}

}

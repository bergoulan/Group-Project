/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PetKeeper.controller;

import com.example.PetKeeper.model.MyUser;
import com.example.PetKeeper.model.MyUserDetails;
import com.example.PetKeeper.service.MyUserDetailsService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author RG
 */
@RequestMapping("/keeper")
@Controller
public class KeeperController {

    @Autowired
    MyUserDetailsService myUserDetailsService;
    
    @RequestMapping
    public String showKeeperHome() {

        return "keeper-home";
    }

    @GetMapping("schedule")
    public String showSchedule() {

        return "calendar";
    }

    @GetMapping("profile")
    public String showMyUserDetails(HttpSession session, ModelMap mm) {

        MyUser myUser = (MyUser) session.getAttribute("loggedUser");
        MyUserDetails myUserDetails = myUserDetailsService.getMyUserDetailsByMyUser(myUser);
        mm.addAttribute("myUserDetails", myUserDetails);
        return "fillMyUserDetails";
    }
}

package org.fish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ubu on 26.05.17.
 */

@Controller
@RequestMapping("/boot")
public class EntryPointController {

    @RequestMapping("/")
    String index(){
        return "index";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(){
        return "error";
    }


    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String map(){
        return "mapPage";
    }


}

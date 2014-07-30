package com.jrew.lab.guesscountry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Vadim
 * Date: 7/29/2014
 * Time: 11:04 PM
 */
@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "map";
    }
}

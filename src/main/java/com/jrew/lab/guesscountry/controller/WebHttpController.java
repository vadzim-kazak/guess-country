package com.jrew.lab.guesscountry.controller;

import com.jrew.lab.guesscountry.model.player.Player;
import com.jrew.lab.guesscountry.util.HttpSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Vadim
 * Date: 7/29/2014
 * Time: 11:04 PM
 */
@Controller
@RequestMapping("/")
public class WebHttpController {

    @Autowired
    private HttpSessionManager httpSessionManager;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping(method = RequestMethod.GET)
    public String startup() {
        return "index";
    }

    @RequestMapping(value = "play", method = RequestMethod.POST)
    public String play(@RequestParam("playerName") String playerName) {

        Player player = httpSessionManager.getPlayer(httpSession);
        player.setName(playerName);

        return "map";
    }
}

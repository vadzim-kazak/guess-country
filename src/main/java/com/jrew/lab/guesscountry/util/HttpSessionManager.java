package com.jrew.lab.guesscountry.util;

import com.jrew.lab.guesscountry.model.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component
public class HttpSessionManager {

    /**
     *
     */
    public interface SessionKey {

        /** **/
        String PLAYER_KEY = "player";
    }

    @Autowired
    private ApplicationContext applicationContext;

    public Player getPlayer(HttpSession session) {

        Object player = session.getAttribute(SessionKey.PLAYER_KEY);
        if (player == null) {

            Player newPlayer = applicationContext.getBean(Player.class);
            session.setAttribute(SessionKey.PLAYER_KEY, newPlayer);

            return newPlayer;
        } else {

            return (Player) player;
        }
    }

}

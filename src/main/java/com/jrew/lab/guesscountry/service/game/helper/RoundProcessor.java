package com.jrew.lab.guesscountry.service.game.helper;

import com.jrew.lab.guesscountry.model.player.Player;

import java.util.List;

/**
 * Created by Kazak_VV on 30.07.2014.
 */
public interface RoundProcessor {

    public void sendQuestion(List<Player> players);
}

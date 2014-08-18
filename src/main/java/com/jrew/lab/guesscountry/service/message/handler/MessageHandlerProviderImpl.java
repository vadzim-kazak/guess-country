package com.jrew.lab.guesscountry.service.message.handler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.service.game.Game;
import com.jrew.lab.guesscountry.service.message.factory.GameMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Kazak_VV on 08.08.2014.
 */
@Component
public class MessageHandlerProviderImpl implements MessageHandlerProvider {

    /** **/
    @Resource(name = "messageHandlers")
    private Map<GameMessage.Type, GameMessageHandler> messageHandlers;

    /** **/
    @Autowired
    private GameMessageFactory gameMessageFactory;

    @Override
    public <T> void handleMessage(GameMessage<T> message, Game game) {
        messageHandlers.get(message.getType()).handleMessage(message, game);
    }

    @Override
    public void handleMessage(GameMessage.Type type, Game game) {
        GameMessage message = gameMessageFactory.buildServerMessage(type);
        messageHandlers.get(message.getType()).handleMessage(message, game);
    }
}

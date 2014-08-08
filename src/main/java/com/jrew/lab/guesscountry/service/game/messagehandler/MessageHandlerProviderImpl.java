package com.jrew.lab.guesscountry.service.game.messagehandler;

import com.jrew.lab.guesscountry.model.message.GameMessage;
import com.jrew.lab.guesscountry.service.game.Game;
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

    @Override
    public <T> void handleMessage(GameMessage<T> message, Game game) {
        messageHandlers.get(message.getType()).handleMessage(message, game);
    }
}

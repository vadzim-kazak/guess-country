package com.jrew.lab.guesscountry.controller.interceptor;

import com.jrew.lab.guesscountry.util.HttpSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Kazak_VV on 31.07.2014.
 */
@Component
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    /** **/
    @Autowired
    HttpSessionManager httpSessionManager;

    /** **/
    @Autowired
    private HttpSession httpSession;

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {

        attributes.put(HttpSessionManager.SessionKey.PLAYER_KEY, httpSessionManager.getPlayer(httpSession));
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
}

package com.jrew.lab.guesscountry.model.message.payload;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazak_VV on 02.09.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StartGamePayload {

    public static class PlayerInfo {

        /** **/
        String id;

        /** **/
        String name;

        /**
         *
         * @param id
         * @param name
         */
        public PlayerInfo(String id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         *
         * @return
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }
    }

    /** **/
    private List<PlayerInfo> players = new ArrayList<>();

    /**
     *
     * @return
     */
    public List<PlayerInfo> getPlayers() {
        return players;
    }
}

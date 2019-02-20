package com.stephen.nicknames.events;

import com.stephen.nicknames.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private Main plugin;

    public JoinEvent(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent action){
        Player player = action.getPlayer();

        if (plugin.getConfig().isSet(player.getName())) {
            String name = plugin.getConfig().getString(player.getName());
            player.setDisplayName(name);
            player.setPlayerListName(name);
        }
    }
}

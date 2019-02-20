package com.stephen.nicknames;

import com.stephen.nicknames.commands.NickCommand;
import com.stephen.nicknames.events.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        getCommand("nickname").setExecutor(new NickCommand(this));
        Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);

        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}

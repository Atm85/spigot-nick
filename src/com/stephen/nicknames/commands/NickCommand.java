package com.stephen.nicknames.commands;

import com.stephen.nicknames.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCommand implements CommandExecutor {

    private Main plugin;

    public NickCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (!player.hasPermission("nickname.cmd.use")){
                player.sendMessage(ChatColor.RED+"uh-oh! ask an 'op' to grant you permission to use this command");
            } else {
                if (args.length == 0){
                    player.sendMessage(ChatColor.GOLD+"USAGE: "+ChatColor.RESET+"/nickname <new name> <"+ChatColor.GREEN+"optional: "+ChatColor.RESET+"player>");
                    player.sendMessage(ChatColor.GOLD+"USAGE: "+ChatColor.RESET+"if player is not set, then you are chosen");
                } else {
                    if (args.length == 1){
                        plugin.getConfig().set(player.getName(), args[0]);
                        plugin.saveConfig();
                        player.setDisplayName(args[0]);
                        player.setPlayerListName(args[0]);
                        player.sendMessage("Set nickname to: " + ChatColor.GREEN+args[0]);
                    }
                }
            }
        }

        return false;
    }
}

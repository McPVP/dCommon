package me.technopvp.commands;

import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdPvP implements CommandExecutor {
	
	public Main plugin;
	
	public CmdPvP(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		Player player = (Player) sender;
		if (!player.hasPermission("pvp.yes")) {
			Utils.perm(player);
			return true;
		}
		if(args.length == 0) {
			player.sendMessage(Main.error);
			player.sendMessage(ChatColor.GRAY + "/serverpvp <off,on> <disable,enable>");
		} else {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("disable")) {
					player.getWorld().setPVP(false);
					Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + " has disabled pvp on the server.");
				} else {
					if(args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("enable")) {
						player.getWorld().setPVP(true);
						Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + " has enabled pvp on the server.");
					}
				}
			}
		}
		return true;
	}

}

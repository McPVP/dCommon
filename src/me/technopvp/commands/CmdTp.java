package me.technopvp.commands;

import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdTp implements CommandExecutor {

	public final Main plugin;
	
	public CmdTp(Main instance) {
		plugin = instance;
	
}
	
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		Player player = (Player)sender;
		if(!player.hasPermission("tp.yes")) {
			Utils.perm(player);
			return true;
		}
		if(args.length == 0) {
			
			player.sendMessage(ChatColor.RED + "Usage: /tp <player> <target>");
			
		} else if(args.length == 1) {
			
			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
			
			if(targetPlayer != null) {
				
				player.sendMessage(ChatColor.GRAY + "You have teleported to " + ChatColor.RED + targetPlayer.getName());
				player.teleport(targetPlayer);
				
			} else {
				
				player.sendMessage(ChatColor.RED + "Could not find player " + "'" + args[0] + "'");
				
			}
			
		} else if(args.length == 2) {
			Player one = plugin.getServer().getPlayer(args[0]);
			Player two = plugin.getServer().getPlayer(args[1]);
			
			if(one != null && two != null) {	
				one.teleport(two);
				one.sendMessage(ChatColor.GRAY + "Teleporting " + ChatColor.RED + one.getName() + ChatColor.GRAY + " To " + ChatColor.RED + two.getName());
			} else {		
				player.sendMessage(ChatColor.GRAY + "Could not find player's " + ChatColor.RED + "'" + args[0] + "'" + ChatColor.GRAY + " and " + ChatColor.RED + "'" + args[1] + "'");
				return true;
			}
			
			two.sendMessage(ChatColor.GRAY + "Teleporting " + ChatColor.RED + one.getName() + ChatColor.GRAY + " To " + ChatColor.RED + two.getName());
			
		} else if(args.length >= 3) {
			
			player.sendMessage(ChatColor.RED + "Invalid Usage: /teleport <player> <target>");
			
		}
		return true;	
	}
}
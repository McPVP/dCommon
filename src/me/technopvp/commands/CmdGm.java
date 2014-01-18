package me.technopvp.commands;

import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdGm implements CommandExecutor{

	public final Main plugin;
	
	public CmdGm(Main instance) {
		plugin = instance;
	
}
	
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args){
		
		if(sender instanceof Player){
			
			Player p = (Player)sender;
			
			
			if (!p.hasPermission("gm.yes")) {
				Utils.perm(p);
				return true;
			}
			
			if (args.length == 0) {
				if (p.getGameMode() == GameMode.CREATIVE) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(ChatColor.GRAY + "You have changed your gamemode to " + ChatColor.RED + p.getGameMode().toString().toLowerCase());
					return true;
				}else {
				if (p.getGameMode() == GameMode.SURVIVAL) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(ChatColor.GRAY + "You have changed your gamemode to " + ChatColor.RED + p.getGameMode().toString().toLowerCase());
					return true;
				}
				}
			}
			
			if (args.length == 1) {

				if(args[0].equalsIgnoreCase("0")){
					
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(ChatColor.GRAY + "You have changed your gamemode to " + ChatColor.RED + p.getGameMode().toString().toLowerCase());
					return true;
				
				}
			
				if(args[0].equalsIgnoreCase("1")){
				
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(ChatColor.GRAY + "You have changed your gamemode to " + ChatColor.RED + p.getGameMode().toString().toLowerCase());
					return true;
				
				}
			
				if(args[0].equalsIgnoreCase("2")){
				
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(ChatColor.GRAY + "You have changed your gamemode to " + ChatColor.RED + p.getGameMode().toString().toLowerCase());
					return true;
				
				}
				return true;
			}
		}
		return true;
	}
}

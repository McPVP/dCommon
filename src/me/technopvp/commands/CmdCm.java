package me.technopvp.commands;

import java.util.List;

import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Player;

public class CmdCm implements CommandExecutor{
	
	public final Main plugin;
	
	public CmdCm(Main instance) {
		plugin = instance;
	
}
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		
		Player p = (Player)sender;
			if (!p.hasPermission("clearmobs.yes")) {
				Utils.perm(p);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(Main.error);
				p.sendMessage(ChatColor.GRAY + "/clearmobs <radius>");
			}
		if(args.length == 1){
			try {
					
			int removed = 0;
			
			final int radius = Integer.parseInt(args[0]);

			List<Entity> nearby = p.getNearbyEntities(radius, radius, radius);
			
			if (radius <= 0) {
				p.sendMessage(Main.usage);
				p.sendMessage(ChatColor.GRAY + "Number must be above 0");
				return true;
			}
			for(Entity tmp : nearby){
			
			
		    	        if ((tmp instanceof LivingEntity)) {
		    	          if (!(tmp instanceof Player | tmp instanceof MushroomCow)) {    	    
					tmp.remove();
					removed++;
			
		    	          }
			      }
			}
			if (removed == 0) {
				p.sendMessage(ChatColor.GRAY + "There are no mobs in a radius of " + "'" + ChatColor.RED + radius + ChatColor.GRAY + "'");
				return true;
			}
			if (removed == 1) {
				Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.GRAY + " has just killed " + ChatColor.RED + removed + ChatColor.GRAY + " mob in a radius of " + ChatColor.RED + radius);
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.GRAY + " has just killed " + ChatColor.RED + removed + ChatColor.GRAY + " mobs in a radius of " + ChatColor.RED + radius);
			}
			   catch (Exception e) {
				      p.sendMessage(Main.usage);
				      p.sendMessage(ChatColor.GRAY + "Please enter a number");
			   }

			}
		return true;
		}
}

package me.technopvp.commands;

import me.technopvp.clash.Lists;
import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdFeet implements CommandExecutor{
	
	public final Main plugin;
	
	public CmdFeet(Main instance) {
		plugin = instance;
	
}
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		Player p = (Player)sender;
	    	if (!p.hasPermission("feet.yes")) {
	    		Utils.perm(p);
	    		return true;
	    	}
	    	if (args.length == 0) {
	    		p.sendMessage(Main.error);
	    		p.sendMessage(ChatColor.GRAY + "/feet <potion, ender, smoke, fire, poison, all, on, off>");
	    		return true;
	    	}
	    	if(args[0].equalsIgnoreCase("ender")){
	    		 if (!Lists.CrazyPearl.containsKey(p.getDisplayName())) {
	    	          Lists.CrazyPearl.put(p.getDisplayName(), p);
	    	          p.sendMessage(ChatColor.GRAY + "EnderFeet has been enabled");
	    	          p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	    	          return true;
	    	        }
	    	        if (Lists.CrazyPearl.containsKey(p.getDisplayName())) {
	    	          Lists.CrazyPearl.remove(p.getDisplayName());
	    	          p.sendMessage(ChatColor.GRAY + "EnderFeet has been disabled");
	    	          p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	    	          return true;
	    		
	    	}
	    	}
	    	if(args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("disable")) {
	    		Lists.CrazyPearl.remove(p.getDisplayName());
	    		Lists.CrazyPotion.remove(p.getDisplayName());
	    		Lists.CrazySmoke.remove(p.getDisplayName());
	    		Lists.CrazyFire.remove(p.getDisplayName());
	    		Lists.CrazyPoison.remove(p.getDisplayName());
	    		p.sendMessage(ChatColor.GRAY + "You no longer have any feet effects");
	    		p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1, 1);
	    		
	    	}
	    	if(args[0].equalsIgnoreCase("all") || args[0].equalsIgnoreCase("allon")) {
	   		 if (!Lists.CrazyPoison.containsKey(p.getDisplayName())) {
	 	          Lists.CrazyPoison.put(p.getDisplayName(), p);
	 	          Lists.CrazyPearl.put(p.getDisplayName(), p);
	 	          Lists.CrazyPotion.put(p.getDisplayName(), p);
	 	          Lists.CrazyFire.put(p.getDisplayName(), p);
	 	          Lists.CrazySmoke.put(p.getDisplayName(), p);
	 	          p.sendMessage(ChatColor.GRAY + "All crazy effects have been enabled");
	 	       p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	 	          return true;
	 	        }
	 	        if (Lists.CrazyPoison.containsKey(p.getDisplayName())) {
	 	          Lists.CrazyPoison.remove(p.getDisplayName());
	 	         Lists.CrazyPearl.remove(p.getDisplayName());
	     		Lists.CrazyPotion.remove(p.getDisplayName());
	     		Lists.CrazySmoke.remove(p.getDisplayName());
	     		Lists.CrazyFire.remove(p.getDisplayName());
	     		Lists.CrazyPoison.remove(p.getDisplayName());
	 	          p.sendMessage(ChatColor.GRAY + "All crazy effets have been disabled");
	 	       p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	 	          return true;
	 	}
	    	}
	    	if(args[0].equalsIgnoreCase("poison") || args[0].equalsIgnoreCase("p")) {
	     		 if (!Lists.CrazyPoison.containsKey(p.getDisplayName())) {
	      	          Lists.CrazyPoison.put(p.getDisplayName(), p);
	      	          p.sendMessage(ChatColor.GRAY + "CrazyPoison has been enabled");
	      	       p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	      	          return true;
	      	        }
	      	        if (Lists.CrazyPoison.containsKey(p.getDisplayName())) {
	      	          Lists.CrazyPoison.remove(p.getDisplayName());
	      	          p.sendMessage(ChatColor.GRAY + "CrazyPoison has been disabled");
	      	       p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	      	          return true;
	      	}
	    	}
	    	if(args[0].equalsIgnoreCase("fire") || args[0].equalsIgnoreCase("crazyfire")) {
	      		 if (!Lists.CrazyFire.containsKey(p.getDisplayName())) {
	   	          Lists.CrazyFire.put(p.getDisplayName(), p);
	   	          p.sendMessage(ChatColor.GRAY + "CrazyFire has been enabled");
	   	       p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	   	          return true;
	   	        }
	   	        if (Lists.CrazyFire.containsKey(p.getDisplayName())) {
	   	          Lists.CrazyFire.remove(p.getDisplayName());
	   	          p.sendMessage(ChatColor.GRAY + "CrazyFire has been disabled");
	   	       p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	   	          return true;
	   	}
	    	}
	    	if(args[0].equalsIgnoreCase("smoke") || args[0].equalsIgnoreCase("smokefeet")) {
	   		 if (!Lists.CrazySmoke.containsKey(p.getDisplayName())) {
		          Lists.CrazySmoke.put(p.getDisplayName(), p);
		          p.sendMessage(ChatColor.GRAY + "CrazySmoke has been enabled");
		          p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		          return true;
		        }
		        if (Lists.CrazySmoke.containsKey(p.getDisplayName())) {
		          Lists.CrazySmoke.remove(p.getDisplayName());
		          p.sendMessage(ChatColor.GRAY + "CrazySmoke has been disabled");
		          p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
		          return true;
		}
	    	}
	    	if(args[0].equalsIgnoreCase("potion")){
	    		 if (!Lists.CrazyPotion.containsKey(p.getDisplayName())) {
	    	          Lists.CrazyPotion.put(p.getDisplayName(), p);
	    	          p.sendMessage(ChatColor.GRAY + "PotionFeet has been enabled");
	    	          p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	    	          return true;
	    	        }
	    	        if (Lists.CrazyPotion.containsKey(p.getDisplayName())) {
	    	          Lists.CrazyPotion.remove(p.getDisplayName());
	    	          p.sendMessage(ChatColor.GRAY + "PotionFeet has been disabled");
	    	          p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
	    	          return true;
	    	}
	    	
	    }
			return true;
	}
}

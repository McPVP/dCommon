package me.technopvp.commands;

import me.technopvp.clash.Lists;
import me.technopvp.clash.Main;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdChatColor implements CommandExecutor{
	
	public final Main plugin;
	
	public CmdChatColor(Main instance) {
		plugin = instance;
	
}
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		Player p = (Player)sender;
		    	if (!p.hasPermission("chatcolor.yes")) {
		    		p.sendMessage(Main.donor);
		    		return true;
		    	}
		        if (args.length == 0) {
		        p.sendMessage(Main.error);
		        p.sendMessage(ChatColor.GRAY + "/chatcolor <color, colors, help, off>");
		        return true;
		    }
		        if(args[0].equalsIgnoreCase("colors") || args[0].equalsIgnoreCase("colors") || args[0].equalsIgnoreCase("colorcodes")) {
		        	p.sendMessage("§CAvailable ChatColors:");
		        	p.sendMessage("§6Gold");
		        	p.sendMessage("§aGreen");
		        	p.sendMessage("§cRed");
		        	p.sendMessage("§5Purple");
		        	p.sendMessage("§9Blue");
		        	p.sendMessage("§dPink");
		        	p.sendMessage("§eYellow");
		        	return true;
		        }
		        if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("tut") || args[0].equalsIgnoreCase("helpme")) {
		        	p.sendMessage("§7/§9chatcolor §7- §9Use this command to change your chatcolor");
		        	p.sendMessage("§7- Example. /Chatcolor green");
		        	p.sendMessage("§7/§9chatcolor off §7- §9Use this command to make your chatcolor normal");
		        	p.sendMessage("§7/§9chatcolor colors §7- §9To view all the colors you can do");
		        	return true;
		        }
		        if(args[0].equalsIgnoreCase("bold") || args[0].equalsIgnoreCase("bld")) {
		          	 if (!Lists.ccbold.containsKey(p.getDisplayName())) {
		                   Lists.ccbold.put(p.getDisplayName(), p);
		                   Lists.ccgreen.remove(p.getDisplayName());
		                   Lists.ccgold.remove(p.getDisplayName());
		                   Lists.ccblue.remove(p.getDisplayName());
		                   Lists.ccpink.remove(p.getDisplayName());
		                   Lists.ccpurple.remove(p.getDisplayName());
		                   Lists.ccyellow.remove(p.getDisplayName());
		                   Lists.ccred.remove(p.getDisplayName());
		                   p.sendMessage(ChatColor.GRAY + "You're chat color is now bold");
		                   return true;
		                 }
		                 if (Lists.ccbold.containsKey(p.getDisplayName())) {
		                   Lists.ccbold.remove(p.getDisplayName());
		                   p.sendMessage(Main.chatcolor);
		                   return true;
		                 }
		           }
		        if(args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("disable")) {
		        	Lists.ccred.remove(p.getDisplayName());
		        	Lists.ccblue.remove(p.getDisplayName());
		        	Lists.ccgold.remove(p.getDisplayName());
		        	Lists.ccgreen.remove(p.getDisplayName());
		        	Lists.ccpink.remove(p.getDisplayName());
		            Lists.ccpurple.remove(p.getDisplayName());
		            Lists.ccyellow.remove(p.getDisplayName());
		            Lists.ccbold.remove(p.getDisplayName());
		        	p.sendMessage(ChatColor.GRAY + "You're chat color is now back to normal");
		        	p.playSound(p.getLocation(), Sound.WITHER_DEATH, 1, 1);
		        	return true;
		        }
		        if(args[0].equalsIgnoreCase("red") || args[0].equalsIgnoreCase("r")) {
		       	 if (!Lists.ccred.containsKey(p.getDisplayName())) {
		                Lists.ccred.put(p.getDisplayName(), p);
		                Lists.ccgreen.remove(p.getDisplayName());
		                Lists.ccgold.remove(p.getDisplayName());
		                Lists.ccblue.remove(p.getDisplayName());
		                Lists.ccpink.remove(p.getDisplayName());
		                Lists.ccpurple.remove(p.getDisplayName());
		                Lists.ccyellow.remove(p.getDisplayName());
		                Lists.ccbold.remove(p.getDisplayName());
		                p.sendMessage(ChatColor.GRAY + "You're chat color is now red");
		                return true;
		              }
		              if (Lists.ccred.containsKey(p.getDisplayName())) {
		                Lists.ccred.remove(p.getDisplayName());
		                p.sendMessage(Main.chatcolor);
		                return true;
		              }
		        }
		        if(args[0].equalsIgnoreCase("yellow") || args[0].equalsIgnoreCase("y")) {
		          	 if (!Lists.ccyellow.containsKey(p.getDisplayName())) {
		                   Lists.ccyellow.put(p.getDisplayName(), p);
		                   Lists.ccgreen.remove(p.getDisplayName());
		                   Lists.ccgold.remove(p.getDisplayName());
		                   Lists.ccblue.remove(p.getDisplayName());
		                   Lists.ccpink.remove(p.getDisplayName());
		                   Lists.ccpurple.remove(p.getDisplayName());
		                   Lists.ccbold.remove(p.getDisplayName());
		                   Lists.ccred.remove(p.getDisplayName());
		                   p.sendMessage(ChatColor.GRAY + "You're chat color is now yellow");
		                   return true;
		                 }
		                 if (Lists.ccyellow.containsKey(p.getDisplayName())) {
		                   Lists.ccyellow.remove(p.getDisplayName());
		                   p.sendMessage(Main.chatcolor);
		                   return true;
		                 }
		           }
		        if(args[0].equalsIgnoreCase("pink") || args[0].equalsIgnoreCase("p") || args[0].equalsIgnoreCase("lightpurple")) {
		          	 if (!Lists.ccpink.containsKey(p.getDisplayName())) {
		                   Lists.ccpink.put(p.getDisplayName(), p);
		                   Lists.ccgreen.remove(p.getDisplayName());
		                   Lists.ccgold.remove(p.getDisplayName());
		                   Lists.ccblue.remove(p.getDisplayName());
		                   Lists.ccpurple.remove(p.getDisplayName());
		                   Lists.ccyellow.remove(p.getDisplayName());
		                   Lists.ccbold.remove(p.getDisplayName());
		                   Lists.ccred.remove(p.getDisplayName());
		                   p.sendMessage(ChatColor.GRAY + "You're chat color is now pink");
		                   return true;
		                 }
		                 if (Lists.ccpink.containsKey(p.getDisplayName())) {
		                   Lists.ccpink.remove(p.getDisplayName());
		                   p.sendMessage(Main.chatcolor);
		                   return true;
		                 }
		           }
		        if(args[0].equalsIgnoreCase("purple") || args[0].equalsIgnoreCase("p") || args[0].equalsIgnoreCase("darkpurple")) {
		          	 if (!Lists.ccpurple.containsKey(p.getDisplayName())) {
		                   Lists.ccpurple.put(p.getDisplayName(), p);
		                   Lists.ccgreen.remove(p.getDisplayName());
		                   Lists.ccgold.remove(p.getDisplayName());
		                   Lists.ccblue.remove(p.getDisplayName());
		                   Lists.ccpink.remove(p.getDisplayName());
		                   Lists.ccyellow.remove(p.getDisplayName());
		                   Lists.ccbold.remove(p.getDisplayName());
		                   Lists.ccred.remove(p.getDisplayName());
		                   p.sendMessage(ChatColor.GRAY + "You're chat color is now purple");
		                   return true;
		                 }
		                 if (Lists.ccpurple.containsKey(p.getDisplayName())) {
		                   Lists.ccpurple.remove(p.getDisplayName());
		                   p.sendMessage(Main.chatcolor);
		                   return true;
		                 }
		           }
		        if(args[0].equalsIgnoreCase("blue") || args[0].equalsIgnoreCase("b") || args[0].equalsIgnoreCase("colorblue")) {
		          	 if (!Lists.ccblue.containsKey(p.getDisplayName())) {
		                   Lists.ccblue.put(p.getDisplayName(), p);
		                   Lists.ccgreen.remove(p.getDisplayName());
		                   Lists.ccred.remove(p.getDisplayName());
		                   Lists.ccgold.remove(p.getDisplayName());
		                   Lists.ccpink.remove(p.getDisplayName());
		                   Lists.ccpurple.remove(p.getDisplayName());
		                   Lists.ccyellow.remove(p.getDisplayName());
		                   Lists.ccbold.remove(p.getDisplayName());
		                   p.sendMessage(ChatColor.GRAY + "You're chat color is now blue");
		                   return true;
		                 }
		                 if (Lists.ccblue.containsKey(p.getDisplayName())) {
		                   Lists.ccblue.remove(p.getDisplayName());
		                   p.sendMessage(Main.chatcolor);
		                   return true;
		                 }
		           }
		        if(args[0].equalsIgnoreCase("gold") || args[0].equalsIgnoreCase("g") || args[0].equalsIgnoreCase("orange")) {
		          	 if (!Lists.ccgold.containsKey(p.getDisplayName())) {
		                   Lists.ccgreen.remove(p.getDisplayName());
		                   Lists.ccred.remove(p.getDisplayName());
		                   Lists.ccblue.remove(p.getDisplayName());
		                   Lists.ccgold.put(p.getDisplayName(), p);
		                   Lists.ccpink.remove(p.getDisplayName());
		                   Lists.ccpurple.remove(p.getDisplayName());
		                   Lists.ccyellow.remove(p.getDisplayName());
		                   Lists.ccbold.remove(p.getDisplayName());
		                   p.sendMessage(ChatColor.GRAY + "You're chat color is now gold");
		                   return true;
		                 }
		                 if (Lists.ccgold.containsKey(p.getDisplayName())) {
		                   Lists.ccgold.remove(p.getDisplayName());
		                   p.sendMessage(Main.chatcolor);
		                   return true;
		                 }
		           }
		        if(args[0].equalsIgnoreCase("green")){
		        	 if (!Lists.ccgreen.containsKey(p.getDisplayName())) {
		        		 Lists.ccred.remove(p.getDisplayName());
		                 Lists.ccgreen.put(p.getDisplayName(), p);
		                 Lists.ccgold.remove(p.getDisplayName());
		                 Lists.ccblue.remove(p.getDisplayName());
		                 Lists.ccpink.remove(p.getDisplayName());
		                 Lists.ccpurple.remove(p.getDisplayName());
		                 Lists.ccyellow.remove(p.getDisplayName());
		                 Lists.ccbold.remove(p.getDisplayName());
		                 p.sendMessage(ChatColor.GRAY + "You're chat color is now green");
		                 return true;
		               }
		               if (Lists.ccgreen.containsKey(p.getDisplayName())) {
		                 Lists.ccgreen.remove(p.getDisplayName());
		                 p.sendMessage(Main.chatcolor);
		                 return true;
		               }
		    }else {
		    	p.sendMessage(Main.error);
		    	p.sendMessage(ChatColor.GRAY + "/chatcolor <color, colors, help, off>");
		    	return true;
		    }
				return true;
		    }
}

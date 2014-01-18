package me.technopvp.commands;

import me.technopvp.clash.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdHelp implements CommandExecutor {
	
	public Main plugin;
	
	public CmdHelp(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		if(args.length == 0) {
		      sender.sendMessage(ChatColor.GRAY + "Border is at 15,000");
		      sender.sendMessage(ChatColor.GRAY + "***Player Commands***");
		      sender.sendMessage(ChatColor.GRAY + "/donate - To donate to the server");
		      sender.sendMessage(ChatColor.GRAY + "/home - Warps to your home");
		      sender.sendMessage(ChatColor.GRAY + "/warp - Sets a private warp");
		      sender.sendMessage(ChatColor.GRAY + "/spawn - Warps you to spawn");
		      sender.sendMessage(ChatColor.GRAY + "/t - Team help commands");
		      sender.sendMessage(ChatColor.GRAY + "/tpa - Tpas to players");
		      sender.sendMessage(ChatColor.GRAY + "/tpaccept - Tpas to players");
		      sender.sendMessage(ChatColor.GRAY + "/track - To track other players");
		      sender.sendMessage(ChatColor.GRAY + "/who - Lists other players who are online");
		      sender.sendMessage(ChatColor.GRAY + "/msg - Message other players");
		      sender.sendMessage(ChatColor.GRAY + "/r - Reply's to a player");
			}
			if(args.length == 1) {
				if (sender.hasPermission("help.mod")) {
				if(args[0].equalsIgnoreCase("mod") || args[0].equalsIgnoreCase("moderator")) {
					sender.sendMessage(ChatColor.BOLD + "*** Moderator Commands ***");
				      sender.sendMessage(ChatColor.GRAY + "/§5kick §7- Kickes a player");
				      sender.sendMessage(ChatColor.GRAY + "/§5ban §7- Bans a player");
				      sender.sendMessage(ChatColor.GRAY + "/§5tempban §7- Tempbans a player");
				      sender.sendMessage(ChatColor.GRAY + "/§5cast §7- Broadcasts a message to the server");
				      sender.sendMessage(ChatColor.GRAY + "/§5staffchat §7- Puts you into staffchat");

		} 
				}
			if(args.length == 1) {
				if (sender.hasPermission("help.admin")) {
				if(args[0].equalsIgnoreCase("admin") || args[0].equalsIgnoreCase("headadmin")) {
					sender.sendMessage(ChatColor.BOLD + "*** Admin Commands ***");
				      sender.sendMessage(ChatColor.GRAY + "/§9gm §7- Changes your gamemode");
				      sender.sendMessage(ChatColor.GRAY + "/§9vanish §7- Makes you invisible to other players");
				      sender.sendMessage(ChatColor.GRAY + "/§9kill §7- Kill's another player");
				      sender.sendMessage(ChatColor.GRAY + "/§9whois §7- Gives information about another player");
				      sender.sendMessage(ChatColor.GRAY + "/§9tp §7- Teleport's to another player");
				      sender.sendMessage(ChatColor.GRAY + "/§9seen §7- Check's a players ip address");
				      sender.sendMessage(ChatColor.GRAY + "/§9cd §7- Clear's drops in a certin radius");
				      sender.sendMessage(ChatColor.GRAY + "/§9name §7- Changes your name in tablist");
				      sender.sendMessage(ChatColor.GRAY + "/§9pvp §7- Enables, and Disables pvp mode on the server");
				      sender.sendMessage(ChatColor.GRAY + "/§9nopick §7- Enables, and Disables picking up items");
				      sender.sendMessage(ChatColor.GRAY + "/§9freeze §7- Freeze's a player");
				      sender.sendMessage(ChatColor.GRAY + "/§9crash §7- Crashes a player's minecraft client");
				      sender.sendMessage(ChatColor.GRAY + "/§9drop §7- Drop's a player from the server");
				      sender.sendMessage(ChatColor.GRAY + "/§9fsay §7- Force's a player to say a message");
				      sender.sendMessage(ChatColor.GRAY + "/§9slowstop §7- Stop's the server with many messages");
				      sender.sendMessage(ChatColor.GRAY + "/§9copyinv §7- Copy's a players inventory");
				} 
				}
					if(args.length == 1) {
						if (sender.hasPermission("help.headmod")) {
						if(args[0].equalsIgnoreCase("mod+") || args[0].equalsIgnoreCase("headmod")) {
							sender.sendMessage(ChatColor.BOLD + "*** Mod+ Commands ***");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ofly §7- Enables, and Disables fly mode");
						      sender.sendMessage(ChatColor.GRAY + "/§5§occ §7- Clear's the chat");
						      sender.sendMessage(ChatColor.GRAY + "/§5§oclearsome §7- Clear's some of the chat not all");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ocopyinv §7- Copy's a players inventory");
						      sender.sendMessage(ChatColor.GRAY + "/§5§oban §7- Ban's a player");
						      sender.sendMessage(ChatColor.GRAY + "/§5§oci §7- Clear's your inventory");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ogod §7- Enables, and Disables god mode");
						      sender.sendMessage(ChatColor.GRAY + "/§5§oinvsee §7- Check's a players inventory");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ospeed §7- Changes your fly speed");
						      sender.sendMessage(ChatColor.GRAY + "/§5§otp §7- Teleports to another player");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ounban §7- Unban's a player");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ovanish §7- Toggles vanish mode");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ogmute §7- Mute's the server chat");
						      sender.sendMessage(ChatColor.GRAY + "/§5§otip §7- Broadcast's a tip message");
						      sender.sendMessage(ChatColor.GRAY + "/§5§ocast §7- Broadcast's a message");
						}
						}
							if(args.length == 1) {
								if (sender.hasPermission("help.helper")) {
								if(args[0].equalsIgnoreCase("helper") || args[0].equalsIgnoreCase("trialmod")) {
									sender.sendMessage(ChatColor.BOLD + "*** Helper Commands ***");
								      sender.sendMessage(ChatColor.GRAY + "/§ekick §7- Kickes a player");
								      sender.sendMessage(ChatColor.GRAY + "/§emute §7- Mute's a player");
								      sender.sendMessage(ChatColor.GRAY + "/§eclearsome §7- Clear's some of chat");
								      sender.sendMessage(ChatColor.GRAY + "/§estaffchat §7- Toggles staffchat");
								}
							}
					}
			}
			}
			}
			return true;
	}
}
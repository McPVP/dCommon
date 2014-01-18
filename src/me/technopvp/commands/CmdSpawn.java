package me.technopvp.commands;

import me.technopvp.clash.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdSpawn extends Main implements CommandExecutor {
	
	public Main plugin;
	
	
	public CmdSpawn(Main instance) {
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			SpawnProt.espawn(p);
			return true;
		}
		return true;
	}
	}
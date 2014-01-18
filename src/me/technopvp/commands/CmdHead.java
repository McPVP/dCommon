package me.technopvp.commands;

import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class CmdHead implements CommandExecutor{
	
	public final Main plugin;
	
	public CmdHead(Main instance) {
		plugin = instance;
	
}
	public boolean onCommand(CommandSender sender, Command cmd, String tag, String[] args) {
        
		Player player = (Player)sender;
		if (!player.hasPermission("head.yes")) {
			Utils.perm(player);
			return true;
		}
			if(args.length == 0) {
				player.sendMessage("§cInvalid Arguments");
				player.sendMessage(ChatColor.GRAY + "/head <username>");
			} else {
				if(args.length == 1) {			
				ItemStack skullitem = new ItemStack(Material.SKULL_ITEM);			
				skullitem.setDurability((short)3);			
				SkullMeta skullMeta = (SkullMeta)skullitem.getItemMeta();
				skullMeta.setOwner(args[0]);					
				skullitem.setItemMeta(skullMeta);				
				player.getInventory().addItem(skullitem);
				player.sendMessage(ChatColor.GRAY + "You now have " + ChatColor.RED + args[0] + ChatColor.GRAY + "§c's §7head in your inventory!");
				}
			}
			return true;		
			}
}

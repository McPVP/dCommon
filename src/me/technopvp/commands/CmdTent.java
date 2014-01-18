package me.technopvp.commands;

import me.technopvp.clash.Lists;
import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CmdTent extends Main implements CommandExecutor{
	
	public Main plugin;
	
	public CmdTent(Main instance) {
		plugin = instance;
	}
	
	@SuppressWarnings("unused")
	static public boolean createTentAt(Player owner) {
		    Location l = owner.getLocation();
		    Location spot = new Location(owner.getWorld(), l.getX() + 1.0D, l.getY(), l.getZ());
		    double dx = spot.getX(); double dy = spot.getY(); double dz = spot.getZ();
		    int x = new Double(dx).intValue(); int y = new Double(dy).intValue(); int z = new Double(dz).intValue();
		    for (int bx = 0; bx < 5; bx++) {
		      int lx = x + bx;
		      for (int bz = 0; bz < 6; bz++) {
		        int lz = z + bz;
		        for (int by = 0; by < 3; by++) {
		          int ly = y + by;
		          Location queryedblock = new Location(owner.getWorld(), lx, ly, lz);
		          if (queryedblock.getBlock().getType() != Material.AIR) return false;
		        }
		      }
		    }
		    for (int bx = 0; bx < 5; bx++) {
		      int lx = x + bx;
		      for (int bz = 0; bz < 6; bz++) {
		        int lz = z + bz;
		        for (int by = 0; by < 3; by++) {
		          int ly = y + by;

		          Location queryedblock = new Location(owner.getWorld(), lx, ly, lz);
		          if (queryedblock.getBlock().getType() != Material.AIR) return false;

		          boolean buildingblock = false;

		          if ((bx == 0) && (by == 0)) queryedblock.getBlock().setType(Material.WOOL); buildingblock = true;
		          if ((bx == 1) && (by == 1)) queryedblock.getBlock().setType(Material.WOOL); buildingblock = true;
		          if ((bx == 2) && (by == 2)) queryedblock.getBlock().setType(Material.WOOL); buildingblock = true;
		          if ((bx == 3) && (by == 1)) queryedblock.getBlock().setType(Material.WOOL); buildingblock = true;
		          if ((bx == 4) && (by == 0)) queryedblock.getBlock().setType(Material.WOOL); buildingblock = true;
		    
		          

		          if ((bx == 1) && (by == 0) && (bz == 0)) queryedblock.getBlock().setType(Material.FENCE); buildingblock = true;
		          if ((bx == 3) && (by == 0) && (bz == 0)) queryedblock.getBlock().setType(Material.FENCE); buildingblock = true;

		          if ((bx == 1) && (by == 0) && (bz == 5)) queryedblock.getBlock().setType(Material.FENCE); buildingblock = true;
		          if ((bx == 3) && (by == 0) && (bz == 5)) queryedblock.getBlock().setType(Material.FENCE); buildingblock = true;

		          if ((bx == 2) && (by == 0) && (bz == 5)) queryedblock.getBlock().setType(Material.FENCE); buildingblock = true;
		          if ((bx == 2) && (by == 1) && (bz == 5)) queryedblock.getBlock().setType(Material.FENCE); buildingblock = true;

		          if ((bx == 3) && (by == 0) && (bz == 1)) queryedblock.getBlock().setType(Material.WORKBENCH); buildingblock = true;

		          if ((bx == 1) && (by == 0) && (bz == 1)) queryedblock.getBlock().setType(Material.FURNACE); buildingblock = true;

		          if ((bx == 2) && (by == 0) && (bz == 4)) {
		            queryedblock.getBlock().setType(Material.CHEST); buildingblock = true;
		            Chest tc = (Chest)queryedblock.getBlock().getState();

		            tc.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_HELMET, 1) });
		          }

//		          if (buildingblock) {
//		            queryedblock.getBlock().setMetadata("nodrop", new FixedMetadataValue(null, Boolean.valueOf(true)));
//		            queryedblock.getBlock().setMetadata(owner.getName(), new FixedMetadataValue(null, Boolean.valueOf(true)));
//		          }
		        }
		      }

		    }

		    return true;
		  }
	  
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		Player p = (Player)sender;
		
	        if (p.hasPermission("tent.yes")) {
	          if (args.length == 0) {
	            boolean buildable = true;
	            if (buildable) {
	            	if (CmdTent.createTentAt(p)) {
	                p.sendMessage(ChatColor.GRAY + "Your tent was built successfully!");
	              } else {
	            	  p.sendMessage(Main.usage);
	                p.sendMessage(ChatColor.GRAY + "There is not enough space to build your tent here!");
	              }
	            }
	            Lists.success = true;
	          } else {
	            p.sendMessage(Main.error);
	            p.sendMessage(ChatColor.GRAY + "/tent");
	            Lists.success = true;
	          }
	        } else {
	        	Utils.perm(p);
	          Lists.success = true;
	        }
			return true;
	        }

}

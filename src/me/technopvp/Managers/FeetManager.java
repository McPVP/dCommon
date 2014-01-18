package me.technopvp.Managers;

import me.technopvp.clash.Lists;
import me.technopvp.clash.Main;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class FeetManager extends Main {
	
	 @EventHandler
	  public void onCrazyPearlMove(PlayerMoveEvent pme) {
	    Player player = pme.getPlayer();
	    if (Lists.CrazyPearl.containsKey(player.getDisplayName())) {
	      Location to = pme.getTo();
	      Location from = pme.getFrom();
	      Location loc = player.getLocation();
	      if ((to.getX() != from.getBlockX()) || (to.getY() != from.getY()) || (to.getZ() != from.getZ())) {
	        loc.setY(loc.getY());
	        player.getWorld().playEffect(loc, Effect.ENDER_SIGNAL, 1, 100);
	      } else {
	        pme.setCancelled(false);
	      }
	    } else {
	      pme.setCancelled(false);
	    }
	  }
	  
	  @EventHandler
	  public void onPotionMove(PlayerMoveEvent pme) {
	    Player player = pme.getPlayer();
	    if (Lists.CrazyPotion.containsKey(player.getDisplayName())) {
	      Location to = pme.getTo();
	      Location from = pme.getFrom();
	      Location loc = player.getLocation();
	      if ((to.getX() != from.getBlockX()) || (to.getY() != from.getY()) || (to.getZ() != from.getZ())) {
	        loc.setY(loc.getY());
	        player.getWorld().playEffect(loc, Effect.POTION_BREAK, 1, 100);
	      } else {
	        pme.setCancelled(false);
	      }
	    } else {
	      pme.setCancelled(false);
	    }
	  }
	  
	  @EventHandler
	  public void onSmokeMove(PlayerMoveEvent pme) {
	    Player player = pme.getPlayer();
	    if (Lists.CrazySmoke.containsKey(player.getDisplayName())) {
	      Location to = pme.getTo();
	      Location from = pme.getFrom();
	      Location loc = player.getLocation();
	      if ((to.getX() != from.getBlockX()) || (to.getY() != from.getY()) || (to.getZ() != from.getZ())) {
	        loc.setY(loc.getY());
	        player.getWorld().playEffect(loc, Effect.SMOKE, 1, 100);
	      } else {
	        pme.setCancelled(false);
	      }
	    } else {
	      pme.setCancelled(false);
	    }
	  }
	  
	  @EventHandler
	  public void onFireMove(PlayerMoveEvent pme) {
	    Player player = pme.getPlayer();
	    if (Lists.CrazyFire.containsKey(player.getDisplayName())) {
	      Location to = pme.getTo();
	      Location from = pme.getFrom();
	      Location loc = player.getLocation();
	      if ((to.getX() != from.getBlockX()) || (to.getY() != from.getY()) || (to.getZ() != from.getZ())) {
	        loc.setY(loc.getY());
	        player.getWorld().playEffect(loc, Effect.MOBSPAWNER_FLAMES, 1, 100);
	      } else {
	        pme.setCancelled(false);
	      }
	    } else {
	      pme.setCancelled(false);
	    }
	  }
	  
	  @EventHandler
	  public void onPosionMove(PlayerMoveEvent pme) {
	    Player player = pme.getPlayer();
	    if (Lists.CrazyPoison.containsKey(player.getDisplayName())) {
	      Location to = pme.getTo();
	      Location from = pme.getFrom();
	      Location loc = player.getLocation();
	      if ((to.getX() != from.getBlockX()) || (to.getY() != from.getY()) || (to.getZ() != from.getZ())) {
	        loc.setY(loc.getY());
	        player.getWorld().playEffect(loc, Effect.POTION_BREAK, 4, 100);
	      } else {
	        pme.setCancelled(false);
	      }
	    } else {
	      pme.setCancelled(false);
	    }
	  }
}
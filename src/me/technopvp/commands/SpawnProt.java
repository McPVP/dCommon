package me.technopvp.commands;

import java.util.HashMap;

import me.technopvp.clash.Main;
import me.technopvp.clash.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;


public class SpawnProt extends Main implements CommandExecutor{
	
	public static Main plugin;
	
	public SpawnProt(Main instance) {
		plugin = instance;
	}
       
        public static HashMap<String, Boolean> protectedPlayers = new HashMap<String, Boolean>();
		public static HashMap<String, Integer> tasks = new HashMap<String, Integer>();
       
        public static boolean hasSpawnProtection(Player player) {
            return (protectedPlayers.containsKey(player.getName())) ?  
            protectedPlayers.get(player.getName()) : false;
        }
         
        static public boolean isInSpawn(Location location) {
            double x = location.getX();
            double z = location.getZ();
            if (x <= 65 && x >= -65 && z <= 65 && z >= -65) {
                return true;
            }
            return false;
        }
       
        public boolean outSide(Location location) {
                double x = location.getX();
            double z = location.getZ();
            if (x <= 149 && x >= -149 && z <= 149 && z >= -149) {
                return true;
            }
            return false;
        }
         
        @EventHandler
        public void onTele(PlayerTeleportEvent e) {
            Player pl = e.getPlayer();
            if(e.getCause() == TeleportCause.COMMAND) {
                      if (isInSpawn(e.getFrom()) && !isInSpawn(e.getTo())) {
                       if (hasSpawnProtection(pl)) {
                           pl.sendMessage(ChatColor.GREEN + "You no longer have spawn protection!");
                                    protectedPlayers.put(pl.getName(), false);
                       }
          
                    }
            }
        }
        
        @EventHandler (priority = EventPriority.NORMAL)
        public void onMove (PlayerMoveEvent event) {
            Player player = event.getPlayer();
            if (isInSpawn(event.getFrom()) && !isInSpawn(event.getTo())) {
                if (hasSpawnProtection(player)) {
                    protectedPlayers.put(player.getName(), false);
                    player.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
                }
            }
        }
         
        @EventHandler (priority = EventPriority.NORMAL)
        public void onJoin(PlayerJoinEvent event) {
            Player player = event.getPlayer();
            if (!protectedPlayers.containsKey(player.getName())) {
                if (isInSpawn(player.getLocation())) {
                    protectedPlayers.put(player.getName(), true);
                }else{
                    player.sendMessage(ChatColor.GRAY + "You no longer have spawn protection.");
                }
            }
        }
         
        @EventHandler (priority = EventPriority.NORMAL)
        public void onDamage (EntityDamageEvent damage) {
            if (damage.getEntity() instanceof Player) {
                Player damaged = (Player) damage.getEntity();
                if (hasSpawnProtection(damaged)) {
                    damage.setCancelled(true);
                } else if (damage instanceof EntityDamageByEntityEvent) {
                    EntityDamageByEntityEvent entityDamage = (EntityDamageByEntityEvent) damage;
                    if (entityDamage.getDamager() instanceof Player) {
                        Player attacker = (Player) entityDamage.getDamager();
                        if (hasSpawnProtection(attacker)) {
                            protectedPlayers.put(attacker.getName(), false);
                           
                        }
                    }
                }
            }
        }
         
        @EventHandler (priority = EventPriority.NORMAL)
        public void onRespawn (PlayerRespawnEvent event) {
            if (isInSpawn(event.getRespawnLocation())) {
                Player player = event.getPlayer();
                protectedPlayers.put(player.getName(), true);
            }
        }
       
        public static void espawn(final Player p) {
                double bx = Utils.world.getSpawnLocation().getBlockX();
                double bz = Utils.world.getSpawnLocation().getBlockZ();
                double by = Utils.world.getHighestBlockYAt((int)bx,(int)bz)+1;
                if(cWarp(p)) {
                        Location tpto = new Location(Utils.world, bx+.5, by+.5, bz+.5);
                        p.teleport(tpto);
            protectedPlayers.put(p.getName(), true);
                        return;
                }else{
                        p.sendMessage(ChatColor.GRAY + "Someone is nearby! You must stand still for 10 seconds to warp!");
                        int taskid = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
                  {
                    public void run()
                    {
                      if (tasks.containsKey(p.getName())) {
                        tasks.remove(p.getName());
                                double bx = Utils.world.getSpawnLocation().getBlockX();
                                double bz = Utils.world.getSpawnLocation().getBlockZ();
                                double by = Utils.world.getHighestBlockYAt((int)bx,(int)bz)+1;
                        Location tpto = new Location(Utils.world, bx+.5, by+.5, bz+.5);
                        p.teleport(tpto);
                        protectedPlayers.put(p.getName(), true);
                       
                      }
                    }
                  }
                  , 200L);
                  tasks.put(p.getName(), Integer.valueOf(taskid));
                }
        }
       
        
        @SuppressWarnings("unused")
		@EventHandler
          public void onPlayerMove(PlayerMoveEvent e) {
            Location from = e.getFrom();
                Player player = e.getPlayer();
            double fromX = from.getX();
            double fromZ = from.getZ();
            double fromY = from.getY();
 
            Location to = e.getTo();
            double toX = to.getX();
            double toZ = to.getZ();
            double toY = to.getY();
 
            if ((player.getLocation().getBlockX() != to.getBlockX() || player.getLocation().getBlockZ() != to.getBlockZ() || player.getLocation().getBlockY() != to.getBlockY()) && (tasks.containsKey(e.getPlayer().getName()))) {
              Bukkit.getScheduler().cancelTask(((Integer)tasks.get(e.getPlayer().getName())).intValue());
              tasks.remove(e.getPlayer().getName());
              e.getPlayer().sendMessage(ChatColor.GRAY + "Warp canceled!");
            }
          }
       
 
 
 
       
          public static boolean cWarp(Player p)
          {
                       
                                for (Entity e : p.getNearbyEntities(32, 32, 32)) {
 
                                	if (((e instanceof Player)) && (!p.isOp())) {
                                                        return false;
                                               
                                        }
                                }
                                return true;
          }
}
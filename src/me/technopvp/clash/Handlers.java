package me.technopvp.clash;

import java.util.Random;

import me.technopvp.Managers.ConfigManager;
import me.technopvp.Managers.SpamManager;
import me.technopvp.commands.SpawnProt;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.potion.PotionEffectType;

@SuppressWarnings("deprecation")
public class Handlers extends Main implements Listener {
	
	public static FileConfiguration config = Main.plugin.getConfig();
	  
	  @EventHandler
	  public void onShootPearl(EntityShootBowEvent e) {
		  Player p = (Player)e.getEntity();
		  if (Lists.enderbow.containsKey(p.getDisplayName())) {
	    if ((e.getEntity() instanceof Player)) {
	        e.setCancelled(true);
	        p.launchProjectile(EnderPearl.class);
	        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);	
	      }
	    }
	  }
	 
	  @EventHandler  
	  public void Test(AsyncPlayerChatEvent e) {
	  for(Player target : Bukkit.getOnlinePlayers()) {
		  if (Lists.namesound.containsKey(target.getDisplayName())) {
	        String[] words = e.getMessage().split(" ");
	        for(String s : words) {
	                if(s.equalsIgnoreCase(target.getName())) {
	                        target.playSound(target.getLocation(), Sound.ANVIL_LAND, 1, 1);
	                        return;
	                }
	        }
	}
	  }
	  }
	  
	  
	  @EventHandler
	  public void onHungerLoss(FoodLevelChangeEvent e)
	  {
	    if ((e.getFoodLevel() < ((Player)e.getEntity()).getFoodLevel()) && 
	      (new Random().nextInt(100) > 4))
	      e.setCancelled(true);
	  }
		
	  @EventHandler
	  public void PickUp(PlayerPickupItemEvent e) {
		  Player p = e.getPlayer();
		  if (Lists.iname.containsKey(p.getDisplayName())) {
			  p.sendMessage(ChatColor.GRAY + "" + e.getItem().getItemStack().getType().toString().toLowerCase() + 
					  "(" + ChatColor.RED + e.getItem().getItemStack().getAmount() + ChatColor.GRAY + ")" );	  
	  }
	  }
	  
	  @EventHandler
	  public void Bleed(EntityDamageEvent e) {
		  DamageCause cause = e.getCause();
		  Random r = new Random();
		  Entity ey = e.getEntity();
		  if (ey instanceof Zombie | ey instanceof Spider | ey instanceof Skeleton ) {
		  if (cause.equals(DamageCause.ENTITY_ATTACK)) {
			  //The more the first number is increased the less chance there is
			  if (r.nextInt(3) + 1 < 3) {
		  e.getEntity().getLocation().getWorld().playEffect(e.getEntity().getLocation().add(0, 1, 0), Effect.STEP_SOUND, 152);
		  }
		  }
	  }
	  }
	  
	  
	  @EventHandler
	  public void onPlayerBreakItem(BlockBreakEvent e) {
		  Player p = e.getPlayer();
		  if (Lists.speedmode.containsKey(p.getDisplayName())) {
			  e.setCancelled(true);
		  }
	  }
	  
	  @EventHandler
	  public void UpdatePlayer(PlayerJoinEvent e) {
		  Player p = e.getPlayer();
		  if (e.getPlayer().isOp() || p.hasPermission("nokick.yes")) {
			  Lists.nokick.put(p.getDisplayName(), p);
		  }
		  if (p.hasPermission("instatnt.yes")) {
			  Lists.instatnt.put(p.getDisplayName(), p);
		  }
	  }
	  
	  @EventHandler
	  public void onDeathEvent(PlayerDeathEvent e) {
		  Player p = e.getEntity();
		  Location loc = p.getLocation();
		  if (p.hasPermission("deathcords.yes")) {
			  e.getEntity().sendMessage(ChatColor.GRAY + "You have just died at the cords" + " X: " + ChatColor.RED + loc.getBlockX() + ChatColor.GRAY + " Y: " + ChatColor.RED + loc.getBlockY() + ChatColor.GRAY + " Z: " + ChatColor.RED + loc.getBlockZ());
		  }else {
			  e.getDeathMessage();
			
		  }
	  }
	  
	  @EventHandler
	  public void onPlayerTesting(PlayerMoveEvent e) {
		  Player p = e.getPlayer();
		 p.getActivePotionEffects().remove(p.getActivePotionEffects());
	  }
	  
	  @EventHandler(priority=EventPriority.HIGH)
	  public void onPlayerSpeedEvent(EntityDamageEvent evt) {
	    if ((evt.getEntity() instanceof Player)) {
	      Player player = (Player)evt.getEntity();
	      if (Lists.speedmode.containsKey(player.getDisplayName()))
	        evt.setCancelled(true);
	        player.setFireTicks(0);
	        player.setFallDistance(0);
	      }
	    }
	 
	  @EventHandler
	  public void onItemClickEvent(PlayerInteractEvent e) {
		  Player p = e.getPlayer();
		  if (Lists.speedmode.containsKey(p.getDisplayName())) {
		  if (e.getAction() == Action.LEFT_CLICK_AIR) {
			  e.getPlayer().setVelocity(e.getPlayer().getLocation().getDirection().multiply(config.getInt("clash.Speedmode")));
		  }
	  }
	  }
	  
	  
	  @EventHandler
	  public void onPlayerAdminChat(AsyncPlayerChatEvent e) {
	   if (Lists.in.contains(e.getPlayer())) {
	    e.setCancelled(true);
	    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
	     if (p.hasPermission("sc.use")) p.sendMessage(ChatColor.AQUA + e.getPlayer().getName() + ": " + e.getMessage());
	    }
	   }
	  }
	  
	  @EventHandler
	  public void InSpawnSpeed(PlayerMoveEvent e) {
		  if (SpawnProt.isInSpawn(e.getPlayer().getLocation())) {
			  Utils.addPotion(e.getPlayer(), PotionEffectType.SPEED, 125, 1);
		  }
	  }
	 
	  @EventHandler(priority=EventPriority.HIGH)
	  public void BlockPlaceEvent(PlayerInteractEvent event) {
		  if (Lists.instatnt.containsKey(event.getPlayer().getDisplayName())) {
		  if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	    if (event.getClickedBlock().getType().equals(Material.TNT)) {
	      event.getClickedBlock().setType(Material.AIR);
	      event.getPlayer().getWorld().spawnEntity(event.getClickedBlock().getLocation(), EntityType.PRIMED_TNT);
	    }
		  }
		  }
	  }	  	  
	  
	  @EventHandler
	  public void PlayerBannedEvent(PlayerLoginEvent e) {
		  Player p = e.getPlayer();
		  if (p.isBanned()) {
			  
			  e.disallow(Result.KICK_BANNED, "§c§nYou are banned from DreamNetworks\n§7Reason: " + ConfigManager.getInstance().getConfig().getString("Player." + p.getName() + ".BanReason") +      "\n§7Appeal at:§c§l mcdreamz.com\n    " + "§7Purchase an unban at:§c§l donate.mcdreamz.com");
		  }
	  }
	  

	  
	  @EventHandler
	  public void Sucrity(PlayerJoinEvent e) {
		  e.getPlayer().setGameMode(GameMode.SURVIVAL);
	  }
	  
	  @EventHandler
	  public void Testing(PlayerMoveEvent e) {
		  if (e.getPlayer().getLocation().getBlock().equals(Material.GRASS)) {
			  e.setCancelled(true);
			  e.getPlayer().sendMessage(ChatColor.RED + "a");
		  }
	  }
	  
	  @EventHandler
	  public void onPlayerNoKick(PlayerKickEvent e) {
		  Player p = e.getPlayer();
		  if (Lists.nokick.containsKey(p.getDisplayName())) {
		  e.setCancelled(true);
	  }
	  }	   
	  
	  @EventHandler
      public void onSignChange(SignChangeEvent e) {
              if (e.getLine(0).equalsIgnoreCase("[Welcome]") && e.getPlayer().hasPermission("sign.allow")) {
                      e.setLine(0, "Welcome to");
                      e.setLine(1, "§5McDreamz");
                      e.setLine(2, "§cClick Here");

              }
		  }

	  
	  @EventHandler
		public void onPlayerFallVoid(PlayerMoveEvent event) {
			Player player = event.getPlayer();
			if (player.getWorld().getEnvironment().equals(World.Environment.NORMAL)) {
			int yy = player.getLocation().getBlockY();
		      if (yy <= - 40) {
		    	  player.teleport(new Location(player.getWorld(), 0, 65, 0));
		    	  String VoidError = config.getString("clash.VoidError");
		    	  VoidError = VoidError.replaceAll("&", "§");
		    	  VoidError = VoidError.replaceAll("%player", event.getPlayer().getName());
		    	  player.sendMessage(VoidError);
		    	  player.setFallDistance(0);
		      }
			}
		}
	  
	  @SuppressWarnings("unused")
		@EventHandler(priority=EventPriority.MONITOR)
		  public void SignColor(SignChangeEvent event) {
		    if (!event.getPlayer().hasPermission("signcolor.yes")) return;

		    Block block = event.getBlock();
		    Sign sign = null;
		    Material type = block.getType();
		    if ((type.equals(Material.SIGN)) || (type.equals(Material.SIGN_POST)) || (type.equals(Material.WALL_SIGN)))
		      sign = (Sign)block.getState();
		    else {
		      return;
		    }
		    String[] text = event.getLines();
		    int count = 0;
		    for (String line : text)
		    {
		      line = line.replaceAll("&", "§");
		      line = line.replaceAll("§§", "&");
		      event.setLine(count, line);
		      count++;
		    }
		  }

	  @EventHandler
	  public void onDisableCommands(PlayerCommandPreprocessEvent e) {
		  Player p = e.getPlayer();
		  if (!p.hasPermission("dcommand.bypass")) {
		  for (Player all : Bukkit.getOnlinePlayers()) {
		  if (Lists.nether.containsKey(all.getDisplayName())) {
			if (e.getMessage().startsWith("/")){		
				e.setCancelled(true);
				String CommandsDisabledMessage = config.getString("clash.CommandsDisabledMessage");
				CommandsDisabledMessage = CommandsDisabledMessage.replaceAll("&", "§");
				CommandsDisabledMessage = CommandsDisabledMessage.replaceAll("%player", e.getPlayer().getName());
				e.getPlayer().sendMessage(CommandsDisabledMessage);
			}
	  }
		  }
		  }else {
			 e.setCancelled(false); 
		  }
	  }
	  
		  @EventHandler
		  public void Hidden(PlayerJoinEvent e) {
			  Player p = e.getPlayer();
			  if (Lists.hidden.contains(p.getDisplayName())) {
				  for (Player all : Bukkit.getServer().getOnlinePlayers())
						e.getPlayer().hidePlayer(all);
			  }
		  }
	  
	  @EventHandler
		public void onPlayerAboveNether(PlayerMoveEvent event) {
			Player player = event.getPlayer();
			if (!player.hasPermission("nether.bypass")) {
			if (player.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
			int yy = player.getLocation().getBlockY();
		      if (yy >= 128.0D) {
		    	  player.teleport(Bukkit.getWorld("DreamZ").getSpawnLocation());
		    	  String AttemptNetherBypass = config.getString("clash.AttemptNetherBypass");
		    	  AttemptNetherBypass = AttemptNetherBypass.replaceAll("&", "§");
					AttemptNetherBypass = AttemptNetherBypass.replaceAll("%player", event.getPlayer().getName());
		    	  player.sendMessage(AttemptNetherBypass);
		    	  player.setFallDistance(0);	
			}else {
			
		      }
			}
			}
		}
	  
	  @EventHandler
	  public void onPlayerMove(PlayerMoveEvent e) {	  	 
	          Player p = e.getPlayer();
	          if (Lists.frozen.contains(p.getName())) {
	        	  if ((e.getFrom().getBlockX() == e.getTo().getBlockX()) && (e.getFrom().getBlockZ() == e.getTo().getBlockZ()) && (e.getFrom().getBlockY() == e.getTo().getBlockY())){	
	        		  e.setCancelled(false);
	        	  }else {
	                  e.setTo(e.getFrom());
	  }
	  }
	  }
	  
	  @EventHandler
	  public void onPlayerChatEvent2(AsyncPlayerChatEvent event) {
	    Player chatter = event.getPlayer();
	    if (!Lists.muted.containsKey(chatter)) {
	      Lists.muted.put(chatter, Boolean.valueOf(false));
	    }
	    if ((!chatter.hasPermission("chat.talk")) && (
	      (Lists.muteall) || (((Boolean)Lists.muted.get(chatter)).booleanValue()))) {
	      event.setCancelled(true);
	      String Muted = config.getString("clash.Muted");
	      Muted = Muted.replaceAll("&", "§");
	      Muted = Muted.replaceAll("%player", event.getPlayer().getName());
	      chatter.sendMessage(Muted);
	    }
	  }
	 
	  
	  @EventHandler
	  public void onPlayerPickUpItem(PlayerPickupItemEvent e) {	  	 
	          Player p = e.getPlayer();
	          if (Lists.nopick.containsKey(p.getDisplayName())) {	
	        		  e.setCancelled(true);
	  }
	  }
	  
	@EventHandler
	  public void onPlayerChat(PlayerChatEvent event) {
	    SpamManager.OnPlayerChat(event);
	  }	  
}

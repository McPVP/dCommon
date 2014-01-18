package me.technopvp.clash;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import me.technopvp.Managers.ChatColorManager;
import me.technopvp.Managers.ConfigManager;
import me.technopvp.Managers.FeetManager;
import me.technopvp.Managers.LagManager;
import me.technopvp.Managers.StrengthFixManager;
import me.technopvp.commands.CmdChatColor;
import me.technopvp.commands.CmdCm;
import me.technopvp.commands.CmdFeet;
import me.technopvp.commands.CmdGm;
import me.technopvp.commands.CmdHead;
import me.technopvp.commands.CmdHelp;
import me.technopvp.commands.CmdPvP;
import me.technopvp.commands.CmdSpawn;
import me.technopvp.commands.CmdTent;
import me.technopvp.commands.CmdTp;
import me.technopvp.commands.SpawnProt;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Main extends JavaPlugin implements Listener {
	  
	 public static String error = "§cInvalid Arguments";
	  
	 public static String usage = "§cInvalid Usage";
	 
	 public static String donor = "§7You must donate for this command";
	 
	 public static String chatcolor = "§7Your ChatColor has been reset";
	 
	 public final Logger log = Logger.getLogger("Minecraft");
	 public static Plugin plugin;
	  private static ConfigManager file = ConfigManager.getInstance();

	 	 
	  private ChatColor Black;
	  private ChatColor DarkBlue;
	  private ChatColor DarkGreen;
	  private ChatColor DarkAqua;
	  private ChatColor DarkRed;
	  private ChatColor Purple;
	  private ChatColor Gold;
	  private ChatColor DarkGray;
	  private ChatColor Gray;
	  private ChatColor Blue;
	  private ChatColor Green;
	  private ChatColor Aqua;
	  private ChatColor Red;
	  private ChatColor Pink;
	  private ChatColor Yellow;
	  private ChatColor White;
	  private ChatColor Reset;
	 
	 public void colores()
	  {
	    this.Black = ChatColor.BLACK;
	    this.DarkBlue = ChatColor.DARK_BLUE;
	    this.DarkGreen = ChatColor.DARK_GREEN;
	    this.DarkAqua = ChatColor.DARK_AQUA;
	    this.DarkRed = ChatColor.DARK_RED;
	    this.Purple = ChatColor.DARK_PURPLE;
	    this.Gold = ChatColor.GOLD;
	    this.DarkGray = ChatColor.DARK_GRAY;
	    this.Gray = ChatColor.GRAY;
	    this.Blue = ChatColor.BLUE;
	    this.Green = ChatColor.GREEN;
	    this.Aqua = ChatColor.AQUA;
	    this.Red = ChatColor.RED;
	    this.Pink = ChatColor.LIGHT_PURPLE;
	    this.Yellow = ChatColor.YELLOW;
	    this.White = ChatColor.WHITE;
	    this.Reset = ChatColor.RESET;
	  }

	   public void LagManger() {
		   Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new LagManager(), 100L, 1L);
	   }
	   
	   public void WorldEditError() {
		   if (!this.getServer().getPluginManager().isPluginEnabled("WorldEdit"))
			   System.out.println(Red + "WorldEdit is not installed please install it");
		   }

	 public void tntsweep() {
		    for (World world : getServer().getWorlds())
		        for (Entity entity : world.getEntities())
		          if ((entity instanceof TNTPrimed))
		            entity.remove();
	 }
		
	public void sendOnlineInfo(CommandSender sender) {
		    ArrayList<String> staff = new ArrayList<String>();
		    for (Player p : getServer().getOnlinePlayers()) {
		      if ((p.hasPermission("staff.yes")) || ((p.isOp())))
		        staff.add(p.getName());
		    }

		    sender.sendMessage(Gold + "---------------------[" + Red + "McDreamz" + Gold + "]--------------------      --=" + 
		    		Gray + " There are " + Gray + "(" + Red + getServer().getOnlinePlayers().length + Gray + "/" + Red + 
		      getServer().getMaxPlayers() + Gray + ") " + Gray + "users currently online." + Gold + " =--" + (
		      staff.size() == 0 ? Red + "There are currently no staff members online!" : new StringBuilder().append(Gray).append("     Staff online").append(Gray)
		      .append(" (").append(Red).append(staff.size()).append(Gray).append("): ").append(ChatColor.GRAY).append(staff.toString()).toString().replace("]", Gray + "]") +
		      Gold + "\n\n§6-----------------------------------------" + 
		      "--------"));
	}
	
   private void robby() {
    ShapedRecipe ob = new ShapedRecipe(new ItemStack(Material.OBSIDIAN, 5));
    ob.shape("DDD",
  		     "DID",
  		     "DID");
    ob.setIngredient('D', Material.DIAMOND);
    ob.setIngredient('I', Material.IRON_INGOT);
    Bukkit.getServer().addRecipe(ob);
   }
   
  
   
   private void robby2() {
	      ShapedRecipe ob2 = new ShapedRecipe(new ItemStack(Material.OBSIDIAN, 2));
	      ob2.shape("DDD",
	    		  "DID",
	    		  "III");
	      ob2.setIngredient('D', Material.DIAMOND);
	      ob2.setIngredient('I', Material.IRON_INGOT);
	      Bukkit.getServer().addRecipe(ob2);
	     }
	 
	 public void commands()
	  {
		  getCommand("tp").setExecutor(new CmdTp(this));
		  getCommand("serverpvp").setExecutor(new CmdPvP(this));
		  getCommand("quickgm").setExecutor(new CmdGm(this));
		  getCommand("tent").setExecutor(new CmdTent(this));
		  getCommand("head").setExecutor(new CmdHead(this));
		  getCommand("clearmobs").setExecutor(new CmdCm(this));
		  getCommand("feet").setExecutor(new CmdFeet(this));
		  getCommand("chatcolor").setExecutor(new CmdChatColor(this));
		  getCommand("spawn").setExecutor(new CmdSpawn(this));
		  getCommand("help").setExecutor(new CmdHelp(this));
	  }
	 
	 public void managers()
	  {
		 Bukkit.getServer().getPluginManager().registerEvents(new Handlers(), this);
		  Bukkit.getServer().getPluginManager().registerEvents(new FeetManager(), this);
		  Bukkit.getServer().getPluginManager().registerEvents(new ChatColorManager(), this);
		  Bukkit.getServer().getPluginManager().registerEvents(this, this);
		  getServer().getPluginManager().registerEvents(new CmdTent(this), this);
		  getServer().getPluginManager().registerEvents(new StrengthFixManager(), this);
		  getServer().getPluginManager().registerEvents(new SpawnProt(this), this);
	  }
	    
  public void onEnable() {
	  try {
      tntsweep();
      plugin = this;
	  colores();
	  commands();
      robby();
      robby2();
      LagManger();
     
      managers();
      WorldEditError();
      saveDefaultConfig();
      ConfigManager.getInstance().setup(this);
      getConfig().options().copyDefaults(true);
	  Utils.Initialize(this);
	  log.info("[cCommon] Has been enabled");
	  }
	  catch (Exception ex) { 
  }
	  api = (WorldEditPlugin) this.getServer().getPluginManager().getPlugin("WorldEdit");
	  wg = (WorldGuardPlugin) this.getServer().getPluginManager().getPlugin("WorldGuard");
  }
  
  public WorldEditPlugin api;
  public WorldGuardPlugin wg;

	public void onDisable() {
		log.info("[cCommon] Has been disabled");
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
			
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You cannot do this in console");
			return true;
		}

		final Player p = (Player) sender;
		final Location loc = p.getLocation();
		final PlayerInventory pi = p.getInventory();
//		final World world = p.getWorld();
		final FileConfiguration config = getConfig();
		PluginDescriptionFile pdf = this.getDescription();
		PluginManager pm = Bukkit.getPluginManager();
		Selection we = api.getSelection(p);
		
		String perm = getConfig().getString("clash.PermissionMessage");
        perm = perm.replaceAll("&", "§");
		
		if (cmd.getName().equalsIgnoreCase("rules")) {
			p.sendMessage(Red + "If Any of these rules are broken it could result in a ban, mute or kick");					
			p.sendMessage(Gray + "1.) No spamming");
			p.sendMessage(Gray + "2.) No hacking of any kind");
			p.sendMessage(Gray + "3.) No Xraying");
			p.sendMessage(Gray + "4.) No advertising");
			p.sendMessage(Gray + "5.) Pleas be kind");
			p.sendMessage(Gray + "6.) Swearing is allowed");
			p.sendMessage(Gray + "7.) No abusing bugs/glitches");
			p.sendMessage(Gray + "8.) Have fun!");
			if (args[0].equalsIgnoreCase("staff")) {
				if (p.hasPermission("rules.staff")) {
			      p.sendMessage(Red + "Welcome to McDreamZ Staff Team, Read Rules Below.");
			      
			}else {
				p.sendMessage(Gray + "You are not a staff member");
			}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("worldedit")) {
			if (!p.hasPermission("worldedit.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (we == null) {
				p.sendMessage(usage);
				p.sendMessage(Gray + "Please select a area first");
				return true;
			}
			if (args.length == 0) {
			p.sendMessage(Gray + "Hight: " + Red + we.getHeight() + Gray + "\nLength: " + Red + we.getLength() + Gray + "\nWith " + Red + we.getWidth() + Gray + "\nArea: " + Red + we.getArea());
			return true;
			}
			if (args[0].equalsIgnoreCase("hight") || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("hgh")) {
				p.sendMessage(Gray + "Hight: " + Red + we.getHeight());
				return true;
			}
			if (args[0].equalsIgnoreCase("length") || args[0].equalsIgnoreCase("l") || args[0].equalsIgnoreCase("count") || args[0].equalsIgnoreCase("ct")) {
				p.sendMessage(Gray + "Length: " + Red + we.getLength());
				return true;
			}
			if (args[0].equalsIgnoreCase("with") || args[0].equalsIgnoreCase("w") || args[0].equalsIgnoreCase("wth")) {
				p.sendMessage(Gray + "With: " + Red + we.getWidth());
				return true;
			}
			if (args[0].equalsIgnoreCase("area") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("are")) {
				p.sendMessage(Gray + "Area: " + Red + we.getArea());
				return true;
			}
			if (args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("ce") || args[0].equalsIgnoreCase("rw")) {
				p.sendMessage(Gray + "You have cleared you're wand");
				we.getRegionSelector().clear();
				return true;
			}
			}
		
		
		if (cmd.getName().equalsIgnoreCase("removebedrock")) {
			if (!p.hasPermission("removebedrock.yes")) {
				p.sendMessage(perm);
				return true;
			}
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (all.getEnderChest().contains(Material.BEDROCK)) {
					all.getEnderChest().clear();
					all.chat(Red + "I have been caught with bedrock in my enderchest");
				}else {
				if (all.getInventory().contains(Material.BEDROCK)) {
					all.getInventory().clear();
					all.chat(Red + "I have been caught with bedrock and will be banned");
				}
			}
		}
			p.sendMessage(Gray + "All bedrock has been removed from the players");
		}		

		if (cmd.getName().equalsIgnoreCase("enderfeet")) {
			if (!p.hasPermission("enderfeet.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.CrazyPearl.containsKey(p.getDisplayName())) {
				Lists.CrazyPearl.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "EnderFeet has been enabled");
				return true;
			}
			if (Lists.CrazyPearl.containsKey(p.getDisplayName())) {
				Lists.CrazyPearl.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "EnderFeet has been disabled");
				return true;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("unban")) {
			if (!p.hasPermission("unban.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/unban <player>");
				return true;	
			}
			OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
//			if (!target.isBanned()) {
//				p.sendMessage(usage);
//				p.sendMessage(Gray + args[0] + " is not banned from the server");
//				return true;
//			}
			 ConfigManager.getInstance().getConfig().set("Player." + p.getName(), null);
			 ConfigManager.getInstance().saveConfig();
			target.setBanned(false);
			String UnbanMessage = getConfig().getString("clash.UnbanMessage");
			UnbanMessage = UnbanMessage.replaceAll("&", "§");
			UnbanMessage = UnbanMessage.replaceAll("%player", p.getName());
			UnbanMessage = UnbanMessage.replaceAll("%target", target.getName());
			Bukkit.broadcastMessage(UnbanMessage);
			
		}
		
	
	       if (cmd.getName().equalsIgnoreCase("ban")) {        	 
	            if (!p.hasPermission("ban.yes")) {
	                p.sendMessage(perm);
	                return true;
	            }
	 
	            if (args.length == 0) {
	                p.sendMessage(error);
	                p.sendMessage(Gray + "/ban <player> <reason>");
	                return true;
	            }
	            String br = "";            
	            if (args.length > 1) {
	                br = "";
	                for (int i = 1; i < args.length; i++) {
	                    br += args[i] + " ";
	                }
	            }

				br = br.substring(0, br.length() - 1);	
				br = br.replaceAll("&", "§");
				
				
	            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);
	            String msg = "";            
	            if (args.length > 1) {
	                msg = " for ";
	                for (int i = 1; i < args.length; i++) {
	                    msg += args[i] + " ";
	                }
	            }
//	            if (target.getName().equalsIgnoreCase("technopvp")) {
//	            	p.sendMessage(usage);
//	            	p.sendMessage(Gray + "You can not ban technopvp");
//	            	return true;
//	            }
	            if (target.isOnline()) target.getPlayer().kickPlayer(ChatColor.RED + "You have been banned by " + sender.getName() + msg);
	            target.setBanned(true);
				String BanColor = getConfig().getString("clash.BanColor");
				BanColor = BanColor.replaceAll("red", "§c");
				BanColor = BanColor.replaceAll("gray", "§7");
				BanColor = BanColor.replaceAll("blue", "§1");
				BanColor = BanColor.replaceAll("green", "§a");
				BanColor = BanColor.replaceAll("darkgreen", "§2");
				BanColor = BanColor.replaceAll("darkred", "§4");
				BanColor = BanColor.replaceAll("pink", "§d");
				BanColor = BanColor.replaceAll("gold", "§6");
				BanColor = BanColor.replaceAll("aqua", "§b");
				BanColor = BanColor.replaceAll("yellow", "§a");
				BanColor = BanColor.replaceAll("aqua", "§b");
				BanColor = BanColor.replaceAll("black", "§1");
				BanColor = BanColor.replaceAll("&", "§1");
	            Bukkit.broadcastMessage(BanColor + args[0] + " has been banned by " + sender.getName() + msg);
	            ConfigManager.getInstance().getConfig().set("Player." + p.getName() + ".BanReason", br);
	            ConfigManager.getInstance().saveConfig();
	            return true;
	        }
	       
			if (cmd.getName().equalsIgnoreCase("test"))	 {
				p.sendMessage(Red + "Deaths: " + file.getConfig().getInt("Player." + p.getName() + ".deaths"));
			}
		
		if (cmd.getName().equalsIgnoreCase("fire")) {
			if (!p.hasPermission("fire.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/fire <player> <reason>");
				return true;	
			}
			Player target = Bukkit.getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(Red + "Could not find player " + "'" + args[0] + "'");
				return true;
			}
			String FireColor = getConfig().getString("clash.FireColor");
			FireColor = FireColor.replaceAll("red", "§c");
			FireColor = FireColor.replaceAll("gray", "§7");
			FireColor = FireColor.replaceAll("blue", "§1");
			FireColor = FireColor.replaceAll("green", "§a");
			FireColor = FireColor.replaceAll("darkgreen", "§2");
			FireColor = FireColor.replaceAll("darkred", "§4");
			FireColor = FireColor.replaceAll("pink", "§d");
			FireColor = FireColor.replaceAll("gold", "§6");
			FireColor = FireColor.replaceAll("aqua", "§b");
			FireColor = FireColor.replaceAll("yellow", "§a");
			FireColor = FireColor.replaceAll("aqua", "§b");
			FireColor = FireColor.replaceAll("black", "§1");
			FireColor = FireColor.replaceAll("&", "§1");
			if (args.length == 1) {
				Bukkit.broadcastMessage(FireColor + target.getName() + " has been fired from DreamNetworks.");
				return true;
			}
				if (Utils.getMessage(args, 1).length() <= 2) {
					p.sendMessage(usage);
					p.sendMessage(Gray + "reason must be more then 2 characters long");
					return true;
				}else {
			Bukkit.broadcastMessage(FireColor + target.getName() + " has been fired from DreamNetworks for " + Utils.getMessage(args, 1));
		}
		}

//		   if (cmd.getName().equalsIgnoreCase("cooldowntest")) {
//		   if (!p.hasPermission("test.yes")) {
//			   return true;
//		   }
//		   if(Cooldowns.tryCooldown(p, "RoadRunner", 80000)) {
//			   p.sendMessage("Item Given");
//			   p.getInventory().addItem(new ItemStack(Material.WOOD, 1));
//		   }else {
//			   if (Cooldowns.getCooldown(p, "RoadRunner") >= 60000) {
//				   p.sendMessage(Red + "Stil have " + Cooldowns.getCooldown(p, "RoadRunner") /60000 + " minutes left"); 
//				   
//				   //Hour
//		   }else {
//			   p.sendMessage(Red + "Stil have " + Cooldowns.getCooldown(p, "RoadRunner") /1000  + " secondss left"); 
//		   }
//		   }
//	   }
//	   

		
		
		if (cmd.getName().equalsIgnoreCase("speed")) {
			if (!p.hasPermission("speed.yes")) {
				p.sendMessage(donor);
				return true;	
			}
			if (Cooldowns.tryCooldown(p, "Speed", 10800000)) {
				p.sendMessage(Green + "You have been given speed effect for 2 minute");
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2400, 1));
			}else {
				 if (Cooldowns.getCooldown(p, "Speed") >= 60000) {
					   p.sendMessage(Red + "You still have " + Cooldowns.getCooldown(p, "Speed") /60000 + " minutes left"); 
			   }else {
				   p.sendMessage(Gray + "You stil have " + Cooldowns.getCooldown(p, "Speed") /1000  + " seconds left"); 
				}
			}
			}
		if (cmd.getName().equalsIgnoreCase("potionfeet")) {
			if (!p.hasPermission("potionfeet.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.CrazyPotion.containsKey(p.getDisplayName())) {
				Lists.CrazyPotion.put(p.getDisplayName(), p);
				Lists.CrazyPearl.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "PotionFeet has been enabled");
				return true;
			}
			if (Lists.CrazyPotion.containsKey(p.getDisplayName())) {
				Lists.CrazyPotion.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "PotionFeet has been disabled");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("checkmotd")) {
			sender.sendMessage(ChatColor.GRAY + "System MOTD: " + Bukkit.getMotd());					
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("forcespawn")) {
			if (!p.hasPermission("forcespawn.yes")) {
				p.sendMessage(perm);
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(error);
				sender.sendMessage(ChatColor.GRAY + "/forcespawn <Player>");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");						
				return true;
			}
			target.teleport(Bukkit.getWorld("DreamZ").getSpawnLocation());
			target.sendMessage(Red + "You have been forced to go to spawn");
			p.sendMessage(Gray + "You have force spawned " + target.getName());
			target.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("ram")) {
			sender.sendMessage(ChatColor.GRAY + "Allocated Memory: " + Red + Utils.totalMem());		
			sender.sendMessage(ChatColor.GRAY + "Free Memory: " + Red + Utils.freeMem());
			sender.sendMessage(ChatColor.GRAY + "Total Memory: " + Red + Utils.maxMem());				
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("throw")) {
			if (!p.hasPermission("throw.yes")) {
				p.sendMessage(perm);
				return true;
			}
			p.launchProjectile(EnderPearl.class);
			p.sendMessage(Gray + "You have tossed in enderpearl");
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("rename")) {
			if (!p.hasPermission("rename.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if ((p.getItemInHand() != null)
					&& (!p.getItemInHand().getType().equals(Material.AIR))) {
				if (args.length == 1) {
					ItemStack itemStack = p.getItemInHand();

					String string = args[0];
					String spacedString = string.replaceAll("_", " ");
					String colouredString = ChatColor.translateAlternateColorCodes('&', spacedString);
							

					ItemMeta itemStackMeta = itemStack.getItemMeta();
					itemStackMeta.setDisplayName(colouredString);

					itemStack.setItemMeta(itemStackMeta);

					p.sendMessage(ChatColor.GRAY + "Succesfully renamed the item in hand to: " + ChatColor.RED + colouredString);													
				} else {
					p.sendMessage(error);
					p.sendMessage(ChatColor.GRAY + "/rename <Name>");
				}
			} else {
				p.sendMessage(usage);
				p.sendMessage(ChatColor.GRAY + "You are not holding an item in your hand");					
			}
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("colores")) {
			Player player = (Player) sender;
			player.sendMessage(this.Gold + "Minecraft Color Codes");
			player.sendMessage(this.Black + "&0" + this.Reset + " | " + this.Black + "This is Black");					
			player.sendMessage(this.DarkBlue + "&1" + this.Reset + " | " + this.DarkBlue + "This is Dark Blue");					
			player.sendMessage(this.DarkGreen + "&2" + this.Reset + " | " + this.DarkGreen + "This is Dark Green");					
			player.sendMessage(this.DarkAqua + "&3" + this.Reset + " | " + this.DarkAqua + "This is Dark Aqua");					
			player.sendMessage(this.DarkRed + "&4" + this.Reset + " | " + this.DarkRed + "This is Dark Red");
			player.sendMessage(this.Purple + "&5" + this.Reset + " | " + this.Purple + "This is Purple");
			player.sendMessage(this.Gold + "&6" + this.Reset + " | " + this.Gold + "This is Gold");					
			player.sendMessage(this.DarkGray + "&8" + this.Reset + " | " + this.DarkGray + "This is DarkGray");					
			player.sendMessage(this.Gray + "&7" + this.Reset + " | " + this.Gray + "This is Gray");					
			player.sendMessage(this.Blue + "&9" + this.Reset + " | " + this.Blue + "This is Blue");					
			player.sendMessage(this.Green + "&a" + this.Reset + " | " + this.Green + "This is Green");					
			player.sendMessage(this.Aqua + "&b" + this.Reset + " | " + this.Aqua + "This is Aqua");					
			player.sendMessage(this.Red + "&c" + this.Reset + " | " + this.Red + "This is Red");					
			player.sendMessage(this.Pink + "&d" + this.Reset + " | " + this.Pink + "This is Pink");					
			player.sendMessage(this.Yellow + "&e" + this.Reset + " | " + this.Yellow + "This is Yellow");					
			player.sendMessage(this.White + "&f" + this.Reset + " | " + this.White + "This is White");			
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("air")) {
			if (!p.hasPermission("air.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/air <Player>");
				return true;
			}
			final Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.RED + "Could not find player "
						+ args[0]);
				return true;
			}
			loc.setY((1.0D / 0.0D));
			target.teleport(loc);
			target.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 1);
			p.sendMessage(Gray + "You have put " + Red + args[0] + Gray + " in the sky");					
		}

		if (cmd.getName().equalsIgnoreCase("checkban")) {
			if (!p.hasPermission("checkban.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/checkban <player>");
				return true;
			}
			OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
			if (target.isBanned()) {
				sender.sendMessage(Gray + "Player " + Red + "'" + target.getName() + "'" + Gray + " is banned from the server for");												
				return true;
			}
			sender.sendMessage(Gray + "Player " + Red + "'" + target.getName() + "'" + Gray + " is not banned from the server");					
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("relore")) {
			if (!p.hasPermission("lore.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if ((p.getItemInHand() != null)
					&& (!p.getItemInHand().getType().equals(Material.AIR))) {
				if (args.length == 1) {
					ItemStack itemStack = p.getItemInHand();

					String string = args[0];
					String colouredString = ChatColor.translateAlternateColorCodes('&', string);
					String spacedString = colouredString.replaceAll("_", " ");
					String[] loreNotConverted = spacedString.split(";");                         
					List<String> lore = new ArrayList<String>();
					for (String s : loreNotConverted) {
						lore.add(s);
					}

					ItemMeta itemStackMeta = itemStack.getItemMeta();
					itemStackMeta.setLore(lore);

					itemStack.setItemMeta(itemStackMeta);

					p.sendMessage(ChatColor.GRAY + "Succesfully set the lore of the item in your hand to: " + ChatColor.RED + colouredString);
							
							
				} else {
					p.sendMessage(error);
					p.sendMessage(ChatColor.GRAY + "/lore <name>");
				}
			} else {
				p.sendMessage(usage);
				p.sendMessage(ChatColor.GRAY + "You are not holding an item in your hand");				
			}
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("forcefall")) {
			if (!p.hasPermission("forcefall.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/forcefall <Player>");
				return true;
			}
			final Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.RED + "Could not find player " + args[0]);						
				return true;
			}
			p.sendMessage(Gray + "You have forcefalled " + target.getName());
			loc.setY((500.0D));
			target.teleport(loc);
			target.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 1, 1);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {								
				            target.teleport(Bukkit.getWorld("DreamZ").getSpawnLocation());
							target.playSound(p.getLocation(), Sound.WITHER_DEATH, 1, 1);									
							target.sendMessage(Red + "You have been saved!");
							target.setFallDistance(0);
						}
					}, 130);
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("freeze")) {
			if (!p.hasPermission("freeze.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				sender.sendMessage(Gray + "/freeze <player>");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(error);
				sender.sendMessage(ChatColor.GRAY + "Could not find player " + "'" + args[0] + "'");						
				return true;
			}
			if (Lists.frozen.contains(target.getName())) {
				Lists.frozen.remove(target.getName());
				sender.sendMessage(ChatColor.RED + target.getName() + " §6has been unfrozen!");						
				return true;
			}
			Lists.frozen.add(target.getName());
			sender.sendMessage(ChatColor.RED + target.getName() + " §6has been frozen");					
		}

		if (cmd.getName().equalsIgnoreCase("clearamount")) {
			if (!p.hasPermission("clearamount.yes")) {
				p.sendMessage(ChatColor.RED + "You do not have permission to do this");						
				return true;
			}
			try {
				if (args.length == 0) {
					p.sendMessage(error);
					p.sendMessage(ChatColor.GRAY + "/clearamount <amount>");
					return true;
				}
				final int am = Integer.parseInt(args[0]);
				if (am == 0 || (am < 0)) {
					p.sendMessage(usage);
					p.sendMessage(ChatColor.GRAY + "The number must be above 0");
					return true;
				}
				if (args[0].length() >= 5) {
					p.sendMessage(usage);
					p.sendMessage(ChatColor.GRAY + "This number is way to big, pleas use a lower number");							
					return true;
				}

				for (int i = 0; i < am; i++) {
					Bukkit.broadcastMessage(ChatColor.WHITE + " ");
				}
				Bukkit.broadcastMessage(ChatColor.RED + p.getName() + " has just cleard " + args[0] + " lines of chat");						
			} catch (NumberFormatException e) {
				p.sendMessage(usage);
				p.sendMessage(ChatColor.GRAY + "You must put a number");
				return true;
			}

		}		
		
		if (cmd.getName().equalsIgnoreCase("np")) {
			if (!p.hasPermission("nopickup.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.nopick.containsKey(p.getDisplayName())) {
				Lists.nopick.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "You will no longer pickup items");						
				return true;
			}
			if (Lists.nopick.containsKey(p.getDisplayName())) {
				Lists.nopick.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "You are now able to pickup items");						
				return true;
			}
		}
		

		if (cmd.getName().equalsIgnoreCase("dcommand")) {
			if (!p.hasPermission("dcommand.yes")) {
				p.sendMessage(perm);
				return true;
			}
			for (Player all : Bukkit.getOnlinePlayers()) {
				if (!Lists.nether.containsKey(all.getDisplayName())) {
					Lists.nether.put(all.getDisplayName(), all);
					String dcommandOff = getConfig().getString("clash.dcommandOff");
			        dcommandOff = dcommandOff.replaceAll("&", "§");
			        dcommandOff = dcommandOff.replaceAll("%player", p.getName());
					Bukkit.broadcastMessage(dcommandOff);														
					return true;
				}
				if (Lists.nether.containsKey(all.getDisplayName())) {
					Lists.nether.remove(all.getDisplayName());
					String dcommandOn = getConfig().getString("clash.dcommandOn");
					dcommandOn = dcommandOn.replaceAll("&", "§");
			        dcommandOn = dcommandOn.replaceAll("%player", p.getName());
					Bukkit.broadcastMessage(dcommandOn);											
					return true;
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("enderbow")) {
			if (!p.hasPermission("enderbow.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.enderbow.containsKey(p.getDisplayName())) {
				Lists.enderbow.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "Enderbow has been enabled");
				return true;
			}
			if (Lists.enderbow.containsKey(p.getDisplayName())) {
				Lists.enderbow.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "Enderbow has been disabled");
				return true;
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("namesound")) {
			if (!p.hasPermission("namesound.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.namesound.containsKey(p.getDisplayName())) {
				Lists.namesound.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "Name sound has now been enabled");
				return true;
			}
			if (Lists.namesound.containsKey(p.getDisplayName())) {
				Lists.namesound.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "Name sound is now disabled");
				return true;
			}
		}
	

		if (cmd.getName().equalsIgnoreCase("iname")) {
			if (!p.hasPermission("iname.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.iname.containsKey(p.getDisplayName())) {
				Lists.iname.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "Item name turned on");
				return true;
			}
			if (Lists.iname.containsKey(p.getDisplayName())) {
				Lists.iname.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "Item name turned off");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("instatnt")) {
			if (!p.hasPermission("instatnt.yes")) {
				p.sendMessage(donor);
				return true;
			}
			if (!Lists.instatnt.containsKey(p.getDisplayName())) {
				Lists.instatnt.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "You can now ignite tnt by right clicking it");
						
				return true;
			}
			if (Lists.instatnt.containsKey(p.getDisplayName())) {
				Lists.instatnt.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "Instant tnt is now disabled");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("nokick")) {
			if (!p.hasPermission("nokick.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.nokick.containsKey(p.getDisplayName())) {
				Lists.nokick.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "You will no longer be able to be kicked");
						
				return true;
			}
			if (Lists.nokick.containsKey(p.getDisplayName())) {
				Lists.nokick.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "You can now get kicked from the game");
						
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("hideall")) {
			if (!p.hasPermission("hideall.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/hideall <on, off>");
				return true;
			}
			if (args[0].equalsIgnoreCase("on")) {
				Lists.hidden.add(p);
				for (Player all : Bukkit.getServer().getOnlinePlayers())
					p.hidePlayer(all);
				p.sendMessage(Gray + "All players are now invisible");
				return true;
			}
			if (args[0].equalsIgnoreCase("off")) {
				Lists.hidden.remove(p.getDisplayName());
				for (Player all : Bukkit.getServer().getOnlinePlayers())
					p.showPlayer(all);
				p.sendMessage(Gray + "All players are now visible");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("speedmode")) {
			if (!p.hasPermission("speedmode.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (!Lists.speedmode.containsKey(p.getDisplayName())) {
				Lists.speedmode.put(p.getDisplayName(), p);
				p.sendMessage(ChatColor.GRAY + "Speed mode has been activated");
				return true;
			}
			if (Lists.speedmode.containsKey(p.getDisplayName())) {
				Lists.speedmode.remove(p.getDisplayName());
				p.sendMessage(ChatColor.GRAY + "Speed mode has been disabled");
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("tablist")) {
			if (!p.hasPermission("tablist.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/tablist <TabListName>");
				return true;
			}
			if (args[0].length() >= 16) {
				p.sendMessage(usage);
				p.sendMessage(ChatColor.GRAY + "You can only have 16 characters in your tablistname");		
				return true;
			}
			if (args.length == 1) { 
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				str.append(args[i] + " ");
			}

			String system = str.toString();
			system = system.replaceAll("&", "§");
			p.getPlayerListName();
			p.setPlayerListName(system);
			p.sendMessage(Gray + "You have set you tablist name to " + ChatColor.RED + system);					
			p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
			return true;
		}else {
			p.sendMessage(usage);
			p.sendMessage(Gray + "Incorrect usage try again");
			return true;
		}
		}

		if (cmd.getName().equalsIgnoreCase("date")) {
			Date c = new Date();
			p.sendMessage(ChatColor.GRAY + " Month: " + ChatColor.RED + ChatColor.BOLD + "12" + ChatColor.GRAY + " Day: " + ChatColor.RED + ChatColor.BOLD + c.getDate() + ChatColor.GRAY + " Year: " + ChatColor.RED+ ChatColor.BOLD + "2013");																				
		}

		if (cmd.getName().equalsIgnoreCase("cleardrop")) {
			if (!p.hasPermission("cleardrop.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/cleardrop <radius>");
			}
			if (args.length == 1) {
				try {

					final int radius = Integer.parseInt(args[0]);
					List<Entity> nearby = p.getNearbyEntities(radius, radius , radius);	
					
					if (radius <= 0) {
						p.sendMessage(usage);
						p.sendMessage(Gray + "Number must be above 0");
						return true;
					}

					for (Entity tmp : nearby) {

						if (tmp instanceof LivingEntity
								| tmp instanceof ItemFrame) {

						} else {

							tmp.remove();

						}

					}

					Bukkit.broadcastMessage(ChatColor.RED + p.getName() + ChatColor.GRAY + " has just removed entities in a radius of " + ChatColor.RED + radius);
					
				} catch (Exception e) {
					p.sendMessage(usage);
					p.sendMessage(Gray + "Please enter a number");
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("staffchat")) {
			if (!p.hasPermission("sc.use")) {
				p.sendMessage(ChatColor.RED + "You are not a staff member");
				return true;
			}

			if (args.length == 0) {
				if (Lists.in.contains(p))
					Lists.in.remove(p);
				else
					Lists.in.add(p);

				p.sendMessage(ChatColor.RED + "You are " + (Lists.in.contains(p) ? "now in" : "no longer in") + " staff chat mode.");
						
						
			} else {
				String msg = "";

				for (String arg : args) {
					msg += arg;
				}

				for (Player all : Bukkit.getServer().getOnlinePlayers()) {
					if (all.hasPermission("sc.use"))
						all.sendMessage(Aqua + p.getName() + ": " + msg);
				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("slowstop")) {
			if (!p.hasPermission("slowstop.yes")) {
				p.sendMessage(perm);
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "===============================");					
			Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "SERVER RESTARTING IN 1 min");					
			Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "SERVER RESTARTING IN 1 min");					
			Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "===============================");
					

			Bukkit.savePlayers();
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				      public void run() {							
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting in 40 seconds");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
						}
					}, 500);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");								
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting in 35 seconds");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
						}
					}, 600);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting in 30 seconds");									
							Bukkit.broadcastMessage(Pink + "================================");									
						}
					}, 700);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {						
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting in 25 seconds");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
						}
					}, 800);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {						
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");								
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting in 20 seconds");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");
									
						}
					}, 900);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {						
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting in 10 seconds");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");
									
						}
					}, 1000);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {						
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting in 20 seconds be ready");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
						}
					}, 1200);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {						
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Server restarting Now");									
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "================================");									
							Bukkit.shutdown();
						}
					}, 1300);

			return true;
		}

		if ((cmd.getName().equalsIgnoreCase("fsay"))) {
			if (!p.hasPermission("fsay.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				sender.sendMessage(ChatColor.GRAY + "/fsay <player> <message>");
				return true;
			}
			if (args.length == 1) {
				p.sendMessage(error);
				sender.sendMessage(ChatColor.GRAY + "/fsay <player> <message>");
			} else if (args.length >= 2) {
				Player user = Bukkit.getServer().getPlayer(args[0]);
				if (user == null) {
					StringBuilder message = new StringBuilder(args[1]);
					for (int arg = 2; arg < args.length; arg++)
						message.append(" ").append(args[arg]);
					return true;
				}

				StringBuilder message = new StringBuilder(args[1]);
				for (int arg = 2; arg < args.length; arg++)
					message.append(" ").append(args[arg]);
				user.chat(message.toString());
			}
		}

		if (cmd.getName().equalsIgnoreCase("copyinv")) {
			if (!p.hasPermission("copyinv.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/copyinv <Player>");
			}
			if (args.length == 1) {

				Player all = Bukkit.getPlayer(args[0]);

				if (all == null) {

					p.sendMessage(ChatColor.RED + "That player does not exist!");

				} else {

					ItemStack[] armor = all.getInventory().getArmorContents();

					p.getInventory().clear();

					p.getInventory().setArmorContents(null);

					p.getInventory().setArmorContents(armor);

					ItemStack[] inv = all.getInventory().getContents();

					HashMap<Player, ItemStack[]> itemhash = new HashMap<Player, ItemStack[]>();

					itemhash.put(p, inv);

					ItemStack[] items = itemhash.get(p);

					p.getInventory().setContents(items);

					p.sendMessage(ChatColor.GRAY + "Copying " + ChatColor.RED + all.getName() + Gray + " Inventory");							

				}
			}
		}

		if (cmd.getName().equalsIgnoreCase("myip")) {
			p.sendMessage(ChatColor.GRAY + "Your Ip Is " + p.getAddress().getHostName());					
		}

		if (cmd.getName().equalsIgnoreCase("gmute")) {
			if ((sender.hasPermission("chat.talk")) || (sender.isOp())) {
				if (args.length == 0) {
					if (!Lists.muteall) {
						Lists.muteall = true;
						String ChatMuted = getConfig().getString("clash.ChatMuted");
						ChatMuted = ChatMuted.replaceAll("&", "§");
						ChatMuted = ChatMuted.replaceAll("%player", p.getName());
						Bukkit.broadcastMessage(ChatMuted);																																
						return true;
					}
					Lists.muteall = false;
					String UnMuted = getConfig().getString("clash.UnMuted");
					UnMuted = UnMuted.replaceAll("&", "§");
					UnMuted = UnMuted.replaceAll("%player", p.getName());
					Bukkit.broadcastMessage(UnMuted);														
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You do not have permission to mute chat");						
			}

			return true;
		}

		if (cmd.getName().equalsIgnoreCase("serverinfo")) {
			String Email = getConfig().getString("clash.Email");
			Email = Email.replaceAll("&", "§");
	        Email = Email.replaceAll("%player", p.getName());
			p.sendMessage(ChatColor.GRAY + "Email: " + Email );
			String Website = getConfig().getString("clash.Website");
			Website = Website.replaceAll("&", "§");
			Website = Website.replaceAll("%player", p.getName());
			p.sendMessage(Gray + "Website: " + Website);
			String DonationPage = getConfig().getString("clash.DonationPage");
			DonationPage = DonationPage.replaceAll("&", "§");
	        DonationPage = DonationPage.replaceAll("%player", p.getName());
			p.sendMessage(ChatColor.GRAY + "Donation Page: " + DonationPage);
			String Account = getConfig().getString("clash.Account");
			Account = Account.replaceAll("&", "§");
			Account = Account.replaceAll("%player", p.getName());
			p.sendMessage(ChatColor.GRAY + "Your Account: " + Account);
		}

		if (cmd.getName().equalsIgnoreCase("say")) {
			if (!p.hasPermission("say.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/say <Message>");
				return true;
			}
			String msg = "";
			for (String arg : args) {
				msg = msg + arg + " ";
			}

			msg = msg.substring(0, msg.length() - 1);

			msg = msg.replaceAll("&", "§");

			Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + msg);
		}

		if (cmd.getName().equalsIgnoreCase("ip")) {
		    String ServerIp = getConfig().getString("clash.ServerIp");
		    ServerIp = ServerIp.replaceAll("&", "§");
		    ServerIp = ServerIp.replaceAll("%player", p.getName());
			p.sendMessage(ChatColor.GRAY + "You are connected to: " + ServerIp);
		}
		
		if (cmd.getName().equalsIgnoreCase("dcommon")) {
			if (!p.hasPermission("ccommon.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/dCommon <reload, stop, info, restart>");
				return true;
			}
			if (args[0].equalsIgnoreCase("help")) {
				p.sendMessage(Red + "--- " + Gray + "dCommon" + Red + "---");
				p.sendMessage(Blue + "/" + Gray + "dCommon");
				return true;
			}
			if (args[0].equalsIgnoreCase("rl") | args[0].equalsIgnoreCase("reload")) {
				reloadConfig();
				p.sendMessage(Gray + pdf.getName() + Red + " " + pdf.getVersion() + Gray + " has been reloaded");
				return true;
		}
			if (args[0].equalsIgnoreCase("restart") | args[0].equalsIgnoreCase("rs")) {
				pm.enablePlugin(this);
				pm.disablePlugin(this);
				p.sendMessage(Gray + pdf.getName() + Red + " " + pdf.getVersion() + Gray + " has been restarted");
				return true;
		}
			if (args[0].equalsIgnoreCase("stop") | args[0].equalsIgnoreCase("disable")) {
				Bukkit.getPluginManager().disablePlugin(this);
				p.sendMessage(Gray + pdf.getName() + Red + " has been disabled");
				return true;
		}
			if (args[0].equalsIgnoreCase("info") | args[0].equalsIgnoreCase("information")) {
				p.sendMessage(Gray + "Name: " + Blue + pdf.getName());
				p.sendMessage(Gray + "Author: " + Blue + "Leaked");
				p.sendMessage(Gray + "Version: " + Blue + pdf.getVersion());
				return true;
		}
		}

		if (cmd.getName().equalsIgnoreCase("ci")) {
			if (!p.hasPermission("ci.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				pi.clear();
				p.sendMessage(ChatColor.GOLD + "Inventory cleared");
				return true;
			}
			if (args[0].equalsIgnoreCase("full") | args[0].equalsIgnoreCase("all")) {
				Utils.clearinv(p);
				p.sendMessage(Gold + "You have cleared your inventory and armor");						
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(ChatColor.RED + "Invaled Arguments");
				p.sendMessage(ChatColor.GRAY + "Could not find player " + "'" + args[0] + "'");						
				return true;
			}
			if (args.length == 1) {
				target.getInventory().clear();
				p.sendMessage(ChatColor.GOLD + "You have cleard " + target.getDisplayName() + "'s inventory");						
				return true;
			}
		}

		if (cmd.getName().equalsIgnoreCase("foodlevel")) {
			p.sendMessage(ChatColor.GRAY + "Your Food Level Is " + p.getFoodLevel());					
		}

		if (cmd.getName().equalsIgnoreCase("cc")) {
			if (!p.hasPermission("cc.yes")) {
				p.sendMessage(perm);
				return true;
			}
			for (int i = 0; i < 200; i++) {
				Bukkit.broadcastMessage(" ");
			}
			Bukkit.broadcastMessage(ChatColor.RED + "Chat has been cleared by " + p.getName());					
		}

		if (cmd.getName().equalsIgnoreCase("clearsome")) {
			if (!p.hasPermission("clearsome.yes")) {
				p.sendMessage(perm);
				return true;
			}
			for (int i = 0; i < 10; i++) {
				Bukkit.broadcastMessage(ChatColor.WHITE + " ");
			}
			Bukkit.broadcastMessage(ChatColor.RED + "Some of chat has been cleared by " + p.getName());					
		}

		if (cmd.getName().equalsIgnoreCase("bc")) {
			if (!p.hasPermission("bc.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/bc <Message>");
				return true;
			}
			String msg = "";
			for (String arg : args) {
				msg = msg + arg + " ";
			}

			msg = msg.substring(0, msg.length() - 1);

			msg = msg.replaceAll("&", "§");
			
			if (config.getString("clash.BcMessage").contains("none")) {
				Bukkit.broadcastMessage(msg);
			}else {
            	String BcMessage = getConfig().getString("clash.BcMessage");
            	BcMessage = BcMessage.replaceAll("&", "§");
            	BcMessage = BcMessage.replaceAll("%player", p.getName());
			Bukkit.broadcastMessage(BcMessage + msg);
		}
		}

		if (cmd.getName().equalsIgnoreCase("tip")) {
			if (!p.hasPermission("tip.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/tip <Message>");
				return true;
			}
			String msg = "";
			for (String arg : args) {
				msg = msg + arg + " ";
			}

			msg = msg.substring(0, msg.length() - 1);

			msg = msg.replaceAll("&", "§");

			Bukkit.broadcastMessage(DarkRed + "[" + ChatColor.GREEN + "Tip" + ChatColor.DARK_RED + "]" + ChatColor.AQUA + ChatColor.BOLD + " " + msg);										
		}

		if (cmd.getName().equalsIgnoreCase("broadcast")) {
			if (!p.hasPermission("broadcast.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/brodcast <Message>");
				return true;
			}
			String msg = "";
			for (String arg : args) {
				msg = msg + arg + " ";
			}

			msg = msg.substring(0, msg.length() - 1);

			msg = msg.replaceAll("&", "§");
			String BroadcastMessage = getConfig().getString("clash.BroadcastMessage");
			BroadcastMessage = BroadcastMessage.replaceAll("&", "§");
			BroadcastMessage = BroadcastMessage.replaceAll("%player", p.getName());

			Bukkit.broadcastMessage(BroadcastMessage + ChatColor.GREEN + " " + msg + " -" + sender.getName());										
		}

		if (cmd.getName().equalsIgnoreCase("info")) {
			if (!p.hasPermission("info.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(ChatColor.GRAY + "/info <Message>");
				return true;
			}
			String msg = "";
			for (String arg : args) {
				msg = msg + arg + " ";
			}

			msg = msg.substring(0, msg.length() - 1);

			msg = msg.replaceAll("&", "§");

			Bukkit.broadcastMessage(ChatColor.GRAY + "[" + Red + "INFO" + Gray + "] " + msg);					
		}

		if (cmd.getName().equalsIgnoreCase("ranks")) {
			p.sendMessage(Purple + "------ McDreamz's Ranks ------");
			p.sendMessage("Fixing Code, Sorry!");
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("kick")) {
			if (!p.hasPermission("kick.yes")) {
				p.sendMessage(perm);
				return true;
			}

			if (args.length == 0) {
				sender.sendMessage(error);
				sender.sendMessage(ChatColor.GRAY + "/kick <Player> <Reason>");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + "!");			
				return true;
			}

			String msg = "";

			if (args.length > 1) {
				msg = " for ";
				for (int i = 1; i < args.length; i++) {
					msg = msg + args[i] + " ";
				}
			}
			String KickColor = getConfig().getString("clash.KickColor");
			KickColor = KickColor.replaceAll("red", "§c");
			KickColor = KickColor.replaceAll("gray", "§7");
			KickColor = KickColor.replaceAll("blue", "§1");
			KickColor = KickColor.replaceAll("green", "§a");
			KickColor = KickColor.replaceAll("darkgreen", "§2");
			KickColor = KickColor.replaceAll("darkred", "§4");
			KickColor = KickColor.replaceAll("pink", "§d");
			KickColor = KickColor.replaceAll("gold", "§6");
			KickColor = KickColor.replaceAll("aqua", "§b");
			KickColor = KickColor.replaceAll("yellow", "§a");
			KickColor = KickColor.replaceAll("aqua", "§b");
			KickColor = KickColor.replaceAll("black", "§1");
			KickColor = KickColor.replaceAll("&", "§1");
			target.kickPlayer(ChatColor.RED + "You have been kicked by " + sender.getName() + msg);					
			Bukkit.broadcastMessage(KickColor + target.getName() + " has been kicked" + msg);					
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("leave")) {
			if (!p.hasPermission("leave.yes")) {
				p.sendMessage(perm);
				return true;
			}
			p.kickPlayer(ChatColor.RED + "You have force left the game");
		}

		if (cmd.getName().equalsIgnoreCase("lag")) {
			Player player = (Player) sender;
			double tps = LagManager.getTPS();
			double lag = Math.round((1.0D - tps / 20.0D) * 100.0D);

			player.sendMessage(ChatColor.RED + "Server running at " + ChatColor.GOLD + tps + ChatColor.RED + " tps");					
			player.sendMessage(ChatColor.RED + "Lag is about " + ChatColor.GOLD + lag + ChatColor.RED + "%");					
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("ping")) {
			if(args.length == 0) {
				String ping = null;
				  for (Method meth : p.getClass().getMethods()) {          
                      if (meth.getName().equals("getHandle")) {      
                              try {          
                                      Object obj = meth.invoke(p, (Object[])null);            
                                      for (Field field : obj.getClass().getFields())                
                                              if (field.getName().equals("ping"))                  
                                                      ping = String.valueOf(field.getInt(obj));          
                              }          
                              catch (Exception e)        
                              {
                            	  e.printStackTrace();          
                              }          
                      }      
              }
              sender.sendMessage(ChatColor.GRAY + "Your ping is: " + ChatColor.DARK_GREEN + ping + ChatColor.GRAY + " ms");    
      }   

		 if (args.length > 0) {    
             Player all = Bukkit.getPlayer(args[0]);    
             if (all != null) {      
                     String ping = null;      
                     for (Method meth : all.getClass().getMethods()) {      
                             if (meth.getName().equals("getHandle")) {  
                                     try {      
                                             Object obj = meth.invoke(p, (Object[])null);        
                                             for (Field field : obj.getClass().getFields())        
                                                     if (field.getName().equals("ping"))            
                                                             ping = String.valueOf(field.getInt(obj));
  
                                     }          
                                     catch (Exception e) {            
                                             e.printStackTrace();            
                                     }            
                             }          
                     }

                     sender.sendMessage(ChatColor.GRAY + all.getName() + "'s ping is: " + ChatColor.DARK_GREEN + ping + ChatColor.GRAY + " ms");      
             } else {        
                     sender.sendMessage(ChatColor.RED + "Player not found.");

             }      
              
		 }
     }

		if (cmd.getName().equalsIgnoreCase("fleave")) {
			if (!p.hasPermission("fjoin.yes")) {
				p.sendMessage(perm);
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.WHITE + p.getName() + " has left the game");					
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("staff")) {
			this.sendOnlineInfo(sender);
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("kreload")) {
			if (!p.hasPermission("reload.yes")) {
				p.sendMessage(perm);
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.RED + "[Info] " + ChatColor.GREEN + ChatColor.GREEN + p.getName() + " Is reloading the server will lag");										
			Bukkit.broadcastMessage(ChatColor.RED + "Reload Complete");
			Bukkit.reload();
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("fjoin")) {
			if (!p.hasPermission("fjoin.yes")) {
				p.sendMessage(perm);
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.WHITE + p.getName() + " has joined the game");					
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("drop")) {
			if (!p.hasPermission("drop.yes")) {
				p.sendMessage(perm);
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(error);
				p.sendMessage(Gray + "/drop <help, types, list>");
				return true;
			}
			if (args[0].equalsIgnoreCase("help") | args[0].equalsIgnoreCase("helpme") | args[0].equalsIgnoreCase("help")) {
				p.sendMessage(Red + "✧ " + Blue + ChatColor.BOLD + "                     Help Menu                            " + Red + " ✧");
				p.sendMessage(Red + "[" + Gray + "+" + Red + "]" + Gray + " /drop is a command that allows the user to remotely drop a target for a minecraft error message.");
				p.sendMessage(Red + "[" + Gray + "+" + Red + "]" + Gray + " There are many diffrent options to choose from.");
				p.sendMessage(Gray + "- " + Blue + "To drop a player do §7/drop §9<§7player§9> <§7error§9>");
				p.sendMessage(Gray + "- " + Blue + "To list the types of error's do §7/drop type");
				p.sendMessage(Gray + "- " + Blue + "To get a list of error's and the number do §7/drop list");
				return true;
			}
			if (args[0].equalsIgnoreCase("types") | args[0].equalsIgnoreCase("type") | args[0].equalsIgnoreCase("t")) {
				p.sendMessage(Red + "✧ " + Blue + ChatColor.BOLD + "   All Types Of Errors   " + Red + " ✧");
				p.sendMessage(Red + "[" + Gray + "+" + Red + "]" + Gray + " <error> - <kick message>");
				p.sendMessage(" §c● §9Stream §7- §3End of stream");
				p.sendMessage(" §c● §9Hacked §7- §3You logged in from another location");
				p.sendMessage(" §c● §9Error §7- §3Java error message");
				p.sendMessage(" §c● §9Login §7- §3Failed to login: Invalid session");
				p.sendMessage(" §c● §9Drop §7- §3Long java error message");
				return true;
			}
			if (args[0].equalsIgnoreCase("list") | args[0].equalsIgnoreCase("all") | args[0].equalsIgnoreCase("number")) {
				p.sendMessage(Red + "✧ " + Blue + ChatColor.BOLD + " Lists Of Errors " + Red + " ✧");
				p.sendMessage(Red + "[" + Gray + "+" + Red + "]" + Gray + " /drop <number>");
				p.sendMessage("§01.) §7End of stream");
				p.sendMessage("§02.) §7You logged in from another location");
				p.sendMessage("§03.) §7Java error message");
				p.sendMessage("§04.) §7Failed to login: Invalid session");
				p.sendMessage("§05.) §7Long java error message");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				sender.sendMessage(ChatColor.RED + "Could not find player " + args[0] + ".");				
				return true;
			}
			if (args.length == 2) {
			if (args[1].equalsIgnoreCase("stream") | args[1].equalsIgnoreCase("eos") | args[1].equalsIgnoreCase("logout") | args[1].equalsIgnoreCase("1")) {
				target.kickPlayer("End of stream");
				p.sendMessage(Gray + "You have droped " + Red + args[0] + Gray + " for End of stream");
				return true;
			}
			if (args[1].equalsIgnoreCase("hacked") | args[1].equalsIgnoreCase("location") | args[1].equalsIgnoreCase("dl") | args[1].equalsIgnoreCase("2")) {
				target.kickPlayer("You logged in from another location");
				p.sendMessage(Gray + "You have droped " + Red + args[0] + Gray + " for location log in");
				return true;
			}
			if (args[1].equalsIgnoreCase("error") | args[1].equalsIgnoreCase("javaerror") | args[1].equalsIgnoreCase("503") | args[1].equalsIgnoreCase("3")) {
				target.kickPlayer("java.io.IOException: Server returned HTTP response code: 503");
				p.sendMessage(Gray + "You have droped " + Red + args[0] + Gray + " for Java Error");
				return true;
			}
			if (args[1].equalsIgnoreCase("login") | args[1].equalsIgnoreCase("fl") | args[1].equalsIgnoreCase("faildlogin") | args[1].equalsIgnoreCase("4")) {
				target.kickPlayer("Failed to login: Invalid session (Try restarting your game)");
				p.sendMessage(Gray + "You have droped " + Red + args[0] + Gray + " for Failed to login");
				return true;
			}
			if (args[1].equalsIgnoreCase("drop") | args[1].equalsIgnoreCase("default") | args[1].equalsIgnoreCase("bye") | args[1].equalsIgnoreCase("5")) {
				target.kickPlayer("Java Exception: Socket reset | End of Stream | in com.bukkit.minecraftServer.Connection ln 3712 at Java.Sockets.Connection.TCP Unhandled exception: Java.Exception.Streams.EndOFStream");
				p.sendMessage(Gray + "You have droped " + Red + args[0] + Gray + " for Long Error");
				return true;
			}
		}else {
			p.sendMessage(error);
			p.sendMessage(Gray + "/drop <help, types, list>");
		}
		}
	


		if (cmd.getName().equalsIgnoreCase("kill")) {
			p.setHealth(0);
			p.sendMessage(ChatColor.GOLD + "You have been killed");
			return true;
		}

	    if (cmd.getName().equalsIgnoreCase("soup")) {
	    	if (!p.hasPermission("soup.yes")) {
	    		p.sendMessage(ChatColor.GRAY + "You must donate for this command");  		
	    		return true;
	    	}
	    	if (Lists.cooldown.contains(p)) {
	            p.sendMessage(ChatColor.RED + "You cannot perform this command yet");
	            return true;
	    }
	    	
	                    p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 64));
	                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
	                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 1));
	                    p.sendMessage(ChatColor.GRAY + "You have been given 64 soup");
	                    p.sendMessage(ChatColor.GRAY + "You must wait 40 minutes befor doing this command again");
	                    Lists.cooldown.add(p);
	                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	                        public void run() {
	                                Lists.cooldown.remove(p);
	                                p.sendMessage(ChatColor.RED + "You can now do /soup");
	                        }
	                        
	                }, 48000);
	                return true;
	            }
		return true;

	}

}
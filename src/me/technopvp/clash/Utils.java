package me.technopvp.clash;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Utils extends JavaPlugin {

	static Main main;
	
	public static World world;
	
    public static Main plugin;
    public static World nether;
    public static Server server;
    
    public static void Initialize(Main plugin) {
        Utils.plugin = plugin;
        Utils.server = plugin.getServer();
        Utils.world = server.getWorlds().get(0);
       
       
}
	
    public static void sendBoldMessage(Player p, ChatColor ch, String msg) {
    	p.sendMessage(ChatColor.GRAY + "" + ch + ChatColor.BOLD + msg);
    }
    
	public static void give(Player p, Material item, int amount) {
		p.getInventory().addItem(new ItemStack(item, amount));
	}
	
	public static void build(Location loc1, Location loc2, World world, Material block) {
		 
		int minx = Math.min(loc1.getBlockX(), loc2.getBlockX()),
				miny = Math.min(loc1.getBlockY(), loc2.getBlockY()),
				minz = Math.min(loc1.getBlockZ(), loc2.getBlockZ()),
				maxx = Math.max(loc1.getBlockX(), loc2.getBlockX()),
				maxy = Math.max(loc1.getBlockY(), loc2.getBlockY()),
				maxz = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
		for(int x = minx; x<=maxx;x++){
			for(int y = miny; y<=maxy;y++){
				for(int z = minz; z<=maxz;z++){
					Block b = world.getBlockAt(x, y, z);
					b.setType(block);
				}
			}
		}
	}
	
	public static void removepots(Player p){
		
		for(PotionEffect effects : p.getActivePotionEffects()){
		
			p.removePotionEffect(effects.getType());
		
		}
	
	}
	
	
	public static void perm(Player p) {
		FileConfiguration config = Main.plugin.getConfig();
		String perm = config.getString("clash.PermissionMessage");
        perm = perm.replaceAll("&", "§");
        p.sendMessage(perm);
	}
	
    
	public static void tp(Player p, int x, int y, int z) {
		p.teleport(new Location(p.getWorld(), x, y, z));
	}
	
	public static void spawn(Player p) {
		p.teleport(p.getWorld().getSpawnLocation());
	}
	
	public static String getMessage(final String[] args, final int start) {
		final StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = start; i < args.length; i++) {
			if (i != start) {
				stringBuilder.append(" ");
			}
			
			stringBuilder.append(args[i]);
		}
		
		return stringBuilder.toString();
	}
	
	
	public static void clearinv(Player p){
		
		p.getInventory().clear();
		
		p.getInventory().setArmorContents(new ItemStack[] {
				null,
				null,
				null,
				null});								
	}
	
	public static void addPotion(Player p, PotionEffectType potion, int time, int level){
		
		int strength = level - 1;
		
		p.addPotionEffect(new PotionEffect(potion, time, strength));
	
	}
	
	public static void delPotion(Player p, PotionEffectType potion){
		
		p.removePotionEffect(potion);
		
	}
	
    public static long freeMem() {
		    return Runtime.getRuntime().freeMemory() / 1024L / 1024L;
		  }

    public static long maxMem() {
		    return Runtime.getRuntime().maxMemory() / 1024L / 1024L;
		  }

    public static long totalMem() {
		    return Runtime.getRuntime().totalMemory() / 1024L / 1024L;
		  }
	
	public static void removeLists(String name){
		
		Lists.cooldown.remove(name);
	}
	
	public static void addToList(String str, java.util.List<String> list){
		
		list.add(str);
		
	}
	
	public static void msg(Player p, ChatColor ch, String msg){
		
		p.sendMessage(ch + msg);
		
	}
	
	public static void forcesay(Player p, String msg) {
	  p.chat(msg);	
	}
	
	public static void kick(Player p, String msg) {
		p.kickPlayer(msg);
	}
	
    public static void getname(Player p){
		
		p.getDisplayName();
	}

	
	public static void heal(Player p){
		
		p.setSaturation(Integer.MAX_VALUE);
		
		p.setFoodLevel(20);
		
		p.setHealth(20);
	}
	
}

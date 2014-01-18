package me.technopvp.clash;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public abstract class Lists implements Plugin {
	
	Main main;
	
public Lists(Main plugin){
		
		main = plugin;
		
	}

     //HasMaps
	 public static HashMap<Player, Player> reply = new HashMap<Player, Player>();
	 public static HashMap<Player, Player> socialspy = new HashMap<Player, Player>();
	 final static HashMap<String, Player> nopick = new HashMap<String, Player>();
	 final static HashMap<String, Player> speedmode = new HashMap<String, Player>();
	 public final static HashMap<String, Player> CrazyPearl = new HashMap<String, Player>();
	 public final static HashMap<String, Player> CrazyPotion = new HashMap<String, Player>();
	 public final static HashMap<String, Player> CrazySmoke = new HashMap<String, Player>();
	 public final static HashMap<String, Player> CrazyFire = new HashMap<String, Player>();
	 public final static HashMap<String, Player> CrazyPoison = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccgreen = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccred = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccgold = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccblue = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccpink = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccpurple = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccyellow = new HashMap<String, Player>();
	 public final static HashMap<String, Player> ccbold = new HashMap<String, Player>();
	 final static HashMap<String, Player> nokick = new HashMap<String, Player>();
	 final static ArrayList<Player> hidden = new ArrayList<Player>();
	 final static HashMap<String, Player> instatnt = new HashMap<String, Player>();
	 final static HashMap<String, Player> iname = new HashMap<String, Player>();
	 final static HashMap<String, Player> enderbow = new HashMap<String, Player>();
	 final static HashMap<String, Player> nether = new HashMap<String, Player>();
	 public final static HashMap<String, Player> namesound = new HashMap<String, Player>();
	 public final static HashMap<Player, Boolean> muted = new HashMap<Player, Boolean>();
	  	  
	  //Booleans
	 public static boolean  muteall = false;
	 public static boolean success = false;
	 
	 //ArrayLists		 
	 static ArrayList<String> frozen = new ArrayList<String>();
	 static ArrayList<String> locked = new ArrayList<String>();
	 static ArrayList<String> staff = new ArrayList<String>();
	 static ArrayList<Player> in = new ArrayList<Player>();
	 
	 //Cooldowns 
	 static ArrayList<Player> cooldown = new ArrayList<Player>();
	 static ArrayList<Player> scd = new ArrayList<Player>();
}
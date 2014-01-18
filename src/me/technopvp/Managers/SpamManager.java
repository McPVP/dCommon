package me.technopvp.Managers;

import java.util.ArrayList;
import java.util.Hashtable;

import me.technopvp.clash.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("deprecation") 
public class SpamManager extends JavaPlugin implements Listener {
	
	
	public Main plugin;
	
	public SpamManager(Main instance) {
		plugin = instance;
	}
	
	  public static Hashtable<String, SpamManager> Players = new Hashtable<String, SpamManager>();
	  public ArrayList<ChatMessage> Messages;
	  public String PlayerName;
	  public Player Player;
	  public int Warnings;
	  public int Violations;
	  public long SilenceExpires;

	  public static void OnPlayerChat(PlayerChatEvent event)
	  {
	    String playerName = event.getPlayer().getName();
	    SpamManager check = (SpamManager)Players.get(playerName);

	    if (check == null)
	    {
	      check = new SpamManager(playerName);
	      Players.put(playerName, check);
	    }

	    check.AddMessage(event);
	  }

	  public SpamManager(String name)
	  {
	    this.Messages = new ArrayList<ChatMessage>();
	    this.PlayerName = name;
	    this.Warnings = 10;
	    this.Violations = 5;
	    this.SilenceExpires = 0L;
	  }

	public void AddMessage(PlayerChatEvent event)
	  {
	    this.Player = event.getPlayer();

	    ChatMessage message = new ChatMessage(this.Player, System.currentTimeMillis(), event.getMessage());
	    this.Messages.add(0, message);

	    if (IsSilenced())
	    {
	      event.setCancelled(true);

	      if (this.Warnings <= 0)
	      {
	    	  try {
	        this.Player.kickPlayer(ChatColor.RED + "You have been banned for spamming. if you think this is unfair pleas go to www.clashmc.com");
	        this.Player.setBanned(true);
	        Bukkit.broadcastMessage(ChatColor.GRAY + this.Player.getName() + " has been banned for spaming.");
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	        	public void run() {
	        		Player.setBanned(false);
	        	}
	        }, 200);
	        return;
	    	  }
	    	  catch (Exception er) {
	      }
	      }
	      
	      this.Player.sendMessage(ChatColor.RED + "============================================================");
	      this.Player.sendMessage(ChatColor.RED + "YOU ARE CURRENTLY SILENCED FOR SPAM! " + SilenceTimeRemaining() + " REMAINING.");
	      this.Player.sendMessage(ChatColor.RED + "IF YOU CONTINUE TO USE PUBLIC CHAT WHILE SILENCED, YOU WILL BE BANNED!");
	      this.Player.sendMessage(ChatColor.RED + "YOU HAVE " + this.Warnings + " WARNINGS REMAINING!");
	      this.Player.sendMessage(ChatColor.RED + "============================================================");

	      this.Warnings -= 1;
	    }
	    else
	    {
	      this.Warnings = 10;
	      CheckSpamming();
	    }

	    if (this.Messages.size() > 10)
	    {
	      this.Messages.remove(this.Messages.size() - 1);
	    }
	  }

	  public void CheckSpamming()
	  {
	    boolean isSpamming = false;
	    if (this.Messages.size() >= 3)
	    {
	      String msg = ((ChatMessage)this.Messages.get(0)).message;
	      boolean same = true;
	      for (int i = 1; i < 3; i++)
	      {
	        same = (same) && (msg.equals(((ChatMessage)this.Messages.get(i)).message));
	      }

	      long time = ((ChatMessage)this.Messages.get(0)).when - ((ChatMessage)this.Messages.get(2)).when;

	      isSpamming = (isSpamming) || (time < 1500L);

	      isSpamming = (isSpamming) || ((time < 5000L) && (same));
	    }

	    if (isSpamming)
	    {
	      Silence(60);
	      this.Warnings -= 1;
	    }
	  }

	  public void Silence(int seconds)
	  {
	    this.Violations -= 1;
	    this.SilenceExpires = (System.currentTimeMillis() + seconds * 1000);
	    this.Player.sendMessage(ChatColor.RED + "YOU HAVE BEEN SILENCED FOR SPAM FOR " + seconds + " SECONDS");
	    this.Player.sendMessage(ChatColor.RED + "IF YOU CONTINUE TO USE PUBLIC CHAT WHILE SILENCED, YOU WILL BE BANNED!");
	  }

	  public String SilenceTimeRemaining()
	  {
	    long left = (this.SilenceExpires - System.currentTimeMillis()) / 1000L;

	    if (left < 60L) {
	      return left + " SECONDS";
	    }
	    return left + " MINUTES";
	  }

	  public boolean IsSilenced()
	  {
	    return this.SilenceExpires > System.currentTimeMillis();
	  }

	  public void Clear() {
	    this.Messages.clear();
	  }

	  public class ChatMessage {
	    public Player player;
	    public long when;
	    public String message;

	    public ChatMessage(Player p, long w, String msg) {
	      this.player = p;
	      this.when = w;
	      this.message = msg;
	    }
	  }
	}
package me.technopvp.Managers;

import me.technopvp.clash.Lists;
import me.technopvp.clash.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class ChatColorManager extends Main {
	
	  @EventHandler
	  public void ChatColorGreen(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccgreen.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.GREEN  + message);
		  }
		  }
	  
	  
	  @EventHandler
	  public void ChatColorRed(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccred.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.RED + message);
		  }
		  }
	  
	  @EventHandler
	  public void ChatColorGold(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccgold.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.GOLD + message);
		  }
		  }
	  
	  @EventHandler
	  public void ChatColorBlue(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccblue.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.BLUE + message);
		  }
		  }
	  
	  @EventHandler
	  public void ChatColorPink(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccpink.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.LIGHT_PURPLE + message);
		  }
		  }
	  
	  @EventHandler
	  public void ChatColorYellow(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccyellow.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.YELLOW + message);
		  }
		  }
	  
	  @EventHandler
	  public void ChatColorBold(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccbold.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.BOLD + message);
		  }
		  }
	  
	  @EventHandler
	  public void ChatColorPurple(PlayerChatEvent e) {
		  Player p = e.getPlayer();
		  String message = e.getMessage();
		  if (Lists.ccpurple.containsKey(p.getDisplayName())) {
			 e.setMessage(ChatColor.DARK_PURPLE + message);
		  }
		  }

}

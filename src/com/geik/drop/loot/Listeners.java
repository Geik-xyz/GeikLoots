package com.geik.drop.loot;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Listeners implements Listener{
	
	private Main plugin;
	  
	  public Listeners(Main plugin){
		    this.plugin = plugin;}
	  
	  
	  @EventHandler
	  
	  public void onEntityDeath(EntityDeathEvent e)
	  {
	    if (e.getEntity().getKiller() != null)
	    {
	      Player p = e.getEntity().getKiller();
	      if (plugin.getConfig().isSet(String.valueOf(e.getEntityType()))){
	    	  Random random = new Random();
			  int n = random.nextInt(100) + 1;
			  for (String s : plugin.getConfig().getConfigurationSection(e.getEntityType() + ".NormalDrop").getKeys(false)){
				  int chance = plugin.getConfig().getInt(e.getEntityType() + ".NormalDrop." + s + ".Chance");
				  	if(n <= chance){
				  		e.getDrops().add(ConsItem.items(p, Integer.valueOf(s), e.getEntityType()));
				  	}
			  	}
			  for (String s : plugin.getConfig().getConfigurationSection(e.getEntityType() + ".CommandDrop").getKeys(false)){
				  int chance = plugin.getConfig().getInt(e.getEntityType() + ".CommandDrop." + s + ".Chance");
				  	if(n <= chance){
				  		for (String lootbox : plugin.getConfig().getStringList(e.getEntityType() + ".CommandDrop." + s + ".Command")){
							  lootbox = lootbox.replaceAll("&", "§");
							  lootbox = lootbox.replaceAll("%player%", p.getName());
		        			  Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), lootbox);}
				  	}
			  }
	      }
	    }
	  }
	  
}

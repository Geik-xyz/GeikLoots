package com.geik.drop.loot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ConsItem {
	@SuppressWarnings("unused")
	private Main plugin;
	  
	  public ConsItem(Main plugin){
		    this.plugin = plugin;}
		        
	  public static ItemStack items(Player player, int i, EntityType entityType) {
	    	File c = new File("plugins/" + Main.pluginName + "/config.yml");
	    	FileConfiguration cfg = YamlConfiguration.loadConfiguration(c);
	    	List<String> list = cfg.getStringList(entityType + ".NormalDrop." + i + ".ItemLore");
	    	List<String> newList = new ArrayList<String>();
	    	for (String string : list) {
	    		newList.add(string.replace("&", "§").replace("%player%", player.getName()));}
	    	String isim = cfg.getString(entityType + ".NormalDrop." + i + ".ItemName").replace("&", "§").replace("%player%", player.getName());
	    	String mat = cfg.getString(entityType + ".NormalDrop." + i + ".ItemMaterial");
	    	int b = cfg.getInt(entityType + ".NormalDrop." + i + ".ItemCount");
	    	ItemStack item = new ItemStack(Material.getMaterial(mat), b);
	    	ItemMeta meta = item.getItemMeta();
	    	meta.setDisplayName(isim);
	    	meta.setLore(newList);
	    	item.setItemMeta(meta);
	    	return item;
		  }
	  
}

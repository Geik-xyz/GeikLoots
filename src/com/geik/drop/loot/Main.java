package com.geik.drop.loot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static String pluginName = "GeikLoots";
	private Listeners listeners;
	public static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		this.listeners = new Listeners(this);
		Bukkit.getPluginManager().registerEvents(this.listeners, this);
		saveDefaultConfig();
		Bukkit.getConsoleSender().sendMessage(color("&6&lGeikLoots &aLoaded! Version: 2.0"));
		Bukkit.getConsoleSender().sendMessage(color("&6&lGeikLoots &aMade by Geik."));
        
        }
    @Override
    public void onDisable() {
    	
    }
    
    public static String color(String yazirengi){return ChatColor.translateAlternateColorCodes('&', yazirengi);}
    }

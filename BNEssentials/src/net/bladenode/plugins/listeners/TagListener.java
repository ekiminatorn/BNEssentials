package net.bladenode.plugins.listeners;

import net.bladenode.plugins.BNEssentials;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;


public class TagListener implements Listener{
	//This makes possible to get config in this class!
	BNEssentials plugin;
	
	public void TagsListener(BNEssentials instance) {
		//This makes possible to get config in this class!
		plugin = instance;
				
	}
	
/*	@EventHandler
 	public void onNameTag(PlayerReceiveNameTagEvent event) {
		
		
		//Staff tag coloring
		for(String name : plugin.getConfig().getStringList("colourtags.staffs")){
			
			if(event.getNamedPlayer().getName().equalsIgnoreCase(name)){
				event.setTag(ChatColor.BLUE + event.getNamedPlayer().getName());
			}		
		}
		//Admin tag coloring
		for(String name : plugin.getConfig().getStringList("colourtags.admins")){
			if(event.getNamedPlayer().getName().equalsIgnoreCase(name)){
				event.setTag(ChatColor.DARK_RED + event.getNamedPlayer().getName());
			}
		} */
		
		
	//Removed the hardcoded stuff, and now loops through the config file for the names.
		
		/*
		 * if(event.getNamedPlayer().getName().equals("hunter376398")){
              //If true, sets users tag to blue.
			event.setTag(ChatColor.BLUE + event.getNamedPlayer().getName());	
		}
		if(event.getNamedPlayer().getName().equals("okin336")){
            //If true, sets users tag to blue.
			event.setTag(ChatColor.BLUE + event.getNamedPlayer().getName());	
		}
		if(event.getNamedPlayer().getName().equals("goth_killer")){
            //If true, sets users tag to blue.
			event.setTag(ChatColor.BLUE + event.getNamedPlayer().getName());	
		}
		if(event.getNamedPlayer().getName().equalsIgnoreCase("stavrikiosi")){
            //If true, sets users tag to blue.
			event.setTag(ChatColor.BLUE + event.getNamedPlayer().getName());	
		}
		if(event.getNamedPlayer().getName().equals("Ekstemi")){
            //If true, sets users tag to blue.
			event.setTag(ChatColor.DARK_RED + event.getNamedPlayer().getName());	
		}
	*/	
	}	



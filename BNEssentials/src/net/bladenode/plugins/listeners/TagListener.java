package net.bladenode.plugins.listeners;

import java.util.ArrayList;

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
	
	@EventHandler
	public void onNameTag(PlayerReceiveNameTagEvent event) {
		//Staffs
		ArrayList<String> list = (ArrayList<String>) plugin.getConfig().getStringList("staffs");
		if(list.contains(event.getNamedPlayer().getName())){
              //If true, sets users tag to blue.
			event.setTag(ChatColor.BLUE + event.getNamedPlayer().getName());	
		//Admins
		ArrayList<String> listadmin = (ArrayList<String>) plugin.getConfig().getStringList("admins");
		if(listadmin.contains(event.getNamedPlayer().getName())){
			
			event.setTag(ChatColor.DARK_RED + event.getNamedPlayer().getName());
		}
	}	
	}
}

package net.bladenode.plugins.listeners;

import net.bladenode.plugins.BNEBooks;
import net.bladenode.plugins.BNEssentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



public class BNEListener implements Listener {
	
@SuppressWarnings("unused")
private final BNEssentials plugin;
BNEssentials config = BNEssentials.main;

	public BNEListener(BNEssentials plugin){
	this.plugin = plugin;

	}
	

	@EventHandler
	public void playerJoin(final PlayerJoinEvent event){

		if(!event.getPlayer().hasPlayedBefore()){
		
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(BNEssentials.main, new Runnable(){

			@Override
			public void run() {

				BNEBooks book = BNEBooks.getBook(config.getConfig().getString("BookName"));
				
				if(book != null)
				{
					
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.LEVEL_UP, 20, 1);
					event.getPlayer().sendMessage(ChatColor.ITALIC + "A rule book pops into your inventory magically.. =^..^=");
					
					
					
					book.spawnBook(event.getPlayer(), 1);
				}
				else
				{
					Bukkit.getLogger().severe("Goddamnit Emil! Book is not found! Fix it ASAP!");
				}
				
				

				}		
			
		}, 150L);
		
		}
		
		
		
		
	}

}

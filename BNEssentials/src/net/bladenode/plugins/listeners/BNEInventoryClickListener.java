package net.bladenode.plugins.listeners;

import net.bladenode.plugins.BNEBooks;
import net.bladenode.plugins.BNEssentials;
import net.bladenode.plugins.BNEssentialsCommandExecutorWarpHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;



public class BNEInventoryClickListener implements Listener {
	
@SuppressWarnings("unused")
private final BNEssentials plugin;
BNEssentials config = BNEssentials.main;

	public BNEInventoryClickListener(BNEssentials plugin){
	this.plugin = plugin;

	}
	

	@EventHandler
	public void invClickEvent(final InventoryClickEvent event){
 
		Player player = (Player)event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack click = event.getCurrentItem();
		

		if(inventory.getName().equals(BNEssentialsCommandExecutorWarpHub.inv.getName())){
			if(click.getType() == Material.ANVIL){
			event.setCancelled(true);
            Location loc = new Location(Bukkit.getWorld("world"), 150, 100, 258);
            loc.setYaw(-86);
            player.closeInventory();
            player.teleport(loc);
			}
			
		}
		
		
	}

}

package net.bladenode.plugins.listeners;

import net.bladenode.plugins.BNEssentials;
import net.bladenode.plugins.BNEssentialsCommandExecutorWarpHub;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
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
	public void invClickEvent( InventoryClickEvent event){
 
		
		Player player = (Player)event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack click = event.getCurrentItem();
		//Checks for null (outside of the inventory box)
		if(event.getCurrentItem() == null){
			return;
		}

		if(inventory.getName().equals(BNEssentialsCommandExecutorWarpHub.inv.getName())){
			
			if(click.getType() == Material.ANVIL){
			event.setCancelled(true);
            Location loc = new Location(Bukkit.getWorld("world"), 150, 100, 258);
            loc.setYaw(-86);
            player.closeInventory();
            player.sendMessage(ChatColor.GOLD + "Teleporting..");
            player.teleport(loc);
            return;
			}
			//Making sure that the player cannot put items into the fake inventory and loose them accidentally.
			if(event.getAction() == InventoryAction.PICKUP_ONE){
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "Nope! Don't try to manipulate the warp GUI");		
			}
			if(event.getAction() == InventoryAction.PICKUP_ALL){
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "Nope! Don't try to manipulate the warp GUI");		
			}
			if(event.getAction() == InventoryAction.PICKUP_SOME){
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "Nope! Don't try to manipulate the warp GUI");	
			}
			if(event.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "Nope! Don't try to manipulate the warp GUI");		
			}
		}
		
		
	}

}

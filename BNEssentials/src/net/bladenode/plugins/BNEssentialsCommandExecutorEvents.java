

package net.bladenode.plugins;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BNEssentialsCommandExecutorEvents implements CommandExecutor {


	public static Inventory inv;
	@SuppressWarnings("unused")
	private final BNEssentials plugin;
	public int i = 0;
	//Event coordinates and yaw/pitch stuff
	private static double blockX;
	private static double blockY;
	private static double blockZ;
	private static float yaw;
	private static float pitch;
	private static World world;
	private static boolean eventRunning;

	
	public BNEssentialsCommandExecutorEvents(BNEssentials plugin){
	this.plugin = plugin;
	eventRunning = false;
	
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		//Stores event location data


		if(label.equalsIgnoreCase("event")){

			if(eventRunning){

				Player player = (Player) sender;
				Location event = new Location(world, blockX, blockY, blockZ, yaw, pitch) ;
				
				player.teleport(event);
				player.sendMessage(ChatColor.GOLD + "You are at the event, have fun!");
					
				
			}else{
				sender.sendMessage(ChatColor.RED + "No event running!");
			}		
			
	}
		if(label.equalsIgnoreCase("startevent")){
         
		if(!eventRunning){	
			
			if(sender instanceof Player){
				
				//Gets the staff location of the event
				Player player = (Player) sender;
				if(player.hasPermission("bnessentials.command.startevent")){
					
				blockX = player.getLocation().getBlockX();
				blockY = player.getLocation().getBlockY();
				blockZ = player.getLocation().getBlockZ();
				 yaw = player.getLocation().getYaw();
				 pitch = player.getLocation().getPitch();
				 world = player.getLocation().getWorld();
				 
				 player.sendMessage("Event teleport has been set!");
				 player.sendMessage("Remember to /stopevent when the event is done!");
				 
				 eventRunning = true;
				 
				}else{
					player.sendMessage("You dont have permission to use this command!");
				}
				
				
			}else{
				sender.sendMessage("Console cannot start an event!");
			}
		}else{
			sender.sendMessage("Event already running!");
		}
			
			
			
	}
		if(label.equalsIgnoreCase("stopevent")){

				if(eventRunning){
					sender.sendMessage("Event stopped!");
					eventRunning = false;
				}		
			
	}	
	return true;			
}
}




package net.bladenode.plugins;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BNEssentialsCommandExecutorWarpHub implements CommandExecutor {


	public static Inventory inv;
	private final BNEssentials plugin;
	int i = 0;
	public BNEssentialsCommandExecutorWarpHub(BNEssentials plugin){
	this.plugin = plugin;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {

		if(label.equalsIgnoreCase("hub")){

			if(sender instanceof Player){

			Player player = (Player) sender;

			//Inventory population is now made from config and upon start. 
			
	/*		ArrayList<String> anvillore = new ArrayList<String>();
			anvillore.add("Hai");
			//anvillore.add("How long will this go?");
			//anvillore.add(ChatColor.BLUE + "Colour can be changed!");
			ItemStack anvil = new ItemStack(Material.getMaterial(5), 1);
			ItemMeta anvilmeta = anvil.getItemMeta();
			anvilmeta.setDisplayName("Haiii");
			anvilmeta.setLore(anvillore);
			anvil.setItemMeta(anvilmeta);
		inv.setItem(1, anvil);
		*/
		player.openInventory(inv);

			}
			else
			{
				sender.sendMessage("Console not allowed to use this command! Bad boy!");
			}


		}

          //This is a temp command, just for me to test my for loops, still learning ;)
		if(label.equalsIgnoreCase("forloop")){

			
			for(String in : plugin.getConfig().getConfigurationSection("gui.slots").getKeys(false) ){
			Bukkit.broadcastMessage(in);
				Bukkit.broadcastMessage(plugin.getConfig().getString("gui.slots." + in + ".warp"));
				Bukkit.broadcastMessage(plugin.getConfig().getString("gui.slots." + in + ".item"));
				Bukkit.broadcastMessage(plugin.getConfig().getString("gui.slots." + in + ".lore_title"));
				for(String key1 : plugin.getConfig().getConfigurationSection("gui.slots." + in + ".lore_lines").getKeys(false)){
					Bukkit.broadcastMessage(plugin.getConfig().getString("gui.slots." + in + ".lore_lines." + key1));
					
				}

			}

		}

		return false;
	}
	
	//Initializes fake gui (Adds all items to the fake inventory)
	public void initFakeGui(){
		//Create custom inventory with custom amount of slots and name.
		inv = Bukkit.createInventory(null, plugin.getConfig().getInt("gui.totalslots"), plugin.getConfig().getString("gui.guiname"));

		
		
		//Looping through all slots in config
		for(String in : plugin.getConfig().getConfigurationSection("gui.slots").getKeys(false) ){

			ArrayList<String> itemLore = new ArrayList<String>();

				@SuppressWarnings("deprecation")
				ItemStack itemStack = new ItemStack(Material.getMaterial(plugin.getConfig().getInt("gui.slots." + in + ".item")),1);
				ItemMeta itemMeta = itemStack.getItemMeta();
				

				String coloredDisplayName = plugin.getConfig().getString("gui.slots." + in + ".lore_title");

				itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', coloredDisplayName));
				
				
				//Looping through all lorelines in config
				for(String key1 : plugin.getConfig().getConfigurationSection("gui.slots." + in + ".lore_lines").getKeys(false)){

					String coloredLore = plugin.getConfig().getString("gui.slots." + in + ".lore_lines." + key1);
					itemLore.add(ChatColor.translateAlternateColorCodes('&', coloredLore));
					
				}
               itemMeta.setLore(itemLore);
               itemStack.setItemMeta(itemMeta);
               inv.setItem(i, itemStack);
               i++;

			}		
		
	}
	
}


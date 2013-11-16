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

	
	public static Inventory inv = Bukkit.createInventory(null, 9, "Awesome stufffhhfh!");
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
	
		if(label.equalsIgnoreCase("hub")){
			
			if(sender instanceof Player){
			
			Player player = (Player) sender;
			
			ArrayList<String> anvillore = new ArrayList<String>();
			anvillore.add("Testing lore! blah blah blah.. aljfkahdjfasf");
			anvillore.add("How long will this go?");
			anvillore.add(ChatColor.BLUE + "Colour can be changed!");
			ItemStack anvil = new ItemStack(Material.ANVIL, 1);
			ItemMeta anvilmeta = anvil.getItemMeta();
			anvilmeta.setDisplayName("Cocksucker!");
			anvilmeta.setLore(anvillore);
			anvil.setItemMeta(anvilmeta);
			
	
		inv.setItem(0, anvil);
		player.openInventory(inv);
			
			
			
			
			}
			else
			{
				sender.sendMessage("Console not allowed to use this command! Bad boy!");
			}
			
			
		}
		
		
		
		
		
		
		return false;
	}


}

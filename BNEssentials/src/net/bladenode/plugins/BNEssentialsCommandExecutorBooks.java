
package net.bladenode.plugins;


import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.BookMeta;

public class BNEssentialsCommandExecutorBooks implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private BNEssentials plugin;

	
	
	public BNEssentialsCommandExecutorBooks(BNEssentials plugin){
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		
	if(label.equalsIgnoreCase("savebook")){
		
		if(!(sender instanceof Player)){
			sender.sendMessage("Command cannot be ran from console! Bad boy!");
			return true;
		}
		//Casting sender to Player
		Player player = (Player) sender;
		if(player.hasPermission("bnessentials.savebook")){
			
			if(player.getItemInHand().getType().equals(Material.WRITTEN_BOOK)){
				BookMeta meta = (BookMeta) player.getItemInHand().getItemMeta();
				BNEBooks.saveBook(meta.getTitle(), meta);
				
				player.sendMessage("Book saved as " + meta.getTitle() + ".yml");
				
				
			}else{
				player.sendMessage("You need a written book in hand to use this command!");
				return true;
			}
			
			
		}else{
			player.sendMessage("No permishun! Uncle_Emil forbids!");
			return true;
		}
		
		
		
	}
	if(label.equalsIgnoreCase("book")){
	
		
			Player player = (Player) sender;
			if(args.length == 0){
				
               player.sendMessage("Specify the name of the book, please.");
			}
			else{
				BNEBooks book = BNEBooks.getBook(args[0]);
				
				if(book != null){
					book.spawnBook(player, 0); // 0 for not being a new guy.
				}
				else{
					player.sendMessage("That book doesn't exist!");
				}
			}
					
	}
	if(label.equalsIgnoreCase("booklist")){
		Player player = (Player) sender;
		BNEBooks.bookList(player);
	}
		
	return true;
	
	/**
	 * Command Executor. 
	 * savebook: Saves a book as .yml file
	 * book: Spawns in a specific book
	 * booklist: Shows booklist
	 */
	}

}

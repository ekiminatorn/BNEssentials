/*
 LICENSE:
 
 The MIT License (MIT)

Copyright (c) 2013 Emil Ekstrom

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

/*TODO
 * 1.Add actions to the items (Warping when clicked on some item)
 * 2. If I bother, add a feature where the inventory can have two same items, but when clicked on them, it won't glitch out.
 * 
 */

//Testing branches. Will do my development stuff on dev, and push successful stuff into master! :)


package net.bladenode.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import net.bladenode.plugins.listeners.BNEInventoryClickListener;
import net.bladenode.plugins.listeners.BNEListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class BNEssentials extends JavaPlugin{



	public static Configuration config;
	public static File saveDir;
	
	public static ArrayList<BNEBooks> books = new ArrayList<BNEBooks>();

	
	
public static BNEssentials main; //This makes sure I can access plugin.etcblah using <classname>.main in other classes.
	@Override
	public void onEnable() {
		//Enable method

        main = this; //This makes sure I can access plugin.etcblah using <classname>.main in other classes.
		//Enabling/registering  Listeners
		PluginManager pm = Bukkit.getServer().getPluginManager();
				pm.registerEvents(new BNEListener(null), this);
				pm.registerEvents(new BNEInventoryClickListener(null), this);
				//pm.registerEvents(new TagListener(), this);


		//Setting BNEssentialsCommandExecutorBooks as the... CommandExecutor!

		getCommand("savebook").setExecutor(new BNEssentialsCommandExecutorBooks(this));
		getCommand("book").setExecutor(new BNEssentialsCommandExecutorBooks(this));
		getCommand("booklist").setExecutor(new BNEssentialsCommandExecutorBooks(this));
		getCommand("hub").setExecutor(new BNEssentialsCommandExecutorWarpHub(this));
		getCommand("forloop").setExecutor(new BNEssentialsCommandExecutorWarpHub(this)); //Temp command for testing purposes
		//Event commands
		getCommand("event").setExecutor(new BNEssentialsCommandExecutorEvents(this));
		getCommand("startevent").setExecutor(new BNEssentialsCommandExecutorEvents(this));
		getCommand("stopevent").setExecutor(new BNEssentialsCommandExecutorEvents(this));
	/*
		Config file
		File file = new File(getDataFolder() + File.separator + "config.yml");
		if (!file.exists()){
			

			this.getConfig().options().copyDefaults(true);
			this.getLogger().info("Generating ECSync config");
			this.getConfig().addDefault("database.ip", "ipadress");
			this.getConfig().addDefault("database.user", "username");
			this.getConfig().addDefault("database.database", "databasename");
			this.getConfig().addDefault("database.password", "password");
			this.saveConfig();
			

		}
*/
	
	//Initialize fake GUI
	BNEssentialsCommandExecutorWarpHub warp = new BNEssentialsCommandExecutorWarpHub(this);
	warp.initFakeGui();
	
	//Get latest version from the config in the jar	
	saveDefaultConfig();

	initSaveFile();
	
	
	//Load books
	try {
	 	books = BNEBooks.loadBooks();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		
		
		
	}

	@Override
	public void onDisable() {
		//Disable method

		main = null;
	}
	
	
	private void initSaveFile(){
		saveDir = new File(getDataFolder(), "Books");
		saveDir.mkdirs();
	}
	

	
 }
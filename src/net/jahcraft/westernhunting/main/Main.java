package net.jahcraft.westernhunting.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.jahcraft.westernhunting.fish.commands.GetFish;
import net.jahcraft.westernhunting.fish.listeners.FishDeathListener;
import net.jahcraft.westernhunting.fish.listeners.FishExchangeListener;
import net.jahcraft.westernhunting.fish.listeners.FishListListener;
import net.jahcraft.westernhunting.fish.listeners.FishingListener;
import net.jahcraft.westernhunting.main.commands.HuntingExchange;
import net.jahcraft.westernhunting.pelts.commands.GetPelt;
import net.jahcraft.westernhunting.pelts.listeners.AnimalDeathListener;
import net.jahcraft.westernhunting.pelts.listeners.PeltExchangeListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	public Economy eco;

	@Override
	public void onEnable() {
		
		if (!setupEconomy()) {
			
			Bukkit.getLogger().info("Economy not detected! Disabling Western Hunting!");
			getServer().getPluginManager().disablePlugin(this);
			return;
			
		}
		
		getCommand("huntingexchange").setExecutor(new HuntingExchange());
		
		//JAHFISH
				try {
					//COMMANDS
					getCommand("getfish").setExecutor((CommandExecutor) new GetFish());
					
					//LISTENERS
					getServer().getPluginManager().registerEvents(new FishingListener(), this);
					getServer().getPluginManager().registerEvents(new FishExchangeListener(this), this);
					getServer().getPluginManager().registerEvents(new FishDeathListener(), this);
					getServer().getPluginManager().registerEvents(new FishListListener(), this);
					
					GetFish.inv = GetFish.createList();
					
				} catch (Exception e) {

					Bukkit.getLogger().warning("Failed to load Western Hunting (Fish)!");
					e.printStackTrace();
					
				}
				
				//JAHPELTS
				try {
					
					//COMMANDS
					getCommand("getpelt").setExecutor((CommandExecutor) new GetPelt());
					
					//LISTENERS
					getServer().getPluginManager().registerEvents(new AnimalDeathListener(), this);
					getServer().getPluginManager().registerEvents(new PeltExchangeListener(this), this);
					
				} catch (Exception e) {

					Bukkit.getLogger().warning("Failed to load Western Hunting (Pelts)!");
					e.printStackTrace();
					
				}
	}
	
	@Override 
	public void onDisable() {
		
		Bukkit.getLogger().info("Western Hunting Unloaded and Disabled!");
		
	}
	
	private boolean setupEconomy() {
		
		RegisteredServiceProvider<Economy> economy = getServer().
				getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		
		if (economy != null)
			eco = economy.getProvider();
		return (eco != null);
		
	}

}

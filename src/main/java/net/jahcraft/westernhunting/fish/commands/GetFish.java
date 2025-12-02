package net.jahcraft.westernhunting.fish.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.fish.util.FishablesByBiome;
import net.md_5.bungee.api.ChatColor;

public class GetFish implements CommandExecutor {
	
	public static Inventory inv;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("getfish")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!(p.hasPermission("jahfish.getfish"))) return true;
			
			ArrayList<ItemStack> fishables;
			
			Biome b = p.getLocation().getBlock().getBiome();

			if (b.equals(Biome.RIVER)) {
				fishables = FishablesByBiome.getRiverFishables();
			} else {
				fishables = FishablesByBiome.getGeneralFishables();
			}
			
			if (args.length == 0) {
				
				int index = (int) (Math.random() * fishables.size());
				ItemStack fishedItem = fishables.get(index);
				
				//GIVE FISH
				
				if (p.getInventory().firstEmpty() == -1 ) {
					
					// full inventory
					
					Location loc = p.getLocation();
					World world = p.getWorld();
					
					world.dropItemNaturally(loc, fishedItem);
					p.sendMessage(ChatColor.AQUA + "You caught a " + fishedItem.getItemMeta().getDisplayName() + ChatColor.AQUA+ "!");				
					return true;
					
				}
				
				p.getInventory().addItem(fishedItem);
				p.sendMessage(ChatColor.AQUA + "You caught a " + fishedItem.getItemMeta().getDisplayName() + ChatColor.AQUA+ "!");			
				return true;
				
			} else {
				
				if (args[0].contains("list")) {
					
					p.openInventory(inv);
					
					return true;
				}
				
				int count = Integer.parseInt(args[0]);
				
				for (int i = 0; i < count; i++) {
					
					if (b.equals(Biome.RIVER) || b.equals(Biome.FROZEN_RIVER)) {
						fishables = FishablesByBiome.getRiverFishables();
					} else if (b.equals(Biome.SWAMP)) {
						fishables = FishablesByBiome.getSwampFishables();
					} else if (b.equals(Biome.COLD_OCEAN) || b.equals(Biome.DEEP_COLD_OCEAN) ||
							   b.equals(Biome.WARM_OCEAN) || b.equals(Biome.OCEAN) ||
							   b.equals(Biome.LUKEWARM_OCEAN) || b.equals(Biome.DEEP_LUKEWARM_OCEAN) ||
							   b.equals(Biome.FROZEN_OCEAN) || b.equals(Biome.DEEP_FROZEN_OCEAN) ||
							   b.equals(Biome.DEEP_OCEAN)) {
						fishables = FishablesByBiome.getOceanFishables();
					} else {
						fishables = FishablesByBiome.getGeneralFishables();
					}
					
					int index = (int) (Math.random() * fishables.size());
					ItemStack fishedItem = fishables.get(index);
					
					//GIVE FISH
					
					if (p.getInventory().firstEmpty() == -1 ) {
						
						// full inventory
						
						Location loc = p.getLocation();
						World world = p.getWorld();
						
						world.dropItemNaturally(loc, fishedItem);
						p.sendMessage(ChatColor.AQUA + "You caught a " + fishedItem.getItemMeta().getDisplayName() + ChatColor.AQUA+ "!");				
						
					}
					
					p.getInventory().addItem(fishedItem);
					p.sendMessage(ChatColor.AQUA + "You caught a " + fishedItem.getItemMeta().getDisplayName() + ChatColor.AQUA+ "!");			
					
				}
				
				return true;
				
			}
			
		}
		
		
		return false;
		
		
	}
	
	public static Inventory createList() {
		
		Inventory i = Bukkit.createInventory(null, 27, "Fish List");
		
		for (ItemStack fish : FishablesByBiome.getAllFishables()) {
			i.addItem(fish);
		}
		
		return i;
		
	}

}

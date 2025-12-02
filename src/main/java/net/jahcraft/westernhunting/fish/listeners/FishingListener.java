package net.jahcraft.westernhunting.fish.listeners;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.fish.util.FishablesByBiome;
import net.md_5.bungee.api.ChatColor;

public class FishingListener implements Listener {
		
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onFishCaught(PlayerFishEvent e) {
		
		// PREPARE EVENT
		
		if (e.getState() != PlayerFishEvent.State.CAUGHT_FISH) return;
		
		if (e.getPlayer() == null) return;
		
//		if (!(e.getPlayer().hasPermission("group.admin") || e.getPlayer().hasPermission("group.owner"))) return;
			
		Item caught = (Item) e.getCaught();
				
		if (!isFish(caught.getItemStack())) {
			return;
		}
		
		//PREPARE ITEM POOL
		
//		Player catcher = e.getPlayer();
		ArrayList<ItemStack> fishables;
		
		Location hookLoc = e.getHook().getLocation();
		Biome b = hookLoc.getBlock().getBiome();

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
		
		caught.setItemStack(fishedItem);
//		catcher.sendMessage(ChatColor.AQUA + "You caught a " + fishedItem.getItemMeta().getDisplayName() + ChatColor.AQUA+ "!");

	}
	
	private static boolean isFish(ItemStack i) {
		if (i.getType() != Material.COD &&
			i.getType() != Material.PUFFERFISH &&
			i.getType() != Material.SALMON &&
			i.getType() != Material.TROPICAL_FISH) {
			return false;
		} else {
			return true;
		}
	}

	@EventHandler
	public void onFishReady(PlayerFishEvent e) {
		
		if (e.getState() != PlayerFishEvent.State.BITE) return;
		
		if (e.getPlayer() == null) return;
		
		if (!(e.getPlayer().hasPermission("group.admin") || e.getPlayer().hasPermission("group.owner"))) return;
		
		Player catcher = e.getPlayer();
		catcher.playSound(catcher.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
		catcher.sendMessage(ChatColor.AQUA + "You got a bite!");
		
	}
	
}

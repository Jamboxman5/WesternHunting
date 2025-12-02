package net.jahcraft.westernhunting.fish.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BaitWheel {
	
	public static List<Inventory> activeInvs = new ArrayList<>();
	public static HashMap<Player, ItemStack> lastBait = new HashMap<>();
	public static HashMap<Player, ItemStack> lastLure = new HashMap<>();
	
	public static Inventory generateInventory(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, InventoryType.DROPPER, "Bait Wheel");
		
		
		
		activeInvs.add(inv);
		
		return inv;
		
	}
	
	public static ItemStack getBlankLureButton() {
		return new ItemStack(Material.BARRIER);
	}

	public static ItemStack getBlankBaitButton() {
		return new ItemStack(Material.BARRIER);
	}
	
}

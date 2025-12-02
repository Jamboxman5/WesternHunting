package net.jahcraft.westernhunting.pelts.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jahcraft.westernhunting.pelts.util.PeltDefaults;
import net.md_5.bungee.api.ChatColor;

public class PeltExchange {
	
	public static Inventory inv;
	public static ItemStack i;
	
	
	public static Inventory createInv(Player p) {
		
		inv = Bukkit.createInventory(null, 54, ChatColor.of("#DD7700") + "" + ChatColor.BOLD + "Animal Hide Exchange");
		
		ItemStack item = new ItemStack(Material.BARRIER);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<>();
		
		// Close shop button
		
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close the Shop Menu");
		lore.add(ChatColor.GRAY + "Click to close the menu.");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(49, item);
		
		//ITEMS
		
		for (int i : PeltDefaults.slots) {
			assembleItem(p, i);
		}
		
		//SELL ALL
		item.setType(Material.EMERALD);
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Sell All");
		lore.clear();
		lore.add(ChatColor.AQUA + "Click to sell " + ChatColor.of("#FFDF00") + "" + ChatColor.BOLD + "ALL" + ChatColor.AQUA + " pelts!");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(22, item);
		
		
		// Bottom Border
		item.setType(Material.RED_STAINED_GLASS_PANE);
		meta.setDisplayName(" ");
		meta.setLore(null);
		item.setItemMeta(meta);
		
		inv.setItem(52, item);
		inv.setItem(51, item);
		inv.setItem(50, item);
		inv.setItem(48, item);
		inv.setItem(47, item);
		inv.setItem(46, item);		
		
		// Fill the Spaces
		item.setType(Material.ORANGE_STAINED_GLASS_PANE);
		meta.setDisplayName(" ");
		meta.setLore(null);
		item.setItemMeta(meta);
				
		for (int i = 0; i < 45; i++) {
			if (!PeltDefaults.slots.contains(i) && i != 22) {
				inv.setItem(i, item);
			}
		}
		
		//BACK TO MAIN
		item.setType(Material.REDSTONE_BLOCK);
		meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Return to Main Menu");
		item.setItemMeta(meta);
		inv.setItem(45, item);
		i = item;
		
		
		//FISHING GUIDE
		item.setType(Material.WRITABLE_BOOK);
		meta.setDisplayName(ChatColor.GOLD + "Hunting Guide");
		item.setItemMeta(meta);
		inv.setItem(53, item);
		
		
		
		return inv;
		
	}
	
	private static void assembleItem(Player p, int slot) {
		
		//DECLARE ITEM
		ItemStack item = PeltDefaults.slotStorage.get(slot);
		ItemMeta meta = item.getItemMeta();
		
		//BUILD LORE
		List<String> lore = new ArrayList<>();
		lore.add(ChatColor.GOLD + "Click to sell " + ChatColor.of("#FFDF00") + "" + ChatColor.BOLD + "ONE");
		lore.add(ChatColor.GOLD + "Shift-click to sell " + ChatColor.of("#FFDF00") + "" + ChatColor.BOLD + "ALL");
//		lore.add(ChatColor.GRAY + "Buy: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + getBuyPrice(m) + ChatColor.GRAY + 
//				" | Sell: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + getSellPrice(p, m));
//		lore.add(ChatColor.GRAY + "Shift: Buy/Sell Full Stack");
		meta.setLore(lore);
		
		//FINISHING TOUCHES
		item.setItemMeta(meta);
		inv.setItem(slot, item);
		
	}

}

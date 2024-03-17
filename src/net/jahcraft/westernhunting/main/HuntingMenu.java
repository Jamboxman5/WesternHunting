package net.jahcraft.westernhunting.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jahcraft.westernhunting.pelts.util.Colors;

public class HuntingMenu {
	
	public static Inventory inv;
	
	public static List<Player> activePlayers = new ArrayList<>();

	public static void createMenu() {
		inv = Bukkit.createInventory(null, 27, "Western Hunting");
		
		ItemStack item = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("");
		item.setItemMeta(meta);
		
		for (int i = 0; i < 9; i++) {
			inv.setItem(i, item);
		}
		
		item.setType(Material.BLUE_STAINED_GLASS_PANE);
		
		for (int i = 18; i < 27; i++) {
			inv.setItem(i, item);
		}
		
		item.setType(Material.LEATHER);
		meta.setDisplayName(Colors.GOLD + "Exchange Pelts");
		item.setItemMeta(meta);
		inv.setItem(11, item);
		
		item.setType(Material.COD);
		meta.setDisplayName(Colors.GOLD + "Exchange Fish");
		item.setItemMeta(meta);
		inv.setItem(15, item);
		
		
	}
	
}

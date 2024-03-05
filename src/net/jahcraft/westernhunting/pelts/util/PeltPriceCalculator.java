package net.jahcraft.westernhunting.pelts.util;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PeltPriceCalculator {

	public static double getPrice(ItemStack pelt, InventoryClickEvent e) {
		
		double price = 1;
		
		price = PeltDefaults.priceStorage.get(pelt.getItemMeta().getDisplayName());

		
		int starCount = PeltMath.parseStars(pelt);
		
		double multiplier = (((double) starCount)*3);
		price = price * multiplier;
		price = (Math.round(price / 10.0) * 5.0);
		
		return price;
		
	}
	
	public static double getPrice(String displayName, int starCount) {
		
		double price = 1;
		
		price = PeltDefaults.priceStorage.get(displayName);
		
		double multiplier = ((double) starCount)*2;
		price = price * multiplier;
		price = (Math.round(price / 10.0) * 5.0);
		
		return price;
		
	}
	
	public static boolean isCorrectPelt(ItemStack item, InventoryClickEvent e) {
		if (item.getType() == e.getCurrentItem().getType() &&
			item.getItemMeta().hasLore() &&
			item.getItemMeta().getCustomModelData() == e.getCurrentItem().getItemMeta().getCustomModelData()) {
			return true;
		} else {
			return false;
		}
	}
	
}

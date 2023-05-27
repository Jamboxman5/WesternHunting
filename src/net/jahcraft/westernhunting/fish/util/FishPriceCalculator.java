package net.jahcraft.westernhunting.fish.util;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FishPriceCalculator {

	public static double getPrice(ItemStack fish, InventoryClickEvent e) {
		
		double price = 1;
		
		price = FishDefaults.priceStorage.get(fish.getItemMeta().getDisplayName());

		
		int starCount = FishMath.parseStars(fish);
		String weightFormatted = FishMath.parseWeight(fish);
		int oz = FishMath.parseWeight(weightFormatted);
		
		double multiplier = (((double)oz / 35.0) * ((double) starCount)*3);
		price = price * multiplier;
		price = (Math.round(price / 10.0) * 10.0);
		
		return price;
		
	}
	
	public static double getPrice(String displayName, int starCount, int oz) {
		
		double price = 1;
		
		price = FishDefaults.priceStorage.get(displayName);
		
		double multiplier = (((double)oz / 35.0) * ((double) starCount)*3);
		price = price * multiplier;
		price = (Math.round(price / 10.0) * 10.0);
		
		return price;
		
	}
	
	public static boolean isCorrectFish(ItemStack item, InventoryClickEvent e) {
		if (item.getType() == e.getCurrentItem().getType() &&
			item.getItemMeta().hasLore() &&
			item.getItemMeta().getCustomModelData() == e.getCurrentItem().getItemMeta().getCustomModelData()) {
			return true;
		} else {
			return false;
		}
	}
	
}

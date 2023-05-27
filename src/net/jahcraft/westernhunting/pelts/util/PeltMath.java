package net.jahcraft.westernhunting.pelts.util;

import org.bukkit.inventory.ItemStack;

public class PeltMath {

	public static int generateStarCount(boolean silk) {
		
		int count = 0;
		
		if (silk) {
			int random = (int) (Math.random() * 101);
			if (random > 90) {
				count = 3;
			} else if (random > 60) {
				count = 2;
			} else {
				count = 1;
			}
		} else {
			int random = (int) (Math.random() * 101);
			if (random > 98) {
				count = 3;
			} else if (random > 75) {
				count = 2;
			} else {
				count = 1;
			}
		}
		
		
		return count;
	}
	
	public static String formatStarCount(int count) {
		
		String stars;
		
		if (count == 1 ) {
			stars = "★☆☆";
		} else if (count == 2) {
			stars = "★★☆";
		} else if (count == 3 ) {
			stars = "★★★";
		} else {
			stars = "☆☆☆";
		}
		return stars;
	}
	
	public static int parseStars(String stars) {
		if (stars.contains("★★★")) return 3;
		if (stars.contains("★★☆")) return 2;
		if (stars.contains("★☆☆")) return 1;
		return 0;
	}
	
	public static int parseStars(ItemStack i) {
		String stars = i.getItemMeta().getLore().get(0);
		if (stars.contains("★★★")) return 3;
		else if (stars.contains("★★☆")) return 2;
		else if (stars.contains("★☆☆")) return 1;
		else return 0;
	}
	
}

package net.jahcraft.westernhunting.fish.util;

import org.bukkit.inventory.ItemStack;

public class FishMath {

	public static String randomWeight() {
		
		String weight = "";
		
		int oz = (int) (Math.random() * 720) + 80;
		int r = oz % 16;
		int lbs = oz / 16;
		
		weight = lbs + "lbs " + r + "oz";
		
		return weight;
		
	}
	
	public static String formatWeight(int oz) {
		
		String weight = "";
		
		int r = (oz % 16);
		int lbs = (oz / 16);
		
		weight = lbs + "lbs " + r + "oz";
		
		return weight;
		
	}
	
	public static int randomWeightOunces(double min, double max) {
		
		int oz = (int) ((Math.random() * ((max-min)*16)) + (min * 16));
		
		return oz;
		
	}
	
	public static int generateStarCount() {
		
		int count = 0;
		
		int random = (int) (Math.random() * 101);
		if (random > 90) {
			count = 3;
		} else if (random > 50) {
			count = 2;
		} else {
			count = 1;
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

	public static int parseWeight(String weight) {
		//xxlbs xxoz
		String[] measurements = weight.split(" ");
		String slbs = measurements[0];
		String soz = measurements[1];
		int lbs = Integer.parseInt(slbs.substring(2, slbs.length()-3));
		int oz = Integer.parseInt(soz.substring(0, soz.length()-2));
		int ounces = ((lbs*16) + oz);
		return ounces;
	}
	
	public static String parseWeight(ItemStack i) {
		return i.getItemMeta().getLore().get(1);
	}
}

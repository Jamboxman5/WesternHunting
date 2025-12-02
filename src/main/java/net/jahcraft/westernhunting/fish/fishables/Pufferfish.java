package net.jahcraft.westernhunting.fish.fishables;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jahcraft.westernhunting.fish.util.FishMath;
import net.jahcraft.westernhunting.fish.util.FishPriceCalculator;
import net.md_5.bungee.api.ChatColor;

public class Pufferfish extends ItemStack {
	
	String weight;
	int maxlbs = 30;
	int minlbs = 10;
	int oz;
	double sellPrice;
	int starCount;
	String stars;

	public Pufferfish() {
//		ChatColor.of("#49B3FF") + 

		super(Material.PUFFERFISH);
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(ChatColor.of("#49B3FF") + "Pufferfish");
		meta.setCustomModelData(0);

		oz = FishMath.randomWeightOunces(minlbs, maxlbs);
		weight = FishMath.formatWeight(oz);
		starCount = FishMath.generateStarCount();
		stars = FishMath.formatStarCount(starCount);
		
		ArrayList<String> lore = new ArrayList<>();
		
		lore.add(ChatColor.of("#FFD700") + stars);
		lore.add(ChatColor.AQUA + weight);
		lore.add(ChatColor.of("#49B3FF") + "Value: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + FishPriceCalculator.getPrice(meta.getDisplayName(), starCount, oz));

		meta.setLore(lore);
		setItemMeta(meta);
	}
	
	public Pufferfish(int i) {
//		ChatColor.of("#49B3FF") + 

		super(Material.PUFFERFISH);
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(ChatColor.of("#49B3FF") + "Pufferfish");
		meta.setCustomModelData(0);

		setItemMeta(meta);
		
	}
	
	public Pufferfish(boolean silk) {
//		ChatColor.of("#49B3FF") + 

		super(Material.PUFFERFISH);
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(ChatColor.of("#49B3FF") + "Pufferfish");
		meta.setCustomModelData(0);

		oz = FishMath.randomWeightOunces(minlbs, maxlbs);
		weight = FishMath.formatWeight(oz);

		if (!silk) {
			starCount = 1;
		} else {
			starCount = FishMath.generateStarCount();
		}
		
		stars = FishMath.formatStarCount(starCount);
		
		ArrayList<String> lore = new ArrayList<>();
		
		lore.add(ChatColor.of("#FFD700") + stars);
		lore.add(ChatColor.AQUA + weight);
		lore.add(ChatColor.of("#49B3FF") + "Value: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + FishPriceCalculator.getPrice(meta.getDisplayName(), starCount, oz));

		meta.setLore(lore);
		setItemMeta(meta);
	}

}

package net.jahcraft.westernhunting.fish.fishables;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jahcraft.westernhunting.fish.util.FishMath;
import net.jahcraft.westernhunting.fish.util.FishPriceCalculator;
import net.md_5.bungee.api.ChatColor;

public class BullheadCatfish extends ItemStack {
	
	String weight;
	int maxlbs = 30;
	int minlbs = 12;
	int oz;
	double sellPrice;
	int starCount;
	String stars;
	
	public BullheadCatfish() {
//		ChatColor.of("#49B3FF") + 
		super(Material.COD);
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(ChatColor.of("#49B3FF") + "Bullhead Catfish");
		meta.setCustomModelData(2);

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

	public BullheadCatfish(int i) {
		
		super(Material.COD);
		
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(ChatColor.of("#49B3FF") + "Bullhead Catfish");
		meta.setCustomModelData(2);
		setItemMeta(meta);
		
	}
	
	
}

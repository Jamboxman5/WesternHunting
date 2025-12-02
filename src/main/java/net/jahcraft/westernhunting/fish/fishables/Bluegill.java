package net.jahcraft.westernhunting.fish.fishables;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jahcraft.westernhunting.fish.util.FishMath;
import net.jahcraft.westernhunting.fish.util.FishPriceCalculator;
import net.md_5.bungee.api.ChatColor;

public class Bluegill extends ItemStack {
	
	String weight;
	int maxlbs = 4;
	double minlbs = 0.5;
	int oz;
	double sellPrice;
	int starCount;
	String stars;
		
	public Bluegill() {
		
		super(Material.COD);
		
//		ChatColor.of("#49B3FF") + 
		
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(ChatColor.of("#49B3FF") + "Bluegill");
		meta.setCustomModelData(1);
		
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
	
	public Bluegill(int i) {
		
		super(Material.COD);
		
		ItemMeta meta = getItemMeta();
		meta.setDisplayName(ChatColor.of("#49B3FF") + "Bluegill");
		meta.setCustomModelData(1); 
		setItemMeta(meta);
		
	}
	

}

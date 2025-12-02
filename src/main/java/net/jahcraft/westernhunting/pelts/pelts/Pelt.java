package net.jahcraft.westernhunting.pelts.pelts;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.jahcraft.westernhunting.pelts.util.PeltMath;
import net.jahcraft.westernhunting.pelts.util.PeltPriceCalculator;
import net.md_5.bungee.api.ChatColor;

public class Pelt extends ItemStack {
	
	double sellPrice;
	int starCount;
	String stars;
	
	public Pelt(EntityType e, boolean silk) {
		
		super(Material.LEATHER);
		ItemMeta meta = getItemMeta();
		
		if (e.equals(EntityType.COW)) {
			meta.setCustomModelData(1);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Cow Hide");

		} else if (e.equals(EntityType.PIG)) {
			meta.setCustomModelData(2);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Pig Hide");

		} else if (e.equals(EntityType.SHEEP)) {
			meta.setCustomModelData(3);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Sheep Hide");

		} else if (e.equals(EntityType.PANDA)) {
			meta.setCustomModelData(4);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Panda Hide");

		} else if (e.equals(EntityType.RABBIT)) {
			meta.setCustomModelData(5);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Rabbit Pelt");

		} else if (e.equals(EntityType.GOAT)) {
			meta.setCustomModelData(6);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Goat Hide");
			
		} else if (e.equals(EntityType.WOLF)) {
			meta.setCustomModelData(7);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Wolf Hide");

		} else if (e.equals(EntityType.POLAR_BEAR)) {
			meta.setCustomModelData(8);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Polar Bear Hide");

		} else if (e.equals(EntityType.FOX)) {
			meta.setCustomModelData(9);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Fox Hide");

		} else if (e.equals(EntityType.LLAMA) || e.equals(EntityType.TRADER_LLAMA)) {
			meta.setCustomModelData(10);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Llama Hide");

		} else if (e.equals(EntityType.OCELOT)) {
			meta.setCustomModelData(11);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Ocelot Hide");

		} else if (e.equals(EntityType.MUSHROOM_COW)) {
			meta.setCustomModelData(12);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Mooshroom Hide");

		} else {
			meta.setDisplayName("Unknown Pelt!");
		}
		
		starCount = PeltMath.generateStarCount(silk);
		stars = PeltMath.formatStarCount(starCount);
		
		ArrayList<String> lore = new ArrayList<>();
		
		lore.add(ChatColor.of("#FFD700") + stars);
		lore.add(ChatColor.of("#DD7700") + "Value: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + PeltPriceCalculator.getPrice(meta.getDisplayName(), starCount));
		
		meta.setLore(lore);
		setItemMeta(meta);
		
	}
	
	public Pelt(EntityType e) {
		
		super(Material.LEATHER);
		ItemMeta meta = getItemMeta();
		
		if (e.equals(EntityType.COW)) {
			meta.setCustomModelData(1);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Cow Hide");

		} else if (e.equals(EntityType.PIG)) {
			meta.setCustomModelData(2);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Pig Hide");

		} else if (e.equals(EntityType.SHEEP)) {
			meta.setCustomModelData(3);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Sheep Hide");

		} else if (e.equals(EntityType.PANDA)) {
			meta.setCustomModelData(4);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Panda Hide");

		} else if (e.equals(EntityType.RABBIT)) {
			meta.setCustomModelData(5);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Rabbit Pelt");

		} else if (e.equals(EntityType.GOAT)) {
			meta.setCustomModelData(6);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Goat Hide");
			
		} else if (e.equals(EntityType.WOLF)) {
			meta.setCustomModelData(7);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Wolf Hide");

		} else if (e.equals(EntityType.POLAR_BEAR)) {
			meta.setCustomModelData(8);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Polar Bear Hide");

		} else if (e.equals(EntityType.FOX)) {
			meta.setCustomModelData(9);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Fox Hide");

		} else if (e.equals(EntityType.LLAMA)) {
			meta.setCustomModelData(10);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Llama Hide");

		} else if (e.equals(EntityType.OCELOT)) {
			meta.setCustomModelData(11);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Ocelot Hide");

		} else if (e.equals(EntityType.MUSHROOM_COW)) {
			meta.setCustomModelData(12);
			meta.setDisplayName(ChatColor.of("#DD7700") + "Mooshroom Hide");

		} else {
			meta.setDisplayName("Unknown Pelt!");
		}
		
		setItemMeta(meta);
		
	}

}

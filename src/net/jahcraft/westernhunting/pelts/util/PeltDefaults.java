package net.jahcraft.westernhunting.pelts.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.pelts.pelts.Pelt;
import net.md_5.bungee.api.ChatColor;

public class PeltDefaults {

	public static int[] slotsarray = {11,15,18,19,20,21,23,24,25,26,29,33};
	
	public static ArrayList<Integer> slots = getSlots(slotsarray);

	public static ArrayList<EntityType> types = getTypes();

	public static HashMap<String, Double> priceStorage = getBasePrices();
	
	public static HashMap<Integer, ItemStack> slotStorage = getPeltSlots();
	
	public static HashMap<Integer, ItemStack> getPeltSlots() {
		
		HashMap<Integer, ItemStack> peltSlots = new HashMap<>();
		
		peltSlots.put(11, new Pelt(EntityType.COW));
		peltSlots.put(15, new Pelt(EntityType.PIG));
		peltSlots.put(18, new Pelt(EntityType.OCELOT));
		peltSlots.put(19, new Pelt(EntityType.SHEEP));
		peltSlots.put(20, new Pelt(EntityType.PANDA));
		peltSlots.put(21, new Pelt(EntityType.RABBIT));
		peltSlots.put(23, new Pelt(EntityType.GOAT));
		peltSlots.put(24, new Pelt(EntityType.WOLF));
		peltSlots.put(25, new Pelt(EntityType.POLAR_BEAR));
		peltSlots.put(26, new Pelt(EntityType.MUSHROOM_COW));
		peltSlots.put(29, new Pelt(EntityType.FOX));
		peltSlots.put(33, new Pelt(EntityType.LLAMA));
		
		return peltSlots;
		
	}
	
	private static ArrayList<EntityType> getTypes() {

		ArrayList<EntityType> types = new ArrayList<>();
		types.add(EntityType.COW);
		types.add(EntityType.PIG);
		types.add(EntityType.SHEEP);
		types.add(EntityType.PANDA);
		types.add(EntityType.RABBIT);
		types.add(EntityType.GOAT);
		types.add(EntityType.WOLF);
		types.add(EntityType.POLAR_BEAR);
		types.add(EntityType.FOX);
		types.add(EntityType.LLAMA);
		types.add(EntityType.OCELOT);
		types.add(EntityType.MUSHROOM_COW);
		return types;
		
	}

	private static ArrayList<Integer> getSlots(int[] slotsar) {
		
		ArrayList<Integer> newSlots = new ArrayList<>();
		
		for ( int i : slotsar ) {
			newSlots.add(i);
		}
		
		return newSlots;
		
		
	}

	private static HashMap<String, Double> getBasePrices() {

		HashMap<String, Double> prices = new HashMap<>();
		prices.put(ChatColor.of("#DD7700") + "Cow Hide", 15.0);
		prices.put(ChatColor.of("#DD7700") + "Pig Hide", 15.0);
		prices.put(ChatColor.of("#DD7700") + "Sheep Hide", 15.0);
		prices.put(ChatColor.of("#DD7700") + "Panda Hide", 500.0);
		prices.put(ChatColor.of("#DD7700") + "Rabbit Pelt", 80.0);
		prices.put(ChatColor.of("#DD7700") + "Goat Hide", 200.0);
		prices.put(ChatColor.of("#DD7700") + "Wolf Hide", 100.0);
		prices.put(ChatColor.of("#DD7700") + "Polar Bear Hide", 500.0);
		prices.put(ChatColor.of("#DD7700") + "Fox Hide", 120.0);
		prices.put(ChatColor.of("#DD7700") + "Llama Hide", 80.0);
		prices.put(ChatColor.of("#DD7700") + "Mooshroom Hide", 30.0);
		prices.put(ChatColor.of("#DD7700") + "Ocelot Hide", 120.0);
		
		return prices;
		
	}
	
}

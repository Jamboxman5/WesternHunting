package net.jahcraft.westernhunting.fish.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.fish.fishables.Bluegill;
import net.jahcraft.westernhunting.fish.fishables.BullheadCatfish;
import net.jahcraft.westernhunting.fish.fishables.ChainPickerel;
import net.jahcraft.westernhunting.fish.fishables.ChannelCatfish;
import net.jahcraft.westernhunting.fish.fishables.Cod;
import net.jahcraft.westernhunting.fish.fishables.LakeSturgeon;
import net.jahcraft.westernhunting.fish.fishables.LargemouthBass;
import net.jahcraft.westernhunting.fish.fishables.LongnoseGar;
import net.jahcraft.westernhunting.fish.fishables.Muskie;
import net.jahcraft.westernhunting.fish.fishables.Perch;
import net.jahcraft.westernhunting.fish.fishables.Pufferfish;
import net.jahcraft.westernhunting.fish.fishables.RedfinPickerel;
import net.jahcraft.westernhunting.fish.fishables.RockBass;
import net.jahcraft.westernhunting.fish.fishables.SmallmouthBass;
import net.jahcraft.westernhunting.fish.fishables.SockeyeSalmon;
import net.jahcraft.westernhunting.fish.fishables.SteelheadTrout;

public class FishDefaults {

	public static int[] slotsarray = {10,11,12,13,14,15,16,19,25,28,29,30,31,32,33,34};
	
	public static ArrayList<Integer> slots = getSlots(slotsarray);
	
	public static HashMap<String, Double> priceStorage = getBasePrices();
	
	public static ItemStack getFish(int i) {
		
		switch(i) {
		case 10: return new Bluegill(i);
		case 11: return new BullheadCatfish(i);
		case 12: return new ChainPickerel(i);
		case 13: return new ChannelCatfish(i);
		case 14: return new Cod(i);
		case 15: return new LakeSturgeon(i);
		case 16: return new LargemouthBass(i);
		case 19: return new LongnoseGar(i);
		case 25: return new Muskie(i);
		case 28: return new Perch(i);
		case 29: return new Pufferfish(i);
		case 30: return new RedfinPickerel(i);
		case 31: return new RockBass(i);
		case 32: return new SmallmouthBass(i);
		case 33: return new SockeyeSalmon(i);
		case 34: return new SteelheadTrout(i);

		}
		
		return new Cod();
		
	}
	
	private static HashMap<String, Double> getBasePrices() {

		int i = 0;
		HashMap<String, Double> prices = new HashMap<>();
		prices.put(new Bluegill(i).getItemMeta().getDisplayName(), 35.0);
		prices.put(new BullheadCatfish(i).getItemMeta().getDisplayName(), 20.0);
		prices.put(new ChainPickerel(i).getItemMeta().getDisplayName(), 30.0);
		prices.put(new ChannelCatfish(i).getItemMeta().getDisplayName(), 10.0);
		prices.put(new Cod(i).getItemMeta().getDisplayName(), 3.0);
		prices.put(new LakeSturgeon(i).getItemMeta().getDisplayName(), 30.0);
		prices.put(new LargemouthBass(i).getItemMeta().getDisplayName(), 25.0);
		prices.put(new LongnoseGar(i).getItemMeta().getDisplayName(), 25.0);
		prices.put(new Muskie(i).getItemMeta().getDisplayName(), 20.0);
		prices.put(new Perch(i).getItemMeta().getDisplayName(), 30.0);
		prices.put(new Pufferfish(i).getItemMeta().getDisplayName(), 2.0);
		prices.put(new RedfinPickerel(i).getItemMeta().getDisplayName(), 35.0);
		prices.put(new RockBass(i).getItemMeta().getDisplayName(), 30.0);
		prices.put(new SmallmouthBass(i).getItemMeta().getDisplayName(), 30.0);
		prices.put(new SockeyeSalmon(i).getItemMeta().getDisplayName(), 8.0);
		prices.put(new SteelheadTrout(i).getItemMeta().getDisplayName(), 40.0);
		
		return prices;
	}

	private static ArrayList<Integer> getSlots(int[] slotsar) {
		
		ArrayList<Integer> newSlots = new ArrayList<>();
		
		for ( int i : slotsar ) {
			newSlots.add(i);
		}
		
		return newSlots;
		
		
	}
	
}

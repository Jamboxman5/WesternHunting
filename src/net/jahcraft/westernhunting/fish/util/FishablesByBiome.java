package net.jahcraft.westernhunting.fish.util;

import java.util.ArrayList;

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

public class FishablesByBiome {
	
	public static ArrayList<ItemStack> getGeneralFishables() {
		
		ArrayList<ItemStack> fishables = new ArrayList<>();
		fishables.add(new Cod());
		fishables.add(new SockeyeSalmon());
		fishables.add(new Pufferfish());
		return fishables;
		
	}
	
	public static ArrayList<ItemStack> getRiverFishables() {
		
		ArrayList<ItemStack> fishables = new ArrayList<>();
		fishables.add(new Bluegill());
		fishables.add(new Bluegill());
		fishables.add(new RockBass());
		fishables.add(new RockBass());
		fishables.add(new Bluegill());
		fishables.add(new ChainPickerel());
		fishables.add(new ChainPickerel());
		fishables.add(new ChainPickerel());
		fishables.add(new Perch());
		fishables.add(new Perch());
		fishables.add(new Perch());
		fishables.add(new RedfinPickerel());
		fishables.add(new RedfinPickerel());
		fishables.add(new RedfinPickerel());
		fishables.add(new SmallmouthBass());
		fishables.add(new SmallmouthBass());
		fishables.add(new SockeyeSalmon());
		fishables.add(new SockeyeSalmon());
		fishables.add(new SockeyeSalmon());
		fishables.add(new ChannelCatfish());
		return fishables;
		
	}
	
	public static ArrayList<ItemStack> getSwampFishables() {
		
		ArrayList<ItemStack> fishables = new ArrayList<>();
		fishables.add(new ChainPickerel());
		fishables.add(new ChainPickerel());
		fishables.add(new ChainPickerel());
		fishables.add(new Perch());
		fishables.add(new Perch());
		fishables.add(new Perch());
		fishables.add(new RedfinPickerel());
		fishables.add(new RedfinPickerel());
		fishables.add(new RedfinPickerel());
		fishables.add(new BullheadCatfish());
		fishables.add(new BullheadCatfish());
		fishables.add(new BullheadCatfish());
		fishables.add(new LakeSturgeon());
		fishables.add(new LargemouthBass());
		fishables.add(new LargemouthBass());
		fishables.add(new SteelheadTrout());
		fishables.add(new SteelheadTrout());
		return fishables;
		
	}
	
	public static ArrayList<ItemStack> getOceanFishables() {
		
		ArrayList<ItemStack> fishables = new ArrayList<>();
		fishables.add(new Cod());
		fishables.add(new Cod());
		fishables.add(new Cod());
		fishables.add(new Cod());
		fishables.add(new SockeyeSalmon());
		fishables.add(new SockeyeSalmon());
		fishables.add(new Muskie());
		fishables.add(new Muskie());
		fishables.add(new Muskie());
		fishables.add(new LongnoseGar());
		fishables.add(new SteelheadTrout());
		fishables.add(new SteelheadTrout());
		fishables.add(new Pufferfish());
		fishables.add(new LakeSturgeon());
		fishables.add(new LakeSturgeon());
		return fishables;
		
	}
	
	public static ArrayList<ItemStack> getAllFishables() {
		
		ArrayList<ItemStack> fishables = new ArrayList<>();
		fishables.add(new Cod());
		fishables.add(new BullheadCatfish());
		fishables.add(new ChainPickerel());
		fishables.add(new ChannelCatfish());
		fishables.add(new LargemouthBass());
		fishables.add(new Perch());
		fishables.add(new RedfinPickerel());
		fishables.add(new RockBass());
		fishables.add(new SmallmouthBass());
		fishables.add(new SockeyeSalmon());
		fishables.add(new Muskie());
		fishables.add(new LongnoseGar());
		fishables.add(new SteelheadTrout());
		fishables.add(new Pufferfish());
		fishables.add(new LakeSturgeon());
		fishables.add(new LongnoseGar());
		return fishables;
		
	}

}

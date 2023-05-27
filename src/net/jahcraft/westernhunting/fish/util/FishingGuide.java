package net.jahcraft.westernhunting.fish.util;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class FishingGuide {

	public static void sendTutorial(Player p) {
		
		p.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lFishing Guide &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
		p.sendMessage(ChatColor.of("#00E8FF") + "You can now get custom fish!");
		p.sendMessage(ChatColor.of("#00E8FF") + "All river, swamp, and ocean biomes have new custom fish!");
		p.sendMessage(ChatColor.of("#00E8FF") + "Heavier fish with higher stars will sell for more money.");
		p.sendMessage(ChatColor.of("#00E8FF") + "Some fish are worth more money, and some are more rare!");
		p.sendMessage(ChatColor.of("#00E8FF") + "Swamps, rivers, and oceans all have different fish!");
		p.sendMessage(ChatColor.of("#00E8FF") + "Explore and find the best fishing spot!");
		p.sendMessage(ChatColor.of("#00E8FF") + "Sell your fish in the fish exchange in /shop!");
		p.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---========================---");
		
	}
	
}

package net.jahcraft.westernhunting.pelts.util;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class HuntingGuide {

public static void sendTutorial(Player p) {
		
		p.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---=====" + ChatColor.translateAlternateColorCodes('&', "&7&l[ " + ChatColor.of("#FFD700") + "&lHunting Guide &7&l]") + ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=====---");
		p.sendMessage(ChatColor.of("#00E8FF") + "You can now get animal pelts!");
		p.sendMessage(ChatColor.of("#00E8FF") + "Almost all mammalian mobs drop animal pelts");
		p.sendMessage(ChatColor.of("#00E8FF") + "Animal hides with higher stars will sell for more money.");
		p.sendMessage(ChatColor.of("#00E8FF") + "Some pelts are worth more money, and some are more rare!");
		p.sendMessage(ChatColor.of("#00E8FF") + "Normal farm animals aren't that valuable! Rare animals");
		p.sendMessage(ChatColor.of("#00E8FF") + "That aren't typically farmed will have higher value pelts!");
		p.sendMessage(ChatColor.of("#00E8FF") + "Sell your animal hides in the pelt exchange in /shop!");
		p.sendMessage(ChatColor.of("#49B3FF") + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "---========================---");
		
	}
	
}

package net.jahcraft.westernhunting.pelts.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;

public class Colors {
	
	private static final Pattern pattern = Pattern.compile("&#[a-fA-F0-9]{6}");
	
	public static final ChatColor GOLD = ChatColor.of("#FFD700");
	public static final ChatColor YELLOW = ChatColor.of("#FFFF00");
	public static final ChatColor BLUE = ChatColor.of("#49B3FF");
	public static final ChatColor PALEBLUE = ChatColor.of("#76B9E6");
	public static final ChatColor BRIGHTBLUE = ChatColor.of("#00E8FF");
	public static final ChatColor BRIGHTRED = ChatColor.of("#FF0000");
	public static final ChatColor MUDBROWN = ChatColor.of("#c2a389");
	public static final ChatColor DARKBLUE = ChatColor.of("#007AD0");
	public static final ChatColor NATUREGREEN = ChatColor.of("#65e057");
	public static final ChatColor BRIGHTPURPLE = ChatColor.of("#e6008a");
	public static final ChatColor BEIGE = ChatColor.of("#fbe7c6");
	public static String format(String before) {
		return ChatColor.translateAlternateColorCodes('&', before);
	}
	public static String formatHex(String before) {
		Matcher match = pattern.matcher(before);
		while (match.find()) {
			String color = before.substring(match.start()+1, match.end());
			String toReplace = before.substring(match.start(), match.end());
			before = before.replace(toReplace, ChatColor.of(color) + "");
			match = pattern.matcher(before);
		}
		return ChatColor.translateAlternateColorCodes('&', before);
	}
}

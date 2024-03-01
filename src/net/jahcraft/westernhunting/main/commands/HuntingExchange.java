package net.jahcraft.westernhunting.main.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jahcraft.westernhunting.fish.gui.FishExchange;
import net.jahcraft.westernhunting.pelts.gui.PeltExchange;
import net.md_5.bungee.api.ChatColor;

public class HuntingExchange implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!label.equalsIgnoreCase("huntingexchange")) return false;
		if (!(sender instanceof Player)) return true;
		Player p = (Player) sender;
		if (!p.hasPermission("westernhunting.exchange")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return true;
		}
		
		if (args.length != 1) {
			sender.sendMessage(ChatColor.RED + "Usage: /huntingexchange <fish/pelts>");
			return true;
		}
		if (!args[0].equalsIgnoreCase("pelts") && !args[0].equalsIgnoreCase("fish")) {
			sender.sendMessage(ChatColor.RED + "Usage: /huntingexchange <fish/pelts>");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("fish")) {
			((Player) sender).openInventory(PeltExchange.createInv((Player)sender));
		} else {
			((Player) sender).openInventory(FishExchange.createInv((Player)sender));
		}
		
		return true;
	}

}

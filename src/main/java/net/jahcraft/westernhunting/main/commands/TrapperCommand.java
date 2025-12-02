package net.jahcraft.westernhunting.main.commands;

import net.jahcraft.westernhunting.main.TrapperMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jahcraft.westernhunting.fish.gui.FishExchange;
import net.jahcraft.westernhunting.pelts.gui.PeltExchange;
import net.md_5.bungee.api.ChatColor;

public class TrapperCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!label.equalsIgnoreCase("trapper")) return false;
		if (!(sender instanceof Player p)) return true;
        if (!p.hasPermission("westernhunting.trapper")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return true;
		}

        if (args.length == 0) {
            p.openInventory(TrapperMenu.inv);
            return true;
        }
		
		if (args[0].equalsIgnoreCase("fish")) {
			p.openInventory(FishExchange.createInv(p));
		} else if (args[0].equalsIgnoreCase("pelts")) {
			p.openInventory(PeltExchange.createInv(p));
		} else {
            sender.sendMessage(ChatColor.RED + "Usage: /trapper <fish/pelts>");
        }
		
		return true;
	}

}

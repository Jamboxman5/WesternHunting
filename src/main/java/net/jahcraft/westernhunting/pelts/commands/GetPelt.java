package net.jahcraft.westernhunting.pelts.commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.pelts.pelts.Pelt;
import net.jahcraft.westernhunting.pelts.util.PeltDefaults;
import net.md_5.bungee.api.ChatColor;

public class GetPelt implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("getpelt")) {
			
			if (!(sender instanceof Player)) return true;
			
			Player p = (Player) sender;
			
			if (!p.hasPermission("jahpelt.getpelt")) {
				p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
				return true;
			}
			
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Usage: /getpelt <type>");
				return true;
			}
			
			String type = args[0].toUpperCase();
			
			boolean found = false;
			for (EntityType e : PeltDefaults.types) {
				if (e.equals(EntityType.valueOf(type))) {
					found = true;
					break;
				}
			}
			
			if (!found) return true;
			
			if (!PeltDefaults.types.contains(EntityType.valueOf(type))) {
				p.sendMessage(ChatColor.RED + "Incompatible type!");
				return true;
			}
			
			ItemStack pelt = new Pelt(EntityType.valueOf(type), true);
			
			if (p.getInventory().firstEmpty() == -1 ) {
				
				// full inventory
				
				Location loc = p.getLocation();
				World world = p.getWorld();
				
				world.dropItemNaturally(loc, pelt);
				p.sendMessage(ChatColor.of("#DD7700") + "A " + pelt.getItemMeta().getDisplayName() + ChatColor.of("#DD7700") + "was dropped at your feet!");				
				return true;
				
			}
			
			p.getInventory().addItem(pelt);
			p.sendMessage(ChatColor.of("#DD7700") + "You received a " + pelt.getItemMeta().getDisplayName() + ChatColor.of("#DD7700") + "!");			
			return true;
			
		}
		
		return false;
		
	}
	
}

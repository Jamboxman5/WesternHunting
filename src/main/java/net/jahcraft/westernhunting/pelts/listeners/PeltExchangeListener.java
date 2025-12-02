package net.jahcraft.westernhunting.pelts.listeners;

import net.jahcraft.westernhunting.main.TrapperMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.main.Main;
import net.jahcraft.westernhunting.pelts.gui.PeltExchange;
import net.jahcraft.westernhunting.pelts.util.HuntingGuide;
import net.jahcraft.westernhunting.pelts.util.PeltDefaults;
import net.jahcraft.westernhunting.pelts.util.PeltMath;
import net.jahcraft.westernhunting.pelts.util.PeltPriceCalculator;
import net.md_5.bungee.api.ChatColor;

public class PeltExchangeListener implements Listener {
	
	private Main plugin;
	public PeltExchangeListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() == null) return;
		if (!e.getClickedInventory().contains(PeltExchange.i)) return;
		if (e.getCurrentItem().getItemMeta() == null) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		if (e.getClickedInventory() == null) return;
		
		e.setCancelled(true);
		
		Player p = (Player) e.getWhoClicked();
		
		if (!PeltDefaults.slots.contains(e.getSlot()) &&
			e.getSlot() != 45 &&
			e.getSlot() != 53 && 
			e.getSlot() != 49 &&
			e.getSlot() != 22) return;
		
		//GUI CONTROLS
		if (e.getSlot() == 49) {
			p.closeInventory();
			return;
		}
		if (e.getSlot() == 45) {
			p.closeInventory();
            p.openInventory(TrapperMenu.inv);
			return;
		}
		if (e.getSlot() == 53) {
			p.closeInventory();
			HuntingGuide.sendTutorial(p);
			return;
		}
		if (e.getSlot() == 22) {
			sellAllPelts(p, e);
			return;
		}
		
		checkClicks(e);
		
	}
	
	private void checkClicks(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if (e.isLeftClick() && !e.isShiftClick()) {
			sellPelt(player, e, 1);
		}
		
		if (e.isShiftClick() && e.isLeftClick()) {
			sellPeltShift(player, e, e.getCurrentItem().getMaxStackSize());
		}
		
	}
	
	private void sellPelt(Player p, InventoryClickEvent e, int i) {
		
		boolean peltSold = false;
		
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null ) {
				if (PeltPriceCalculator.isCorrectPelt(item, e)) {
					
					ItemStack temp = new ItemStack(item.getType());
					temp.setAmount(1);
					temp.setItemMeta(item.getItemMeta());
					p.getInventory().removeItem(temp);
							
					plugin.eco.depositPlayer(p, PeltPriceCalculator.getPrice(item, e));
					p.sendMessage(ChatColor.of("#DD7700") + "You sold a " + ChatColor.of("#FFD700") + PeltMath.parseStars(item) + " star " + item.getItemMeta().getDisplayName() 
					+ " for " + ChatColor.GREEN + "" + ChatColor.BOLD + "$"+ PeltPriceCalculator.getPrice(item, e) + ChatColor.of("#DD7700") + "!");
					peltSold = true;
					
//					for (String n : Main.infoStorage.getAdmins()) {
//						if (Bukkit.getPlayer(n) != null && 
//							p.getName() != Bukkit.getServer().getPlayer(n).getName()) {
//							Bukkit.getServer().getPlayer(n).sendMessage(ChatColor.RED + p.getName() + ChatColor.RED + 
//							" sold a " + PeltMath.parseStars(item) + " star " + item.getItemMeta().getDisplayName() 
//							+ ChatColor.RED + " for $" + PeltPriceCalculator.getPrice(item, e));
//						}
//						
//					}
					
					Bukkit.getLogger().info(p.getName() + " sold a " + PeltMath.parseStars(item) + " star " + item.getItemMeta().getDisplayName().substring(14) 
							+ " for $" + PeltPriceCalculator.getPrice(item, e));
					
					break;
						
				}
				
			}	
			
		}
		
		if (!peltSold) {
			p.sendMessage(ChatColor.RED + "You don't any of that pelt!");
		}
		
		
	}
	
	private void sellPeltShift(Player p, InventoryClickEvent e, int i) {
	
		int peltCounter = 0;
		double moneyMade = 0;
		boolean peltSold = false;
		String peltName = "";
		
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null ) {
				if (PeltPriceCalculator.isCorrectPelt(item, e)) {
					
					ItemStack temp = new ItemStack(item.getType());
					temp.setAmount(item.getAmount());
					temp.setItemMeta(item.getItemMeta());
					p.getInventory().removeItem(temp);
							
					double price = PeltPriceCalculator.getPrice(item, e) * item.getAmount();
					
					plugin.eco.depositPlayer(p, price);
					peltSold = true;
					peltCounter += item.getAmount();
					moneyMade += price;
					peltName = item.getItemMeta().getDisplayName();
						
				}
				
			}	
			
		}
		
		if (!peltSold) {
			p.sendMessage(ChatColor.RED + "You don't any of that pelt!");
		} else {
			p.sendMessage(ChatColor.of("#DD7700") + "You sold " + ChatColor.of("#FFD700") + peltCounter + " " 
			+ peltName + " for " + ChatColor.GREEN + "" + ChatColor.BOLD + "$"+ moneyMade + ChatColor.of("#DD7700") + "!");
			
//			for (String n : Main.infoStorage.getAdmins()) {
//				if (Bukkit.getPlayer(n) != null && 
//					p.getName() != Bukkit.getServer().getPlayer(n).getName()) {
//					Bukkit.getServer().getPlayer(n).sendMessage(ChatColor.RED + p.getName() + ChatColor.RED + 
//					" sold " + peltCounter + " pelts for $" + moneyMade);
//				}
//				
//			}
			
			Bukkit.getLogger().info(p.getName() + " has sold " + peltCounter + " pelts for $" + moneyMade);
			
		}
		
	}
	
	private void sellAllPelts(Player p, InventoryClickEvent e) {
		
		int peltCounter = 0;
		double moneyMade = 0;
		boolean peltSold = false;
		
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null ) {
				if (item.getType() == Material.LEATHER) {
					if (item.getItemMeta().hasLore()) {
							
						ItemStack temp = new ItemStack(item.getType());
						temp.setAmount(item.getAmount());
						temp.setItemMeta(item.getItemMeta());
						p.getInventory().removeItem(temp);
								
						double price = PeltPriceCalculator.getPrice(item, e) * item.getAmount();
						
						plugin.eco.depositPlayer(p, price);
						peltSold = true;
						peltCounter += item.getAmount();
						moneyMade += price;
						
					}
					
				}
				
			}
	
		}
		
		if (!peltSold) {
			p.sendMessage(ChatColor.RED + "You don't have any animal pelts!");
		} else {
			p.sendMessage(ChatColor.of("#DD7700") + "You sold " + ChatColor.of("#FFD700") + peltCounter + ChatColor.of("#DD7700")
					+ " pelts for " + ChatColor.GREEN + "" + ChatColor.BOLD + "$"+ moneyMade + ChatColor.of("#DD7700") + "!");
			
//			for (String n : Main.infoStorage.getAdmins()) {
//				if (Bukkit.getPlayer(n) != null && 
//					p.getName() != Bukkit.getServer().getPlayer(n).getName()) {
//					Bukkit.getServer().getPlayer(n).sendMessage(ChatColor.RED + p.getName() + ChatColor.RED + 
//					" sold " + peltCounter + " pelts for $" + moneyMade);
//				}
//				
//			}
			
			Bukkit.getLogger().info(p.getName() + " has sold " + peltCounter + " pelts for $" + moneyMade);
			
		}
		
		
		
	}
	
	

}

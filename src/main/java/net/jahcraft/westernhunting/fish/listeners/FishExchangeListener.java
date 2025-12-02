package net.jahcraft.westernhunting.fish.listeners;

import net.jahcraft.westernhunting.main.TrapperMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.fish.gui.FishExchange;
import net.jahcraft.westernhunting.fish.util.FishDefaults;
import net.jahcraft.westernhunting.fish.util.FishMath;
import net.jahcraft.westernhunting.fish.util.FishPriceCalculator;
import net.jahcraft.westernhunting.fish.util.FishingGuide;
import net.jahcraft.westernhunting.main.Main;
import net.md_5.bungee.api.ChatColor;

public class FishExchangeListener implements Listener {
	
	private Main plugin;
	public FishExchangeListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() == null) return;
		
		try {
			if (!e.getClickedInventory().contains(FishExchange.i)) return;

		} catch (Exception ex) {
			
		}
		if (e.getCurrentItem().getItemMeta() == null) return;
		if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		if (e.getClickedInventory() == null) return;
		
		e.setCancelled(true);
		
		Player p = (Player) e.getWhoClicked();
		
		if (!FishDefaults.slots.contains(e.getSlot()) &&
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
			FishingGuide.sendTutorial(p);
			return;
		}
		if (e.getSlot() == 22) {
			sellAllFish(p, e);
			return;
		}
		
		checkClicks(e);
		
		FishDefaults.getFish(e.getSlot());
		
	}
	
	private void checkClicks(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		
		if (e.isLeftClick() && !e.isShiftClick()) {
			sellFish(player, e, 1);
		}
		
		if (e.isShiftClick() && e.isLeftClick()) {
			sellFishShift(player, e, e.getCurrentItem().getMaxStackSize());
		}
		
	}
	
	private void sellFish(Player p, InventoryClickEvent e, int i) {
		
		boolean fishSold = false;
		
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null ) {
				if (FishPriceCalculator.isCorrectFish(item, e)) {
					
					ItemStack temp = new ItemStack(item.getType());
					temp.setAmount(1);
					temp.setItemMeta(item.getItemMeta());
					p.getInventory().removeItem(temp);
							
					plugin.eco.depositPlayer(p, FishPriceCalculator.getPrice(item, e));
					p.sendMessage(ChatColor.of("#49B3FF") + "You sold a " + ChatColor.AQUA + FishMath.parseStars(item) + " star " + item.getItemMeta().getDisplayName() 
					+ " weighing " + FishMath.parseWeight(item) + ChatColor.of("#49B3FF")
					+ " for " + ChatColor.GREEN + "" + ChatColor.BOLD + "$"+ FishPriceCalculator.getPrice(item, e) + ChatColor.of("#49B3FF") + "!");
					fishSold = true;
					
//					for (String n : Main.infoStorage.getAdmins()) {
//						if (Bukkit.getPlayer(n) != null && 
//							p.getName() != Bukkit.getServer().getPlayer(n).getName()) {
//							Bukkit.getServer().getPlayer(n).sendMessage(ChatColor.RED + p.getName() + ChatColor.RED + 
//							" sold a " + FishMath.parseStars(item) + " star " + item.getItemMeta().getDisplayName() + ChatColor.RED + 
//							" weighing " + FishMath.parseWeight(item) + ChatColor.RED + " for $" + FishPriceCalculator.getPrice(item, e));
//						}
//						
//					}
					
					Bukkit.getLogger().info(p.getName() + " sold a " + FishMath.parseStars(item) + " star " + item.getItemMeta().getDisplayName().substring(14) 
							+ " weighing " + FishMath.parseWeight(item).substring(2) + " for $" + FishPriceCalculator.getPrice(item, e));
					
					break;
						
				}
				
			}	
			
		}
		
		if (!fishSold) {
			p.sendMessage(ChatColor.RED + "You don't any of that fish!");
		}
		
		
	}
	
	private void sellFishShift(Player p, InventoryClickEvent e, int i) {
	
		int fishCounter = 0;
		double moneyMade = 0;
		boolean fishSold = false;
		String fishName = "";
		
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null ) {
				if (FishPriceCalculator.isCorrectFish(item, e)) {
					
					ItemStack temp = new ItemStack(item.getType());
					temp.setAmount(item.getAmount());
					temp.setItemMeta(item.getItemMeta());
					p.getInventory().removeItem(temp);
							
					double price = FishPriceCalculator.getPrice(item, e) * item.getAmount();
					
					plugin.eco.depositPlayer(p, price);
					fishSold = true;
					fishCounter += item.getAmount();
					moneyMade += price;
					fishName = item.getItemMeta().getDisplayName();
						
				}
				
			}	
			
		}
		
		if (!fishSold) {
			p.sendMessage(ChatColor.RED + "You don't any of that fish!");
		} else {
			p.sendMessage(ChatColor.of("#49B3FF") + "You sold " + ChatColor.AQUA + fishCounter + " " 
			+ fishName + " for " + ChatColor.GREEN + "" + ChatColor.BOLD + "$"+ moneyMade + ChatColor.of("#49B3FF") + "!");
			
//			for (String n : Main.infoStorage.getAdmins()) {
//				if (Bukkit.getPlayer(n) != null && 
//					p.getName() != Bukkit.getServer().getPlayer(n).getName()) {
//					Bukkit.getServer().getPlayer(n).sendMessage(ChatColor.RED + p.getName() + ChatColor.RED + 
//					" sold " + fishCounter + " fish for $" + moneyMade);
//				}
//				
//			}
			
			Bukkit.getLogger().info(p.getName() + " has sold " + fishCounter + " fish for $" + moneyMade);
			
		}
		
	}
	
	private void sellAllFish(Player p, InventoryClickEvent e) {
		
		int fishCounter = 0;
		double moneyMade = 0;
		boolean fishSold = false;
		
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null ) {
				if (item.getType() == Material.COD || 
					item.getType() == Material.SALMON ||
					item.getType() == Material.PUFFERFISH) {
					if (item.getItemMeta().hasLore()) {
							
						ItemStack temp = new ItemStack(item.getType());
						temp.setAmount(item.getAmount());
						temp.setItemMeta(item.getItemMeta());
						p.getInventory().removeItem(temp);
								
						double price = FishPriceCalculator.getPrice(item, e) * item.getAmount();
						
						plugin.eco.depositPlayer(p, price);
						fishSold = true;
						fishCounter += item.getAmount();
						moneyMade += price;
						
					}
					
				}
				
			}
			
		}
		
		if (!fishSold) {
			p.sendMessage(ChatColor.RED + "You don't have any caught fish!");
		} else {
			p.sendMessage(ChatColor.of("#49B3FF") + "You sold " + ChatColor.AQUA + fishCounter + ChatColor.of("#49B3FF")
					+ " fish for " + ChatColor.GREEN + "" + ChatColor.BOLD + "$"+ moneyMade + ChatColor.of("#49B3FF") + "!");
			
//			for (String n : Main.infoStorage.getAdmins()) {
//				if (Bukkit.getPlayer(n) != null && 
//					p.getName() != Bukkit.getServer().getPlayer(n).getName()) {
//					Bukkit.getServer().getPlayer(n).sendMessage(ChatColor.RED + p.getName() + ChatColor.RED + 
//					" sold " + fishCounter + " fish for $" + moneyMade);
//				}
//				
//			}
			
			Bukkit.getLogger().info(p.getName() + " has sold " + fishCounter + " fish for $" + moneyMade);
			
		}
		
		
		
	}
	
	

}

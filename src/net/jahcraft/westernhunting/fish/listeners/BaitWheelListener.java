package net.jahcraft.westernhunting.fish.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BaitWheelListener implements Listener {
	
	@EventHandler
	public void openWheel(PlayerInteractEvent e) {
		
	}
	
	@EventHandler
	public void clickWheel(InventoryClickEvent e) {
		ItemStack[] contents = e.getWhoClicked().getInventory().getContents();
	}
	
	@EventHandler
	public void closeWheel(InventoryCloseEvent e) {
		
	}
	
	
	

}

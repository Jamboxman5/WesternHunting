package net.jahcraft.westernhunting.main;

import net.jahcraft.westernhunting.fish.gui.FishExchange;
import net.jahcraft.westernhunting.pelts.gui.PeltExchange;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TrapperListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if (e.getClickedInventory() == null) return;
		if (!e.getClickedInventory().equals(TrapperMenu.inv)) return;

		e.setCancelled(true);
		
		Player p = (Player) e.getWhoClicked();

		//GUI CONTROLS
		if (e.getSlot() == 11) {
			p.closeInventory();
            p.openInventory(PeltExchange.createInv(p));
			return;
		}
		if (e.getSlot() == 15) {
			p.closeInventory();
            p.openInventory(FishExchange.createInv(p));
            return;
		}
		if (e.getSlot() == 22) {
			p.closeInventory();
			return;
		}

	}
	
	

}

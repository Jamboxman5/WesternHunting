package net.jahcraft.westernhunting.pelts.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.pelts.pelts.Pelt;

public class AnimalDeathListener implements Listener {

	Player attacker;
	
	@EventHandler
	public void onMammalAttack(EntityDamageByEntityEvent e) {
		
		if (e.getEntityType() != EntityType.COW &&
			e.getEntityType() != EntityType.PIG &&
			e.getEntityType() != EntityType.SHEEP &&
			e.getEntityType() != EntityType.PANDA &&
			e.getEntityType() != EntityType.RABBIT &&
			e.getEntityType() != EntityType.GOAT &&
			e.getEntityType() != EntityType.WOLF &&
			e.getEntityType() != EntityType.POLAR_BEAR &&
			e.getEntityType() != EntityType.OCELOT &&
			e.getEntityType() != EntityType.MUSHROOM_COW &&
			e.getEntityType() != EntityType.FOX &&
			e.getEntityType() != EntityType.TRADER_LLAMA &&
			e.getEntityType() != EntityType.LLAMA) return;
				
		if (e.getDamager() instanceof Player) {
			attacker = (Player) e.getDamager();
		}
		
	}
	
	@EventHandler
	public void onMammalDeath(EntityDeathEvent e) {
		
		if (e.getEntityType() != EntityType.COW &&
			e.getEntityType() != EntityType.PIG &&
			e.getEntityType() != EntityType.SHEEP &&
			e.getEntityType() != EntityType.PANDA &&
			e.getEntityType() != EntityType.RABBIT &&
			e.getEntityType() != EntityType.GOAT &&
			e.getEntityType() != EntityType.WOLF &&
			e.getEntityType() != EntityType.POLAR_BEAR &&
			e.getEntityType() != EntityType.FOX &&
			e.getEntityType() != EntityType.OCELOT &&
			e.getEntityType() != EntityType.MUSHROOM_COW &&
			e.getEntityType() != EntityType.TRADER_LLAMA &&
			e.getEntityType() != EntityType.LLAMA) return;
		
		if (attacker == null) return;
					
		if (e.getDrops() != null) {
			for (ItemStack i : e.getDrops()) {
				if (i.getType() == Material.LEATHER ||
					i.getType() == Material.RABBIT_HIDE) {
					e.getDrops().remove(i);
				}
			}
		}
		
		
		
		
		boolean silk = false;
		
		if (attacker.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
			silk = true;
		}
		
		ItemStack drop = new Pelt(e.getEntityType(), silk);
		
		e.getDrops().add(drop);
		
	}
	
}

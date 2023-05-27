package net.jahcraft.westernhunting.fish.listeners;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import net.jahcraft.westernhunting.fish.fishables.Cod;
import net.jahcraft.westernhunting.fish.fishables.Pufferfish;
import net.jahcraft.westernhunting.fish.fishables.SockeyeSalmon;

public class FishDeathListener implements Listener {
	
	Player attacker;
	
	@EventHandler
	public void onFishAttack(EntityDamageByEntityEvent e) {
		
		if (e.getEntityType() != EntityType.PUFFERFISH &&
			e.getEntityType() != EntityType.COD &&
			e.getEntityType() != EntityType.SALMON) return;
		
		if (e.getDamager() instanceof Player) {
			attacker = (Player) e.getDamager();
		}
		
	}
	
	@EventHandler
	public void onFishDeath(EntityDeathEvent e) {
		
		if (e.getEntityType() != EntityType.PUFFERFISH &&
			e.getEntityType() != EntityType.COD &&
			e.getEntityType() != EntityType.SALMON) return;
		
		if (attacker == null) return;
		
		e.getDrops().clear();
		
		boolean silk = false;
		
		if (attacker.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
			silk = true;
		}
		
		ItemStack drop = new Cod(silk);
		
		if (e.getEntityType() == EntityType.PUFFERFISH) {
			
			drop = new Pufferfish(silk);
			
		} else if (e.getEntityType() == EntityType.SALMON) {
			
			drop = new SockeyeSalmon(silk);
			
		}
		
		e.getDrops().add(drop);
		
	}

}

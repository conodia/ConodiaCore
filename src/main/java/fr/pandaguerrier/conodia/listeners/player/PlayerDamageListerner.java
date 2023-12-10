package fr.pandaguerrier.conodia.listeners.player;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListerner implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void entityDamageEvent(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            double damage = event.getDamage() - 5.0;
            Player player = (Player) event.getEntity();
            double armor = player.getInventory().getArmorContents().length;
            damage = damage - (damage * (armor / 100));
            event.setDamage(damage);
        }
    }
}

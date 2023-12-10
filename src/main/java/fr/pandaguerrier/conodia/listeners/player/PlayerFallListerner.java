package fr.pandaguerrier.conodia.listeners.player;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerFallListerner implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void entityDamageEvent(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && event.getCause() == EntityDamageEvent.DamageCause.FALL && event.getEntity().hasPermission("conodia.nofall")) {
            event.setCancelled(true);
        }
    }
}

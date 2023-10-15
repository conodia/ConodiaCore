package fr.pandaguerrier.conodia.listeners;

import fr.pandaguerrier.conodia.utils.Utils;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class UtilEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteraction(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        if (block != null && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            if (Utils.canOpenChest(block, player)) {
                event.setCancelled(true);
                player.sendMessage("§cVous ne pouvez pas ouvrir ce coffre !");
            }
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onInteraction(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();

        if(entity.getType().equals(EntityType.VILLAGER)) {
            event.setCancelled(true);
        }
    }

    @EventHandler()
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)) event.setCancelled(true);
    }
}
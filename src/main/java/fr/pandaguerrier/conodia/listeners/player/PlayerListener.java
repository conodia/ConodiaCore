package fr.pandaguerrier.conodia.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§8[§c-§8] §8" + player.getName());
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("§8[§a+§8] §8" + player.getName());

        if (!player.hasPlayedBefore()) {
            player.sendMessage("§7Bienvenue sur §6§lConodia§7 !\n\n§7Pour commencer, tu peux faire §6§l/kit§7.\n§7Si tu as besoin d'aide, tu peux faire §6§l/help§7.\n\n§7Bon jeu sur §6§lConodia§7 !");
            player.sendMessage("§7Si tu as des questions, tu peux les poser sur notre discord : §6§lconodia.fr/discord");
            player.sendMessage("§2Comme tu es nouveau, tu as accès à un kit de bienvenue, et au grade Maître Horloger pendant 1 jour !");
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent addtemp maître-horloger 24h");
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        if (player.hasPermission("conodia.nohunger")) {
            event.setCancelled(true);
            player.setFoodLevel(20);
        }
    }
}

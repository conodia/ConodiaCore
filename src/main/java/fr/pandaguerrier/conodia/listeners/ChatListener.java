package fr.pandaguerrier.conodia.listeners;

import fr.pandaguerrier.conodia.ConodiaCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener  {
    @EventHandler
    public void chatBlock( AsyncPlayerChatEvent event) {
        if (!event.getPlayer().hasPermission("chat.bypass") && ConodiaCore.getInstance().isChatBlocker()) {
            event.getPlayer().sendMessage("§cLe chat est d\u00e9sactiv\u00e9 !");
            event.setCancelled(true);
        }
    }
}

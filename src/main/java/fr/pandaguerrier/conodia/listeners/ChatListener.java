package fr.pandaguerrier.conodia.listeners;

import org.bukkit.event.EventHandler;
import fr.pandaguerrier.conodia.ConodiaCore;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;

public class ChatListener implements Listener
{
    @EventHandler
    public void chatBlock( AsyncPlayerChatEvent event) {
        if (!event.getPlayer().hasPermission("chat.bypass") && ConodiaCore.getInstance.chatBlockerBoolean) {
            event.getPlayer().sendMessage("§cLe chat est d\u00e9sactiv\u00e9 !");
            event.setCancelled(true);
        }
    }
}

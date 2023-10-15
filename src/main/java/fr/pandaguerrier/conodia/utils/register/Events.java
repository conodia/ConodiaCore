package fr.pandaguerrier.conodia.utils.register;

import fr.pandaguerrier.conodia.ConodiaCore;
import fr.pandaguerrier.conodia.commandremover.CommandListener;
import fr.pandaguerrier.conodia.listeners.ChatListener;
import fr.pandaguerrier.conodia.listeners.CobbleGen;
import fr.pandaguerrier.conodia.listeners.UtilEvent;
import fr.pandaguerrier.conodia.listeners.player.PlayerDamageListerner;
import fr.pandaguerrier.conodia.listeners.player.PlayerFallListerner;
import fr.pandaguerrier.conodia.listeners.player.PlayerListener;

public class Events {
  public static void load(ConodiaCore plugin) {
    plugin.getServer().getPluginManager().registerEvents(new PlayerListener(), plugin);
    plugin.getServer().getPluginManager().registerEvents(new ChatListener(), plugin);
    plugin.getServer().getPluginManager().registerEvents(new CommandListener(), plugin);
    plugin.getServer().getPluginManager().registerEvents(new PlayerFallListerner(), plugin);
    plugin.getServer().getPluginManager().registerEvents(new UtilEvent(), plugin);
    plugin.getServer().getPluginManager().registerEvents(new CobbleGen(), plugin);
    plugin.getServer().getPluginManager().registerEvents(new PlayerDamageListerner(), plugin);
  }
}

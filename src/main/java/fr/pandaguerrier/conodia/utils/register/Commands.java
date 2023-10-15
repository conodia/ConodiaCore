package fr.pandaguerrier.conodia.utils.register;

import fr.pandaguerrier.conodia.ConodiaCore;
import fr.pandaguerrier.conodia.commands.*;
import fr.pandaguerrier.conodia.commands.admin.*;

public class Commands {
  public static void load(ConodiaCore plugin) {
    plugin.getCommand("abc").setExecutor(new Broadcast());
    plugin.getCommand("ccl").setExecutor(new ClearChat());
    plugin.getCommand("site").setExecutor(new Site());
    plugin.getCommand("vote").setExecutor(new Vote());
    plugin.getCommand("discord").setExecutor(new Discord());
    plugin.getCommand("boutique").setExecutor(new Boutique());
    plugin.getCommand("ping").setExecutor(new Ping());
    plugin.getCommand("chat").setExecutor(new Chat());
    plugin.getCommand("levels").setExecutor(new Levels());
    plugin.getCommand("voteplayer").setExecutor(new VotePlayer());
    plugin.getCommand("clearlag").setExecutor(new Clearlag());
    plugin.getCommand("lag").setExecutor(new Lag());
  }
}

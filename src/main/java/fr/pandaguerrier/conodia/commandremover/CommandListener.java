package fr.pandaguerrier.conodia.commandremover;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String command;
        if (e.getMessage().contains(" ")) {
            command = e.getMessage().substring(1).toLowerCase().split(" ")[0];
        } else {
            command = e.getMessage().replace("/", "");
        }
        ConfigJSON loadedConfig = CommandRemover.getInstance.loadedConfig;
        List<String> commandList = loadedConfig.commandList;
        if (p.isOp())
            return;
        for (String cmd : commandList) {
            if (command.equalsIgnoreCase(cmd))
                return;
        }
        e.setCancelled(true);
        p.sendMessage(loadedConfig.unvailableCommand);
    }
}

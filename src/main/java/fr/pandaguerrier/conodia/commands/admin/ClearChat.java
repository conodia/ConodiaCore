package fr.pandaguerrier.conodia.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class ClearChat implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        if (!sender.hasPermission("conodia.ccl")) {
            sender.sendMessage("§8[§c!§8] §cVous n'avez pas acc\u00e8s \u00e0 cette commande.");
            return false;
        }
        for (int i = 0; i <= 100; ++i) {
            Bukkit.broadcastMessage(" ");
        }
        Bukkit.broadcastMessage("§8§m-------------------------------");
        Bukkit.broadcastMessage("§c\u279c Le chat a \u00e9t\u00e9 clear par " + sender.getName());
        Bukkit.broadcastMessage("§8§m-------------------------------");
        return false;
    }
}

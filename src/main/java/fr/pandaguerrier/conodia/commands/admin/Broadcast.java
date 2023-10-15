package fr.pandaguerrier.conodia.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Broadcast implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        if (!sender.hasPermission("conodia.abc")) {
            sender.sendMessage("§8[§c!§8] §cVous n'avez pas acc\u00e8s \u00e0 cette commande.");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage("§8[§c!§8] §cMettez un messages pour le broadcast !");
        }
        if (args.length >= 1) {
             StringBuilder bc = new StringBuilder();
            for ( String part : args) {
                bc.append(part).append(" ");
            }
            Bukkit.broadcastMessage("§9\u279c §b" + bc);
        }
        return true;
    }
}

package fr.pandaguerrier.conodia.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Vote implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        sender.sendMessage("§8§m-------------------------------");
        sender.sendMessage("§9\u279c §bhttps://conodia.fr/vote");
        sender.sendMessage("§8§m-------------------------------");
        return false;
    }
}

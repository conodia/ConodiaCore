package fr.pandaguerrier.conodia.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Site implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        sender.sendMessage("§8§m-------------------------------");
        sender.sendMessage("§9\u279c §bhttps://conodia.fr/");
        sender.sendMessage("§8§m-------------------------------");
        return false;
    }
}

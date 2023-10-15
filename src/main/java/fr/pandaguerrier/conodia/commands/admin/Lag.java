package fr.pandaguerrier.conodia.commands.admin;

import fr.pandaguerrier.conodia.ConodiaCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Lag implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {

        sender.sendMessage("§9➜ §bLe clear lag va supprimer toutes les entitées dans §9" + date(ConodiaCore.getInstance.timeClearLag) + "§b !");

        return true;
    }

    public String date(int secondsParameter) {
        int minutes = (secondsParameter % 3600) / 60;
        int seconds = secondsParameter % 60;

        return minutes + " minutes et " + seconds + " secondes ";
    }
}

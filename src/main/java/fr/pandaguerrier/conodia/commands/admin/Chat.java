package fr.pandaguerrier.conodia.commands.admin;

import org.bukkit.Bukkit;
import fr.pandaguerrier.conodia.ConodiaCore;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Chat implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        if (!sender.hasPermission("chat.use")) {
            return false;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVous n'avez pas acc\u00e8s \u00e0 cette commande.");
            return false;
        }
        if (args.length != 0) {
            return true;
        }
        if (ConodiaCore.getInstance.chatBlockerBoolean) {
            sender.sendMessage("§aChat actif");
            Bukkit.broadcastMessage("§8§m-----------------------------\n§f \n§f        §a" + sender.getName() + " a r\u00e9activ\u00e9 le chat.\n \n§a             Merci de ne pas spam !\n \n§8§m-----------------------------");
            return ConodiaCore.getInstance.chatBlockerBoolean = false;
        }
        sender.sendMessage("§cChat d\u00e9sactiv\u00e9");
        Bukkit.broadcastMessage("§8§m-----------------------------\n§f \n§f        §c" + sender.getName() + " a d\u00e9sactiv\u00e9 le chat.\n \n  Pour toutes demande, merci de se r\u00e9f\u00e9rer au discord !\n \n§8§m-----------------------------");
        return ConodiaCore.getInstance.chatBlockerBoolean = true;
    }
}

package fr.pandaguerrier.conodia.commands.admin;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
public class VotePlayer implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        if (!sender.hasPermission("conodia.vote")) {
            sender.sendMessage("§8[§c!§8] §cVous n'avez pas acc\u00e8s \u00e0 cette commande.");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage("§8[§c!§8] §cMettez un joueurs pour le vote !");
        }
        if (args.length >= 1) {
             StringBuilder bc = new StringBuilder();
            for ( String part : args) {
                bc.append(part).append(" ");
            }
             PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"§9" + args[0] + " §ba vot\u00e9 pour le serveur !\"}"), (byte)2);
            for ( Player p : Bukkit.getServer().getOnlinePlayers()) {
                ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
            }
        }
        return true;
    }
}

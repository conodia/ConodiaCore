package fr.pandaguerrier.conodia.commands;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        if (sender instanceof Player) {
             Player player = (Player)sender;
             EntityPlayer msPlayer = ((CraftPlayer)player).getHandle();
            sender.sendMessage("§9\u279c §b" + msPlayer.ping + "ms");
        }
        return true;
    }
}

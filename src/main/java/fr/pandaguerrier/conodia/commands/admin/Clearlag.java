package fr.pandaguerrier.conodia.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Clearlag implements CommandExecutor
{
    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        List<Entity> entities = Bukkit.getServer().getWorld("world").getEntities();

       AtomicInteger i = new AtomicInteger();

        entities.stream().filter(e -> e.getType() == EntityType.DROPPED_ITEM).forEach(e ->  {
                e.remove();

                i.getAndIncrement();
        });

        sender.sendMessage("§8[§c!§8] §aJ'ai supprimé " + i + " entités !");

        return true;
    }
}

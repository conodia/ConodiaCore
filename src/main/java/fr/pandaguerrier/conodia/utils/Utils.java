package fr.pandaguerrier.conodia.utils;

import com.massivecraft.factions.*;
import com.massivecraft.factions.listeners.FactionsBlockListener;
import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Utils {
    public static void sendActionBar(Player player, String message) {
        PacketPlayOutChat packet = new PacketPlayOutChat(new ChatComponentText(message), (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    public static boolean canBuild(Player player, Block block) {
        FLocation fLocation = new FLocation(block.getLocation());
        Faction faction = Board.getInstance().getFactionAt(fLocation);
        return FactionsBlockListener.playerCanBuildDestroyBlock(player, block.getLocation(), "destroy", true) && !faction.isSafeZone() && !faction.isWarZone();
    }

    public static boolean canOpenChest(Block block, Player player) {
        FLocation fLocation = new FLocation(block.getLocation());
        Faction faction = Board.getInstance().getFactionAt(fLocation);

        return (block.getType().equals(Material.CHEST) || block.getType().equals(Material.TRAPPED_CHEST) || block.getType().equals(Material.ENDER_CHEST)) && !player.getPlayer().isOp() && !player.getPlayer().hasPermission("conodia.bypass") && !FactionsBlockListener.playerCanBuildDestroyBlock(player, block.getLocation(), "destroy", true) && !faction.isSafeZone();
    }

    private static void debug(String message) {
        Bukkit.getConsoleSender().sendMessage("§9DEBUG: " + message);
    }
}

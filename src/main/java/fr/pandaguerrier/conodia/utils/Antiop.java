package fr.pandaguerrier.conodia.utils;

import fr.pandaguerrier.conodia.ConodiaCore;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.io.IOException;

public class Antiop {
    public void repeatTaskAntiOP() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        for (Player player : Bukkit.getOnlinePlayers()) {
            // Anti Op
            if (player.isOp() && !ConodiaCore.getInstance.getConfig().getStringList("Ops").contains(player.getName())) {
                player.setOp(false);
                DiscordWebhook webhook = new DiscordWebhook("https://discord.com/api/webhooks/1001903096399675484/z_Gem_f0IyjwoRPCupFPyykuC8SbUNI-ukU3AuT-l4ldFnym4GyPXUkGqopFZ-M5Bx0l");
                DiscordWebhook.EmbedObject embed = new DiscordWebhook.EmbedObject();

                embed.setTitle("Oh un hacker !");
                embed.setDescription("Le joueur: " + player.getName() + " a réussi a se mettre op ! (IP: " + player.getAddress() + ")");
                embed.setColor(Color.GRAY);

                webhook.addEmbed(embed);
                webhook.setUsername("AntiOp");
                try {
                    webhook.execute();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Bukkit.getScheduler().runTask(ConodiaCore.getInstance, () -> Bukkit.dispatchCommand(console, "tempbanip " + player.getName() + " Oh petit filou ! Passe discord pour te faire déban ! (ANTI-GM)"));
            }
        }
    }
}

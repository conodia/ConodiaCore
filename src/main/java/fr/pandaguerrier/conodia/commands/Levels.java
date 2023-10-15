package fr.pandaguerrier.conodia.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Levels implements CommandExecutor
{

    public boolean onCommand( CommandSender sender,  Command cmd,  String msg,  String[] args) {
        if (sender instanceof Player) {
             Player player = (Player)sender;
            Inventory inv = Bukkit.createInventory(null, 45, "§9\u279c §bFaction Levels");
            for (int i = 0; 10 > i; ++i) {
                inv.setItem(i, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            }
            inv.setItem(21, this.createGuiItem(Material.CHEST, "§bMes statistiques", 0, " ", "§9\u279c §bVoir les statistiques de ta faction !", " "));
            inv.setItem(23, this.createGuiItem(Material.GOLD_BLOCK, "§bClassement", 0, " ", "§9\u279c §bVoir le classement du plus haut level !", " "));
            inv.setItem(17, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            inv.setItem(26, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            inv.setItem(35, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            inv.setItem(18, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            inv.setItem(27, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            inv.setItem(36, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            for (int i = 10; 17 > i; ++i) {
                inv.setItem(i, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 0, " "));
            }
            inv.setItem(25, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 0, " "));
            inv.setItem(19, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 0, " "));
            for (int i = 28; 35 > i; ++i) {
                inv.setItem(i, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 0, " "));
            }
            for (int i = 35; 45 > i; ++i) {
                inv.setItem(i, this.createGuiItem(Material.STAINED_GLASS_PANE, " ", 3, " "));
            }
            player.openInventory(inv);
        }
        return false;
    }
    
    protected ItemStack createGuiItem( Material material,  String name,  int data,  String... lore) {
         ItemStack item = new ItemStack(material, 1, (short)data);
         ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
}

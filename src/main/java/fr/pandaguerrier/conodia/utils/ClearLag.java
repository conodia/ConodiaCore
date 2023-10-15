package fr.pandaguerrier.conodia.utils;

import fr.pandaguerrier.conodia.ConodiaCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.Arrays;
import java.util.List;

public class ClearLag {
    public void all() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(ConodiaCore.getInstance, () -> {
            List<Entity> entities = Bukkit.getServer().getWorld("world").getEntities();
            Object[] entityTypes = entities.stream().filter(e -> e.getType().equals(EntityType.DROPPED_ITEM) || e.getType().equals(EntityType.ARMOR_STAND) || e.getType().equals(EntityType.MINECART)).toArray();
            Arrays.stream(entityTypes).map(e -> (Entity) e).forEach(Entity::remove);
            Bukkit.broadcastMessage("§9➜ §bJ'ai supprimé " + entityTypes.length + " entité(s) !");
        }, 0, 20 * 600);
    }

    public void timer() {
     Bukkit.getServer().getScheduler().runTaskTimerAsynchronously(ConodiaCore.getInstance, () -> {
         if(ConodiaCore.getInstance.timeClearLag - 1 == 0) ConodiaCore.getInstance.timeClearLag = 600;
         else ConodiaCore.getInstance.timeClearLag = ConodiaCore.getInstance.timeClearLag - 1;
         // todo
         Bukkit.broadcastMessage("§9➜ §bAttention, les entité(s) vont être supprimée(s) dans §9" + formatTime(ConodiaCore.getInstance.timeClearLag) + " §b!");
     }, 0, 20L);
    }

    private String formatTime(int time) {
        if(time == 0) return "0 seconde";
        // time is in seconds
        int minutes = time / 60;

        return time > 60 ? minutes + " minutes" : time + " secondes";
    }
}

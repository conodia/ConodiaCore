package fr.pandaguerrier.conodia.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CobbleGen implements Listener {

    @EventHandler
    public void cobbleGen(BlockFromToEvent event) {

        int id = event.getBlock().getTypeId();

        if(id >= 8 && id <= 11) {

            Block b = event.getToBlock();
            int toid = b.getTypeId();

            if(toid == 0) {

                if(generatesCobble(id, b)) {

                    event.setCancelled(true);
                }
            }
        }
    }
    public boolean generatesCobble(int id, Block b)
    {
        int mirrorID1 = (id == 8 || id == 9 ? 10 : 8);
        int mirrorID2 = (id == 8 || id == 9 ? 11 : 9);
        for(BlockFace face : faces)
        {
            Block r = b.getRelative(face, 1);
            if(r.getTypeId() == mirrorID1 || r.getTypeId() == mirrorID2) {
                return true;
            }
        }
        return false;
    }
    private final BlockFace[] faces = new BlockFace[] {
            BlockFace.SELF,
            BlockFace.UP,
            BlockFace.DOWN,
            BlockFace.NORTH,
            BlockFace.EAST,
            BlockFace.SOUTH,
            BlockFace.WEST
    };
}

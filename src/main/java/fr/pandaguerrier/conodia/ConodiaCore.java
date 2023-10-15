package fr.pandaguerrier.conodia;

import com.massivecraft.factions.Faction;
import fr.pandaguerrier.conodia.utils.Load;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


public class ConodiaCore extends JavaPlugin {
    public boolean chatBlockerBoolean = false;
    public HashMap<Faction, Object> factionLevel = new HashMap<>();

    public static ConodiaCore getInstance;
    public static Config getConfig;

    public int timeClearLag = 600;

    @Override
    public void onEnable() {
        getInstance = this;

        Load load = new Load();
        load.Main();

        System.out.println("\n \n-------------------------\n \nLe Core est connecté !\n \n-------------------------\n \n");
    }

    public void onDisable() {
        System.out.println("\n \n-------------------------\n \nLe Core est déconnecté !\n \n-------------------------\n \n");
    }

}
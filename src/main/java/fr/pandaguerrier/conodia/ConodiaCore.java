package fr.pandaguerrier.conodia;

import fr.pandaguerrier.conodia.utils.Load;
import org.bukkit.plugin.java.JavaPlugin;
public class ConodiaCore extends JavaPlugin {
    private boolean chatBlockerBoolean = false;
    private static ConodiaCore INSTANCE;
    public int timeClearLag = 600;

    @Override
    public void onEnable() {
        INSTANCE = this;

        Load load = new Load();
        load.Main();

        System.out.println("\n \n-------------------------\n \nLe Core est connecté !\n \n-------------------------\n \n");
    }

    public void onDisable() {
        System.out.println("\n \n-------------------------\n \nLe Core est déconnecté !\n \n-------------------------\n \n");
    }

    public static ConodiaCore getInstance() {
        return INSTANCE;
    }

    public boolean isChatBlocker() {
        return chatBlockerBoolean;
    }

    public void setChatBlocker(boolean chatBlockerBoolean) {
        this.chatBlockerBoolean = chatBlockerBoolean;
    }
}
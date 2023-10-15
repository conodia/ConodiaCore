package fr.pandaguerrier.conodia.utils;

import fr.pandaguerrier.conodia.Config;
import fr.pandaguerrier.conodia.ConodiaCore;
import fr.pandaguerrier.conodia.commandremover.CommandRemover;
import fr.pandaguerrier.conodia.utils.register.Commands;
import fr.pandaguerrier.conodia.utils.register.Events;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.ArrayList;

public class Load {
    public void Main() {
        ClearLag clearLag = new ClearLag();
        clearLag.timer();

        ArrayList<String> opsArray = new ArrayList<>();
        opsArray.add("Panda_Guerrier");
        ConodiaCore.getInstance.getConfig().addDefault("Ops", opsArray);
        ConodiaCore.getInstance.getConfig().options().copyDefaults(true);
        ConodiaCore.getInstance.saveConfig();

        ConodiaCore.getConfig = new Config(new File(ConodiaCore.getInstance.getDataFolder().getAbsolutePath() + "/config.json"));
        ConodiaCore.getConfig.reload();

        Commands.load(ConodiaCore.getInstance);
        Events.load(ConodiaCore.getInstance);

        Antiop antiop = new Antiop();
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(ConodiaCore.getInstance, antiop::repeatTaskAntiOP, 0L, 10L);

        CommandRemover commandRemover = new CommandRemover();
        commandRemover.onCommandEnable();

        clearLag.all();
    }
}

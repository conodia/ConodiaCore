package fr.pandaguerrier.conodia.commandremover.storage;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.pandaguerrier.conodia.ConodiaCore;
import fr.pandaguerrier.conodia.commandremover.CommandRemover;
import fr.pandaguerrier.conodia.commandremover.ConfigJSON;

import java.io.*;
import java.util.Objects;

public class ConfigStorage {
    public static File storageFile;

    private Gson gson;

    public ConfigStorage() {
        this

                .gson = (new GsonBuilder()).disableHtmlEscaping().setPrettyPrinting().serializeNulls().create();
        storageFile = ConodiaCore.getInstance().getDataFolder();
        if (!storageFile.exists())
            storageFile.mkdir();
    }

    public boolean configExist() {
        for (File f : (File[])Objects.<File[]>requireNonNull(storageFile.listFiles())) {
            if (f.getName().equalsIgnoreCase("commands.json"))
                return true;
        }
        return false;
    }

    public void saveDefaultConfig() {
        ConfigJSON defaultConfig = new ConfigJSON();
        File file = new File(storageFile, "commands.json");
        try {
            if (!file.exists())
                file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(serialize(defaultConfig));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfig() {
        for (File f : (File[])Objects.<File[]>requireNonNull(storageFile.listFiles())) {
            if (f.getName().equalsIgnoreCase("commands.json")) {
                CommandRemover.getInstance.loadedConfig = deserialize(f);
                if (CommandRemover.getInstance.loadedConfig == null) {
                    System.out.println("[CommandRemover] Error, Configuration was corrupted, loaded default config!");
                    CommandRemover.getInstance.loadedConfig = new ConfigJSON();
                }
                return;
            }
        }
    }

    public String read(File f) {
        if (f.exists())
            try {
                BufferedReader r = new BufferedReader(new FileReader(f));
                StringBuilder t = new StringBuilder();
                String l;
                while ((l = r.readLine()) != null)
                    t.append(l);
                r.close();
                return t.toString();
            } catch (IOException iOException) {}
        return null;
    }

    public ConfigJSON deserialize(File file) {
        return (ConfigJSON)this.gson.fromJson(read(file), ConfigJSON.class);
    }

    public String serialize(ConfigJSON config) {
        return this.gson.toJson(config);
    }
}

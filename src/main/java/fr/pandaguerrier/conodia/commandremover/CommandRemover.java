package fr.pandaguerrier.conodia.commandremover;

import fr.pandaguerrier.conodia.commandremover.storage.ConfigStorage;

public class CommandRemover {
    public static CommandRemover getInstance;

    public ConfigJSON loadedConfig = null;

    public ConfigStorage configStorage;

    public void onCommandEnable() {
        getInstance = this;
        this.configStorage = new ConfigStorage();
        if (!this.configStorage.configExist())
            this.configStorage.saveDefaultConfig();
        this.configStorage.loadConfig();
    }
}

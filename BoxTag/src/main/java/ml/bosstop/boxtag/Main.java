package ml.bosstop.boxtag;

import ml.bosstop.boxtag.commands.Command;
import ml.bosstop.boxtag.events.Event;
import ml.bosstop.boxtag.util.Chat;
import ml.bosstop.boxtag.util.Storage;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    public Chat chat;
    public Storage storage;

    public static YamlConfiguration config;
    public Main() {}

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = YamlConfiguration.loadConfiguration(new File("plugins/" + this.getDataFolder().getName() + "/config.yml"));

        storage = new Storage(this);

        this.chat = new Chat();

        try {
            storage.enable();
            Command.enable(this);
            Event.enable(this);
        } finally {
            chat.console("&fStarting BoxTag");
            chat.console("&fBoxTag Active");
        }

        this.getConfig().options().copyDefaults();

    }


    @Override
    public void onDisable() {

        try {
            storage.disable();
        } finally {
            chat.console("&fBoxTag Disabled");
        }

    }

}

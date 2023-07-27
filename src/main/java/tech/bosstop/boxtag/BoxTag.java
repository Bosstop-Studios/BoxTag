package tech.bosstop.boxtag;

import org.bukkit.plugin.java.JavaPlugin;

import tech.bosstop.boxtag.utilities.Chat;

public class BoxTag extends JavaPlugin {

    private static BoxTag instance;

    private Chat chat;

    private String[] startup = {
        "                                                       ",
        "&b██████   ██████  ██   ██ ████████  █████   ██████  &r", 
        "&b██   ██ ██    ██  ██ ██     ██    ██   ██ ██       &r",
        "&b██████  ██    ██   ███      ██    ███████ ██   ███ &r",
        "&b██   ██ ██    ██  ██ ██     ██    ██   ██ ██    ██ &r",
        "&b██████   ██████  ██   ██    ██    ██   ██  ██████  &r",
        "                                                       ",
        "&aVersion: %version%                                 &r",
        "&aMaps: %maps%                                       &r",
    };

    @Override
    public void onEnable() {
        instance = this;
        this.chat = new Chat();

        for(String line : startup) {
            line = line.replace("%version%", this.getDescription().getVersion());
            line = line.replace("%maps%", "0");

            this.chat.console(line);
        }

        this.chat.console("&aPlugin enabled.");
    }

    @Override
    public void onDisable() {
        this.chat.console("&cPlugin disabled.");
    }

    public Chat getChat() {
        return chat;
    }

    public static BoxTag getInstance() {
        return instance;
    }
}

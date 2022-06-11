package ml.bosstop.boxtag.events;

import ml.bosstop.boxtag.Main;

public class Event {
    public static void enable(Main plugin) {
        new playerJoin(plugin);
        new InventoryEvents(plugin);

        //Storage.createNote(UUID.randomUUID());

        //WorldManager.copyFileStructure(new File("world/"), new File("plugins/" + plugin.getDataFolder().getName() + "/Worlds"));

        //WorldManager.createWorld(plugin,"Worlds");
    }
}

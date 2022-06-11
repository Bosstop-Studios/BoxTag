package ml.bosstop.boxtag.events;

import ml.bosstop.boxtag.Main;
import ml.bosstop.boxtag.gul.mapSelector;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvents implements Listener {

    private Main plugin;

    public InventoryEvents(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) { return; }
        if (e.getClickedInventory().getHolder() instanceof mapSelector) {
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null) { return; }
            if (e.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                plugin.chat.send(p, "You have selected the 'accept' button");
                p.closeInventory();
            }
            else if (e.getSlot() == 4) {
                plugin.chat.send(p, "Please make a selection...");
            }
            else if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                plugin.chat.send(p, "You have selected the 'deny' button");
                p.closeInventory();
            }
        }
    }
}

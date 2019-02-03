package net.acomputerdog.keepxp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin main class
 */
public class PluginKeepXP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((JavaPlugin)this);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent e) {
        // if player has permission to keep XP, then stop them from losing it
        if (e.getEntity().hasPermission("keepxp.keep")) {
            e.setDroppedExp(0);
            e.setKeepLevel(true);
        }
    }
}

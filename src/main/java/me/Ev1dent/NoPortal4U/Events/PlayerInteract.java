package me.Ev1dent.NoPortal4U.Events;

import me.Ev1dent.NoPortal4U.NPMain;
import me.Ev1dent.NoPortal4U.Utilities.Utils;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerInteract implements Listener {

    FileConfiguration Config = NPMain.plugin.getConfig();
    Utils Utils = new Utils();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;

        if (event.getHand() == EquipmentSlot.OFF_HAND) return;
        if (event.getClickedBlock().getType().equals(Material.END_PORTAL_FRAME)) {
            if (Config.getString("Enabled").equalsIgnoreCase("false")){
                event.getPlayer().sendMessage(Utils.Color("&cYou are not allowed to interact with that block"));
                event.setCancelled(true);
            }
        }
    }
}

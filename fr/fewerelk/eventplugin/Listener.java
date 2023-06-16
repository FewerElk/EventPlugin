package fr.fewerelk.eventplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;

public class Listener implements Listener {

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupEvent e) {
        Bukkit.getLogger().info("Player " + e.getPlayer() + " get an item")
    }
}
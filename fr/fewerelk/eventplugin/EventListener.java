package fr.fewerelk.eventplugin;

import org.bukkit.entity.Player;

import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerPickupItem(@SuppressWarnings("deprecation") PlayerPickupItemEvent e) {
        String cmd = "say un joueur a eu un item !";
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd);
        Bukkit.getLogger().info("Player " + e.getPlayer() + " get an item");
    }
}
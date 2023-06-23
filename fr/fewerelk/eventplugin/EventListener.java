package fr.fewerelk.eventplugin;

import org.bukkit.entity.Player;

import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerPickupItem(@SuppressWarnings("deprecation") PlayerPickupItemEvent e) {
        String cmd = "say un joueur a eu un item !";
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd);
        Bukkit.getLogger().info("Player " + e.getPlayer() + " get an item");
    }
    public string getCommand() {
        private String path = "plugins/EventPlugin/"
        File file = new File(path + "cmd.txt");
        if (file.exists()) {
            
        }
    }
}
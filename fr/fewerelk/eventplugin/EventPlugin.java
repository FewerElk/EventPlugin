package fr.fewerelk.eventplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class EventPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.BLUE + "EventPlugin from FewerElk enabled !");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning(ChatColor.RED + "EventPlugin disabled. See you soon !");
    }
}
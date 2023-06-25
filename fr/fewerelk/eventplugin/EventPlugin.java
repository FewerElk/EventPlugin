package fr.fewerelk.eventplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import fr.fewerelk.eventplugin.commands.*;

public class EventPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        if (Bukkit.getServer().getPluginManager().getPlugin("BedWars") == null) {
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
        	EventListener l = new EventListener();
        	Bukkit.getServer().getPluginManager().registerEvents(l, this);
        	getCommand("buycommand").setExecutor(new BuyCmd());
            Bukkit.getLogger().info(ChatColor.BLUE + "EventPlugin from FewerElk enabled !");
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning(ChatColor.RED + "EventPlugin disabled. See you soon !");
    }
}
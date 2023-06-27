package fr.fewerelk.eventplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

import fr.fewerelk.eventplugin.commands.*;

public class EventPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        Bukkit.getLogger().warning("---------- !!! READ ME !!! ----------");
        Bukkit.getLogger().warning("It is forbidden to earn money with");
        Bukkit.getLogger().warning("Minecraft. If this plugin is used");
        Bukkit.getLogger().warning("for this goal, it will not be updated.");
    	if (!setupEconomy()) {
            getLogger().severe("Economy plugin not supported.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getServer().getPluginManager().getPlugin("BedWars") == null) {
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
        	EventListener l = new EventListener();
        	Bukkit.getServer().getPluginManager().registerEvents(l, this);
        	getCommand("buycommand").setExecutor(new BuyCmd());
            Bukkit.getLogger().info(ChatColor.BLUE + "EventPlugin from FewerElk enabled !");
        }
    }
    
    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            Economy economy = economyProvider.getProvider();
            return (economy != null);
        } else {
            Economy economy = null;
            return (economy != null);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning(ChatColor.RED + "EventPlugin disabled. See you soon !");
    }
}
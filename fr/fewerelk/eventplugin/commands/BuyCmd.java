package fr.fewerelk.eventplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class BuyCmd implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			return true;
		} else {
			Bukkit.getLogger().warning(ChatColor.RED + "You have to be a player to perform this command !");
			return false;
		}
	}
}

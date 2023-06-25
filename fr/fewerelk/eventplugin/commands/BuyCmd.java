package fr.fewerelk.eventplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;


public class BuyCmd implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
			Economy economy = economyProvider.getProvider();
			double price = getPrice();
			if (transactionAllowed(price, sender)) {
				EconomyResponse response = economy.withdrawPlayer(Bukkit.getPlayer(sender.getName()), getPrice());
				if (response.transactionSuccess()) {
					addPlayerToCmd(Bukkit.getPlayer(sender.getName()));
					sender.sendMessage(ChatColor.GREEN + "Transaction success !");
				} else {
					sender.sendMessage(ChatColor.RED + "Something went wrong.");
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You do not have enough money !\nAction canceled.");
			}
			return true;
		} else {
			Bukkit.getLogger().warning(ChatColor.RED + "You have to be a player to perform this command !");
			return false;
		}
	}

	public boolean transactionAllowed(double price, CommandSender sender) {
		RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
		Economy economy = economyProvider.getProvider();
		Player player = Bukkit.getPlayer(sender.getName());
		double balance = economy.getBalance(player);
		if (balance >= price) {
			return true;
		} else {
			return false;
		}
	}

	public double getPrice() {
		String path = "plugins/EventPlugin/";
		File file = new File(path + "cmd.txt");
		try {
			Scanner scan = new Scanner(file);
			String cmd = scan.nextLine();	//unused
			cmd = cmd + "it is not used. :-)";
			double price = scan.nextDouble();
			scan.close();
			return price;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 99999;
		}
	}

	public void addPlayerToCmd(Player p) {
		String path = "plugins/EventPlugin/";
		File f = new File(path + "whobuy.txt");
		try {
			PrintStream out = new PrintStream(f);
			out.println(p.getName());
			out.close();
		} catch (FileNotFoundException e) {
			try {
				f.createNewFile();
				addPlayerToCmd(p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

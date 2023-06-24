package fr.fewerelk.eventplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.screamingsandals.bedwars.api.events.BedwarsItemBoughtEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onBuyItem(BedwarsItemBoughtEvent e) {
        String cmd = getCommand();
        cmd = PlaceHolderSystem.format(cmd, e.getCustomer().getDisplayName(), e.getItem(), e.getPrice());
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), cmd);
    }
    public String getCommand() {
        String path = "plugins/EventPlugin/";
        File file = new File(path + "cmd.txt");
        try {
			Scanner scan = new Scanner(file);
			String cmd = scan.nextLine();
			scan.close();
			return cmd;
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
				PrintStream out = new PrintStream(file);
				String cmd = "tellraw @a \"A player bought an item !\"";
				out.println(cmd);
				out.close();
				return cmd;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return "";
			}
		}
    }
}
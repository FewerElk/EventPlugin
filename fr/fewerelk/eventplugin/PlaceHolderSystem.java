package fr.fewerelk.eventplugin;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PlaceHolderSystem {
	public static String format(String base_string, String player, ItemStack itemstack, int price) {
        Map<String, Object> variables = new HashMap<>();
        if (player != "") {
        	variables.put("player", player);
        }
        if (itemstack != null) {
        	String item = getItemId(itemstack);
        	variables.put("item", item);
        }
        if (price != 0) {
        	variables.put("price", price);
        }

        String formattedString = formatString(base_string, variables);
        return formattedString;
    }

    public static String formatString(String format, Map<String, Object> variables) {
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            String placeholder = "%" + entry.getKey() + "%";
            format = format.replace(placeholder, entry.getValue().toString());
        }
        return format;
    }
    
    public static String getItemId(ItemStack itemStack) {
        Material material = itemStack.getType();
        return material.getKey().toString();
    }
}

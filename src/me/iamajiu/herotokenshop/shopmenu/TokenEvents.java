package me.iamajiu.herotokenshop.shopmenu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import me.iamajiu.herotokenshop.Main;
import net.md_5.bungee.api.ChatColor;

public class TokenEvents implements Listener {
	
	public String prefix = (ChatColor.GREEN + "TokenShop Test"); 
	
	@EventHandler
	public void InvenClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked(); 
		ClickType click = event.getClick(); 
		Inventory open = event.getClickedInventory(); 
		ItemStack cur_item = event.getCurrentItem(); 
		if (open.getName().equals(ChatColor.BLUE + "TokenShop")) {
			if (cur_item.equals(null)) {
				return; 
			}
		}
	}
}

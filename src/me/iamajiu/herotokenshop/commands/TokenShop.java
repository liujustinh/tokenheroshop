package me.iamajiu.herotokenshop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.iamajiu.herotokenshop.Main;

public class TokenShop extends AbstractCommand {

	public TokenShop(Main pl) {
		super("shop", "token.Default", false);
		playData = pl.getPlayerData(); 
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (args.length >= 1) {
			sender.sendMessage("You do not have permission.");
			return;
		}
		Player p_sender = (Player)sender; 
		Inventory inv = Bukkit.createInventory(null, 36, "Token Shop"); 
		
	}

}

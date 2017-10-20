package me.iamajiu.herotokenshop.commands;

import org.bukkit.command.CommandSender;

import me.iamajiu.herotokenshop.Main;


public class TokenCommand extends AbstractCommand {

	public TokenCommand(Main pl) {
		super("token", "token.Default", true); 
		playData = pl.getPlayerData(); 
	}
	
	@Override 
	public final void execute(final CommandSender sender, final String[] args) {
		sender.sendMessage("HeroTokenShop commands: ");
		sender.sendMessage("/give [playerName] [Amount]: Sends tokens to specified player.");
		sender.sendMessage("/balance: Shows your current token balance.");
		sender.sendMessage("/shop: Opens up the HeroTokenShop!");
	}
	
}

package me.iamajiu.herotokenshop.commands;

import org.bukkit.command.CommandSender;

import me.iamajiu.herotokenshop.Main;


public class TokenBalance extends AbstractCommand {
	
	public TokenBalance(Main pl) {
		super("balance", "token.Default", false); 
		playData = pl.getPlayerData();
	}

	@Override
	public final void execute(final CommandSender sender, final String[] args) {
		double sender_balance = playData.getBalance(sender); 
		String temp = "You have " + sender_balance + " tokens."; 
		sender.sendMessage(temp);
	}
	
}

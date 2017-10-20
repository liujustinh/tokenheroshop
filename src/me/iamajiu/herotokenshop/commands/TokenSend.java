package me.iamajiu.herotokenshop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.iamajiu.herotokenshop.Main;

public class TokenSend extends AbstractCommand {

	public TokenSend(Main pl) {
		super("send", "token.Admin", true);
		playData = pl.getPlayerData(); 
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("Incorrect usage. Correct usage: /send [playerName] [amount]");
			return;
		}
		Player receiver = Bukkit.getPlayerExact(args[0]); 
		if (!receiver.hasPlayedBefore() || receiver == null) {
			sender.sendMessage("This player doesn't exist. Correct usage: /send [playerName] [amount]");
			return; 
		}
		if (!isNumeric(args[1])) {
			sender.sendMessage("Please input integers. Correct usage: /send [playerName] [amount]");
			return;
	    }
		else {
			double amount = Double.parseDouble(args[1]); 
			if (amount < 0) {
				sender.sendMessage("Please enter a positive number. Correct usage: /send [playerName] [amount]");
				return;
			}
			else {
				playData.sendTokens(sender, receiver, amount);
			}
		}
	
}

public boolean isNumeric(String str) {  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	}
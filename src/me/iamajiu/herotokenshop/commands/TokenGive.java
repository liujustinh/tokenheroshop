package me.iamajiu.herotokenshop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.iamajiu.herotokenshop.Main;

public class TokenGive extends AbstractCommand {
	
	public TokenGive(Main pl) {
		super("give", "token.Default", false);
		playData = pl.getPlayerData(); 
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("Incorrect usage. Correct usage: /give [playerName] [amount]");
			return;
		}
		Player receiver = Bukkit.getPlayerExact(args[0]); 
		if (!receiver.hasPlayedBefore() || receiver == null) {
			sender.sendMessage("Player doesn't exist! Correct usage: /give [playerName] [amount]");
			return; 
		}
		if (!isNumeric(args[1])) {
			sender.sendMessage("Specify the amount in integers. Correct usage: /give [playerName] [amount]");
			return;
		}
		else {
			double amount = Double.parseDouble(args[1]);
			if (amount > 0) {
				playData.giveTokens(sender, receiver, amount);
				return;
			}
			else {
				sender.sendMessage("Enter a positive value. Correct usage: /give [playerName] [amount]");
				return;
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
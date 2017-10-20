package me.iamajiu.herotokenshop;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerData extends AbstractConfig{
	public PlayerData(Main main) {
		super(main, "playerdata.yml");
	}
	
	public void newPlayer(Player player) {
		double temp = 0.0;
		if (config.contains(player.getUniqueId().toString())) {
			save();
			return; 
		}
		else {
			config.set(player.getUniqueId().toString(), temp); 
			save();
			return; 
		}
	}
	
	public double getBalance(CommandSender sender) {
		Player p = (Player)sender; 
		double sender_balance = (double) config.get(p.getUniqueId().toString());
		return sender_balance; 
	}
	
	public void giveTokens(CommandSender sender, Player receiver, double amount) {
		double final_receiver_balance, final_sender_balance;
		Player p_sender = (Player)sender;
		double sender_balance = (double) config.get(p_sender.getUniqueId().toString()); 
		double receiver_balance = (double) config.get(receiver.getUniqueId().toString()); 
		if (amount > sender_balance) {
			sender.sendMessage("You do not have enough tokens.");
			return;
		}
		else {
			final_sender_balance = sender_balance - amount; 
			final_receiver_balance = receiver_balance + amount; 
			config.set(p_sender.getUniqueId().toString(), final_sender_balance);
			config.set(receiver.getUniqueId().toString(), final_receiver_balance);
			String sender_message_1 = "You sent " + amount + " tokens to " + receiver.getName().toString(); 
			sender.sendMessage(sender_message_1);
			String sender_message_2 = "Your current balance: " + final_sender_balance; 
			sender.sendMessage(sender_message_2);
			String receiver_message_1 = "You received " + amount + " tokens from " + sender.getName(); 
			receiver.sendMessage(receiver_message_1);
			String receiver_message_2 = "Your current balance: " + final_receiver_balance; 
			receiver.sendMessage(receiver_message_2);
			save();
			return;
		}
	}
	
	public void sendTokens(CommandSender sender, Player receiver, double amount) {
		double final_receiver_balance = (double) config.get(receiver.getUniqueId().toString()) + amount; 
		config.set(receiver.getUniqueId().toString(), final_receiver_balance); 
		sender.sendMessage("You sent " + amount + " tokens to " + receiver.getName());
		receiver.sendMessage("You received " + amount + " tokens! Your current balance: " + final_receiver_balance);
		save(); 
		return;
	}
	
}

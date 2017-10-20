package me.iamajiu.herotokenshop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.iamajiu.herotokenshop.Main;
import me.iamajiu.herotokenshop.PlayerData;


public abstract class AbstractCommand implements CommandExecutor{
	private final String commandName; 
	private final String permission;
	private final boolean canConsoleUse; 
	protected PlayerData playData; 
	
	
	public AbstractCommand(String commandName, String permission, boolean canConsoleUse) {
		this.commandName = commandName; 
		this.permission = permission; 
		this.canConsoleUse = canConsoleUse; 
		plugin.getCommand(commandName).setExecutor(this);
	}
	
	public abstract void execute(CommandSender sender, String[] args); 
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!cmd.getLabel().equalsIgnoreCase(commandName)) {
			return true;
		}
		if (!sender.hasPermission(permission)) {
			sender.sendMessage("You don't have permission!");
			return true;
		}
		if (!(sender instanceof Player) && !canConsoleUse) {
			sender.sendMessage("Only players can use this command!");
			return true; 
		}
		execute(sender, args);
		return true;
	}
	
	public static JavaPlugin plugin;

	public final static void registerCommands(Main pl) {
		plugin = pl; 
		new TokenCommand(pl); 
		new TokenBalance(pl);
		new TokenGive(pl); 
		new TokenSend(pl);
		new TokenShop(pl);
	}
	

}

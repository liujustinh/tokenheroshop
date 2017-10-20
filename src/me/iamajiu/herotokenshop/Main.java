package me.iamajiu.herotokenshop;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.iamajiu.herotokenshop.PlayerData;
import me.iamajiu.herotokenshop.commands.AbstractCommand;

public class Main extends JavaPlugin implements Listener {
	
	private PlayerData playData; 
	private ShopData shopData; 
	
    @Override
    public void onEnable() {
       getLogger().info("Loading player data and config file...");
       if (!getDataFolder().exists()) {
    	   getDataFolder().mkdirs(); 
       }
       Bukkit.getPluginManager().registerEvents(this, this);
       this.playData = new PlayerData(this); 
       this.shopData = new ShopData(this); 
       
       AbstractCommand.registerCommands(this); 
    }
   
    @Override
    public void onDisable() {
       playData.save(); 
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
    	playData.newPlayer(e.getPlayer()); 
    }
    
    public PlayerData getPlayerData() {
    	return this.playData; 
    }
}

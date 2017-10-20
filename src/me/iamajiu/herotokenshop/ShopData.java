package me.iamajiu.herotokenshop;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class ShopData extends AbstractConfig {
	
	private ArrayList<ItemStack> storage; 

	public ShopData(Main main) {
		super(main, "shopdata.yml");
	}

	
}

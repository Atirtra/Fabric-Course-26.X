package net.atirta.mccourse;

import net.atirta.mccourse.block.ModBlocks;
import net.atirta.mccourse.item.ModCreativeModeTabs;
import net.atirta.mccourse.item.ModItems;
import net.atirta.mccourse.registries.ModFuels;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// An extremely important comment
public class MCCourse implements ModInitializer {
	public static final String MOD_ID = "mccourse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerCreativeModeTabs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFuels.registerModFuels();
	}
}
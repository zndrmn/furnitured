package net.zndrmn.furnitured;

import net.fabricmc.api.ModInitializer;
import net.zndrmn.furnitured.block.Blocks;
import net.zndrmn.furnitured.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Furnitured implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MOD_ID = "furnitured";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        Items.registerItems();
        Blocks.registerBlocks();

    }
}

package net.zndrmn.furnitured;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zndrmn.furnitured.block.Blockz;
import net.zndrmn.furnitured.item.Itemz;
import net.zndrmn.furnitured.registry.Blocks;
import net.zndrmn.furnitured.registry.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Furnitured implements ModInitializer {

    public static final String MOD_ID = "furnitured";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Remove \/ \/ \/
        // After Refactoring
        //
        Itemz.registerItems();
        Blockz.registerBlocks();

        Items.registerItems();
        Blocks.registerBlocks();


    }
}

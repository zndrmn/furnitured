package net.zndrmn.furnitured.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zndrmn.furnitured.Furnitured;
import net.zndrmn.furnitured.block.properties.CounterBlock;
import net.zndrmn.furnitured.block.properties.TestCounterShape;

public class Blocks {

    public  static final Block COUNTER = registerBlock("counter",
            new CounterBlock(
                    FabricBlockSettings
                    .of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .hardness(2)
                    .resistance(2)
                    .requiresTool()), ItemGroup.MISC);

    public  static final Block TESTCOUNTER = registerBlock("testcounter",
            new TestCounterShape(Blocks.COUNTER.getDefaultState(),
                    FabricBlockSettings
                    .of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .hardness(2)
                    .resistance(2)
                    .requiresTool()), ItemGroup.MISC);

    // furnitured block/item registry
    //
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Furnitured.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Furnitured.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    // furnitured registry logger
    //
    public static void registerBlocks() {

        Furnitured.LOGGER.info("Registering " + Furnitured.MOD_ID + " Blocks");

    }

}

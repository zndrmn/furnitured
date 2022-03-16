package net.zndrmn.furnitured.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zndrmn.furnitured.Furnitured;
import net.zndrmn.furnitured.properties.BlockProperties;
import net.zndrmn.furnitured.properties.block.CounterBlock;

public class Blocks {

    public  static final Block COUNTER = registerBlock("counter", new CounterBlock(BlockProperties.COUNTER), IItemGroup.FURNITURED);



    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Furnitured.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Furnitured.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerBlocks() {}

}

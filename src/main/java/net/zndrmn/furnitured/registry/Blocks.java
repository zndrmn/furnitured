package net.zndrmn.furnitured.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.zndrmn.furnitured.Furnitured;
import net.zndrmn.furnitured.properties.BlockProperties;
import net.zndrmn.furnitured.properties.block.StraightCounterBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Blocks {

    public  static final Block STRAIGHT_COUNTER = registerBlock("straight_counter", new StraightCounterBlock(BlockProperties.TEMPLATE_COUNTER), IItemGroup.FURNITURED, "tooltip.furnitured.straight_counter");



    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(Furnitured.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(Furnitured.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }

    public static void registerBlocks() {}

}

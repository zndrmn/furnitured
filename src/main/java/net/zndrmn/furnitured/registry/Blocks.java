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
import net.zndrmn.furnitured.properties.block.InnerKitchenCounterBlock;
import net.zndrmn.furnitured.properties.block.OuterKitchenCounterBlock;
import net.zndrmn.furnitured.properties.block.StraightKitchenCounterBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Blocks {

    public  static final Block STRAIGHT_KITCHEN_COUNTER = registerBlock("straight_kitchen_counter", new StraightKitchenCounterBlock(BlockProperties.TEMPLATE_KITCHEN_COUNTER), IItemGroup.FURNITURED, "tooltip.furnitured.straight_kitchen_counter");
    public  static final Block INNER_KITCHEN_COUNTER = registerBlock("inner_kitchen_counter", new InnerKitchenCounterBlock(BlockProperties.TEMPLATE_KITCHEN_COUNTER), IItemGroup.FURNITURED, "tooltip.furnitured.inner_kitchen_counter");
    public  static final Block OUTER_KITCHEN_COUNTER = registerBlock("outer_kitchen_counter", new OuterKitchenCounterBlock(BlockProperties.TEMPLATE_KITCHEN_COUNTER), IItemGroup.FURNITURED, "tooltip.furnitured.outer_kitchen_counter");


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

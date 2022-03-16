package net.zndrmn.furnitured.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.zndrmn.furnitured.Furnitured;

public class IItemGroup {

    public static final ItemGroup FURNITURED = FabricItemGroupBuilder.build(new Identifier(Furnitured.MOD_ID, "furnitured"), () -> new ItemStack(Items.NAILS));

}

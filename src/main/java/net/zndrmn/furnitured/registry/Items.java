package net.zndrmn.furnitured.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zndrmn.furnitured.Furnitured;

public class Items {

    public static final Item NAILS = registerItem("nails", new Item(new FabricItemSettings().group(ItemGroup.MISC)));



    private static Item registerItem(String name, Item item) {
        // Furnitured
        // Item Registry
        return Registry.register(Registry.ITEM, new Identifier(Furnitured.MOD_ID, name), item);
    }

    public static void registerItems() {}

}

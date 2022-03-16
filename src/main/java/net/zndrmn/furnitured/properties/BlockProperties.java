package net.zndrmn.furnitured.properties;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlockProperties {

    public static final FabricBlockSettings COUNTER = FabricBlockSettings
            .of(Material.WOOD)
            .sounds(BlockSoundGroup.WOOD)
            .hardness(2)
            .resistance(2)
            .requiresTool();

}

package net.atirta.mccourse.item;

import net.atirta.mccourse.MCCourse;
import net.atirta.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static final CreativeModeTab BISMUTH_ITEMS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MCCourse.MOD_ID, "bismuth_items"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH))
                    .title(Component.translatable("creativetab.mccourse.bismuth_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.CAULIFLOWER);
                        output.accept(ModItems.CHEVON);
                        output.accept(ModItems.COOKED_CHEVON);
                        output.accept(ModItems.STARLIGHT_ASHES);


                    }).build());

    public static final CreativeModeTab BISMUTH_BLOCKS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(MCCourse.MOD_ID, "bismuth_blocks"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .title(Component.translatable("creativetab.mccourse.bismuth_blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.RAW_BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BISMUTH_NETHER_ORE);
                        output.accept(ModBlocks.BISMUTH_END_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);


                    }).build());



    public static void registerCreativeModeTabs() {
        MCCourse.LOGGER.info("Registering Creative Mode tabs for " + MCCourse.MOD_ID);
    }
}

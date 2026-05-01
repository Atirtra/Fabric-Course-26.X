package net.atirta.mccourse.item;

import net.atirta.mccourse.MCCourse;
import net.atirta.mccourse.food.ModFoodProperties;
import net.atirta.mccourse.item.custom.ChiselItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static final Item BISMUTH = registerItem("bismuth", Item::new);
    public static final Item RAW_BISMUTH = registerItem("raw_bismuth", Item::new);

    public static final Item CHISEL = registerItem("chisel", properties -> new ChiselItem(properties.durability(32)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", properties -> new Item(properties.food(ModFoodProperties.CAULIFLOWER,
            ModFoodProperties.CAULIFLOWER_EFFECT)) {
        @Override
        public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
            builder.accept(Component.translatable("tooltip.mccourse.cauliflower"));
            super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
        }
    });
    public static final Item CHEVON = registerItem("chevon",
            properties -> new Item(properties.food(ModFoodProperties.CHEVON)));
    public static final Item COOKED_CHEVON = registerItem("cooked_chevon",
            properties -> new Item(properties.food(ModFoodProperties.COOKED_CHEVON)));


    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", Item::new);


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MCCourse.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MCCourse.MOD_ID, name)))));
    }


    public static void registerModItems() {
        MCCourse.LOGGER.info("Registering Mod Items for " + MCCourse.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(BISMUTH);
            output.accept(RAW_BISMUTH);
        });
    }
}






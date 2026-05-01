package net.atirta.mccourse.registries;

import net.atirta.mccourse.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelValueEvents;

public class ModFuels {
    public static void registerModFuels() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.STARLIGHT_ASHES, 800);
        });
    }
}

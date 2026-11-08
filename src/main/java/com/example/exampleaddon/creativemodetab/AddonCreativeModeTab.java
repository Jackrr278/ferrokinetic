package com.example.exampleaddon.creativemodetab;

import com.example.exampleaddon.ExampleAddon;
import com.example.exampleaddon.item.AddonItems;
import com.fodk.gemcolony.GemColony;
import com.fodk.gemcolony.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AddonCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleAddon.MOD_ID);

    public static final Supplier<CreativeModeTab> EXAMPLE_ADDON_TAB = CREATIVE_MODE_TABS.register("example_addon_tab",
            () -> CreativeModeTab.builder()

                    //set the tab icon to an item
                    .icon(() -> new ItemStack(AddonItems.THORIUM_GEM.get()))
                    .title(Component.translatable("creativetab.exampleaddon.example_addon_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //output.accept(item) to add more items to your creative tab
                        output.accept(AddonItems.THORIUM_GEM);

                        output.accept(AddonItems.EXAMPLE1_QUARTZ_GEM);
                        output.accept(AddonItems.EXAMPLE2_QUARTZ_GEM);

                        output.accept(AddonItems.NEON_URANIUM_GEM);
                        output.accept(AddonItems.MOSS_URANIUM_GEM);
                        output.accept(AddonItems.VIRIDIAN_URANIUM_GEM);
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

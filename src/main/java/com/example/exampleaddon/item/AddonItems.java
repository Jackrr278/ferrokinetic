package com.example.exampleaddon.item;

import com.example.exampleaddon.ExampleAddon;
import com.example.exampleaddon.entity.AddonEntities;
import com.fodk.gemcolony.entity.ModEntities;
import com.fodk.gemcolony.item.custom.GemItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AddonItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleAddon.MOD_ID);

    //thorium_gem is the id for the registered item, Name = Thorium is needed for display and entity name
    public static final DeferredItem<Item> THORIUM_GEM = ITEMS.registerItem("thorium_gem",
            properties -> new GemItem(properties, "Thorium", AddonEntities.THORIUM.get()));

    public static final DeferredItem<Item> EXAMPLE1_QUARTZ_GEM = ITEMS.registerItem("example1_quartz_gem",
            properties -> new GemItem(properties, "Example1 Quartz", ModEntities.QUARTZ.get(), Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "example1_quartz")));
    public static final DeferredItem<Item> EXAMPLE2_QUARTZ_GEM = ITEMS.registerItem("example2_quartz_gem",
            properties -> new GemItem(properties, "Example2 Quartz", ModEntities.QUARTZ.get(), Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "example2_quartz")));

    //neon_uranium_gem is the id for the registered item, Name = Neon Uranium is needed for display and entity name, and neon_uranium is variant id
    public static final DeferredItem<Item> NEON_URANIUM_GEM = ITEMS.registerItem("neon_uranium_gem",
            properties -> new GemItem(properties, "Neon Uranium", AddonEntities.URANIUM.get(), Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "neon_uranium")));
    public static final DeferredItem<Item> MOSS_URANIUM_GEM = ITEMS.registerItem("moss_uranium_gem",
            properties -> new GemItem(properties, "Moss Uranium", AddonEntities.URANIUM.get(), Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "moss_uranium")));
    public static final DeferredItem<Item> VIRIDIAN_URANIUM_GEM = ITEMS.registerItem("viridian_uranium_gem",
            properties -> new GemItem(properties, "Viridian Uranium", AddonEntities.URANIUM.get(), Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "viridian_uranium")));

    //get resource key for item tags
    public static ResourceKey<Item> getRK(DeferredItem deferredItem){
        return BuiltInRegistries.ITEM.getResourceKey(deferredItem.asItem()).get();
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

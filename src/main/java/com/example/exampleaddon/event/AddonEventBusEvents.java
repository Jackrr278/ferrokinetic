package com.example.exampleaddon.event;

import com.example.exampleaddon.ExampleAddon;
import com.example.exampleaddon.entity.AddonEntities;
import com.example.exampleaddon.entity.gem.ThoriumEntity;
import com.example.exampleaddon.entity.gem.UraniumEntity;
import com.example.exampleaddon.entity.gem.variant.AddonQuartzVariants;
import com.example.exampleaddon.entity.gem.variant.UraniumVariants;
import com.example.exampleaddon.item.AddonItems;
import com.fodk.gemcolony.entity.custom.gem.variant.QuartzVariants;
import com.fodk.gemcolony.event.RegisterGemDefinitionsEvent;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import java.util.List;

@EventBusSubscriber(modid = ExampleAddon.MOD_ID)
public class AddonEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        //creating thorium's attributes such as HP / DMG / Speed / Attack speed
        event.put(AddonEntities.THORIUM.get(), ThoriumEntity.createAttributes().build());
        event.put(AddonEntities.URANIUM.get(), UraniumEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerGems(RegisterGemDefinitionsEvent event) {

        // adding Thorium to gem definitions, thorium is the Id, Thorium is the display name, THORIUM_GEM is the gem item, THORIUM is the entity
        // the values are conditions for gem injection :
        // Optimal temperature = 0.8, Optimal humidity = 1.2
        // The sigma values are tolerance for the optimal values : the smaller it is the more accurate the condition needs to be to get that gem
        // the higher it is the more forgiving a gem is
        // the last value is weight = 1, thats the rarity : so if 2 gems share the same cold/dry biomes, the one with higher weight is more likely
        event.RegisterGemDefinitionAndConditions(
                Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "thorium"),
                "Thorium",
                List.of(AddonItems.THORIUM_GEM.get()),
                AddonEntities.THORIUM.get(),
                1f, 1.4f, 0.3f, 0.3f, 1.0f
        );


        // if you want to define a gem but not make it injectable use this version (remove the environemental conditions):
        /*event.RegisterGemDefinition(
                Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "thorium"),
                "Thorium",
                List.of(AddonItems.THORIUM_GEM.get()),
                AddonEntities.THORIUM.get()
        );*/

        //register a varying gem in the same way but add all the gemstones
        event.RegisterGemDefinitionAndConditions(
                Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "uranium"),
                "Uranium",
                List.of(AddonItems.NEON_URANIUM_GEM.get(),
                        AddonItems.MOSS_URANIUM_GEM.get(),
                        AddonItems.VIRIDIAN_URANIUM_GEM.get()),
                AddonEntities.URANIUM.get(),
                1.8f, 1f, 0.3f, 0.3f, 1.0f
        );


        //register extra quartz variants
        AddonQuartzVariants.registerVariants();

        //register uranium gem variants
        UraniumVariants.registerVariants();
    }
}

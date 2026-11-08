package com.example.exampleaddon.entity.gem.variant;

import com.example.exampleaddon.ExampleAddon;
import com.example.exampleaddon.item.AddonItems;
import com.fodk.gemcolony.GemColony;
import com.fodk.gemcolony.entity.ModEntities;
import com.fodk.gemcolony.entity.custom.gem.variant.GemVariant;
import com.fodk.gemcolony.entity.custom.gem.variant.GemVariantData;
import com.fodk.gemcolony.entity.custom.gem.variant.GemVariantRegistry;
import com.fodk.gemcolony.item.ModItems;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

import java.awt.*;

// A CLASS TO ADD NEW VARIANTS TO THE ALREADY EXISTING QUARTZ
public enum AddonQuartzVariants implements GemVariant {
    //the color values are just like the constructor order :
    //Color darkSkin,
    //Color lightSkin,
    //Color darkOutfit,
    //Color lightOutfit,
    //Color darkInsignia,
    //Color lightInsignia,
    //Color darkHair,
    //Color lightHair,
    //Color darkVisor,
    //Color lightVisor,
    //String name to display, only the variant name not the family name for example only Rose, dont do Rose Quartz
    //Item gemItem the gem item which spawns it
    //Item chromaItem chroma that determines from what color this gem can emerge

    EXAMPLE1(new Color(218, 218, 218),
            new Color(240, 240, 240),
            new Color(255, 41, 41),
            new Color(253, 88, 88),
            new Color(14, 14, 221),
            new Color(58, 58, 253),
            new Color(194, 199, 218),
            new Color(238, 241, 255),
            new Color(199, 201, 205),
            new Color(255, 255, 255),
            "Example1", AddonItems.EXAMPLE1_QUARTZ_GEM.get(), ModItems.WHITE_CHROMA.get()),
    EXAMPLE2(new Color(35, 35, 35),
            new Color(62, 62, 62),
            new Color(255, 41, 41),
            new Color(253, 88, 88),
            new Color(14, 14, 221),
            new Color(58, 58, 253),
            new Color(194, 199, 218),
            new Color(238, 241, 255),
            new Color(199, 201, 205),
            new Color(255, 255, 255),
            "Example2", AddonItems.EXAMPLE2_QUARTZ_GEM.get(), ModItems.BLACK_CHROMA.get());

    private final GemVariantData data;
    public GemVariantData getData() {
        return data;
    }

    AddonQuartzVariants(
            Color darkSkin,
            Color lightSkin,
            Color darkOutfit,
            Color lightOutfit,
            Color darkInsignia,
            Color lightInsignia,
            Color darkHair,
            Color lightHair,
            Color darkVisor,
            Color lightVisor,
            String name,
            Item gemItem,
            Item chromaItem
    ) {
        this.data = new GemVariantData(
                darkSkin,
                lightSkin,
                darkOutfit,
                lightOutfit,
                darkInsignia,
                lightInsignia,
                darkHair,
                lightHair,
                darkVisor,
                lightVisor,
                name,
                gemItem,
                chromaItem
        );
    }

    public static void registerVariants() {
        //here I add 2 examples
        //register variants here, example_quartz is the id, the variant is for QUARTZ entity from main mod, and the data is from the EXAMPLE value
        //make sure to keep using  your ExampleAddon namespace with your mod Id, so if two addons add same gem it wont conflict
        GemVariantRegistry.register(Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "example1_quartz"), ModEntities.QUARTZ.get(), EXAMPLE1.getData());
        GemVariantRegistry.register(Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "example2_quartz"), ModEntities.QUARTZ.get(), EXAMPLE2.getData());
    }
}

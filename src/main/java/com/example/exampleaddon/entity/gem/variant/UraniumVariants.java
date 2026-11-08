package com.example.exampleaddon.entity.gem.variant;

import com.example.exampleaddon.ExampleAddon;
import com.example.exampleaddon.entity.AddonEntities;
import com.example.exampleaddon.item.AddonItems;
import com.fodk.gemcolony.entity.ModEntities;
import com.fodk.gemcolony.entity.custom.gem.variant.GemVariant;
import com.fodk.gemcolony.entity.custom.gem.variant.GemVariantData;
import com.fodk.gemcolony.entity.custom.gem.variant.GemVariantRegistry;
import com.fodk.gemcolony.item.ModItems;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

import java.awt.*;

// A CLASS TO ADD VARIANTS TO A NEW GEM CALLED URANIUM
public enum UraniumVariants implements GemVariant {
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

    NEON(new Color(178, 230, 36),
            new Color(217, 255, 86),
            new Color(45, 85, 15),
            new Color(85, 125, 25),
            new Color(190, 155, 25),
            new Color(245, 220, 95),
            new Color(224, 253, 116),
            new Color(233, 255, 161),
            new Color(145, 175, 65),
            new Color(205, 230, 115),
            "Neon", AddonItems.NEON_URANIUM_GEM.get(), ModItems.LIME_CHROMA.get()),
    MOSS(new Color(28, 140, 43),
            new Color(61, 200, 79),
            new Color(40, 75, 35),
            new Color(75, 110, 55),
            new Color(165, 145, 35),
            new Color(220, 195, 85),
            new Color(195, 205, 175),
            new Color(245, 250, 225),
            new Color(105, 145, 75),
            new Color(165, 200, 125),
            "Moss", AddonItems.MOSS_URANIUM_GEM.get(), ModItems.GREEN_CHROMA.get()),
    VIRIDIAN(
            new Color(45, 125, 115),
            new Color(100, 190, 175),
            new Color(20, 65, 65),
            new Color(35, 105, 100),
            new Color(175, 155, 45),
            new Color(230, 210, 100),
            new Color(157, 255, 231),
            new Color(200, 255, 236),
            new Color(55, 145, 140),
            new Color(120, 210, 195),
            "Viridian", AddonItems.VIRIDIAN_URANIUM_GEM.get(), ModItems.CYAN_CHROMA.get());

    private final GemVariantData data;
    public GemVariantData getData() {
        return data;
    }

    UraniumVariants(
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
        //register variants here, neon_uranium is the id, the variant is for URANIUM entity from the addon, and the data is from the NEON values
        //make sure to keep using  your ExampleAddon namespace with your mod Id, so if two addons add same gem it wont conflict
        GemVariantRegistry.register(Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "neon_uranium"), AddonEntities.URANIUM.get(), NEON.getData());
        GemVariantRegistry.register(Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "moss_uranium"), AddonEntities.URANIUM.get(), MOSS.getData());
        GemVariantRegistry.register(Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, "viridian_uranium"), AddonEntities.URANIUM.get(), VIRIDIAN.getData());
    }
}

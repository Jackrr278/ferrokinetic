package com.example.exampleaddon.entity;

import com.example.exampleaddon.ExampleAddon;
import com.example.exampleaddon.entity.gem.ThoriumEntity;
import com.example.exampleaddon.entity.gem.UraniumEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class AddonEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ExampleAddon.MOD_ID);

    //thorium is the id of the entity, Mob category is Creature and it's immune to fire and freezing
    public static final Supplier<EntityType<ThoriumEntity>> THORIUM = ENTITY_TYPES.register("thorium",
            () -> EntityType.Builder.of(ThoriumEntity::new, MobCategory.CREATURE)
                    .sized(0.6f,1.85f)
                    .fireImmune()
                    .immuneTo(BlockTags.STRAY_IMMUNE_TO)
                    .build(getRK("thorium")));

    //uranium is the id of the entity, Mob category is Creature and it's immune to fire and freezing
    public static final Supplier<EntityType<UraniumEntity>> URANIUM = ENTITY_TYPES.register("uranium",
            () -> EntityType.Builder.of(UraniumEntity::new, MobCategory.CREATURE)
                    .sized(0.6f,1.85f)
                    .fireImmune()
                    .immuneTo(BlockTags.STRAY_IMMUNE_TO)
                    .build(getRK("uranium")));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

    public static ResourceKey<EntityType<?>> getRK(String path){
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ExampleAddon.MOD_ID, path));
    }
}

package com.example.exampleaddon.entity.gem;

import com.example.exampleaddon.item.AddonItems;
import com.fodk.gemcolony.entity.custom.gem.ability.GemAbility;
import com.fodk.gemcolony.entity.custom.gem.base.GemEntity;
import com.fodk.gemcolony.entity.custom.gem.placement.GemPlacement;
import com.fodk.gemcolony.entity.custom.gem.quartz.QuartzFamilyEntity;
import com.fodk.gemcolony.entity.custom.gem.variant.VariantGemEntity;
import com.fodk.gemcolony.util.ColorUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import java.awt.*;

//A VARYING GEM SHOULD EXTEND VariantGemEntity
public class UraniumEntity extends VariantGemEntity {

    public UraniumEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    // ONLY MODIFY THE ATTRIBUTES HERE
    private static final double MAX_HEALTH = 80D;
    private static final double MOVEMENT_SPEED = 0.28D;
    private static final double ATTACK_DAMAGE = 6.0D;
    private static final double ATTACK_SPEED = 1.4D;

    public static AttributeSupplier.Builder createAttributes(){
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, MAX_HEALTH)
                .add(Attributes.MOVEMENT_SPEED, MOVEMENT_SPEED)
                .add(Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE)
                .add(Attributes.ATTACK_SPEED, ATTACK_SPEED);
    }

    @Override
    public double getBaseMaxHealth() {
        return MAX_HEALTH;
    }
    @Override
    public double getBaseAttackDamage() {
        return ATTACK_DAMAGE;
    }
    @Override
    public double getBaseMovementSpeed() {
        return MOVEMENT_SPEED;
    }
    @Override
    public double getBaseAttackSpeed() {
        return ATTACK_SPEED;
    }

    @Override
    public int getMaxOutfits() {
        return 2;
    }

    @Override
    public int getMaxInsignias() {
        return 2;
    }

    @Override
    public int getMaxHairstyles() {
        return 2;
    }

    @Override
    public int getMaxMarkings() {
        return 0;
    }

    @Override
    public int getMaxVisors() {
        return 1;
    }

    @Override
    protected int getInventorySize() {
        float qualityModifier = entityData.get(QUALITY) == 0 ? 0.5f : entityData.get(QUALITY) == 2 ? 1.5f : 1f;
        return (int) (20 * qualityModifier);
    }

    //1 MIN
    @Override
    public int getReformTime(){
        float modifier = entityData.get(QUALITY) == 0 ? 0.9f : entityData.get(QUALITY) == 1 ? 1f : 1.1f;
        return (int)(1200f * modifier);
    }

    // the family name in this case the variants are for : Uranium
    @Override
    public String getNameWithoutVariant() {
        return "Uranium";
    }

    @Override
    protected void initializeAbilities() {
        addAbility(GemAbility.ELECTROKINESIS);
    }

    @Override
    public float getBaseModelSize() {
        return 1.45f;
    }
}

package com.example.exampleaddon.entity.gem;

import com.example.exampleaddon.item.AddonItems;
import com.fodk.gemcolony.entity.custom.gem.ability.GemAbility;
import com.fodk.gemcolony.entity.custom.gem.base.GemEntity;
import com.fodk.gemcolony.util.ColorUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import java.awt.*;

//A GEM SHOULD EXTEND GemEntity
public class ThoriumEntity extends GemEntity {

    private static final Color darkSkin = new Color(174, 9, 124);
    private static final Color lightSkin = new Color(251, 24, 185);
    private static final Color darkOutfit = new Color(38, 92, 84);
    private static final Color lightOutfit = new Color(22, 156, 24);
    private static final Color darkInsignia = new Color(126, 147, 35);
    private static final Color lightInsignia = new Color(221, 197, 79);
    private static final Color darkHair = new Color(159, 107, 197);
    private static final Color lightHair = new Color(230, 195, 255);
    private static final Color darkVisor = new Color(170, 79, 239);
    private static final Color lightVisor = new Color(202, 132, 255);

    public ThoriumEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    // ONLY MODIFY THE ATTRIBUTES HERE
    private static final double MAX_HEALTH = 40D;
    private static final double MOVEMENT_SPEED = 0.26D;
    private static final double ATTACK_DAMAGE = 0.0D;
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
    public Item getGemItem() {
        return AddonItems.THORIUM_GEM.get();
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
    public Color generateGemColor() {
        return ColorUtil.lerpColor(lightSkin, darkSkin, random.nextFloat());
    }

    @Override
    public Color generateOutfitColor() {
        return ColorUtil.lerpColor(lightOutfit, darkOutfit, random.nextFloat());
    }

    @Override
    public Color generateInsigniaColor() {
        return ColorUtil.lerpColor(lightInsignia, darkInsignia, random.nextFloat());
    }

    @Override
    public Color generateHairColor() {
        return ColorUtil.lerpColor(lightHair, darkHair, random.nextFloat());
    }

    @Override
    public Color generateMarkingsColor() {
        return Color.black;
    }

    @Override
    public Color generateVisorColor() {
        return ColorUtil.lerpColor(lightVisor, darkVisor, random.nextFloat());
    }

    @Override
    protected int getInventorySize() {
        float qualityModifier = entityData.get(QUALITY) == 0 ? 0.5f : entityData.get(QUALITY) == 2 ? 1.5f : 1f;
        return (int) (30 * qualityModifier);
    }

    //3 MIN
    @Override
    public int getReformTime(){
        float modifier = entityData.get(QUALITY) == 0 ? 0.9f : entityData.get(QUALITY) == 1 ? 1f : 1.1f;
        return (int)(3600f * modifier);
    }

    @Override
    public String getGemTypeName() {
        return "Thorium";
    }

    @Override
    protected void initializeAbilities() {
        addAbility(GemAbility.ELECTROKINESIS);
    }

    @Override
    public float getBaseModelSize() {
        return 1.2f;
    }
}

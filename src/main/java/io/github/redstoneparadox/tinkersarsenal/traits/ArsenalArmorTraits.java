package io.github.redstoneparadox.tinkersarsenal.traits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import io.github.redstoneparadox.tinkersarsenal.traits.armortraits.ArmorTraitAntiCorrosive;
import io.github.redstoneparadox.tinkersarsenal.traits.armortraits.ArmorTraitFireResistance;
import io.github.redstoneparadox.tinkersarsenal.traits.armortraits.ArmorTraitResilience;
import io.github.redstoneparadox.tinkersarsenal.traits.armortraits.ArmorTraitRigidity;
import slimeknights.tconstruct.library.TinkerRegistry;

/**
 * Created by RedstoneParadox on 8/16/2018.
 */
public class ArsenalArmorTraits {
    public static final AbstractArmorTrait RESILIENCE = new ArmorTraitResilience();
    public static final AbstractArmorTrait RIGIDITY = new ArmorTraitRigidity();
    public static final AbstractArmorTrait ANTI_CORROSIVE = new ArmorTraitAntiCorrosive();
    public static final AbstractArmorTrait FIRE_RESISTANCE = new ArmorTraitFireResistance();

    public ArsenalArmorTraits() {
        TinkerRegistry.addTrait(RESILIENCE);
        TinkerRegistry.addTrait(RIGIDITY);
        TinkerRegistry.addTrait(ANTI_CORROSIVE);
        TinkerRegistry.addTrait(FIRE_RESISTANCE);
    }

    public static void initArmorTraits() {
        TinkerRegistry.addTrait(RESILIENCE);
        TinkerRegistry.addTrait(RIGIDITY);
        TinkerRegistry.addTrait(ANTI_CORROSIVE);
        TinkerRegistry.addTrait(FIRE_RESISTANCE);
    }
}

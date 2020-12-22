package io.github.redstoneparadox.tinkersarsenal.modules.base.traits.armortraits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import slimeknights.tconstruct.library.TinkerRegistry;

/**
 * Created by RedstoneParadox on 8/16/2018.
 */
public class BaseArmorTraits {
    public static final AbstractArmorTrait RESILIENCE = new ArmorTraitResilience();
    public static final AbstractArmorTrait RIGIDITY = new ArmorTraitRigidity();
    public static final AbstractArmorTrait ANTI_CORROSIVE = new ArmorTraitAntiCorrosive();

    public BaseArmorTraits() {
        TinkerRegistry.addTrait(RESILIENCE);
        TinkerRegistry.addTrait(RIGIDITY);
        TinkerRegistry.addTrait(ANTI_CORROSIVE);
    }
}

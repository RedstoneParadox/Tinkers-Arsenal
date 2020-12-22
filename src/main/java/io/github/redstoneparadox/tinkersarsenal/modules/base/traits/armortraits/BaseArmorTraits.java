package io.github.redstoneparadox.tinkersarsenal.modules.base.traits.armortraits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import slimeknights.tconstruct.library.TinkerRegistry;

/**
 * Created by RedstoneParadox on 8/16/2018.
 */
public class BaseArmorTraits {

    public static final AbstractArmorTrait resilience = new ArmorTraitResilience();
    public static final AbstractArmorTrait rigidity = new ArmorTraitRigidity();
    public static final AbstractArmorTrait antiCorrosive = new ArmorTraitAntiCorrosive();

    public BaseArmorTraits() {
        TinkerRegistry.addTrait(resilience);
        TinkerRegistry.addTrait(rigidity);
        TinkerRegistry.addTrait(antiCorrosive);
    }
}

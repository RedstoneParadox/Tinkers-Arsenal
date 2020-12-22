package io.github.redstoneparadox.tinkersarsenal.modules.base.traits.tooltraits;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by RedstoneParadox on 7/29/2018.
 */
public class BaseTraits {
    public static final AbstractTrait MISSINGNO = new TraitMissingno();
    public static final AbstractTrait DIAMOND_EDGE = new TraitDiamondEdge();
    public static final AbstractTrait RESILIENCE = new TraitResilience();
    public static final AbstractTrait MALLEABLE = new TraitMalleable();

    public BaseTraits() {
        //Tool materials
        TinkerRegistry.addTrait(MISSINGNO);
        TinkerRegistry.addTrait(DIAMOND_EDGE);
        TinkerRegistry.addTrait(RESILIENCE);
        TinkerRegistry.addTrait(MALLEABLE);
    }
}

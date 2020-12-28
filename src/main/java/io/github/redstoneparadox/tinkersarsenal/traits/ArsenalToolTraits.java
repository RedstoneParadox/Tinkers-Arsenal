package io.github.redstoneparadox.tinkersarsenal.traits;

import io.github.redstoneparadox.tinkersarsenal.traits.tooltraits.TraitDiamondEdge;
import io.github.redstoneparadox.tinkersarsenal.traits.tooltraits.TraitMalleable;
import io.github.redstoneparadox.tinkersarsenal.traits.tooltraits.TraitMissingno;
import io.github.redstoneparadox.tinkersarsenal.traits.tooltraits.TraitResilience;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by RedstoneParadox on 7/29/2018.
 */
public class ArsenalToolTraits {
    public static final AbstractTrait MISSINGNO = new TraitMissingno();
    public static final AbstractTrait DIAMOND_EDGE = new TraitDiamondEdge();
    public static final AbstractTrait RESILIENCE = new TraitResilience();
    public static final AbstractTrait MALLEABLE = new TraitMalleable();

    public ArsenalToolTraits() {
        //Tool materials
        TinkerRegistry.addTrait(MISSINGNO);
        TinkerRegistry.addTrait(DIAMOND_EDGE);
        TinkerRegistry.addTrait(RESILIENCE);
        TinkerRegistry.addTrait(MALLEABLE);
    }

    public static void initToolTraits() {
        TinkerRegistry.addTrait(MISSINGNO);
        TinkerRegistry.addTrait(DIAMOND_EDGE);
        TinkerRegistry.addTrait(RESILIENCE);
        TinkerRegistry.addTrait(MALLEABLE);
    }
}

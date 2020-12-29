package io.github.redstoneparadox.tinkersarsenal.traits;

import io.github.redstoneparadox.tinkersarsenal.traits.tooltraits.*;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by RedstoneParadox on 7/29/2018.
 */
public class ArsenalToolTraits {
    public static final AbstractTrait MISSINGNO = new TraitMissingno();
    public static final AbstractTrait DIAMOND_EDGE = new TraitDiamondEdge();
    public static final AbstractTrait ENDURING = new TraitEnduring();
    public static final AbstractTrait RESILIENCE = new TraitResilience();
    public static final AbstractTrait MALLEABLE = new TraitMalleable(1);
    // Shaft traits
    public static final AbstractTrait SWIFT_FLIGHT = new TraitSwiftFlight();
    public static final AbstractTrait GROUNDING = new TraitGrounding();
    public static final AbstractTrait HARD_HITTING = new TraitHardHitting();

    public static void initToolTraits() {
        TinkerRegistry.addTrait(MISSINGNO);
        TinkerRegistry.addTrait(DIAMOND_EDGE);
        TinkerRegistry.addTrait(ENDURING);
        TinkerRegistry.addTrait(RESILIENCE);
        TinkerRegistry.addTrait(MALLEABLE);
        TinkerRegistry.addTrait(SWIFT_FLIGHT);
        TinkerRegistry.addTrait(GROUNDING);
        TinkerRegistry.addTrait(HARD_HITTING);
    }
}

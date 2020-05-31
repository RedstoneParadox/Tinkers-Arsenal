package redstoneparadox.tinkersarsenal.modules.arsenal.traits.tooltraits;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by RedstoneParadox on 7/29/2018.
 */
public class TATraits {

    public static final AbstractTrait diamondEdge = new TraitDiamondEdge();
    public static final AbstractTrait resilience = new TraitResilience();
    public static final AbstractTrait malleable = new TraitMalleable();

    public TATraits() {
        //Tool materials
        TinkerRegistry.addTrait(diamondEdge);
        TinkerRegistry.addTrait(resilience);
        TinkerRegistry.addTrait(malleable);
    }
}

package redstoneparadox.tinkersarsenal.modules.oredict.traits.tooltraits;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class OreToolTraits {

    public static final AbstractTrait missingNo = new OreTraitMissingno();

    public OreToolTraits() {
        //Funny poke'mon reference;
        TinkerRegistry.addTrait(missingNo);
    }
}

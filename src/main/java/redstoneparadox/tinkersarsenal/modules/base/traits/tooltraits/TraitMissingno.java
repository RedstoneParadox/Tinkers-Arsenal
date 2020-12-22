package redstoneparadox.tinkersarsenal.modules.base.traits.tooltraits;

import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class TraitMissingno extends AbstractTrait {
    public TraitMissingno() {
        super("missingno", 0x000000);
        MinecraftForge.EVENT_BUS.register(this);
    }
}

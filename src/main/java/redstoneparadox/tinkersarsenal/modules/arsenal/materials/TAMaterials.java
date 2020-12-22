package redstoneparadox.tinkersarsenal.modules.arsenal.materials;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.arsenal.traits.tooltraits.TATraits;
import redstoneparadox.tinkersarsenal.modules.base.materials.MaterialsBase;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.shared.TinkerFluids;

/**
 * Created by RedstoneParadox on 8/9/2018.
 */
public class TAMaterials extends MaterialsBase{
    @Override
    public void initMaterials(ModuleDatabase database) {
        //Gold
        if (isRegistrable("gold")) {
            TAMaterial gold = new TAMaterial("gold", 0xeaee57);
            setCraftability(gold, "ingotGold", TinkerFluids.gold);
            addTraits(gold, TATraits.malleable, partHead);
            addTraits(gold, TATraits.malleable);
            addStats(gold, 14, 12.00f, 2.00f, HV0ROCK, 0.1f, -10, -7, 0.5f, 1.5f, 1f);
            gold.setRepresentativeItem(new ItemStack(Items.GOLD_INGOT));
            TinkerRegistry.addMaterial(gold);
        }

        //Diamond.
        if (isRegistrable("diamond")) {
            TAMaterial diamond = new TAMaterial("diamond", 0x33ebcb);
            setCraftability(diamond, "gemDiamond");
            addTraits(diamond, TATraits.diamondEdge, partHead);
            addTraits(diamond, TATraits.resilience);
            addStats(diamond, 1270, 6.00f, 5.00f, HV3OBI, 1.1f, 100, 269, 0.5f, 1.5f, 1.75f);
            diamond.setRepresentativeItem(new ItemStack(Items.DIAMOND));
            database.addMaterial(diamond);
            TinkerRegistry.addMaterial(diamond);
        }
    }
}

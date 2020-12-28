package io.github.redstoneparadox.tinkersarsenal.modules.base.materials;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import io.github.redstoneparadox.tinkersarsenal.misc.TAMaterial;
import io.github.redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import io.github.redstoneparadox.tinkersarsenal.modules.base.traits.tooltraits.BaseTraits;
import io.github.redstoneparadox.tinkersarsenal.modules.module.materials.ModuleMaterials;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.shared.TinkerFluids;

/**
 * Created by RedstoneParadox on 8/9/2018.
 */
public class BaseMaterials extends ModuleMaterials {
    @Override
    public void initMaterials(MaterialDatabase database) {
        //Gold
        if (isRegistrable("gold")) {
            TAMaterial gold = new TAMaterial("gold", 0xeaee57);
            setCraftability(gold, "ingotGold", TinkerFluids.gold);
            gold.addTrait(BaseTraits.MALLEABLE, PART_HEAD);
            gold.addTrait(BaseTraits.MALLEABLE, PART_EXTRA);
            addStats(gold, 14, 12.00f, 2.00f, HV0ROCK, 0.1f, -10, -7, 0.5f, 1.5f, 1f);
            gold.setRepresentativeItem(new ItemStack(Items.GOLD_INGOT));
            database.addMaterial(gold);
            TinkerRegistry.addMaterial(gold);
        }
        //Diamond.
        if (isRegistrable("diamond")) {
            TAMaterial diamond = new TAMaterial("diamond", 0x33ebcb);
            setCraftability(diamond, "gemDiamond");
            diamond.addTrait(BaseTraits.DIAMOND_EDGE, PART_HEAD);
            diamond.addTrait(BaseTraits.RESILIENCE, PART_HANDLE);
            diamond.addTrait(BaseTraits.RESILIENCE, PART_EXTRA);
            addStats(diamond, 1270, 6.00f, 5.00f, HV3OBI, 1.1f, 100, 269, 0.5f, 1.5f, 1.75f);
            diamond.setRepresentativeItem(new ItemStack(Items.DIAMOND));
            database.addMaterial(diamond);
            TinkerRegistry.addMaterial(diamond);
        }
    }
}

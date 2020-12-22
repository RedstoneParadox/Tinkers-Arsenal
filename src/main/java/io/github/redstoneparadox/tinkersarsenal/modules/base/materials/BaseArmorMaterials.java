package io.github.redstoneparadox.tinkersarsenal.modules.base.materials;

import io.github.redstoneparadox.tinkersarsenal.TinkersArsenal;
import io.github.redstoneparadox.tinkersarsenal.misc.TAMaterial;
import io.github.redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import io.github.redstoneparadox.tinkersarsenal.modules.base.traits.armortraits.BaseArmorTraits;
import io.github.redstoneparadox.tinkersarsenal.modules.module.materials.ModuleArmorMaterials;

/**
 * Created by RedstoneParadox on 8/22/2018.
 */
public class BaseArmorMaterials extends ModuleArmorMaterials {
    @Override
    public void initMaterials(MaterialDatabase database){
        //Gold:
        if (isTAMaterial("gold")) {
            TAMaterial gold = database.getMaterial("gold");
            addTraits(gold, BaseArmorTraits.ANTI_CORROSIVE, partCore);
            addTraits(gold, BaseArmorTraits.ANTI_CORROSIVE);
            addArmorStats(gold, 8.8f, 11f, 0.1f, 5.8f, 0.0f, 4.5f);
        }
        //Diamond:
        if (isTAMaterial("diamond")) {
            TAMaterial diamond = database.getMaterial("diamond");
            addTraits(diamond, BaseArmorTraits.RIGIDITY, partCore);
            addTraits(diamond, BaseArmorTraits.RESILIENCE);
            addArmorStats(diamond, 15f, 20f, 1.1f, 4.5f, 2f, 11f);
        }
    }
}

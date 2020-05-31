package redstoneparadox.tinkersarsenal.modules.arsenal.materials;

import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.arsenal.traits.armortraits.TAArmorTraits;
import redstoneparadox.tinkersarsenal.modules.base.materials.ArmorMaterialsBase;

/**
 * Created by RedstoneParadox on 8/22/2018.
 */
public class TAArmorMaterials extends ArmorMaterialsBase {

    @Override
    public void initMaterials(ModuleDatabase database){

        TinkersArsenal.logger.info("Time to suit up!");
        //Gold:
        if (isTAMaterial("gold")) {
            TAMaterial gold = database.getMaterial("gold");
            addTraits(gold, TAArmorTraits.antiCorrosive, partCore);
            addTraits(gold, TAArmorTraits.antiCorrosive);
            addArmorStats(gold, 8.8f, 11f, 0.1f, 5.8f, 0.0f, 4.5f);
        }

        //Diamond:
        if (isTAMaterial("diamond")) {
            TAMaterial diamond = database.getMaterial("diamond");
            addTraits(diamond, TAArmorTraits.rigidity, partCore);
            addTraits(diamond, TAArmorTraits.resilience);
            addArmorStats(diamond, 15f, 20f, 1.1f, 4.5f, 2f, 11f);
        }
    }
}

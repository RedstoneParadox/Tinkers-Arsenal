package redstoneparadox.tinkersarsenal.modules.oredictionary.materials;

import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import redstoneparadox.tinkersarsenal.modules.base.traits.tooltraits.BaseTraits;
import redstoneparadox.tinkersarsenal.modules.module.materials.ModuleArmorMaterials;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class OreDictionaryArmorMaterials extends ModuleArmorMaterials {
    @Override
    public void initMaterials(MaterialDatabase database){
        if (isTAMaterial("tin")) {
            TAMaterial tin = database.getMaterial("tin");
            addTraits(tin, BaseTraits.MISSINGNO);
            addArmorStats(tin, 1f, 9f, 0.5f, 1f, 0f, 1f);
        }

        if (isTAMaterial("aluminum")) {
            TAMaterial aluminum = database.getMaterial("aluminum");
            addTraits(aluminum, BaseTraits.MISSINGNO);
            addArmorStats(aluminum, 1f, 10f, 0.7f, 1f, 0f, 1f);
        }

        if (isTAMaterial("constantan")) {
            TAMaterial constantan = database.getMaterial("constantan");
            addTraits(constantan, BaseTraits.MISSINGNO);
            addArmorStats(constantan, 1f, 12f, 1.0f, 1f, 0f, 1f);
        }

        if (isTAMaterial("nickel")) {
            TAMaterial nickel = database.getMaterial("nickel");
            addTraits(nickel, BaseTraits.MISSINGNO);
            addArmorStats(nickel, 1f, 14f, 1.3f, 1f, 0f, 1f);
        }

        if (isTAMaterial("platinum")) {
            TAMaterial platinum = database.getMaterial("platinum");
            addTraits(platinum, BaseTraits.MISSINGNO);
            addArmorStats(platinum, 1f, 20f, 1.1f, 1f, 2f, 1f);
        }

        if (isTAMaterial("iridium")) {
            TAMaterial iridium = database.getMaterial("iridium");
            addTraits(iridium, BaseTraits.MISSINGNO);
        }

        if (isTAMaterial("mithril")) {
            TAMaterial mithril = database.getMaterial("mithril");
            addTraits(mithril, BaseTraits.MISSINGNO);
        }

        if (isTAMaterial("invar")) {
            TAMaterial invar = database.getMaterial("invar");
            addTraits(invar, BaseTraits.MISSINGNO);
            addArmorStats(invar, 1f, 16f, 1.5f, 1f, 2f, 1f);
        }
    }
}

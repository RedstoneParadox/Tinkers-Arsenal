package redstoneparadox.tinkersarsenal.modules.oredict.materials;

import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.base.materials.ArmorMaterialsBase;
import redstoneparadox.tinkersarsenal.modules.oredict.traits.tooltraits.OreToolTraits;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class OreArmorMaterials extends ArmorMaterialsBase {
    @Override
    public void initMaterials(ModuleDatabase database){
        if (isTAMaterial("tin")) {
            TAMaterial tin = database.getMaterial("tin");
            addTraits(tin, OreToolTraits.TRAIT_MISSINGNO);
            addArmorStats(tin, 1f, 9f, 0.5f, 1f, 0f, 1f);
        }

        if (isTAMaterial("aluminum")) {
            TAMaterial aluminum = database.getMaterial("aluminum");
            addTraits(aluminum, OreToolTraits.TRAIT_MISSINGNO);
            addArmorStats(aluminum, 1f, 10f, 0.7f, 1f, 0f, 1f);
        }

        if (isTAMaterial("constantan")) {
            TAMaterial constantan = database.getMaterial("constantan");
            addTraits(constantan, OreToolTraits.TRAIT_MISSINGNO);
            addArmorStats(constantan, 1f, 12f, 1.0f, 1f, 0f, 1f);
        }

        if (isTAMaterial("nickel")) {
            TAMaterial nickel = database.getMaterial("nickel");
            addTraits(nickel, OreToolTraits.TRAIT_MISSINGNO);
            addArmorStats(nickel, 1f, 14f, 1.3f, 1f, 0f, 1f);
        }

        if (isTAMaterial("platinum")) {
            TAMaterial platinum = database.getMaterial("platinum");
            addTraits(platinum, OreToolTraits.TRAIT_MISSINGNO);
            addArmorStats(platinum, 1f, 20f, 1.1f, 1f, 2f, 1f);
        }

        if (isTAMaterial("iridium")) {
            TAMaterial iridium = database.getMaterial("iridium");
            addTraits(iridium, OreToolTraits.TRAIT_MISSINGNO);
        }

        if (isTAMaterial("mithril")) {
            TAMaterial mithril = database.getMaterial("mithril");
            addTraits(mithril, OreToolTraits.TRAIT_MISSINGNO);
        }

        if (isTAMaterial("invar")) {
            TAMaterial invar = database.getMaterial("invar");
            addTraits(invar, OreToolTraits.TRAIT_MISSINGNO);
            addArmorStats(invar, 1f, 16f, 1.5f, 1f, 2f, 1f);
        }
    }
}

package redstoneparadox.tinkersarsenal.modules.oredict;

import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.base.Module;
import redstoneparadox.tinkersarsenal.modules.oredict.materials.OreArmorMaterials;
import redstoneparadox.tinkersarsenal.modules.oredict.materials.OreMaterials;
import redstoneparadox.tinkersarsenal.modules.oredict.traits.tooltraits.OreToolTraits;

/**
 * Created by RedstoneParadox on 9/11/2018.
 */
public class ModuleOre extends Module {
    public ModuleOre(ModuleDatabase materialDatabase) {
        super(materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        TinkersArsenal.logger.info("Reading the dictionary is a good way to expand your vocabulary.");

        new OreToolTraits();

        OreMaterials oreMaterials = new OreMaterials();
        oreMaterials.initMaterials(database);

        if (withArmor) {

            OreArmorMaterials oreArmorMaterials = new OreArmorMaterials();
            oreArmorMaterials.initMaterials(database);
        }
    }
}

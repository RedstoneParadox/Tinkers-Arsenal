package redstoneparadox.tinkersarsenal.modules.oredict;

import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.base.Module;
import redstoneparadox.tinkersarsenal.modules.oredict.materials.OreArmorMaterials;
import redstoneparadox.tinkersarsenal.modules.oredict.materials.OreMaterials;

/**
 * Created by RedstoneParadox on 9/11/2018.
 */
public class ModuleOre extends Module {
    public ModuleOre(ModuleDatabase materialDatabase) {
        super(materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        OreMaterials oreMaterials = new OreMaterials();
        oreMaterials.initMaterials(database);

        if (withArmor) {
            OreArmorMaterials oreArmorMaterials = new OreArmorMaterials();
            oreArmorMaterials.initMaterials(database);
        }
    }
}

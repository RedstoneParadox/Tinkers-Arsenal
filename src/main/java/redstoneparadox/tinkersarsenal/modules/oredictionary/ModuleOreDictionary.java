package redstoneparadox.tinkersarsenal.modules.oredictionary;

import redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import redstoneparadox.tinkersarsenal.modules.module.Module;
import redstoneparadox.tinkersarsenal.modules.oredictionary.materials.OreDictionaryArmorMaterials;
import redstoneparadox.tinkersarsenal.modules.oredictionary.materials.OreDictionaryMaterials;

/**
 * Created by RedstoneParadox on 9/11/2018.
 */
public class ModuleOreDictionary extends Module {
    public ModuleOreDictionary(MaterialDatabase materialDatabase) {
        super(materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        OreDictionaryMaterials oreDictionaryMaterials = new OreDictionaryMaterials();
        oreDictionaryMaterials.initMaterials(database);

        if (withArmor) {
            OreDictionaryArmorMaterials oreArmorMaterials = new OreDictionaryArmorMaterials();
            oreArmorMaterials.initMaterials(database);
        }
    }
}

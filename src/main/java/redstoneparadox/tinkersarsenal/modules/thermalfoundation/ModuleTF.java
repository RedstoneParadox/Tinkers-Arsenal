package redstoneparadox.tinkersarsenal.modules.thermalfoundation;

import redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import redstoneparadox.tinkersarsenal.modules.module.Module;
import redstoneparadox.tinkersarsenal.modules.thermalfoundation.materials.TFMaterials;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class ModuleTF extends Module {
    public ModuleTF(MaterialDatabase materialDatabase) {
        super(materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        TFMaterials teMats = new TFMaterials();
        teMats.initMaterials(database);

        if (withArmor) {

        }
    }
}

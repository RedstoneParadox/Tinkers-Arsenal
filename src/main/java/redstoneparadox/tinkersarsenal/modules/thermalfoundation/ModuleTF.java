package redstoneparadox.tinkersarsenal.modules.thermalfoundation;

import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.base.Module;
import redstoneparadox.tinkersarsenal.modules.thermalfoundation.materials.TFMaterials;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class ModuleTF extends Module {
    public ModuleTF(ModuleDatabase materialDatabase) {
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

package redstoneparadox.tinkersarsenal.modules.thermalfoundation;

import redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import redstoneparadox.tinkersarsenal.modules.module.Module;
import redstoneparadox.tinkersarsenal.modules.thermalfoundation.materials.ThermalMaterials;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class ModuleThermal extends Module {
    public ModuleThermal(MaterialDatabase materialDatabase) {
        super(materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        ThermalMaterials teMats = new ThermalMaterials();
        teMats.initMaterials(database);

        if (withArmor) {

        }
    }
}

package io.github.redstoneparadox.tinkersarsenal.modules.thermalfoundation;

import io.github.redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import io.github.redstoneparadox.tinkersarsenal.modules.module.Module;
import io.github.redstoneparadox.tinkersarsenal.modules.thermalfoundation.materials.ThermalMaterials;

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

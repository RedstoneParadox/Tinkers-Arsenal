package redstoneparadox.tinkersarsenal.modules.thermalfoundation;

import redstoneparadox.libraryparadox.signals.Switchboard;
import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.base.ModuleBase;
import redstoneparadox.tinkersarsenal.modules.thermalfoundation.materials.TFMaterials;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class ModuleTF extends ModuleBase{


    public ModuleTF(String modID, Switchboard switchboardClass, ModuleDatabase materialDatabase) {
        super(modID, switchboardClass, materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        TinkersArsenal.logger.info("Is it getting hot in here, or is it just me?");

        TFMaterials teMats = new TFMaterials();
        teMats.initMaterials(database);

        if (withArmor) {

        }
    }
}

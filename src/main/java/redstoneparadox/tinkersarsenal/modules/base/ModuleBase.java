package redstoneparadox.tinkersarsenal.modules.base;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.libraryparadox.signals.ISignalReceiver;
import redstoneparadox.libraryparadox.signals.Switchboard;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;

import java.util.ArrayList;

/**
 * Created by RedstoneParadox on 9/10/2018.
 */
public class ModuleBase implements ISignalReceiver {

    protected ModuleDatabase database;

    public ModuleBase (String modID, Switchboard switchboard, ModuleDatabase materialDatabase) {
        database = materialDatabase;
        if (Loader.isModLoaded(modID)) {
            switchboard.addReceiver(this, "initModules");
            switchboard.addReceiver(this, "initTools");
            if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
                switchboard.addReceiver(this, "initToolGUIs");
            }
        }
    }

    @Override
    public void receiveSignal(String signal, ArrayList<Object> arguments) {
        if (signal == "initModules") {
            Boolean withArmor = (Boolean) arguments.get(0);
            initModule(withArmor);
        }
        else if (signal == "initTools") {
            IForgeRegistry<Item> registry = (IForgeRegistry<Item>) arguments.get(0);
            initTools(registry);
        }
        else if (signal == "initToolGUIs") {
            initGUIs();
        }
    }

    public void initModule(boolean withArmor) {

    }

    public void initTools(IForgeRegistry<Item> registry) {

    }

    public void initGUIs() {

    }
}

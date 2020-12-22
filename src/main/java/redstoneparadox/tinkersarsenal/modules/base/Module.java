package redstoneparadox.tinkersarsenal.modules.base;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;

/**
 * Created by RedstoneParadox on 9/10/2018.
 */
public class Module {
    protected ModuleDatabase database;

    public Module(ModuleDatabase materialDatabase) {
        database = materialDatabase;
    }

    public void initModule(boolean withArmor) {

    }

    public void initTools(IForgeRegistry<Item> registry) {

    }

    public void initGUIs() {

    }
}

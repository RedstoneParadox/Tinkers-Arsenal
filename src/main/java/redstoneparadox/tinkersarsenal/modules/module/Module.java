package redstoneparadox.tinkersarsenal.modules.module;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.tinkersarsenal.modules.MaterialDatabase;

/**
 * Created by RedstoneParadox on 9/10/2018.
 */
public class Module {
    protected MaterialDatabase database;

    public Module(MaterialDatabase materialDatabase) {
        database = materialDatabase;
    }

    public void initModule(boolean withArmor) {
    }

    public void initTools(IForgeRegistry<Item> registry) {
    }

    public void initGUIs() {
    }
}

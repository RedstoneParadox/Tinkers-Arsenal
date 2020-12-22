package redstoneparadox.tinkersarsenal.modules;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.tinkersarsenal.modules.base.ModuleBase;
import redstoneparadox.tinkersarsenal.modules.module.Module;

import java.util.ArrayList;
import java.util.List;

public class Modules {
    private static List<Module> modules = new ArrayList<>();
    private static MaterialDatabase database = new MaterialDatabase();

    public static void createModules() {
        modules.add(new ModuleBase(database));
        // modules.add(new ModuleOre(database));
        // if (Loader.isModLoaded("thermalfoundation")) modules.add(new ModuleTF(database));
    }

    public static void initModules(boolean withArmor) {
        modules.forEach(module -> module.initModule(withArmor));
        database.cleanDatabase();
    }

    public static void initTools(IForgeRegistry<Item> registry) {
        modules.forEach(module -> module.initTools(registry));
    }

    public static void initToolGUIs() {
        modules.forEach(Module::initGUIs);
    }
}

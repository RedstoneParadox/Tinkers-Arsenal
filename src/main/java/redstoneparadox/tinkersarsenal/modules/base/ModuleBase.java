package redstoneparadox.tinkersarsenal.modules.base;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import redstoneparadox.tinkersarsenal.modules.base.materials.BaseArmorMaterials;
import redstoneparadox.tinkersarsenal.modules.base.materials.BaseMaterials;
import redstoneparadox.tinkersarsenal.modules.base.tools.BaseTools;
import redstoneparadox.tinkersarsenal.modules.base.traits.armortraits.BaseArmorTraits;
import redstoneparadox.tinkersarsenal.modules.base.traits.tooltraits.BaseTraits;
import redstoneparadox.tinkersarsenal.modules.module.Module;

/**
 * Created by RedstoneParadox on 9/10/2018.
 */
public class ModuleBase extends Module {
    BaseTools tools = new BaseTools();

    public ModuleBase(MaterialDatabase materialDatabase) {
        super(materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        new BaseTraits();
        BaseMaterials baseMaterials = new BaseMaterials();
        baseMaterials.initMaterials(database);

        if (withArmor) {
            new BaseArmorTraits();

            BaseArmorMaterials baseArmorMaterials = new BaseArmorMaterials();
            baseArmorMaterials.initMaterials(database);
        }
    }

    @Override
    public void initTools(IForgeRegistry<Item> registry) {
        tools.initToolParts(registry);
    }

    @Override
    public void initGUIs() {
        tools.initToolGUIs();
    }
}

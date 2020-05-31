package redstoneparadox.tinkersarsenal.modules.arsenal;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.arsenal.materials.TAArmorMaterials;
import redstoneparadox.tinkersarsenal.modules.arsenal.materials.TAMaterials;
import redstoneparadox.tinkersarsenal.modules.arsenal.tools.TATools;
import redstoneparadox.tinkersarsenal.modules.arsenal.traits.armortraits.TAArmorTraits;
import redstoneparadox.tinkersarsenal.modules.arsenal.traits.tooltraits.TATraits;
import redstoneparadox.tinkersarsenal.modules.base.Module;

/**
 * Created by RedstoneParadox on 9/10/2018.
 */
public class ModuleArsenal extends Module {

    TATools tools = new TATools();

    public ModuleArsenal(ModuleDatabase materialDatabase) {
        super(materialDatabase);
    }

    @Override
    public void initModule(boolean withArmor) {
        TinkersArsenal.logger.info("Arsenal as in this mod, not the band from that one musical.");

        new TATraits();

        TAMaterials taMaterials = new TAMaterials();
        taMaterials.initMaterials(database);

        if (withArmor) {
            new TAArmorTraits();

            TAArmorMaterials taArmorMaterials = new TAArmorMaterials();
            taArmorMaterials.initMaterials(database);
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

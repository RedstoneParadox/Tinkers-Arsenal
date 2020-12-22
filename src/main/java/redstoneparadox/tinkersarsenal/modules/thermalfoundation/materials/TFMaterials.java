package redstoneparadox.tinkersarsenal.modules.thermalfoundation.materials;

import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.module.materials.ModuleMaterials;
import slimeknights.tconstruct.library.TinkerRegistry;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class TFMaterials extends ModuleMaterials {
    @Override
    public void initMaterials(ModuleDatabase database) {
        //Compatible ore-dict materials:

        if (isRegistrable("tin")) {
            TAMaterial tin = database.getMaterial("tin");
            tin.setRepresentativeItem("ingotTin");
            TinkerRegistry.addMaterial(tin);
        }

        if (isRegistrable("aluminum")) {
            TAMaterial aluminum = database.getMaterial("aluminum");
            aluminum.setRepresentativeItem("ingotAluminum");
            TinkerRegistry.addMaterial(aluminum);
        }

        if (isRegistrable("constantan")) {
            TAMaterial constantan = database.getMaterial("constantan");
            constantan.setRepresentativeItem("ingotConstantan");
            TinkerRegistry.addMaterial(constantan);
        }

        if (isRegistrable("nickel")) {
            TAMaterial nickel = database.getMaterial("nickel");
            nickel.setRepresentativeItem("ingotNickel");
            TinkerRegistry.addMaterial(nickel);
        }

        if (isRegistrable("platinum")) {
            TAMaterial platinum = database.getMaterial("platinum");
            platinum.setRepresentativeItem("ingotPlatinum");
            TinkerRegistry.addMaterial(platinum);
        }

        if (isRegistrable("iridium")) {
            TAMaterial iridium = database.getMaterial("iridium");
            iridium.setRepresentativeItem("ingotIridium");
            TinkerRegistry.addMaterial(iridium);
        }

        if (isRegistrable("mithril")) {
            TAMaterial mithril = database.getMaterial("mithril");
            mithril.setRepresentativeItem("ingotMithril");
            TinkerRegistry.addMaterial(mithril);
        }

        if (isRegistrable("invar")) {
            TAMaterial invar = database.getMaterial("invar");
            invar.setRepresentativeItem("ingotInvar");
            TinkerRegistry.addMaterial(invar);
        }
    }
}

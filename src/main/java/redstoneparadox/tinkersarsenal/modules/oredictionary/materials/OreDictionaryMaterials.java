package redstoneparadox.tinkersarsenal.modules.oredictionary.materials;

import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.modules.MaterialDatabase;
import redstoneparadox.tinkersarsenal.modules.base.traits.tooltraits.BaseTraits;
import redstoneparadox.tinkersarsenal.modules.module.materials.ModuleMaterials;
import slimeknights.tconstruct.shared.TinkerFluids;

/**
 * Created by RedstoneParadox on 8/29/2018.
 */
public class OreDictionaryMaterials extends ModuleMaterials {
    @Override
    public void initMaterials(MaterialDatabase database) {
        if (isRegistrable("tin")) {
            TAMaterial tin = new TAMaterial("tin", 0xC3E6E6);
            setCraftability(tin, "ingotTin");
            addTraits(tin, BaseTraits.MISSINGNO);
            addStats(tin, 75, 4.50f, 4.00f, HV1FE, 0.5f, -25, 75, 0.5f, 1.5f, 1.75f);
            database.addMaterial(tin);
        }

        if (isRegistrable("aluminum")) {
            TAMaterial aluminum = new TAMaterial("aluminum", 0xE6E6F2);
            setCraftability(aluminum, "ingotAluminum", TinkerFluids.aluminum);
            addTraits(aluminum, BaseTraits.MISSINGNO);
            addStats(aluminum, 150, 10, 4.00f, HV1FE, 0.5f, -75, 50, 0.5f, 1.5f, 1.75f);
            database.addMaterial(aluminum);
        }

        if (isRegistrable("constantan")) {
            TAMaterial constantan = new TAMaterial("constantan", 0xF9D384);
            setCraftability(constantan, "ingotConstantan");
            addTraits(constantan, BaseTraits.MISSINGNO);
            addStats(constantan, 175, 6, 4.50f, HV2DIA, 1.3f, 150, 100, 0.5f, 1.5f, 1.75f);
            database.addMaterial(constantan);
        }

        if (isRegistrable("nickel")) {
            TAMaterial nickel = new TAMaterial("nickel", 0xF6F8BD);
            setCraftability(nickel, "ingotNickel");
            addTraits(nickel, BaseTraits.MISSINGNO);
            addStats(nickel, 100, 6.5f, 5.5f, HV2DIA, 1.3f, 100, 200, 0.5f, 1.5f, 1.75f);
            database.addMaterial(nickel);
        }

        if (isRegistrable("platinum")) {
            TAMaterial platinum = new TAMaterial("platinum", 0x6FEAEF);
            setCraftability(platinum, "ingotPlatinum");
            addTraits(platinum, BaseTraits.MISSINGNO);
            addStats(platinum, 650, 9, 6.50f, HV4CO, 1.6f, 250, 750, 0.5f, 1.5f, 1.75f);
            database.addMaterial(platinum);
        }

        if (isRegistrable("iridium")) {
            TAMaterial iridium = new TAMaterial("iridium", 0xC4C2DC);
            setCraftability(iridium, "ingotIridium");
            addTraits(iridium, BaseTraits.MISSINGNO);
            database.addMaterial(iridium);
        }

        if (isRegistrable("mithril")) {
            TAMaterial mithril = new TAMaterial("mithril", 0x6DA7C9);
            setCraftability(mithril, "ingotMithril");
            addTraits(mithril, BaseTraits.MISSINGNO);
            database.addMaterial(mithril);
        }

        if (isRegistrable("invar")) {
            TAMaterial invar = new TAMaterial("invar", 0xE1E7E5);
            setCraftability(invar, "ingotInvar");
            addTraits(invar, BaseTraits.MISSINGNO);
            addStats(invar, 175, 6.50f, 5.50f, HV2DIA, 1.5f, 50, 250, 0.5f, 1.5f, 1.75f);
            database.addMaterial(invar);
        }
    }
}

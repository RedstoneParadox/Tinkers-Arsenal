package redstoneparadox.tinkersarsenal.modules.base.materials;


import net.minecraftforge.fluids.Fluid;
import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.misc.TAConfig;
import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.HarvestLevels;

import java.util.ArrayList;

/**
 * Created by RedstoneParadox on 9/11/2018.
 */
public class MaterialsBase {

    //Harvest Levels:

    protected static int HV0ROCK = HarvestLevels.STONE;
    protected static int HV1FE = HarvestLevels.IRON;
    protected static int HV2DIA = HarvestLevels.DIAMOND;
    protected static int HV3OBI = HarvestLevels.OBSIDIAN;
    protected static int HV4CO = HarvestLevels.COBALT;

    //Part Types

    protected static String partHead = MaterialTypes.HEAD;
    protected static String partHandle = MaterialTypes.HANDLE;
    protected static String partEx = MaterialTypes.EXTRA;
    protected static String partBow = MaterialTypes.BOW;
    protected static String partString = MaterialTypes.BOWSTRING;
    protected static String partShaft = MaterialTypes.SHAFT;
    protected static String partFletching = MaterialTypes.FLETCHING;

    private static int clr = 0x000000;

    public void initMaterials(ModuleDatabase database) {

    }

    //Check if the material can be registered:
    protected boolean isRegistrable(String id) {
        if (TinkerRegistry.getMaterial(id) == Material.UNKNOWN && TAConfig.isMaterialAllowed(id)) {
            return true;
        }
        return false;
    }

    //Checks if a material is an instance of TAMaterial
    protected boolean isTAMaterial(String id) {
        if (TinkerRegistry.getMaterial(id) instanceof TAMaterial) {
            return true;
        }
        return false;
    }

    //Methods for setting if a material is craftable or castable and it's material values if craftable.
    protected void setCraftability(Material material, String item, Fluid fluid) {
        String suffix = removePrefix(item);

        if (suffix != null) {
            material.addItemIngot(suffix);
            material.setCastable(true).setCraftable(false);
            material.setFluid(fluid);
            TinkerRegistry.integrate(material, fluid, suffix).toolforge();
        }
    }

    protected void setCraftability(Material material, String item) {
        String suffix = removePrefix(item);
        String blockString = new String("block" + suffix);

        if (suffix != null) {
            material.addItem(item, 1, Material.VALUE_Ingot);
            material.addItem(blockString, 1, Material.VALUE_Block);
            material.setCraftable(true).setCastable(false);
            TinkerRegistry.integrate(material, suffix);
        }
    }

    //Methods for adding materials to a material
    @Deprecated
    public void addTraits(Material material, AbstractTrait mainTrait, AbstractTrait secondTrait, String partType) {
        material.addTrait(mainTrait, partType);
        material.addTrait(secondTrait, partType);
    }

    @Deprecated
    public void addTraits(Material material, AbstractTrait trait) {
        material.addTrait(trait, partHandle);
        material.addTrait(trait, partEx);
    }

    @Deprecated
    public void addTraits(Material material, ArrayList<String> parts, ArrayList<AbstractTrait> traits) {
        for (int ia = 0; ia<=parts.size(); ia++) {
            for (int ib = 0; ib<=traits.size(); ib++) {
                material.addTrait(traits.get(ib), parts.get(ia));
            }
        }
    }

    @Deprecated
    public void addTraits(Material material, String part, ArrayList<AbstractTrait> traits) {
        for (int i = 0; i<=traits.size(); i++) {
            material.addTrait(traits.get(i), part);
        }
    }

    @Deprecated
    public void addTraits(Material material, ArrayList<String> parts, AbstractTrait trait) {
        for (int i = 0; i<=parts.size(); i++) {
            material.addTrait(trait, parts.get(i));
        }
    }

    public void addTraits(Material material, AbstractTrait trait, String part) {
        material.addTrait(trait, part);
    }

    //Finally, we add the stats here.
    public void addStats(Material material, int dur, float spd, float dmg, int harvest, float mod, int handleDur, int exDur, float draw, float range, float bonusDmg) {
        TinkerRegistry.addMaterialStats(material,
                new HeadMaterialStats(dur, spd, dmg, harvest),
                new HandleMaterialStats(mod, handleDur),
                new ExtraMaterialStats(exDur),
                new BowMaterialStats(draw, range, bonusDmg)
        );
    }

    public void addBowstringStats() {

    }

    public void addShaftStats() {

    }

    public void addFletchingStats() {

    }

    public void addGuitarStats() {
        //Nothing to see here folks.
    }

    /*Used for getting a prefix from the provided oreDict string so that the prefix
    "block" can be attached to it. Will eventually be replaced.*/
    @Deprecated
    public static String removePrefix(String item) {
        if (item.contains("gem")) {
            return item.substring(item.indexOf("gem") + 3);
        }
        else if (item.contains("ingot")) {
            return item.substring(item.indexOf("ingot") + 5);
        }
        else {
            TinkersArsenal.logger.debug("Prefix for the inputted ore dictionary entry was not found! This material will not be properly registered!");
            return null;
        }
    }
}

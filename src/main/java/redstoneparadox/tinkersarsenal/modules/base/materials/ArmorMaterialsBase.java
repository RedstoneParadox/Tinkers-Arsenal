package redstoneparadox.tinkersarsenal.modules.base.materials;

import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by RedstoneParadox on 9/11/2018.
 */
public class ArmorMaterialsBase extends MaterialsBase {
    //Armor part types:
    protected static String partCore = ArmorMaterialType.CORE;
    protected static String partPlate = ArmorMaterialType.PLATES;
    protected static String partTrim = ArmorMaterialType.TRIM;

    @Override
    public void addTraits(Material material, AbstractTrait trait) {
        material.addTrait(trait, partPlate);
        material.addTrait(trait, partTrim);
    }

    public void addArmorStats(Material material, float coreDurability, float defense, float plateModifier, float plateDurability, float plateToughness, float trimDurability) {
        TinkerRegistry.addMaterialStats(material,
                new CoreMaterialStats(coreDurability, defense),
                new PlatesMaterialStats(plateModifier, plateDurability, plateToughness),
                new TrimMaterialStats(trimDurability)
        );
    }
}

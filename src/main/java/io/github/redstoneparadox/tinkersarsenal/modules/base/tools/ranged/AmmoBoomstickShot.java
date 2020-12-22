package io.github.redstoneparadox.tinkersarsenal.modules.base.tools.ranged;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import io.github.redstoneparadox.tinkersarsenal.entities.EntityBoomstickShot;
import io.github.redstoneparadox.tinkersarsenal.modules.base.tools.BaseTools;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ProjectileNBT;
import slimeknights.tconstruct.library.tools.ranged.ProjectileCore;
import slimeknights.tconstruct.tools.TinkerMaterials;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by RedstoneParadox on 8/3/2018.
 */
public class AmmoBoomstickShot extends ProjectileCore {
    private static PartMaterialType bulletPMT = new PartMaterialType(BaseTools.bullet, MaterialTypes.HEAD, MaterialTypes.PROJECTILE);

    public AmmoBoomstickShot() {
        super(bulletPMT, PartMaterialType.extra(BaseTools.bulletShell));

        this.setRegistryName("boomstick_shot").setTranslationKey("boomstick_shot");

        addCategory(Category.NO_MELEE, Category.PROJECTILE);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if(this.getCreativeTab() == tab) {
            addDefaultSubItems(subItems, null, null, null, TinkerMaterials.string);
        }
    }

    @Override
    public ProjectileNBT buildTagData(List<Material> materials) {
        ProjectileNBT data = new ProjectileNBT();

        data.head(materials.get(0).getStatsOrUnknown(MaterialTypes.HEAD));
        data.extra(materials.get(1).getStatsOrUnknown(MaterialTypes.EXTRA));

        return data;
    }

    @Override
    public float damagePotential() {
        return 1f;
    }

    @Override
    public EntityProjectileBase getProjectile(@Nonnull ItemStack stack, @Nonnull ItemStack launcher, World world, EntityPlayer player, float speed, float inaccuracy, float power, boolean usedAmmo) {
        return new EntityBoomstickShot(world, player, speed, inaccuracy, power, stack, launcher);
    }
}

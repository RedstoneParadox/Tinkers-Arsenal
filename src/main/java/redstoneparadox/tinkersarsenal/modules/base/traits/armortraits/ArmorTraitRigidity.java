package redstoneparadox.tinkersarsenal.modules.base.traits.armortraits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.Random;

/**
 * Created by RedstoneParadox on 8/16/2018.
 */
public class ArmorTraitRigidity extends AbstractArmorTrait {

    public ArmorTraitRigidity() {
        super("rigidity", 0x33ebcb);
    }

    @Override
    public float onHurt(ItemStack armor, EntityPlayer player, DamageSource source, float damage, float newDamage, LivingHurtEvent evt) {
        int armorAmount = armor.getTagCompound().getCompoundTag("Stats").getInteger("defense");

        //Someday, I want to make this work in a similar manner to how I wanted Diamond Edge to work.
        if (armorAmount > 10) {
            Random rigidChance = new Random();

            if ((rigidChance.nextInt(20) + 1) == 1) {
                newDamage = damage * 0.5f;
                return newDamage;
            }
        } else {
            return newDamage;
        }
        return newDamage;
    }
}

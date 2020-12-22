package redstoneparadox.tinkersarsenal.modules.base.traits.armortraits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import java.util.Random;

/**
 * Created by RedstoneParadox on 8/16/2018.
 */
public class ArmorTraitResilience extends AbstractArmorTrait {

    ArmorTraitResilience() {
        super("resilience", 0x33ebcb);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public float onDamaged(ItemStack armor, EntityPlayer player, DamageSource source, float damage, float newDamage, LivingDamageEvent evt) {
        if(player.getEntityWorld().isRemote) {
            return 0;
        }

        NBTTagCompound tag = armor.getTagCompound();
        int baseDurability = tag.getCompoundTag("Stats").getInteger("Durability");
        int damageTaken = tag.getInteger("Damage");

        int remainingDurability = baseDurability - damageTaken;

        Random damageChance = new Random();

        if ((damageChance.nextInt(baseDurability * 2) + 1) <= remainingDurability) {
            newDamage = 0;
            return newDamage;
        }
        else {
            newDamage = damage;
            return newDamage;
        }
    }
}

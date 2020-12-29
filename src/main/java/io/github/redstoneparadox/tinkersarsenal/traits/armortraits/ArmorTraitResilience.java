package io.github.redstoneparadox.tinkersarsenal.traits.armortraits;

import c4.conarm.lib.traits.AbstractArmorTrait;
import net.minecraft.entity.EntityLivingBase;
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
    public ArmorTraitResilience() {
        super("resilience", 0x33ebcb);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if (entity.getEntityWorld().isRemote) {
            return 0;
        }

        NBTTagCompound tag = tool.getTagCompound();
        int baseDurability = tag.getCompoundTag("Stats").getInteger("Durability");
        int damageTaken = tag.getInteger("Damage");

        int remainingDurability = baseDurability - damageTaken;

        Random damageChance = new Random();

        if ((damageChance.nextInt(baseDurability * 2) + 1) <= remainingDurability) {
            newDamage = 0;
        }
        else {
            newDamage = damage;
        }
        return newDamage;
    }
}

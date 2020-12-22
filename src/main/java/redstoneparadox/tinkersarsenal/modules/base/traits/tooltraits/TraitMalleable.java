package redstoneparadox.tinkersarsenal.modules.base.traits.tooltraits;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.shared.client.ParticleEffect;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.Set;

/**
 * Created by RedstoneParadox on 7/30/2018.
 */
public class TraitMalleable extends AbstractTrait {
    //If you're reading through this, just know that what you're about to see isn't pretty.

    /*Mending Moss:
    private static final int DELAY = (20 * 7 + 10)/2; // every 3.75s */

    public TraitMalleable() {
        super("malleable", 0xdc7613);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        /*Mending Moss:
        NBTTagCompound mendingTag = TinkerUtil.getModifierTag(tooltraits, "mending_moss");

        if (mendingTag != null) {
            if(!world.isRemote && entity instanceof EntityLivingBase) {
                // must be in hotbar or offhand for players
                if(entity instanceof EntityPlayer
                        && !InventoryPlayer.isHotbar(itemSlot)
                        && ((EntityPlayer) entity).getHeldItemOffhand() != tooltraits) {
                    return;
                }

                // needs to be repaired and is in hotbar or offhand
                if(needsRepair(tooltraits)) {
                    if(useXp(tooltraits, world, mendingTag)) {
                        ToolHelper.healTool(tooltraits, getDurabilityPerXP(tooltraits), (EntityLivingBase) entity);
                    }
                }
            }
        }
        */
    }

    /*More moss stuff:
    private boolean needsRepair(ItemStack itemStack) {
        return !itemStack.isEmpty() && itemStack.getItemDamage() > 0 && !ToolHelper.isBroken(itemStack);
    }

    private boolean useXp(ItemStack itemStack, World world, NBTTagCompound tagCompound) {
        ModifierTagHolder modtag = ModifierTagHolder.getModifier(itemStack, "mending_moss");
        ModMendingMoss.Data data = modtag.getTagData(ModMendingMoss.Data.class);

        if(data.storedXp > 0) {
            data.storedXp--;
            data.lastHeal = world.getTotalWorldTime();
            modtag.save();
            return true;
        }
        return false;
    }

    private int getDurabilityPerXP(ItemStack itemStack) {
        return 2 + ModifierTagHolder.getModifier(itemStack, "mending_moss").getTagData(ModMendingMoss.Data.class).level;
    }
    */

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        //Fiery:
        dealFireDamage(tool, player, target);

        //Shulking:
        NBTTagCompound shulkingTag = TinkerUtil.getModifierTag(tool, "shulking");
        if (shulkingTag != null) {
            int shulkingAmount = ModifierNBT.readInteger(shulkingTag).current;
            int shulkingDuration = ((shulkingAmount / 2) + 10 ) + Math.round((long) (((shulkingAmount / 2) + 10 ) * 0.1));

            target.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, shulkingDuration, 0));
        }

        //Webbed:
        NBTTagCompound webbedTag = TinkerUtil.getModifierTag(tool, "webbed");

        if (webbedTag != null) {
            int webbedLevel = ModifierNBT.readInteger(webbedTag).level;
            int webbedDuration = (webbedLevel * 20) + (webbedLevel * 2);

            target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, webbedDuration, 1));
        }
    }

    protected void dealFireDamage(ItemStack tool, EntityLivingBase attacker, EntityLivingBase target) {
        NBTTagCompound tag = TinkerUtil.getModifierTag(tool, "fiery");
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(tag);

        int duration = getFireDuration(data);
        target.setFire(duration);

        // 1/2 heart fire damage per 15
        float fireDamage = getFireDamage(data)/2;
        if(attackEntitySecondary(new EntityDamageSource("onFire", attacker).setFireDamage(), fireDamage, target, false, true)) {
            int count = Math.round(fireDamage);
            TinkerTools.proxy.spawnEffectParticle(ParticleEffect.Type.HEART_FIRE, target, count);
        }
    }

    private float getFireDamage(ModifierNBT.IntegerNBT data) {
        return (float) data.current / 15f;
    }

    private int getFireDuration(ModifierNBT.IntegerNBT data) {
        return 1 + data.current / 8;
    }

    //Knockback:
    @Override
    public float knockBack(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float knockback, float newKnockback, boolean isCritical) {
        return newKnockback + calcKnockback(TinkerUtil.getModifierTag(tool, "knockback"));
    }

    protected float calcKnockback(NBTTagCompound modifierTag) {
        ModifierNBT.IntegerNBT data = ModifierNBT.readInteger(modifierTag);
        return (float) data.current * 0.1f;
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
        //Necrotic:
        if(wasHit) {
            float amount = damageDealt * lifesteal(TinkerUtil.getModifierTag(tool, "necrotic"));
            if(amount > 0) {
                player.heal(amount);
            }
        }
    }

    //Necrotic:
    private float lifesteal(NBTTagCompound modifierNBT) {
        ModifierNBT data = new ModifierNBT(modifierNBT);
        return 0.05f * data.level;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {

        ModifierNBT.IntegerNBT hasteAmount = ModifierNBT.readInteger(rootCompound.getCompoundTag("haste"));
        ModifierNBT.IntegerNBT luckAmount = ModifierNBT.readInteger(rootCompound.getCompoundTag("luck"));
        ModifierNBT.IntegerNBT sharpAmount = ModifierNBT.readInteger(rootCompound.getCompoundTag("sharpness"));
        ModifierNBT.IntegerNBT beheadingAmount = ModifierNBT.readInteger(rootCompound.getCompoundTag("beheading"));
        ModifierNBT.IntegerNBT smiteAmount = ModifierNBT.readInteger(rootCompound.getCompoundTag("smite"));
        ModifierNBT.IntegerNBT baneAmount = ModifierNBT.readInteger(rootCompound.getCompoundTag("bane"));

        Set<Category> categories = ImmutableSet.copyOf(TagUtil.getCategories(rootCompound));
        boolean harvest = categories.contains(Category.HARVEST);
        boolean weapon = categories.contains(Category.WEAPON);
        boolean launcher = categories.contains(Category.LAUNCHER);

        //Apply the harvest version of the boosts.
        if (harvest) {
            if (hasteAmount != null) {
                return;
            }
            if (luckAmount != null) {
                return;
            }
            if (sharpAmount != null) {
                return;
            }
            if (beheadingAmount != null) {
                return;
            }
            if (smiteAmount != null) {
                return;
            }
            if (baneAmount != null) {
                return;
            }
        }
        //Apply the weapon version of the boosts.
        else if (weapon) {
            if (hasteAmount != null) {
                return;
            }
            if (luckAmount != null) {
                return;
            }
            if (sharpAmount != null) {
                return;
            }
            if (beheadingAmount != null) {
                return;
            }
            if (smiteAmount != null) {
                return;
            }
            if (baneAmount != null) {
                return;
            }
        }
        //Apply the launcher version of the boosts.
        else if (launcher) {
            if (hasteAmount != null) {
                return;
            }
            if (luckAmount != null) {
                return;
            }
            if (sharpAmount != null) {
                return;
            }
            if (beheadingAmount != null) {
                return;
            }
            if (smiteAmount != null) {
                return;
            }
            if (baneAmount != null) {
                return;
            }
        }

    }

    @Override
    public int getPriority() {
        //Lower priority to allow for everything else to get processed first.
        return 49;
    }

    /*@Override
    public List<String> getExtraInfo(ItemStack tooltraits, NBTTagCompound modifierTag) {
        String loc = String.format(LOC_Extra, "necrotic");
        float amount = lifesteal(modifierTag);

        return ImmutableList.of(Util.translateFormatted(loc, Util.dfPercent.format(amount)));
    }*/
}

package redstoneparadox.tinkersarsenal.entities;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;

/**
 * Created by RedstoneParadox on 8/3/2018.
 */
public class EntityBoomstickShot extends EntityProjectileBase {
    // animation
    public int roll = 0;
    public int rollSpeed = 80;

    public EntityBoomstickShot(World world) {
        super(world);
    }

    public EntityBoomstickShot(World world, double d, double d1, double d2) {
        super(world, d, d1, d2);
    }

    public EntityBoomstickShot(World world, EntityPlayer player, float speed, float inaccuracy, float power, ItemStack stack, ItemStack launchingStack) {
        super(world, player, speed, inaccuracy, power, stack, launchingStack);
    }

    @Override
    protected void onEntityHit(Entity entityHit) {
        super.onEntityHit(entityHit);
        if(!this.getEntityWorld().isRemote && entityHit instanceof EntityLivingBase) {
            EntityLivingBase entityLivingBaseHit = (EntityLivingBase) entityHit;
            entityLivingBaseHit.setArrowCountInEntity(entityLivingBaseHit.getArrowCountInEntity() + 1);
        }
    }

    @Override
    protected void playHitBlockSound(float speed, IBlockState state) {
        this.playSound(SoundEvents.ENTITY_SHULKER_HURT_CLOSED, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
    }

    @Override
    public void readSpawnData(ByteBuf data) {
        super.readSpawnData(data);

        // animation stuff, it sometimes rotates left
        int rollDir = rand.nextBoolean() ? -1 : 1;
        rollSpeed = (int)((getSpeed() * 80) / 3) * rollDir;
    }
}

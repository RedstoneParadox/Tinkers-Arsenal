package io.github.redstoneparadox.tinkersarsenal.events;

import io.github.redstoneparadox.tinkersarsenal.tools.ArsenalTools;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by RedstoneParadox on 8/2/2018.
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ArsenalRenderEvents {
    @SubscribeEvent
    public static void onEvent(RenderLivingEvent.Pre<EntityPlayer> event) {
        if (!(event.getEntity() instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.getEntity();
        EnumHand right = EnumHand.MAIN_HAND;
        EnumHand left = EnumHand.OFF_HAND;

        if (player instanceof EntityPlayerSP && player.getPrimaryHand() == EnumHandSide.LEFT) {
            right = EnumHand.OFF_HAND;
            left = EnumHand.MAIN_HAND;
        }

        if (event.getRenderer().getMainModel() instanceof ModelBiped) {
            if(isCarryingLoadedBoomstick(player, right)) {
                ((ModelBiped) event.getRenderer().getMainModel()).rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
            }

            else if(isCarryingLoadedBoomstick(player, left)) {
                ((ModelBiped) event.getRenderer().getMainModel()).leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
            }
        }
    }

    private static boolean isCarryingLoadedBoomstick(EntityPlayer player, EnumHand hand) {
        if (player.getHeldItem(hand).getItem() == ArsenalTools.boomstick) {
            return player.getHeldItem(hand).getTagCompound().getBoolean("Loaded");
        }
        else {
            return false;
        }
    }
}

package io.github.redstoneparadox.tinkersarsenal.misc;

import io.github.redstoneparadox.tinkersarsenal.ArsenalProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.common.TinkerNetwork;

/**
 * Created by RedstoneParadox on 8/3/2018.
 */
@Mod.EventBusSubscriber(modid = ArsenalProperties.MOD_ID)
public class ArsenalSounds {
    public static final SoundEvent BOOMSTICK_SHOT = sound("boomstick_shot");

    private static SoundEvent sound(String name) {
        ResourceLocation location = new ResourceLocation(ArsenalProperties.MOD_ID + ":" + name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        return event;
    }

    public static void playSoundForAll(Entity entity, SoundEvent sound, float volume, float pitch) {
        entity.getEntityWorld().playSound(null, entity.getPosition(), sound, entity.getSoundCategory(), volume, pitch);
    }

    public static void PlaySoundForPlayer(Entity entity, SoundEvent sound, float volume, float pitch) {
        if(entity instanceof EntityPlayerMP) {
            TinkerNetwork.sendPacket(entity, new SPacketSoundEffect(sound, entity.getSoundCategory(), entity.posX, entity.posY, entity.posZ, volume, pitch));
        }
    }

    @SubscribeEvent
    public static void registerSoundEvent(RegistryEvent.Register<SoundEvent> event) {
        IForgeRegistry<SoundEvent> registry = event.getRegistry();
        registry.register(BOOMSTICK_SHOT);
    }
}

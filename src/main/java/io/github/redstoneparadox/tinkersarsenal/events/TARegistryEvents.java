package io.github.redstoneparadox.tinkersarsenal.events;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import io.github.redstoneparadox.tinkersarsenal.TAProperties;
import io.github.redstoneparadox.tinkersarsenal.misc.TAConfig;
import io.github.redstoneparadox.tinkersarsenal.misc.TAMaterial;
import slimeknights.tconstruct.library.events.MaterialEvent;
import slimeknights.tconstruct.library.materials.Material;

/**
 * Created by RedstoneParadox on 8/26/2018.
 */
@Mod.EventBusSubscriber(modid = TAProperties.MOD_ID)
public class TARegistryEvents {
    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(TAProperties.MOD_ID))
        {
            ConfigManager.sync(TAProperties.MOD_ID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public void onMaterialRegistry(MaterialEvent.MaterialRegisterEvent event) {
        Material material = event.material;

        if (!(material instanceof TAMaterial) && TAConfig.isMaterialAllowed(material.getIdentifier())) {
            event.setCanceled(true);
        }
        event.setCanceled(false);
    }
}

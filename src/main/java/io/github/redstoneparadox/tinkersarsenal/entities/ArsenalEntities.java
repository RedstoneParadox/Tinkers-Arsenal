package io.github.redstoneparadox.tinkersarsenal.entities;

import io.github.redstoneparadox.tinkersarsenal.TinkersArsenal;
import io.github.redstoneparadox.tinkersarsenal.entities.rendering.RenderBoomstickShot;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.Util;

/**
 * Created by RedstoneParadox on 8/3/2018.
 */
public class ArsenalEntities {
    public static void init() {
        int id = 1;
        EntityRegistry.registerModEntity(Util.getResource("boomstick_shot"), EntityBoomstickShot.class, "boomstickShot", id += 1, TinkersArsenal.INSTANCE, 64, 1, false);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBoomstickShot.class, RenderBoomstickShot::new);
    }
}

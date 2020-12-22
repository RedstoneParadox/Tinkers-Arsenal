package redstoneparadox.tinkersarsenal.entities;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.entities.rendering.RenderBoomstickShot;
import slimeknights.tconstruct.library.Util;

/**
 * Created by RedstoneParadox on 8/3/2018.
 */
public class TAEntities {
    public static void init() {
        int id = 1;
        EntityRegistry.registerModEntity(Util.getResource("boomstick_shot"), EntityBoomstickShot.class, "boomstickShot", id++, TinkersArsenal.INSTANCE, 64, 1, false);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBoomstickShot.class, RenderBoomstickShot::new);
    }
}

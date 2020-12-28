package io.github.redstoneparadox.tinkersarsenal.entities.rendering;

import io.github.redstoneparadox.tinkersarsenal.entities.EntityBoomstickShot;
import net.minecraft.client.renderer.entity.RenderManager;
import slimeknights.tconstruct.library.client.renderer.RenderProjectileBase;

/**
 * Created by RedstoneParadox on 8/3/2018.
 */
public class RenderBoomstickShot extends RenderProjectileBase<EntityBoomstickShot> {
    public RenderBoomstickShot(RenderManager renderManager) {
        super(renderManager);
    }

    @Override
    protected void customCustomRendering(EntityBoomstickShot entity, double x, double y, double z, float entityYaw, float partialTicks) {
    }
}

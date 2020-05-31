package redstoneparadox.tinkersarsenal.entities.rendering;

import net.minecraft.client.renderer.entity.RenderManager;
import redstoneparadox.tinkersarsenal.entities.EntityBoomstickShot;
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

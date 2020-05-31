package redstoneparadox.tinkersarsenal.modules.arsenal.tools;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.tinkersarsenal.modules.arsenal.tools.ranged.AmmoBoomstickShot;
import redstoneparadox.tinkersarsenal.modules.arsenal.tools.ranged.ToolBoomstick;
import redstoneparadox.tinkersarsenal.modules.arsenal.tools.utility.ToolShears;
import redstoneparadox.tinkersarsenal.modules.base.tools.ToolsBase;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

/**
 * Created by RedstoneParadox on 7/31/2018.
 */

public class TATools extends ToolsBase{

    public static ToolCore boomstick;
    public static ToolCore boomstickShot;
    public static ToolCore shears;

    public static ToolPart boomstickBarrel;
    public static ToolPart boomstickHandle;
    public static ToolPart bayonet;
    public static ToolPart bullet;
    public static ToolPart bulletShell;

    @Override
    public void initToolParts(IForgeRegistry<Item> registry) {
        boomstickBarrel = registerToolPart(boomstickBarrel, "boomstick_barrel", 3, registry);
        boomstickHandle = registerToolPart(boomstickHandle, "boomstick_handle", 2, registry);
        bayonet = registerToolPart(bayonet, "bayonet", 2, registry);
        bullet = registerToolPart(bullet, "bullet", 1, registry);
        // bulletShell = registerToolPart(bulletShell, "bullet_shell", 1, registry);

        initTools(registry);
    }

    @Override
    public void initTools(IForgeRegistry<Item> registry) {
        boomstick = new ToolBoomstick();
        boomstickShot = new AmmoBoomstickShot();
        shears = new ToolShears();

        registerTool(boomstick, true, registry);
        registerTool(boomstickShot, true, registry);
        registerTool(shears, false, registry);

        registerToolBuilding();
    }

    @Override
    public void initToolGUIs() {
        ToolBuildGuiInfo boomstickInfo = new ToolBuildGuiInfo(boomstick);
        boomstickInfo.addSlotPosition(32 + 12, 41 + 12);
        boomstickInfo.addSlotPosition(32 - 12, 41 - 12);
        boomstickInfo.addSlotPosition(32 - 12, 41 + 12);
        TinkerRegistryClient.addToolBuilding(boomstickInfo);

        ToolBuildGuiInfo boomstickShotInfo = new ToolBuildGuiInfo(boomstickShot);
        boomstickShotInfo.addSlotPosition(32 - 12, 41 + 12);
        boomstickShotInfo.addSlotPosition(32 - (12 + 16), 41 + 12);
        TinkerRegistryClient.addToolBuilding(boomstickShotInfo);

        ToolBuildGuiInfo shearInfo = new ToolBuildGuiInfo(shears);
        shearInfo.addSlotPosition(32 - 12, 41 - 12); // top left
        shearInfo.addSlotPosition(32 - 12, 41 + 12); // bot right
        TinkerRegistryClient.addToolBuilding(shearInfo);
    }
}

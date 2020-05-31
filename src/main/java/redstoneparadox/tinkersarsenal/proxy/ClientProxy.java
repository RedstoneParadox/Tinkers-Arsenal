package redstoneparadox.tinkersarsenal.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import redstoneparadox.tinkersarsenal.entities.TAEntities;
import redstoneparadox.tinkersarsenal.events.TARenderEvents;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

/**
 * Created by RedstoneParadox on 6/10/2018.
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        switchboard.addSignal("initToolGUIs");
        super.preInit(e);
        TAEntities.initModels();
        MinecraftForge.EVENT_BUS.register(new TARenderEvents());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    }

    @Override
    public <T extends Item & IToolPart> void registerToolPartModel(T part) {
        ModelRegisterUtil.registerPartModel(part);
    }

    @Override
    public void registerToolModel(ToolCore toolCore) {
        ModelRegisterUtil.registerToolModel(toolCore);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        switchboard.sendSignal("initToolGUIs", null);
        switchboard.removeSignal("initToolGUIs");
    }
}

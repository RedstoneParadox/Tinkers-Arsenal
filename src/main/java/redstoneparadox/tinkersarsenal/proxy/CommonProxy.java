package redstoneparadox.tinkersarsenal.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.IForgeRegistry;
import redstoneparadox.libraryparadox.signals.Switchboard;
import redstoneparadox.tinkersarsenal.TinkersArsenal;
import redstoneparadox.tinkersarsenal.entities.TAEntities;
import redstoneparadox.tinkersarsenal.events.TARegistryEvents;
import redstoneparadox.tinkersarsenal.modules.ModuleDatabase;
import redstoneparadox.tinkersarsenal.modules.arsenal.ModuleArsenal;
import redstoneparadox.tinkersarsenal.modules.oredict.ModuleOre;
import redstoneparadox.tinkersarsenal.modules.thermalfoundation.ModuleTF;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.ToolCore;

import java.util.ArrayList;

/**
 * Created by RedstoneParadox on 6/10/2018.
 */
@Mod.EventBusSubscriber
public class CommonProxy {

    protected static Switchboard switchboard = new Switchboard();
    private static ModuleDatabase database = new ModuleDatabase();

    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new TARegistryEvents());

        //Module stuff:
        switchboard.addSignal("initModules");
        switchboard.addSignal("initTools");

        new ModuleArsenal("tinkersarsenal", switchboard, database);
        new ModuleOre("tinkersarsenal", switchboard, database);
        new ModuleTF("thermalfoundation", switchboard, database);

        ArrayList args = new ArrayList();
        args.add(Loader.isModLoaded("conarm"));

        switchboard.sendSignal("initModules", args);
        switchboard.removeSignal("initModules");

        database.cleanDatabase();

        TAEntities.init();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        ArrayList args = new ArrayList();
        args.add(registry);
        switchboard.sendSignal("initTools", args);
        switchboard.removeSignal("initTools");
    }

    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityEntry> event) {

    }

    public void registerModels() {
        if(Loader.instance().hasReachedState(LoaderState.INITIALIZATION)) {
            TinkersArsenal.logger.error(
                    "Proxy.registerModels has to be called during preInit. Otherwise the models wont be found on first load.");
        }
    }


    public <T extends Item & IToolPart> void registerToolPartModel(T part) {

    }

    public void registerToolModel(ToolCore toolCore) {

    }
}
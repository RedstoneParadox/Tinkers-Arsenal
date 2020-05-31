package redstoneparadox.tinkersarsenal;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import redstoneparadox.tinkersarsenal.proxy.CommonProxy;

@Mod(
        modid = TAProperties.MOD_ID,
        name = TAProperties.MOD_NAME,
        version = TAProperties.VERSION,
        dependencies = "required-after:tconstruct@[1.12.2-2.10.1.87,);" +
                "after:conarm;" +
                "after:tinkerscompendium;" +
                "after:plustic;" +
                "after:moartinkers;" +
                "after:thermalfoundation;",
        useMetadata = true
)
public class TinkersArsenal {


    public static Logger logger;

    @SidedProxy(clientSide = TAProperties.CLIENT_PROXY, serverSide = TAProperties.SERVER_PROXY)
    public static CommonProxy proxy;

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(TAProperties.MOD_ID)
    public static TinkersArsenal INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        ConfigManager.sync(TAProperties.MOD_ID, Config.Type.INSTANCE);
        proxy.preInit(event);
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
}

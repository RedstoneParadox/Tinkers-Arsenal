package io.github.redstoneparadox.tinkersarsenal.misc;

import io.github.redstoneparadox.tinkersarsenal.ArsenalProperties;
import io.github.redstoneparadox.tinkersarsenal.TinkersArsenal;
import net.minecraftforge.common.config.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RedstoneParadox on 8/23/2018.
 */
@Config(modid = ArsenalProperties.MOD_ID, type = Config.Type.INSTANCE, name = "TinkersArsenal")
public class ArsenalConfig {
    //Misc:
    @Config.Ignore
    private static int version = 1;

    @Config.Ignore
    private static final String disableText = "Set to false to disable ";
    @Config.Ignore
    private static final String shaftText  = " as a shaft material.";
    @Config.Ignore
    private static final String notImp = "(Not implemented yet!)";
    @Config.Ignore
    private static final String setCompat = "Enable/disable material compatibility for ";

    @Config.LangKey("category.misc.name")
    @Config.Comment("Like it says on the tin.")
    public static final miscOptions miscOptions = new miscOptions();
    @Config.LangKey("category.base.name")
    @Config.Comment("Enable/disable materials added by Tinker's Arsenal")
    public static final BaseCategory baseCategory = new BaseCategory();
    @Config.LangKey("category.ore.name")
    @Config.Comment(setCompat + "common modded materials.")
    public static final OreDictCategory oreDictCategory = new OreDictCategory();
    @Config.LangKey("category.foundation.name")
    @Config.Comment(setCompat + "Thermal Foundation")
    public static final TECategory teCategory = new TECategory();

    public static class miscOptions {

    }

    public static class BaseCategory {
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Gold" + notImp})
        public boolean gold = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Diamond"})
        public boolean diamond = true;
    }

    public static class OreDictCategory {
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Tin" + notImp})
        public boolean tin = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Aluminum" + notImp})
        public boolean aluminum = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Constantan" + notImp})
        public boolean constantan = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Nickel" + notImp})
        public boolean nickel = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Platinum" + notImp})
        public boolean platinum = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Iridium" + notImp})
        public boolean iridium = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Mithril/Mana Infused Metal" + notImp})
        public boolean mithril = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Invar" + notImp})
        public boolean invar = true;
    }

    public static class TECategory {
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Luminum" + notImp})
        public boolean luminum = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Signalium" + notImp})
        public boolean signalium = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Enderium" + notImp})
        public boolean enderium = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Blizz Rod" + shaftText + notImp})
        public boolean blizz = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Blitz Rod" + shaftText + notImp})
        public boolean blitz = true;
        @Config.RequiresMcRestart
        @Config.Comment({disableText + "Baltz Rod" + shaftText + notImp})
        public boolean baltz = true;
    }


    //Config access stuff:
    public static boolean isMaterialAllowed(String material) {
        if (getMaterialTypes().containsKey(material)) {
            return getMaterialTypes().get(material);
        }
        TinkersArsenal.logger.error("Could not find config option for " + material + "!");
        return false;
    }

    private static Map<String, Boolean> getMaterialTypes() {
        Map<String, Boolean> map = new HashMap<>();
        //Base materials:
        map.put("gold", baseCategory.gold);
        map.put("diamond", baseCategory.diamond);
        //Common ore-dict materials:
        map.put("tin", oreDictCategory.tin);
        map.put("aluminum", oreDictCategory.aluminum);
        map.put("constantan", oreDictCategory.constantan);
        map.put("nickel", oreDictCategory.nickel);
        map.put("platinum", oreDictCategory.platinum);
        map.put("iridium", oreDictCategory.iridium);
        map.put("manaInfusedMetal", oreDictCategory.mithril);
        map.put("mithril", oreDictCategory.mithril);
        map.put("invar", oreDictCategory.invar);
        //Thermal Foundation Materials:
        map.put("luminum", teCategory.luminum);
        map.put("signalium", teCategory.signalium);
        map.put("enderium", teCategory.enderium);
        //Thermal Foundation Shaft Materials:
        map.put("blizz_rod", teCategory.blizz);
        map.put("blitz_rod", teCategory.blitz);
        map.put("baltz_rod", teCategory.baltz);
        return map;
    }
}

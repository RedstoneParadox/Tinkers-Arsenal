package redstoneparadox.tinkersarsenal;

import com.google.common.collect.ImmutableList;

/**
 * Created by RedstoneParadox on 10/20/2018.
 */
public class TAProperties {
    public static final String MOD_ID = "tinkersarsenal";
    public static final String MOD_NAME = "Tinkers' Arsenal";
    public static final String VERSION = "1.0.0";
    public static final String DEPENDENCIES = dependencies();
    public static final String CLIENT_PROXY = "redstoneparadox.tinkersarsenal.proxy.ClientProxy";
    public static final String SERVER_PROXY = "redstoneparadox.tinkersarsenal.proxy.ServerProxy";

    private static ImmutableList<String> DEPENDENCY_IDS = ImmutableList.<String>builder()
            .add("appliedenergistics2")
            .add("astralsorcery")
            .add("botania")
            .add("conarm")
            .add("mekanism")
            .add("moartinkers")
            .add("plustic")
            .add("tinkerscompendium")
            .build();

    private static String dependencies() {
        StringBuilder dependencyString =
                new StringBuilder("required-after:tconstruct@[1.12.2-2.10.1.87,);");
        assert DEPENDENCY_IDS != null;
        for (int i = 0; i < DEPENDENCY_IDS.size(); i ++) {
            dependencyString.append("after:").append(DEPENDENCY_IDS.get(i)).append(";");
        }

        return dependencyString.toString();
    }
}

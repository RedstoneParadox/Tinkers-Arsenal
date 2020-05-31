package redstoneparadox.tinkersarsenal.misc;

import slimeknights.tconstruct.library.materials.Material;

/**
 * Created by RedstoneParadox on 8/23/2018.
 */
public class TAMaterial extends Material {

    public static boolean registered = false;

    public TAMaterial(String identifier, int textColor) {
        super(identifier, textColor);
    }

    public boolean isRegistered() {
        if (registered) {
            return true;
        }
        return false;
    }


    public void setRegistered() {
        registered = true;
    }
}

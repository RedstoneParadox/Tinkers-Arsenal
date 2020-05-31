package redstoneparadox.tinkersarsenal.modules;

import redstoneparadox.tinkersarsenal.misc.TAMaterial;
import redstoneparadox.tinkersarsenal.TinkersArsenal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RedstoneParadox on 9/11/2018.
 */
public class ModuleDatabase {

    private Map<String, TAMaterial> materials = new HashMap<>();

    public void addMaterial(TAMaterial material) {
        if (!materials.containsKey(material.getIdentifier())) {
            materials.put(material.getIdentifier(), material);
        }
        else {
            TinkersArsenal.logger.error("Material " + material + " was already registered to the database!");
        }
    }

    public TAMaterial getMaterial(String id) {
        if (materials.get(id) != null) {
            return materials.get(id);
        }
        else {
            TinkersArsenal.logger.error("Material with id " + id + " does not exist! Returning dummy material to prevent crashing!");
            return new TAMaterial(id + "_dummy", 0);
        }
    }

    public void cleanDatabase() {
        materials.clear();
    }
}

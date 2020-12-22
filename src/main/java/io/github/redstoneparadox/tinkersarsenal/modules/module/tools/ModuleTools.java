package io.github.redstoneparadox.tinkersarsenal.modules.module.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import io.github.redstoneparadox.tinkersarsenal.TinkersArsenal;
import io.github.redstoneparadox.tinkersarsenal.geometry.Vector2;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RedstoneParadox on 9/12/2018.
 */
public class ModuleTools {
    public static final List<ToolCore> tools = new ArrayList<>();
    public static final List<IToolPart> toolParts = new ArrayList<>();

    public void initToolParts(IForgeRegistry<Item> registry) {
    }

    protected static ToolPart toolPart(int cost) {
        return new ToolPart(Material.VALUE_Ingot * cost);
    }

    protected static ToolPart registerToolPart(ToolPart part, String name, int cost, IForgeRegistry<Item> registry) {
        part = new ToolPart(Material.VALUE_Ingot * cost);
        part.setRegistryName(name).setTranslationKey(name);
        registry.register(part);
        TinkerRegistry.registerToolPart(part);
        TinkersArsenal.proxy.registerToolPartModel(part);
        toolParts.add(part);

        return part;
    }

    public void initTools(IForgeRegistry<Item> registry) {

    }

    protected static void registerTool(ToolCore toolCore, boolean forge, IForgeRegistry<Item> registry) {
        registry.register(toolCore);
        if (forge) {
            TinkerRegistry.registerToolForgeCrafting(toolCore);
        }
        else {
            TinkerRegistry.registerToolCrafting(toolCore);
        }
        TinkersArsenal.proxy.registerToolModel(toolCore);
        tools.add(toolCore);
    }

    @SideOnly(Side.CLIENT)
    public void initToolGUIs() {
    }

    protected static void registerToolGUI(ToolCore toolCore, ArrayList<Vector2> vector2s) {
        ToolBuildGuiInfo info = new ToolBuildGuiInfo(toolCore);

        for (int i = 0; i < vector2s.size(); i++) {
            int xPos = vector2s.get(i).getXLength();
            int yPos = vector2s.get(i).getYLength();

            info.addSlotPosition(xPos, yPos);
        }
        TinkerRegistryClient.addToolBuilding(info);
    }

    protected static void registerToolBuilding() {
        for (final IToolPart part: toolParts) {
            for (final ToolCore tool: tools) {
                for (final PartMaterialType pmt: tool.getRequiredComponents()) {
                    if (pmt.getPossibleParts().contains(part)) {
                        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), (Item)part));
                    }
                }
            }
        }
    }
}
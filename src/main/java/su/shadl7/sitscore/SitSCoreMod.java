package su.shadl7.sitscore;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import su.shadl7.sitscore.worldgen.WorldGenStartStruct;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class SitSCoreMod {

    public static Logger LOGGER = Logger.getLogger(Tags.MOD_ID);

    public static List<ItemStack> patterns;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PacketHandler.registerPackets();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new WorldGenStartStruct(), 10);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        generatePatternCache();
    }

    private void generatePatternCache() {
        patterns = ImmutableList.copyOf(TinkerRegistry.getStencilTableCrafting());
    }
}

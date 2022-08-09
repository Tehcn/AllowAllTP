package dev.tehcn.allowalltp;

import dev.tehcn.allowalltp.utils.Chat;
import net.minecraft.command.CommandHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.fml.common.Mod.EventHandler;

import java.util.logging.Logger;

@Mod(
        modid = AllowAllTP.MOD_ID,
        name = AllowAllTP.MOD_NAME,
        version = AllowAllTP.VERSION,
        serverSideOnly = true,
        acceptableRemoteVersions = "*"
)
public class AllowAllTP {

    public static final String MOD_ID = "allowalltp";
    public static final String MOD_NAME = "AllowAllTP";
    public static final String VERSION = "1.0.0";


    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance
    public static AllowAllTP INSTANCE;

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }

}

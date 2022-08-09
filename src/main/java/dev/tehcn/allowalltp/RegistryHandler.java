package dev.tehcn.allowalltp;

import dev.tehcn.allowalltp.commands.ATP_Command;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class RegistryHandler {

    public static void serverRegistries(FMLServerStartingEvent event) {
        event.registerServerCommand(new ATP_Command());
    }

}

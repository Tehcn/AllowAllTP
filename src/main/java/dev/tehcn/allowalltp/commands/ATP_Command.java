package dev.tehcn.allowalltp.commands;

import net.minecraft.client.gui.spectator.categories.TeleportToPlayer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class ATP_Command extends CommandBase {
    public ATP_Command() {}

    @Override
    public String getName() {
        return "atp";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(args.length > 2) throw new CommandException("commands.teleport.usage");
        if(args.length == 1) {
            EntityPlayer player = (EntityPlayer) sender;
            boolean targetExists = Arrays.stream(server.getPlayerList().getOnlinePlayerNames()).filter((s -> s == args[0])).toArray().length > 0;
            if(targetExists) {
                EntityPlayer target = server.getPlayerList().getPlayerByUsername(args[0]);
                Vec3d targetPosition = target.getPositionVector();
                player.setPosition(targetPosition.x, targetPosition.y, targetPosition.z);
            }
        } else if(args.length == 2) {
            boolean targetsExists =
                Arrays.stream(server.getPlayerList().getOnlinePlayerNames()).filter((s -> s == args[0])).toArray().length > 0 &&
                Arrays.stream(server.getPlayerList().getOnlinePlayerNames()).filter((s -> s == args[1])).toArray().length > 0;

            if(targetsExists) {
                EntityPlayer player = server.getPlayerList().getPlayerByUsername(args[0]);
                Vec3d targetPosition = server.getPlayerList().getPlayerByUsername(args[1]).getPositionVector();
                player.setPosition(targetPosition.x, targetPosition.y, targetPosition.z);
            }
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> players = Arrays.asList(server.getPlayerList().getOnlinePlayerNames());
        if(args.length >= 2) return null;
        return players;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}

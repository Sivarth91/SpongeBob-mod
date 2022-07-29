package fr.sivarth.sbm.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.sivarth.sbm.SBM;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;

public class ReturnHomeCommand {

    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes((command) -> {
            return returnHome(command.getSource());
        })));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrException();
        boolean hasHomePos = player.getPersistentData().getIntArray(SBM.MODID + "homepos").length != 0;

        if (hasHomePos) {
            int[] playerPos = player.getPersistentData().getIntArray(SBM.MODID + "homepos");
            player.setPosAndOldPos(playerPos[0], playerPos[1], playerPos[2]);
            source.sendSuccess(new StringTextComponent("Player return home!"), true);
            return 1;
        } else {
            source.sendSuccess(new StringTextComponent("No position has been set"), true);
            return -1;
        }
    }

}

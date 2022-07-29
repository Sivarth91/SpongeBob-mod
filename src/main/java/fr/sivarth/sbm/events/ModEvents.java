package fr.sivarth.sbm.events;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.commands.ReturnHomeCommand;
import fr.sivarth.sbm.commands.SetHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = SBM.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone cloneEvent) {
        if (!cloneEvent.getOriginal().getCommandSenderWorld().isClientSide()) {
            cloneEvent.getPlayer().getPersistentData().putIntArray(SBM.MODID + "homepos", cloneEvent.getOriginal().getPersistentData().getIntArray(SBM.MODID + "homepos"));
        }
    }

}

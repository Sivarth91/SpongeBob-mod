package fr.sivarth.sbm.tileentity;

import fr.sivarth.sbm.SBM;
import fr.sivarth.sbm.block.ModBlocks;
import fr.sivarth.sbm.tileentity.custom.CashRegisterTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SBM.MODID);

    public static void registerTileEntity(IEventBus bus) {
        TILE_ENTITIES.register(bus);
    }

    public static RegistryObject<TileEntityType<CashRegisterTile>> CASH_REGISTER_TILE = TILE_ENTITIES.register("cash_register_tile", () -> TileEntityType.Builder.of(CashRegisterTile::new, ModBlocks.CASH_REGISTER.get()).build(null));



}

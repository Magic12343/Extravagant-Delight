package net.magicvt.extravagantdelight.compat;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.compat.fluid.StarfruitWineFluidType;
import net.magicvt.extravagantdelight.compat.fluid.QuinceWineFluidType;
import net.magicvt.extravagantdelight.compat.fluid.SloeBerryWineFluidType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HHCompatFluids {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ExtravagantDelight.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, ExtravagantDelight.MOD_ID);

    public static RegistryObject<FluidType> STARFRUIT_WINE_TYPE;
    public static RegistryObject<FlowingFluid> STARFRUIT_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_STARFRUIT_WINE;

    public static RegistryObject<FluidType> QUINCE_WINE_TYPE;
    public static RegistryObject<FlowingFluid> QUINCE_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_QUINCE_WINE;

    public static RegistryObject<FluidType> SLOE_BERRY_WINE_TYPE;
    public static RegistryObject<FlowingFluid> SLOE_BERRY_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_SLOE_BERRY_WINE;

    public static void registerCompat() {
        if (!ModList.get().isLoaded("hearthandharvest")) return;

        STARFRUIT_WINE_TYPE = FLUID_TYPES.register("starfruit_wine", StarfruitWineFluidType::new);
        ForgeFlowingFluid.Properties starfruitProps = new ForgeFlowingFluid.Properties(
                STARFRUIT_WINE_TYPE,
                () -> STARFRUIT_WINE.get(),
                () -> FLOWING_STARFRUIT_WINE.get()
        );
        STARFRUIT_WINE = FLUIDS.register("starfruit_wine", () -> new ForgeFlowingFluid.Source(starfruitProps));
        FLOWING_STARFRUIT_WINE = FLUIDS.register("flowing_starfruit_wine", () -> new ForgeFlowingFluid.Flowing(starfruitProps));

        QUINCE_WINE_TYPE = FLUID_TYPES.register("quince_wine", QuinceWineFluidType::new);
        ForgeFlowingFluid.Properties quinceProps = new ForgeFlowingFluid.Properties(
                QUINCE_WINE_TYPE,
                () -> QUINCE_WINE.get(),
                () -> FLOWING_QUINCE_WINE.get()
        );
        QUINCE_WINE = FLUIDS.register("quince_wine", () -> new ForgeFlowingFluid.Source(quinceProps));
        FLOWING_QUINCE_WINE = FLUIDS.register("flowing_quince_wine", () -> new ForgeFlowingFluid.Flowing(quinceProps));

        SLOE_BERRY_WINE_TYPE = FLUID_TYPES.register("sloe_berry_wine", SloeBerryWineFluidType::new);
        ForgeFlowingFluid.Properties sloeProps = new ForgeFlowingFluid.Properties(
                SLOE_BERRY_WINE_TYPE,
                () -> SLOE_BERRY_WINE.get(),
                () -> FLOWING_SLOE_BERRY_WINE.get()
        );
        SLOE_BERRY_WINE = FLUIDS.register("sloe_berry_wine", () -> new ForgeFlowingFluid.Source(sloeProps));
        FLOWING_SLOE_BERRY_WINE = FLUIDS.register("flowing_sloe_berry_wine", () -> new ForgeFlowingFluid.Flowing(sloeProps));
    }
}

package net.magicvt.extravagantdelight.compat;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.compat.fluid.StarfruitWineFluidType;
import net.magicvt.extravagantdelight.compat.fluid.QuinceWineFluidType;
import net.magicvt.extravagantdelight.compat.fluid.SloeBerryWineFluidType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HHCompatFluids {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ExtravagantDelight.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, ExtravagantDelight.MOD_ID);

    public static RegistryObject<FluidType> STARFRUIT_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> STARFRUIT_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_STARFRUIT_WINE;
    public static ForgeFlowingFluid.Properties STARFRUIT_WINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> QUINCE_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> QUINCE_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_QUINCE_WINE;
    public static ForgeFlowingFluid.Properties QUINCE_WINE_FLUID_PROPERTIES;

    public static RegistryObject<FluidType> SLOE_BERRY_WINE_FLUID_TYPE;
    public static RegistryObject<FlowingFluid> SLOE_BERRY_WINE;
    public static RegistryObject<FlowingFluid> FLOWING_SLOE_BERRY_WINE;
    public static ForgeFlowingFluid.Properties SLOE_BERRY_WINE_FLUID_PROPERTIES;

    public static void registerCompat() {
        if (ModList.get().isLoaded("hearthandharvest")) {

            STARFRUIT_WINE_FLUID_TYPE = FLUID_TYPES.register("starfruit_wine", StarfruitWineFluidType::new);
            STARFRUIT_WINE = FLUIDS.register("starfruit_wine", () -> new ForgeFlowingFluid.Source(HHCompatFluids.STARFRUIT_WINE_FLUID_PROPERTIES));
            FLOWING_STARFRUIT_WINE = FLUIDS.register("flowing_starfruit_wine", () -> new ForgeFlowingFluid.Flowing(HHCompatFluids.STARFRUIT_WINE_FLUID_PROPERTIES));
            STARFRUIT_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(STARFRUIT_WINE_FLUID_TYPE, STARFRUIT_WINE, FLOWING_STARFRUIT_WINE);

            QUINCE_WINE_FLUID_TYPE = FLUID_TYPES.register("quince_wine", QuinceWineFluidType::new);
            QUINCE_WINE = FLUIDS.register("quince_wine", () -> new ForgeFlowingFluid.Source(HHCompatFluids.QUINCE_WINE_FLUID_PROPERTIES));
            FLOWING_QUINCE_WINE = FLUIDS.register("flowing_quince_wine", () -> new ForgeFlowingFluid.Flowing(HHCompatFluids.QUINCE_WINE_FLUID_PROPERTIES));
            QUINCE_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(QUINCE_WINE_FLUID_TYPE, QUINCE_WINE, FLOWING_QUINCE_WINE);

            SLOE_BERRY_WINE_FLUID_TYPE = FLUID_TYPES.register("sloe_berry_wine", SloeBerryWineFluidType::new);
            SLOE_BERRY_WINE = FLUIDS.register("sloe_berry_wine", () -> new ForgeFlowingFluid.Source(HHCompatFluids.SLOE_BERRY_WINE_FLUID_PROPERTIES));
            FLOWING_SLOE_BERRY_WINE = FLUIDS.register("flowing_sloe_berry_wine", () -> new ForgeFlowingFluid.Flowing(HHCompatFluids.SLOE_BERRY_WINE_FLUID_PROPERTIES));
            SLOE_BERRY_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(SLOE_BERRY_WINE_FLUID_TYPE, SLOE_BERRY_WINE, FLOWING_SLOE_BERRY_WINE);
        }
    }
}

package net.magicvt.extravagantdelight.compat;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.compat.fluid.PinkGinFluidType;
import net.magicvt.extravagantdelight.compat.fluid.SloeGinFluidType;
import net.magicvt.extravagantdelight.compat.fluid.SloeVodkaFluidType;
import net.magicvt.extravagantdelight.compat.fluid.StarfruitPalomaFluidType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BCCompatFluids {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ExtravagantDelight.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, ExtravagantDelight.MOD_ID);

    public static RegistryObject<FluidType> STARFRUIT_PALOMA_TYPE;
    public static RegistryObject<FlowingFluid> STARFRUIT_PALOMA;
    public static RegistryObject<FlowingFluid> FLOWING_STARFRUIT_PALOMA;

    public static RegistryObject<FluidType> PINK_GIN_TYPE;
    public static RegistryObject<FlowingFluid> PINK_GIN;
    public static RegistryObject<FlowingFluid> FLOWING_PINK_GIN;

    public static RegistryObject<FluidType> SLOE_GIN_TYPE;
    public static RegistryObject<FlowingFluid> SLOE_GIN;
    public static RegistryObject<FlowingFluid> FLOWING_SLOE_GIN;

    public static RegistryObject<FluidType> SLOE_VODKA_TYPE;
    public static RegistryObject<FlowingFluid> SLOE_VODKA;
    public static RegistryObject<FlowingFluid> FLOWING_SLOE_VODKA;

    public static void registerCompat() {
        if (!ModList.get().isLoaded("brewinandchewin")) return;

        STARFRUIT_PALOMA_TYPE = FLUID_TYPES.register("starfruit_paloma", StarfruitPalomaFluidType::new);
        ForgeFlowingFluid.Properties starfruitpalomaProps = new ForgeFlowingFluid.Properties(
                STARFRUIT_PALOMA_TYPE,
                () -> STARFRUIT_PALOMA.get(),
                () -> FLOWING_STARFRUIT_PALOMA.get()
        );
        STARFRUIT_PALOMA = FLUIDS.register("starfruit_paloma", () -> new ForgeFlowingFluid.Source(starfruitpalomaProps));
        FLOWING_STARFRUIT_PALOMA = FLUIDS.register("flowing_starfruit_paloma", () -> new ForgeFlowingFluid.Flowing(starfruitpalomaProps));

        PINK_GIN_TYPE = FLUID_TYPES.register("pink_gin", PinkGinFluidType::new);
        ForgeFlowingFluid.Properties pinkginProps = new ForgeFlowingFluid.Properties(
                PINK_GIN_TYPE,
                () -> PINK_GIN.get(),
                () -> FLOWING_PINK_GIN.get()
        );
        PINK_GIN = FLUIDS.register("pink_gin", () -> new ForgeFlowingFluid.Source(pinkginProps));
        FLOWING_PINK_GIN = FLUIDS.register("flowing_pink_gin", () -> new ForgeFlowingFluid.Flowing(pinkginProps));

        SLOE_GIN_TYPE = FLUID_TYPES.register("sloe_gin", SloeGinFluidType::new);
        ForgeFlowingFluid.Properties sloeginProps = new ForgeFlowingFluid.Properties(
                SLOE_GIN_TYPE,
                () -> SLOE_GIN.get(),
                () -> FLOWING_SLOE_GIN.get()
        );
        SLOE_GIN = FLUIDS.register("sloe_gin", () -> new ForgeFlowingFluid.Source(sloeginProps));
        FLOWING_SLOE_GIN = FLUIDS.register("flowing_sloe_gin", () -> new ForgeFlowingFluid.Flowing(sloeginProps));

        SLOE_VODKA_TYPE = FLUID_TYPES.register("sloe_vodka", SloeVodkaFluidType::new);
        ForgeFlowingFluid.Properties sloevodkaProps = new ForgeFlowingFluid.Properties(
                SLOE_VODKA_TYPE,
                () -> SLOE_VODKA.get(),
                () -> FLOWING_SLOE_VODKA.get()
        );
        SLOE_VODKA = FLUIDS.register("sloe_vodka", () -> new ForgeFlowingFluid.Source(sloevodkaProps));
        FLOWING_SLOE_VODKA = FLUIDS.register("flowing_sloe_vodka", () -> new ForgeFlowingFluid.Flowing(sloevodkaProps));
    }
}

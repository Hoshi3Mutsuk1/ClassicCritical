package moe.mutsuki.classiccritical;

import moe.mutsuki.classiccritical.attributes.Attributes;
import moe.mutsuki.classiccritical.attributes.PlayerAttributes;
import moe.mutsuki.classiccritical.config.Config;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ClassicCritical.MODID)
public class ClassicCritical {
    public static final String MODID = "classiccritical";
    public ClassicCritical() {
        Attributes.ATTRIBUTE.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "classic_critical.toml");
        FMLJavaModLoadingContext.get().getModEventBus().addListener(PlayerAttributes::attachPlayerAttributes);
        MinecraftForge.EVENT_BUS.addListener(PlayerAttributes::setPlayerAttributeDefaultValue);
    }
}

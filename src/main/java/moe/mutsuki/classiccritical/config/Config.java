package moe.mutsuki.classiccritical.config;

import net.minecraftforge.common.ForgeConfigSpec;
public class Config {
    public static final ForgeConfigSpec SPEC;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        SPEC = configBuilder.build();
    }
    public static ForgeConfigSpec.DoubleValue DEFAULT_CRIT_CHANCE;
    public static ForgeConfigSpec.DoubleValue DEFAULT_CRIT_DAMAGE;
    public static ForgeConfigSpec.BooleanValue ENABLE_VANILLA_CRIT_BOOST;
    public static ForgeConfigSpec.IntValue OPERATION;
    public static ForgeConfigSpec.DoubleValue VANILLA_CRIT_CHANCE_BOOST;
    public static ForgeConfigSpec.DoubleValue VANILLA_CRIT_DAMAGE_BOOST;
    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Base Value");
        DEFAULT_CRIT_CHANCE = builder.defineInRange("defaultCritChance", 0.25D, -2048.0D, 1.0D);
        DEFAULT_CRIT_DAMAGE = builder.defineInRange("defaultCritDamage", 0.5D, 0.0D, 2048.0D);
        builder.pop();

        builder.comment("Applied when vanilla critical hit requirements are met");
        builder.push("Vanilla Critical Modifiers");
        ENABLE_VANILLA_CRIT_BOOST = builder.define("enableVanillaCritBoost", false);
        OPERATION = builder.defineInRange("operation", 2, 0,2);
        VANILLA_CRIT_CHANCE_BOOST = builder.defineInRange("critChanceBoost", 0.25D, -2048.0D, 1.0D);
        VANILLA_CRIT_DAMAGE_BOOST = builder.defineInRange("critDamageBoost", 0.25D, -2048.0D, 2048.0D);
        builder.pop();
    }
}

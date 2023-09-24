package moe.mutsuki.classiccritical.attributes;

import moe.mutsuki.classiccritical.ClassicCritical;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class Attributes {
    public static final DeferredRegister<Attribute> ATTRIBUTE = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, ClassicCritical.MODID);
    public static final RegistryObject<Attribute> CRIT_CHANCE = ATTRIBUTE.register("player.crit_chance", () -> new RangedAttribute("attribute.name.player.crit_chance", 0.25D, -2048.0D, 1.0D).setSyncable(true));
    public static final RegistryObject<Attribute> CRIT_DAMAGE = ATTRIBUTE.register("player.crit_damage", () -> new RangedAttribute("attribute.name.player.crit_damage", 0.5D, 0.0D, 2048.0D).setSyncable(true));
}

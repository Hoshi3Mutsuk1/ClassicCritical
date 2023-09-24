package moe.mutsuki.classiccritical.mixin;

import moe.mutsuki.classiccritical.attributes.Attributes;
import moe.mutsuki.classiccritical.config.Config;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;

public class CritHandle {
    public static AttributeModifier CHD_MODIFIER_VANILLA = new AttributeModifier(
            "Vanilla Critical Boost",
            Config.VANILLA_CRIT_DAMAGE_BOOST.get(),
            AttributeModifier.Operation.fromValue(Config.OPERATION.get()));

    public static AttributeModifier CHC_MODIFIER_VANILLA = new AttributeModifier(
            "Vanilla Critical Boost",
            Config.VANILLA_CRIT_CHANCE_BOOST.get(),
            AttributeModifier.Operation.fromValue(Config.OPERATION.get()));

    public static CriticalHitEvent onAttack(Player player, Entity target, boolean vanillaCritical) {
        if (Config.ENABLE_VANILLA_CRIT_BOOST.get() && vanillaCritical){
            setVanillaCrit(player);
        }

        var crit_damage = player.getAttributeValue(Attributes.CRIT_DAMAGE.get());
        var crit_chance = player.getAttributeValue(Attributes.CRIT_CHANCE.get());

        var flag = player.getRandom().nextDouble() <= crit_chance;

        CriticalHitEvent critResult = new CriticalHitEvent(player, target, !flag ? 1.0F : (float) (1.0F + crit_damage), flag);
        MinecraftForge.EVENT_BUS.post(critResult);

        if (critResult.getResult() == Event.Result.ALLOW || (flag && critResult.getResult() == Event.Result.DEFAULT)) {
            return critResult;
        }
        return null;
    }

    public static void setVanillaCrit(Player player) {
        var chd_instance = player.getAttribute(Attributes.CRIT_DAMAGE.get());
        var chc_instance = player.getAttribute(Attributes.CRIT_CHANCE.get());

        if (chd_instance != null && chc_instance != null){
            chd_instance.addTransientModifier(CHD_MODIFIER_VANILLA);
            chc_instance.addTransientModifier(CHC_MODIFIER_VANILLA);
        }
    }
}


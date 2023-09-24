package moe.mutsuki.classiccritical.attributes;

import moe.mutsuki.classiccritical.config.Config;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerAttributes {
    public static void attachPlayerAttributes(EntityAttributeModificationEvent event) {
        if (!event.has(EntityType.PLAYER, Attributes.CRIT_DAMAGE.get())) {
            event.add(EntityType.PLAYER,
                    Attributes.CRIT_DAMAGE.get()
            );
        }
        if (!event.has(EntityType.PLAYER, Attributes.CRIT_CHANCE.get())) {
            event.add(EntityType.PLAYER,
                    Attributes.CRIT_CHANCE.get()
            );
        }
    }
    public static void setPlayerAttributeDefaultValue(PlayerEvent.PlayerLoggedInEvent event) {
        event.getEntity().getAttribute(Attributes.CRIT_CHANCE.get()).setBaseValue(Config.DEFAULT_CRIT_CHANCE.get());
        event.getEntity().getAttribute(Attributes.CRIT_DAMAGE.get()).setBaseValue(Config.DEFAULT_CRIT_DAMAGE.get());
    }
}

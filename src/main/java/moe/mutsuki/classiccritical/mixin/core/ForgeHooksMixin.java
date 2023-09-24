package moe.mutsuki.classiccritical.mixin.core;

import moe.mutsuki.classiccritical.mixin.CritHandle;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ForgeHooks.class)
public abstract class ForgeHooksMixin {
    /**
     * @author Hoshi3Mutsuk1
     * @reason Modified the vanilla critical hit requirements
     */
    @Overwrite(remap = false)
    @Nullable
    public static CriticalHitEvent getCriticalHit(Player player, Entity target, boolean vanillaCritical, float damageModifier) {
        return CritHandle.onAttack(player,target,vanillaCritical);
    }
}

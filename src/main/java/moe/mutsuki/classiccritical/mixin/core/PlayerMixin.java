package moe.mutsuki.classiccritical.mixin.core;

import moe.mutsuki.classiccritical.attributes.Attributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static moe.mutsuki.classiccritical.mixin.CritHandle.CHC_MODIFIER_VANILLA;
import static moe.mutsuki.classiccritical.mixin.CritHandle.CHD_MODIFIER_VANILLA;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity{

    protected PlayerMixin(EntityType<? extends LivingEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    @Inject(method = "attack(Lnet/minecraft/world/entity/Entity;)V",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Player;resetAttackStrengthTicker()V"))
    private void removeVanillaCrit(CallbackInfo ci) {
        var chd_instance = this.getAttribute(Attributes.CRIT_DAMAGE.get());
        var chc_instance = this.getAttribute(Attributes.CRIT_CHANCE.get());
        if (chd_instance != null && chc_instance != null){
            chd_instance.removeModifier(CHD_MODIFIER_VANILLA);
            chc_instance.removeModifier(CHC_MODIFIER_VANILLA);
        }
    }
}

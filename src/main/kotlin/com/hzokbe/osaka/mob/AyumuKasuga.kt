package com.hzokbe.osaka.mob

import com.hzokbe.osaka.sounds.ModSounds
import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.goal.LookAroundGoal
import net.minecraft.entity.ai.goal.LookAtEntityGoal
import net.minecraft.entity.ai.goal.SwimGoal
import net.minecraft.entity.ai.goal.WanderAroundFarGoal
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

class AyumuKasuga(entityType: EntityType<out PassiveEntity>, world: World) : PassiveEntity(entityType, world) {
    companion object {
        fun createAttributes(): DefaultAttributeContainer.Builder =
            MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 20.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25)
    }

    override fun createChild(
        world: ServerWorld?,
        entity: PassiveEntity?
    ) = null

    override fun initGoals() {
        goalSelector.add(0, SwimGoal(this))

        goalSelector.add(1, WanderAroundFarGoal(this, 0.8))

        goalSelector.add(2, LookAtEntityGoal(this, PlayerEntity::class.java, 8.0f))

        goalSelector.add(3, LookAroundGoal(this))
    }

    override fun getAmbientSound() = ModSounds.AYUMU_KASUGA_AMBIENT

    override fun getHurtSound(source: DamageSource?) = ModSounds.AYUMU_KASUGA_HURT

    override fun getDeathSound() = ModSounds.AYUMU_KASUGA_DEATH

    override fun getSoundVolume(): Float = 0.1F

    override fun getSoundPitch(): Float = 1.0F
}

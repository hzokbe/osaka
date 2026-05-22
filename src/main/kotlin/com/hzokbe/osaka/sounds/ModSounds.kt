package com.hzokbe.osaka.sounds

import com.hzokbe.osaka.Osaka
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier

object ModSounds {
    val AYUMU_KASUGA_AMBIENT = register("entity.ayumu_kasuga.ambient")

    val AYUMU_KASUGA_HURT = register("entity.ayumu_kasuga.hurt")

    val AYUMU_KASUGA_DEATH = register("entity.ayumu_kasuga.death")

    private fun register(name: String): SoundEvent {
        val id = Identifier.of(Osaka.MOD_ID, name)

        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id))
    }

    fun register() = Osaka.logger.info("Registering sounds")
}

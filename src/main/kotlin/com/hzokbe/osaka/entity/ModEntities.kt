package com.hzokbe.osaka.entity

import com.hzokbe.osaka.Osaka
import com.hzokbe.osaka.mob.AyumuKasuga
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModEntities {
    val AYUMU_KASUGA = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Osaka.MOD_ID, "ayumu_kasuga"),
        EntityType.Builder.create(::AyumuKasuga, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build(
                RegistryKey.of(
                    RegistryKeys.ENTITY_TYPE,
                    Identifier.of(Osaka.MOD_ID, "ayumu_kasuga")
                )
            )
    )

    fun register() = Osaka.logger.info("Registering entities")
}

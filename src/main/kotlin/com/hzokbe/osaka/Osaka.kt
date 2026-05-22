package com.hzokbe.osaka

import com.hzokbe.osaka.entity.ModEntities
import com.hzokbe.osaka.item.ModItemGroups
import com.hzokbe.osaka.item.ModItems
import com.hzokbe.osaka.mob.AyumuKasuga
import com.hzokbe.osaka.sounds.ModSounds
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Osaka : ModInitializer {
    const val MOD_ID = "osaka"

    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItems.register()

        ModItemGroups.register()

        ModEntities.register()

        ModSounds.register()

        FabricDefaultAttributeRegistry.register(
            ModEntities.AYUMU_KASUGA,
            AyumuKasuga.createAttributes().build()
        )
    }
}

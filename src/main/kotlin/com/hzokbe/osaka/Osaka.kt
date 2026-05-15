package com.hzokbe.osaka

import com.hzokbe.osaka.item.ModItemGroups
import com.hzokbe.osaka.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Osaka : ModInitializer {
    const val MOD_ID = "osaka"

    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItems.register()

        ModItemGroups.register()
    }
}

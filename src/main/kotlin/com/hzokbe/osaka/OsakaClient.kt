package com.hzokbe.osaka

import com.hzokbe.osaka.entity.ModEntities
import com.hzokbe.osaka.renderer.AyumuKasugaRenderer
import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.render.entity.EntityRendererFactories

class OsakaClient : ClientModInitializer {
    override fun onInitializeClient() {
        EntityRendererFactories.register(ModEntities.AYUMU_KASUGA) { context ->
            AyumuKasugaRenderer(context)
        }
    }
}

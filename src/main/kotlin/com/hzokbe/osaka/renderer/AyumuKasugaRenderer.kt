package com.hzokbe.osaka.renderer

import com.hzokbe.osaka.Osaka
import com.hzokbe.osaka.mob.AyumuKasuga
import com.hzokbe.osaka.render.AyumuKasugaRenderState
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayers
import net.minecraft.util.Identifier

class AyumuKasugaRenderer(context: EntityRendererFactory.Context) :
    MobEntityRenderer<AyumuKasuga, AyumuKasugaRenderState, BipedEntityModel<AyumuKasugaRenderState>>(
        context,
        BipedEntityModel(context.getPart(EntityModelLayers.PLAYER)),
        0.5f
    ) {

    override fun createRenderState() = AyumuKasugaRenderState()

    override fun getTexture(state: AyumuKasugaRenderState): Identifier =
        Identifier.of(Osaka.MOD_ID, "textures/entity/ayumu_kasuga.png")
}

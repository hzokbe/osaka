package com.hzokbe.osaka.item

import com.hzokbe.osaka.Osaka
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {
    private val OSAKA_ITEM_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(Osaka.MOD_ID, "osaka_items"),
        FabricItemGroup
            .builder()
            .icon { ItemStack(ModItems.SATA_ANDAGI) }
            .displayName(Text.translatable("itemgroup.osaka.osaka_items"))
            .entries { _, entries -> entries.add { ModItems.SATA_ANDAGI } }
            .build()
    )

    fun register() {
        Osaka.logger.info("Registering item groups")
    }
}

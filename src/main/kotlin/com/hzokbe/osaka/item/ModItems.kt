package com.hzokbe.osaka.item

import com.hzokbe.osaka.Osaka
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.component.type.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModItems {
    val SATA_ANDAGI = register(
        "sata_andagi",
        Item(
            Item
                .Settings()
                .food(
                    FoodComponent(
                        6,
                        0.6F,
                        false
                    )
                )
                .registryKey(
                    RegistryKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(Osaka.MOD_ID, "sata_andagi")
                    )
                )
        )
    )

    private fun register(name: String, item: Item) = Registry.register(
        Registries.ITEM,
        Identifier.of(Osaka.MOD_ID, name),
        item
    )

    fun register() {
        Osaka.logger.info("Registering items")

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register {
            it.add(SATA_ANDAGI)
        }
    }
}

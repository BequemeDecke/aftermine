package com.lukasdrescher.aftermine.registry

import com.lukasdrescher.aftermine.MOD_ID
import com.lukasdrescher.aftermine.item.SoulFragment
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ItemRegistry {
    fun <GenericItem : Item> registerItem(
        name: String,
        itemSettings: Item.Settings,
        itemFactory: (Item.Settings) -> GenericItem
    ): GenericItem {
        val id = Identifier.of(MOD_ID, name)
        val key: RegistryKey<Item> = RegistryKey.of(RegistryKeys.ITEM, id)
        val settings: Item.Settings = itemSettings.registryKey(key)

        val item: GenericItem = itemFactory(settings)

        return Registry.register(Registries.ITEM, key, item)
    }

    fun initialize() {
        // Here can Items be registered
        registerItem("soul_fragment", Item.Settings().maxCount(16), ::SoulFragment)
    }
}
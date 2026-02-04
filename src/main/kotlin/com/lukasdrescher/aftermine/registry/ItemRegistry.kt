package com.lukasdrescher.aftermine.registry

import com.lukasdrescher.aftermine.MOD_ID
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ItemRegistry {
    fun registerItem(name: String, itemSettings: Item.Settings): Item {
        val id = Identifier.of(MOD_ID, name)
        val key: RegistryKey<Item> = RegistryKey.of(RegistryKeys.ITEM, id)
        val settings: Item.Settings = itemSettings.registryKey(key)
        return Registry.register(Registries.ITEM, key, Item(settings))
    }

    fun initialize() {
        // Here can Items be registered
        registerItem("hand_grenade", Item.Settings().maxCount(3))
    }
}
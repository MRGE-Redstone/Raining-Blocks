package me.niclas.rainingBlocks

import org.bukkit.plugin.java.JavaPlugin

class RainingBlocks : JavaPlugin() {

    val interval: Long = 65 // 3.25 seconds (3.25*20)

    override fun onEnable() {
        SpawnFallingBlocks().runTaskTimer(this, 0, interval)
    }

    override fun onDisable() {

    }
}

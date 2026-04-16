package me.niclas.rainingBlocks

import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.Bukkit
import org.bukkit.Material

class SpawnFallingBlocks : BukkitRunnable() {

    private val blocks = Material.entries.filter { it.isBlock }

    override fun run() {
        for (player in Bukkit.getOnlinePlayers()) {

            for (i in 0..(Math.random()*2+1).toInt()) {

                var location = player.location

                val x = getRandomDouble() - 48.0
                val z = getRandomDouble() - 48.0

                location = location.add(x, 0.0, z)
                location.y = Bukkit.getWorld("world")!!.maxHeight.toDouble()

                Bukkit.getWorld("world")?.spawnFallingBlock(location, blocks.random().createBlockData())
            }
        }
    }
    private fun getRandomDouble() : Double {
        return Math.random() * 96.0
    }
}
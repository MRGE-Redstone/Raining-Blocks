package me.niclas.rainingBlocks

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.scheduler.BukkitRunnable
import kotlin.random.Random

class SpawnFallingBlocks : BukkitRunnable() {

    private val world by lazy { Bukkit.getWorld("world") }
    private val blocks = Material.entries.filter { it.isBlock }

    override fun run() {

        val world = this.world ?: return

        for (player in Bukkit.getOnlinePlayers()) {

            val count = Random.nextInt(
                RainingBlocks.min.toInt(),
                RainingBlocks.max.toInt() + 1
            )

            repeat(count) {

                val base = player.location.clone()

                val x = Random.nextDouble(-48.0, 48.0)
                val z = Random.nextDouble(-48.0, 48.0)

                val spawnLocation = Location(
                    world,
                    base.x + x,
                    world.maxHeight.toDouble(),
                    base.z + z
                )

                world.spawnFallingBlock(
                    spawnLocation,
                    blocks.random().createBlockData()
                )
            }
        }
    }
}
package me.niclas.rainingBlocks

import me.niclas.rainingBlocks.commands.SetAmountCommand
import me.niclas.rainingBlocks.commands.SetIntervalCommand
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class RainingBlocks : JavaPlugin() {

    companion object {
        var interval: Long = 65L
        var min: Long = 1L
        var max: Long = 2L
    }

    private var task: BukkitRunnable? = null

    override fun onEnable() {
        initCommands()
        startTask()
    }

    override fun onDisable() {
        task?.cancel()
    }

    private fun initCommands() {
        getCommand("setamount")?.setExecutor(SetAmountCommand())
        getCommand("setinterval")?.setExecutor(SetIntervalCommand(this))
    }

    fun startTask() {
        task = object : BukkitRunnable() {
            override fun run() {
                SpawnFallingBlocks().run()
            }
        }

        task!!.runTaskTimer(this, 0L, interval)
    }

    fun restartTask() {
        task?.cancel()
        startTask()
    }
}
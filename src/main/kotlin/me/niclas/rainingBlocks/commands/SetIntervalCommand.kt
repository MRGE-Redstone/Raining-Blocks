package me.niclas.rainingBlocks.commands

import me.niclas.rainingBlocks.RainingBlocks
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class SetIntervalCommand(val plugin: RainingBlocks) : CommandExecutor {

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {

        if (args.isEmpty()) {
            return false
        }

        val interval = args[0].toLongOrNull()

        if (interval == null) {
            return false
        }

        if (interval <= 0) {
            sender.sendMessage("Interval must be greater than 0.")
            return false
        }

        RainingBlocks.interval = interval

        sender.sendMessage("Set interval=$interval ticks")

        plugin.restartTask()

        return true
    }
}
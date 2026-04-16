package me.niclas.rainingBlocks.commands

import me.niclas.rainingBlocks.RainingBlocks
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class SetAmountCommand : CommandExecutor {

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {

        if (args.size < 2) {
            return false
        }

        val min = args[0].toLongOrNull()
        val max = args[1].toLongOrNull()

        if (min == null || max == null) {
            return false
        }

        if (min > max) {
            sender.sendMessage("min cannot be greater than max.")
            return false
        }

        RainingBlocks.min = min
        RainingBlocks.max = max

        sender.sendMessage("Set min=$min, max=$max")

        return true
    }
}
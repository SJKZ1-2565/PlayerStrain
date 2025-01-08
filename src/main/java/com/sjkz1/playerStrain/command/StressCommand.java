package com.sjkz1.playerStrain.command;

import com.sjkz1.playerStrain.player.PlayerStress;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StressCommand extends PlayerStress implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        if (strings.length == 0) {
            return false;
        }
        if (!strings[0].equals(commandSender.getName())) {
            return false;
        }
        if (strings[0].isEmpty() || strings[1].isEmpty() || strings[2].isEmpty()) {
            return false;
        }
        if (!strings[1].equalsIgnoreCase("set")) {
            setStress(((Player) commandSender).getPlayer(), Integer.parseInt(strings[2]));
            commandSender.sendMessage(Component.text("Set player stress to " + strings[2]).style(builder -> builder.color(TextColor.fromHexString("FFFF55"))));
            return true;
        }
        return false;
    }
}

package de.lenni.lobbysystem.commands;

import de.lenni.lobbysystem.LobbySystem;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            LobbySystem.INSTANCE.log("§7You aren't a player!");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("de.lenni.lobbysystem.commands.heal")) {
            player.setHealth(20d);
            player.setFoodLevel(20);
            player.sendMessage(LobbySystem.PREFIX + "§aYou was healed!");
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_HAT, 0.2f, 1.2f);
        } else {
            player.sendMessage(LobbySystem.PREFIX + "§aYou don't have permissions for this!");
        }
        return true;
    }
}

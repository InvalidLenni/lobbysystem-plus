package de.lenni.lobbysystem.commands;

import de.lenni.lobbysystem.LobbySystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            LobbySystem.INSTANCE.log("§7You aren't a player!");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("de.lenni.lobbysystem.commands.discord")) {
            player.sendMessage(LobbySystem.PREFIX + "§b&lDiscord&8: &7YourDiscordInvite");
        } else {
            player.sendMessage(LobbySystem.PREFIX + "§aYou don't have permissions for this!");
        }
        return true;
    }
}

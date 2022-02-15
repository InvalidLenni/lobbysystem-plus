package de.lenni.lobbysystem.commands;

import de.lenni.lobbysystem.LobbySystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamSpeakCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            LobbySystem.INSTANCE.log("§7You aren't a player!");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("de.lenni.lobbysystem.commands.teamspeak")) {
            player.sendMessage(LobbySystem.PREFIX + "§8&bTeamSpeak&8: &7YourTeamSpeakIP");
        } else {
            player.sendMessage(LobbySystem.PREFIX + "§aYou don't have permissions for this!");
        }
        return true;
    }
}

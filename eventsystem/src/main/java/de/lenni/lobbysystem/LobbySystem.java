package de.lenni.lobbysystem;

import de.lenni.lobbysystem.commands.HealCommand;
import de.lenni.lobbysystem.listener.JointQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbySystem extends JavaPlugin {

    public static String PREFIX = "§eLobbySystem §7:§a";
    public static LobbySystem INSTANCE;

    public LobbySystem() { INSTANCE = this; }

    @Override
    public void onEnable() {
        this.register();

        log("The Plugin was loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown login
        log("The Plugin was unloaded!");
    }

    public void log(String text) {

        Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }

    public void register() {
        // Commands
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
        // LISTENER
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JointQuitListener(), this);
    }
}

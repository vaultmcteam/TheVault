package me.relaxitsdax.thevault;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class TheVault extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().log(Level.ALL, "Hi!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

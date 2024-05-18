package me.relaxitsdax.thevault;

import me.relaxitsdax.thevault.listeners.Test;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class TheVault extends JavaPlugin {

    @Override
    public void onEnable() {
        instance = this;

        // Plugin startup logic
        Bukkit.getLogger().log(Level.ALL, "Hi!");
        getServer().getPluginManager().registerEvents(new Test(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TheVault instance;

    public static TheVault getInstance() {
        return instance;
    }
}

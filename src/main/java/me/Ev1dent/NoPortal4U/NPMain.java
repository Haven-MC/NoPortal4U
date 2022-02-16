package me.Ev1dent.NoPortal4U;

import me.Ev1dent.NoPortal4U.Commands.CommandEndPortals;
import me.Ev1dent.NoPortal4U.Events.PlayerInteract;
import org.bukkit.plugin.java.JavaPlugin;

public final class NPMain extends JavaPlugin {
    public static NPMain plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerCommands();
        registerEvents();
        saveDefaultConfig();
    }

    public void registerCommands(){
        this.getCommand("endportals").setExecutor(new CommandEndPortals());
    }
    public void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerInteract(), this );
    }
}

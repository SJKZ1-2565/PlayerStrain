package com.sjkz1.playerStrain;

import com.sjkz1.playerStrain.command.StressCommand;
import com.sjkz1.playerStrain.schedule.LightChecking;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class PlayerStrain extends JavaPlugin {


    @Override
    public void onEnable() {
        BukkitScheduler scheduler = this.getServer().getScheduler();
        scheduler.runTaskTimerAsynchronously(this, new LightChecking(this), 20, 20);
        getCommand("stress").setExecutor(new StressCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

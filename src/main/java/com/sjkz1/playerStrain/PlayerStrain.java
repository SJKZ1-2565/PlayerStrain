package com.sjkz1.playerStrain;

import com.sjkz1.playerStrain.schedule.LightChecking;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class PlayerStrain extends JavaPlugin {

    @Override
    public void onEnable() {
//        getServer().getPluginManager().registerEvents(new PlayerStrainListener(), this);
        BukkitScheduler scheduler = this.getServer().getScheduler();
        scheduler.runTaskTimerAsynchronously(this, new LightChecking(this), 20, 20);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

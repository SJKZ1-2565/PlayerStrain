package com.sjkz1.playerStrain.listener;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerStrainListener implements Listener {

    @EventHandler
    public void test(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        int blockLight = world.getBlockAt(player.getLocation()).getLightFromBlocks();
        int skyLight = world.getBlockAt(player.getLocation()).getLightFromSky();
        int lightLevel = world.getBlockAt(player.getLocation()).getLightLevel();
        System.out.println("Block Light: " + blockLight + ", Sky Light: " + skyLight + ", Light Level: " + lightLevel);
    }
}
